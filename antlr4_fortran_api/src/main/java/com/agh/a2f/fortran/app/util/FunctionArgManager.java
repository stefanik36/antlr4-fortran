package com.agh.a2f.fortran.app.util;

import com.agh.a2f.fortran.generated.fortran77Parser.*;
import org.bytedeco.javacpp.LLVM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.bytedeco.javacpp.LLVM.LLVMInt32Type;

public class FunctionArgManager{
    private Map<String, LLVM.LLVMTypeRef> argsType;
    private SubprogramBodyContext ctx;
    List<String> args;

    public FunctionArgManager(SubprogramBodyContext ctx, List<String> args) {
        this.ctx = ctx;
        this.args = args;
        this.argsType = new HashMap<>();
    }
    private void prepareArgumentsType(){
        ctx.wholeStatement()
                .stream()
                .filter(x -> x.statement().typeStatement() != null)
                .map(x -> x.statement().typeStatement())
                .forEach(this::findFunctionArgsType);
    }

    private void findFunctionArgsType(TypeStatementContext typeStm){
        if (typeStm.typeStatementNameList() != null)
            findSingleAllocation(typeStm.typeStatementNameList(), typeStm.typename().getText());
        else
            findArrayAllocation(typeStm.typeStatementNameCharList());

    }

    private int findArrayAllocation(TypeStatementNameCharListContext typeStatementNameCharListContext) {
        return 1;
        //TODO może być problem z typami przy dodawaniu do mapy argsType

    }

    private void findSingleAllocation(TypeStatementNameListContext argsList, String type) {
        argsList.typeStatementName()
                .stream()
                .map(arg -> arg.identifier().getText())
                .forEach(argName -> {
                    if (isFunctionArg(argName)) {
                        argsType.put(argName, LLVMInt32Type());
                    }
                });
    }

    private boolean isFunctionArg(String name){
        return args.stream().anyMatch(x -> x.equals(name));
    }

    public LLVM.LLVMTypeRef[] getArgsTypeArray(){
        if(args == null)
            return new LLVM.LLVMTypeRef[0];

        prepareArgumentsType();
        LLVM.LLVMTypeRef args [] = new LLVM.LLVMTypeRef[this.args.size()];
        for(int i = 0; i < args.length; i++){
            String argName = this.args.get(i);
            args[i] = argsType.get(argName);
        }
        return args;
    }

}
