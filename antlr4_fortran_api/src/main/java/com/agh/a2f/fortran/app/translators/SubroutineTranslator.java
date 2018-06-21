package com.agh.a2f.fortran.app.translators;

import com.agh.a2f.fortran.generated.fortran77Parser;
import com.agh.a2f.fortran.generated.fortran77Parser.*;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.PointerPointer;
import java.util.*;

import static org.bytedeco.javacpp.LLVM.*;

public abstract class SubroutineTranslator extends FunctionTranslator {
    SubroutineTranslator(BufferedTokenStream tokens) {
        super(tokens);
    }


    @Override
    public void enterCallStatement(fortran77Parser.CallStatementContext ctx) {
        megaStack.startSection();
        super.enterCallStatement(ctx);
    }

    @Override
    public void exitCallStatement(fortran77Parser.CallStatementContext ctx) {
        Stack<LLVMValueRef> val = new Stack<>();
        while (megaStack.size() > 0)
            val.push(megaStack.popValue());
        LLVMValueRef sub = valueRefs.get(ctx.subroutineCall().identifier().getText());
        LLVMValueRef args[] = new LLVMValueRef[val.size()];
        val.toArray(args);
        LLVMBuildCall(builder, sub, new PointerPointer<>(args), args.length, "");
        megaStack.endSection();
    }

    @Override
    public void enterSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx) {
        megaStack.startSection();

        this.args = ctx.subroutineStatement().namelist().identifier();
        this.argsType = new HashMap<>();
        String subName = ctx.subroutineStatement().identifier().getText();

        prepareArgumentsType(ctx);
        LLVMTypeRef[] args = getArgsTypeArray();

        LLVMValueRef fun = LLVMAddFunction(mod, subName, LLVMFunctionType(LLVMVoidType(), new PointerPointer<>(args), args.length, 0));

        executableUnitName = subName;
        functionType = FunctionType.SUBROUTINE;
        valueRefs.put(subName, fun);
    }

    /**
     *Argumenty funckji są wyszukiwane w typeStatement(np integer i), a następnie jest określany ich typ, który jest
     *     trzymany potem w mapie argsType pod nazwą agumentu. Następnie argumenty funkcji są usuwane z typeStatement, tak
     *     aby nie były potem zaalokowane ponownie. Jeżeli typeStatement zawiera same argumenty funkcji, to jest ono usuwane.
     *     Alokacja pamięci jest realizowana w LLVMBaseTranslator.enterSubprogramBody
     */

    private void prepareArgumentsType(SubroutineSubprogramContext ctx){
        Iterator<ParseTree> statementItr = ctx.subprogramBody().children.iterator();

        while (statementItr.hasNext()) {
            ParseTree i = statementItr.next();
            if(WholeStatementContext.class.isInstance(i)){ //tree path wholeStatement->statement->typeStatement
                TypeStatementContext typeStm = ((WholeStatementContext) i).statement().typeStatement();
                if (typeStm == null) break; //check if child is typeStatement
                int size = findFunctionArgsType(typeStm);
                removeIfEmptyStatement(size, statementItr);
            }

        }
    }

    private int findFunctionArgsType(TypeStatementContext typeStm){
        if (typeStm.typeStatementNameList() != null)
            return findAndRemoveSingleAllocation(typeStm.typeStatementNameList(), typeStm.typename().getText());
        else
            return findAndRemoveArrayAllocation(typeStm.typeStatementNameCharList());

    }

    private void removeIfEmptyStatement(int size, Iterator<ParseTree> itr){
        if (size == 0)
            itr.remove();
    }

    private int findAndRemoveArrayAllocation(fortran77Parser.TypeStatementNameCharListContext typeStatementNameCharListContext) {
        return 1;
        //TODO może być problem z typami przy dodawaniu do mapy argsType

    }

    private int findAndRemoveSingleAllocation(TypeStatementNameListContext argsList, String type) {
        Iterator<ParseTree> argsItr = argsList.children.iterator();
        while (argsItr.hasNext()){
            ParseTree currentArg = argsItr.next();
            if(TypeStatementNameContext.class.isInstance(currentArg)) {
                String argName = ((TypeStatementNameContext) currentArg).identifier().getText();
                if (isFunctionArg(argName)) {
                    argsType.put(argName, LLVMInt32Type());
                    argsItr.remove();
                }
            }
        }
        return argsList.typeStatementName().size();
    }

    private boolean isFunctionArg(String name){
        return args.stream().anyMatch(x -> x.getText().equals(name));
    }

    private LLVMTypeRef[] getArgsTypeArray(){
        LLVMTypeRef args [] = new LLVMTypeRef[this.args.size()];
        for(int i = 0; i < args.length; i++){
            String argName = this.args.get(i).getText();
            args[i] = argsType.get(argName);
        }
        return args;
    }

    @Override
    public void exitSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx) {
        argsType = null;
        args = null;
        megaStack.endSection();
    }
}
