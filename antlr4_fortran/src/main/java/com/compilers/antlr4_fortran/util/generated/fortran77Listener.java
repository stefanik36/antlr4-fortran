// Generated from /home/prw/IdeaProjects/antlr4-fortran/src/main/java/com/agh/a2f/fortran/generated/fortran77.g4 by ANTLR 4.7
package com.compilers.antlr4_fortran.util.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fortran77Parser}.
 */
public interface fortran77Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(fortran77Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(fortran77Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#executableUnit}.
	 * @param ctx the parse tree
	 */
	void enterExecutableUnit(fortran77Parser.ExecutableUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#executableUnit}.
	 * @param ctx the parse tree
	 */
	void exitExecutableUnit(fortran77Parser.ExecutableUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#mainProgram}.
	 * @param ctx the parse tree
	 */
	void enterMainProgram(fortran77Parser.MainProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#mainProgram}.
	 * @param ctx the parse tree
	 */
	void exitMainProgram(fortran77Parser.MainProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#functionSubprogram}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#functionSubprogram}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subroutineSubprogram}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subroutineSubprogram}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#blockdataSubprogram}.
	 * @param ctx the parse tree
	 */
	void enterBlockdataSubprogram(fortran77Parser.BlockdataSubprogramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#blockdataSubprogram}.
	 * @param ctx the parse tree
	 */
	void exitBlockdataSubprogram(fortran77Parser.BlockdataSubprogramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#otherSpecificationStatement}.
	 * @param ctx the parse tree
	 */
	void enterOtherSpecificationStatement(fortran77Parser.OtherSpecificationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#otherSpecificationStatement}.
	 * @param ctx the parse tree
	 */
	void exitOtherSpecificationStatement(fortran77Parser.OtherSpecificationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#executableStatement}.
	 * @param ctx the parse tree
	 */
	void enterExecutableStatement(fortran77Parser.ExecutableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#executableStatement}.
	 * @param ctx the parse tree
	 */
	void exitExecutableStatement(fortran77Parser.ExecutableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#programStatement}.
	 * @param ctx the parse tree
	 */
	void enterProgramStatement(fortran77Parser.ProgramStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#programStatement}.
	 * @param ctx the parse tree
	 */
	void exitProgramStatement(fortran77Parser.ProgramStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#seos}.
	 * @param ctx the parse tree
	 */
	void enterSeos(fortran77Parser.SeosContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#seos}.
	 * @param ctx the parse tree
	 */
	void exitSeos(fortran77Parser.SeosContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#entryStatement}.
	 * @param ctx the parse tree
	 */
	void enterEntryStatement(fortran77Parser.EntryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#entryStatement}.
	 * @param ctx the parse tree
	 */
	void exitEntryStatement(fortran77Parser.EntryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(fortran77Parser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(fortran77Parser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#blockdataStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockdataStatement(fortran77Parser.BlockdataStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#blockdataStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockdataStatement(fortran77Parser.BlockdataStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subroutineStatement}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineStatement(fortran77Parser.SubroutineStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subroutineStatement}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineStatement(fortran77Parser.SubroutineStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#namelist}.
	 * @param ctx the parse tree
	 */
	void enterNamelist(fortran77Parser.NamelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#namelist}.
	 * @param ctx the parse tree
	 */
	void exitNamelist(fortran77Parser.NamelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(fortran77Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(fortran77Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subprogramBody}.
	 * @param ctx the parse tree
	 */
	void enterSubprogramBody(fortran77Parser.SubprogramBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subprogramBody}.
	 * @param ctx the parse tree
	 */
	void exitSubprogramBody(fortran77Parser.SubprogramBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#wholeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWholeStatement(fortran77Parser.WholeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#wholeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWholeStatement(fortran77Parser.WholeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(fortran77Parser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(fortran77Parser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#endStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndStatement(fortran77Parser.EndStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#endStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndStatement(fortran77Parser.EndStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dimensionStatement}.
	 * @param ctx the parse tree
	 */
	void enterDimensionStatement(fortran77Parser.DimensionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dimensionStatement}.
	 * @param ctx the parse tree
	 */
	void exitDimensionStatement(fortran77Parser.DimensionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclarator(fortran77Parser.ArrayDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclarator(fortran77Parser.ArrayDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclarators(fortran77Parser.ArrayDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclarators(fortran77Parser.ArrayDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtents}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaratorExtents(fortran77Parser.ArrayDeclaratorExtentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtents}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaratorExtents(fortran77Parser.ArrayDeclaratorExtentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtent}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaratorExtent(fortran77Parser.ArrayDeclaratorExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtent}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaratorExtent(fortran77Parser.ArrayDeclaratorExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#equivalenceStatement}.
	 * @param ctx the parse tree
	 */
	void enterEquivalenceStatement(fortran77Parser.EquivalenceStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#equivalenceStatement}.
	 * @param ctx the parse tree
	 */
	void exitEquivalenceStatement(fortran77Parser.EquivalenceStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#equivEntityGroup}.
	 * @param ctx the parse tree
	 */
	void enterEquivEntityGroup(fortran77Parser.EquivEntityGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#equivEntityGroup}.
	 * @param ctx the parse tree
	 */
	void exitEquivEntityGroup(fortran77Parser.EquivEntityGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#equivEntity}.
	 * @param ctx the parse tree
	 */
	void enterEquivEntity(fortran77Parser.EquivEntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#equivEntity}.
	 * @param ctx the parse tree
	 */
	void exitEquivEntity(fortran77Parser.EquivEntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#commonStatement}.
	 * @param ctx the parse tree
	 */
	void enterCommonStatement(fortran77Parser.CommonStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#commonStatement}.
	 * @param ctx the parse tree
	 */
	void exitCommonStatement(fortran77Parser.CommonStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#commonName}.
	 * @param ctx the parse tree
	 */
	void enterCommonName(fortran77Parser.CommonNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#commonName}.
	 * @param ctx the parse tree
	 */
	void exitCommonName(fortran77Parser.CommonNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#commonItem}.
	 * @param ctx the parse tree
	 */
	void enterCommonItem(fortran77Parser.CommonItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#commonItem}.
	 * @param ctx the parse tree
	 */
	void exitCommonItem(fortran77Parser.CommonItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#commonItems}.
	 * @param ctx the parse tree
	 */
	void enterCommonItems(fortran77Parser.CommonItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#commonItems}.
	 * @param ctx the parse tree
	 */
	void exitCommonItems(fortran77Parser.CommonItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#commonBlock}.
	 * @param ctx the parse tree
	 */
	void enterCommonBlock(fortran77Parser.CommonBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#commonBlock}.
	 * @param ctx the parse tree
	 */
	void exitCommonBlock(fortran77Parser.CommonBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatement(fortran77Parser.TypeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatement(fortran77Parser.TypeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatementNameList}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatementNameList}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatementName}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatementName(fortran77Parser.TypeStatementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatementName}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatementName(fortran77Parser.TypeStatementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatementNameCharList}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatementNameCharList}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatementNameChar}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatementNameChar(fortran77Parser.TypeStatementNameCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatementNameChar}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatementNameChar(fortran77Parser.TypeStatementNameCharContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typeStatementLenSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatementLenSpec(fortran77Parser.TypeStatementLenSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typeStatementLenSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatementLenSpec(fortran77Parser.TypeStatementLenSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(fortran77Parser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(fortran77Parser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(fortran77Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(fortran77Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#typenameLen}.
	 * @param ctx the parse tree
	 */
	void enterTypenameLen(fortran77Parser.TypenameLenContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#typenameLen}.
	 * @param ctx the parse tree
	 */
	void exitTypenameLen(fortran77Parser.TypenameLenContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#pointerStatement}.
	 * @param ctx the parse tree
	 */
	void enterPointerStatement(fortran77Parser.PointerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#pointerStatement}.
	 * @param ctx the parse tree
	 */
	void exitPointerStatement(fortran77Parser.PointerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#pointerDecl}.
	 * @param ctx the parse tree
	 */
	void enterPointerDecl(fortran77Parser.PointerDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#pointerDecl}.
	 * @param ctx the parse tree
	 */
	void exitPointerDecl(fortran77Parser.PointerDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitStatement}.
	 * @param ctx the parse tree
	 */
	void enterImplicitStatement(fortran77Parser.ImplicitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitStatement}.
	 * @param ctx the parse tree
	 */
	void exitImplicitStatement(fortran77Parser.ImplicitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitSpec}.
	 * @param ctx the parse tree
	 */
	void enterImplicitSpec(fortran77Parser.ImplicitSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitSpec}.
	 * @param ctx the parse tree
	 */
	void exitImplicitSpec(fortran77Parser.ImplicitSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitSpecs}.
	 * @param ctx the parse tree
	 */
	void enterImplicitSpecs(fortran77Parser.ImplicitSpecsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitSpecs}.
	 * @param ctx the parse tree
	 */
	void exitImplicitSpecs(fortran77Parser.ImplicitSpecsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitNone}.
	 * @param ctx the parse tree
	 */
	void enterImplicitNone(fortran77Parser.ImplicitNoneContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitNone}.
	 * @param ctx the parse tree
	 */
	void exitImplicitNone(fortran77Parser.ImplicitNoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitLetter}.
	 * @param ctx the parse tree
	 */
	void enterImplicitLetter(fortran77Parser.ImplicitLetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitLetter}.
	 * @param ctx the parse tree
	 */
	void exitImplicitLetter(fortran77Parser.ImplicitLetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitRange}.
	 * @param ctx the parse tree
	 */
	void enterImplicitRange(fortran77Parser.ImplicitRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitRange}.
	 * @param ctx the parse tree
	 */
	void exitImplicitRange(fortran77Parser.ImplicitRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#implicitLetters}.
	 * @param ctx the parse tree
	 */
	void enterImplicitLetters(fortran77Parser.ImplicitLettersContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#implicitLetters}.
	 * @param ctx the parse tree
	 */
	void exitImplicitLetters(fortran77Parser.ImplicitLettersContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lenSpecification}.
	 * @param ctx the parse tree
	 */
	void enterLenSpecification(fortran77Parser.LenSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lenSpecification}.
	 * @param ctx the parse tree
	 */
	void exitLenSpecification(fortran77Parser.LenSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#characterWithLen}.
	 * @param ctx the parse tree
	 */
	void enterCharacterWithLen(fortran77Parser.CharacterWithLenContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#characterWithLen}.
	 * @param ctx the parse tree
	 */
	void exitCharacterWithLen(fortran77Parser.CharacterWithLenContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#cwlLen}.
	 * @param ctx the parse tree
	 */
	void enterCwlLen(fortran77Parser.CwlLenContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#cwlLen}.
	 * @param ctx the parse tree
	 */
	void exitCwlLen(fortran77Parser.CwlLenContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#parameterStatement}.
	 * @param ctx the parse tree
	 */
	void enterParameterStatement(fortran77Parser.ParameterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#parameterStatement}.
	 * @param ctx the parse tree
	 */
	void exitParameterStatement(fortran77Parser.ParameterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#paramlist}.
	 * @param ctx the parse tree
	 */
	void enterParamlist(fortran77Parser.ParamlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#paramlist}.
	 * @param ctx the parse tree
	 */
	void exitParamlist(fortran77Parser.ParamlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#paramassign}.
	 * @param ctx the parse tree
	 */
	void enterParamassign(fortran77Parser.ParamassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#paramassign}.
	 * @param ctx the parse tree
	 */
	void exitParamassign(fortran77Parser.ParamassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#externalStatement}.
	 * @param ctx the parse tree
	 */
	void enterExternalStatement(fortran77Parser.ExternalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#externalStatement}.
	 * @param ctx the parse tree
	 */
	void exitExternalStatement(fortran77Parser.ExternalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#intrinsicStatement}.
	 * @param ctx the parse tree
	 */
	void enterIntrinsicStatement(fortran77Parser.IntrinsicStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#intrinsicStatement}.
	 * @param ctx the parse tree
	 */
	void exitIntrinsicStatement(fortran77Parser.IntrinsicStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#saveStatement}.
	 * @param ctx the parse tree
	 */
	void enterSaveStatement(fortran77Parser.SaveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#saveStatement}.
	 * @param ctx the parse tree
	 */
	void exitSaveStatement(fortran77Parser.SaveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#saveEntity}.
	 * @param ctx the parse tree
	 */
	void enterSaveEntity(fortran77Parser.SaveEntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#saveEntity}.
	 * @param ctx the parse tree
	 */
	void exitSaveEntity(fortran77Parser.SaveEntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataStatement}.
	 * @param ctx the parse tree
	 */
	void enterDataStatement(fortran77Parser.DataStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataStatement}.
	 * @param ctx the parse tree
	 */
	void exitDataStatement(fortran77Parser.DataStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataStatementItem}.
	 * @param ctx the parse tree
	 */
	void enterDataStatementItem(fortran77Parser.DataStatementItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataStatementItem}.
	 * @param ctx the parse tree
	 */
	void exitDataStatementItem(fortran77Parser.DataStatementItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataStatementMultiple}.
	 * @param ctx the parse tree
	 */
	void enterDataStatementMultiple(fortran77Parser.DataStatementMultipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataStatementMultiple}.
	 * @param ctx the parse tree
	 */
	void exitDataStatementMultiple(fortran77Parser.DataStatementMultipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataStatementEntity}.
	 * @param ctx the parse tree
	 */
	void enterDataStatementEntity(fortran77Parser.DataStatementEntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataStatementEntity}.
	 * @param ctx the parse tree
	 */
	void exitDataStatementEntity(fortran77Parser.DataStatementEntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dse1}.
	 * @param ctx the parse tree
	 */
	void enterDse1(fortran77Parser.Dse1Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dse1}.
	 * @param ctx the parse tree
	 */
	void exitDse1(fortran77Parser.Dse1Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dse2}.
	 * @param ctx the parse tree
	 */
	void enterDse2(fortran77Parser.Dse2Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dse2}.
	 * @param ctx the parse tree
	 */
	void exitDse2(fortran77Parser.Dse2Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataImpliedDo}.
	 * @param ctx the parse tree
	 */
	void enterDataImpliedDo(fortran77Parser.DataImpliedDoContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataImpliedDo}.
	 * @param ctx the parse tree
	 */
	void exitDataImpliedDo(fortran77Parser.DataImpliedDoContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataImpliedDoRange}.
	 * @param ctx the parse tree
	 */
	void enterDataImpliedDoRange(fortran77Parser.DataImpliedDoRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataImpliedDoRange}.
	 * @param ctx the parse tree
	 */
	void exitDataImpliedDoRange(fortran77Parser.DataImpliedDoRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataImpliedDoList}.
	 * @param ctx the parse tree
	 */
	void enterDataImpliedDoList(fortran77Parser.DataImpliedDoListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataImpliedDoList}.
	 * @param ctx the parse tree
	 */
	void exitDataImpliedDoList(fortran77Parser.DataImpliedDoListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#dataImpliedDoListWhat}.
	 * @param ctx the parse tree
	 */
	void enterDataImpliedDoListWhat(fortran77Parser.DataImpliedDoListWhatContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#dataImpliedDoListWhat}.
	 * @param ctx the parse tree
	 */
	void exitDataImpliedDoListWhat(fortran77Parser.DataImpliedDoListWhatContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(fortran77Parser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(fortran77Parser.GotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#unconditionalGoto}.
	 * @param ctx the parse tree
	 */
	void enterUnconditionalGoto(fortran77Parser.UnconditionalGotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#unconditionalGoto}.
	 * @param ctx the parse tree
	 */
	void exitUnconditionalGoto(fortran77Parser.UnconditionalGotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#computedGoto}.
	 * @param ctx the parse tree
	 */
	void enterComputedGoto(fortran77Parser.ComputedGotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#computedGoto}.
	 * @param ctx the parse tree
	 */
	void exitComputedGoto(fortran77Parser.ComputedGotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lblRef}.
	 * @param ctx the parse tree
	 */
	void enterLblRef(fortran77Parser.LblRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lblRef}.
	 * @param ctx the parse tree
	 */
	void exitLblRef(fortran77Parser.LblRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#labelList}.
	 * @param ctx the parse tree
	 */
	void enterLabelList(fortran77Parser.LabelListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#labelList}.
	 * @param ctx the parse tree
	 */
	void exitLabelList(fortran77Parser.LabelListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#assignedGoto}.
	 * @param ctx the parse tree
	 */
	void enterAssignedGoto(fortran77Parser.AssignedGotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#assignedGoto}.
	 * @param ctx the parse tree
	 */
	void exitAssignedGoto(fortran77Parser.AssignedGotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(fortran77Parser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(fortran77Parser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arithmeticIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticIfStatement(fortran77Parser.ArithmeticIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arithmeticIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticIfStatement(fortran77Parser.ArithmeticIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#logicalIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterLogicalIfStatement(fortran77Parser.LogicalIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#logicalIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitLogicalIfStatement(fortran77Parser.LogicalIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#blockIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockIfStatement(fortran77Parser.BlockIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#blockIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockIfStatement(fortran77Parser.BlockIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#firstIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterFirstIfBlock(fortran77Parser.FirstIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#firstIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitFirstIfBlock(fortran77Parser.FirstIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(fortran77Parser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(fortran77Parser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(fortran77Parser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(fortran77Parser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(fortran77Parser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(fortran77Parser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#endIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndIfStatement(fortran77Parser.EndIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#endIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndIfStatement(fortran77Parser.EndIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(fortran77Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(fortran77Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#doVarArgs}.
	 * @param ctx the parse tree
	 */
	void enterDoVarArgs(fortran77Parser.DoVarArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#doVarArgs}.
	 * @param ctx the parse tree
	 */
	void exitDoVarArgs(fortran77Parser.DoVarArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#doWithLabel}.
	 * @param ctx the parse tree
	 */
	void enterDoWithLabel(fortran77Parser.DoWithLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#doWithLabel}.
	 * @param ctx the parse tree
	 */
	void exitDoWithLabel(fortran77Parser.DoWithLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#doBody}.
	 * @param ctx the parse tree
	 */
	void enterDoBody(fortran77Parser.DoBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#doBody}.
	 * @param ctx the parse tree
	 */
	void exitDoBody(fortran77Parser.DoBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#doWithEndDo}.
	 * @param ctx the parse tree
	 */
	void enterDoWithEndDo(fortran77Parser.DoWithEndDoContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#doWithEndDo}.
	 * @param ctx the parse tree
	 */
	void exitDoWithEndDo(fortran77Parser.DoWithEndDoContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#enddoStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnddoStatement(fortran77Parser.EnddoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#enddoStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnddoStatement(fortran77Parser.EnddoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(fortran77Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(fortran77Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#stopStatement}.
	 * @param ctx the parse tree
	 */
	void enterStopStatement(fortran77Parser.StopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#stopStatement}.
	 * @param ctx the parse tree
	 */
	void exitStopStatement(fortran77Parser.StopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void enterPauseStatement(fortran77Parser.PauseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void exitPauseStatement(fortran77Parser.PauseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(fortran77Parser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(fortran77Parser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(fortran77Parser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(fortran77Parser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(fortran77Parser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(fortran77Parser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlInfoList}.
	 * @param ctx the parse tree
	 */
	void enterControlInfoList(fortran77Parser.ControlInfoListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlInfoList}.
	 * @param ctx the parse tree
	 */
	void exitControlInfoList(fortran77Parser.ControlInfoListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlErrSpec}.
	 * @param ctx the parse tree
	 */
	void enterControlErrSpec(fortran77Parser.ControlErrSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlErrSpec}.
	 * @param ctx the parse tree
	 */
	void exitControlErrSpec(fortran77Parser.ControlErrSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlInfoListItem}.
	 * @param ctx the parse tree
	 */
	void enterControlInfoListItem(fortran77Parser.ControlInfoListItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlInfoListItem}.
	 * @param ctx the parse tree
	 */
	void exitControlInfoListItem(fortran77Parser.ControlInfoListItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#ioList}.
	 * @param ctx the parse tree
	 */
	void enterIoList(fortran77Parser.IoListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#ioList}.
	 * @param ctx the parse tree
	 */
	void exitIoList(fortran77Parser.IoListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#ioListItem}.
	 * @param ctx the parse tree
	 */
	void enterIoListItem(fortran77Parser.IoListItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#ioListItem}.
	 * @param ctx the parse tree
	 */
	void exitIoListItem(fortran77Parser.IoListItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#ioImpliedDoList}.
	 * @param ctx the parse tree
	 */
	void enterIoImpliedDoList(fortran77Parser.IoImpliedDoListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#ioImpliedDoList}.
	 * @param ctx the parse tree
	 */
	void exitIoImpliedDoList(fortran77Parser.IoImpliedDoListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#openStatement}.
	 * @param ctx the parse tree
	 */
	void enterOpenStatement(fortran77Parser.OpenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#openStatement}.
	 * @param ctx the parse tree
	 */
	void exitOpenStatement(fortran77Parser.OpenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#openControl}.
	 * @param ctx the parse tree
	 */
	void enterOpenControl(fortran77Parser.OpenControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#openControl}.
	 * @param ctx the parse tree
	 */
	void exitOpenControl(fortran77Parser.OpenControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlFmt}.
	 * @param ctx the parse tree
	 */
	void enterControlFmt(fortran77Parser.ControlFmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlFmt}.
	 * @param ctx the parse tree
	 */
	void exitControlFmt(fortran77Parser.ControlFmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlUnit}.
	 * @param ctx the parse tree
	 */
	void enterControlUnit(fortran77Parser.ControlUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlUnit}.
	 * @param ctx the parse tree
	 */
	void exitControlUnit(fortran77Parser.ControlUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlRec}.
	 * @param ctx the parse tree
	 */
	void enterControlRec(fortran77Parser.ControlRecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlRec}.
	 * @param ctx the parse tree
	 */
	void exitControlRec(fortran77Parser.ControlRecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlEnd}.
	 * @param ctx the parse tree
	 */
	void enterControlEnd(fortran77Parser.ControlEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlEnd}.
	 * @param ctx the parse tree
	 */
	void exitControlEnd(fortran77Parser.ControlEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlErr}.
	 * @param ctx the parse tree
	 */
	void enterControlErr(fortran77Parser.ControlErrContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlErr}.
	 * @param ctx the parse tree
	 */
	void exitControlErr(fortran77Parser.ControlErrContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlIostat}.
	 * @param ctx the parse tree
	 */
	void enterControlIostat(fortran77Parser.ControlIostatContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlIostat}.
	 * @param ctx the parse tree
	 */
	void exitControlIostat(fortran77Parser.ControlIostatContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlFile}.
	 * @param ctx the parse tree
	 */
	void enterControlFile(fortran77Parser.ControlFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlFile}.
	 * @param ctx the parse tree
	 */
	void exitControlFile(fortran77Parser.ControlFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlStatus}.
	 * @param ctx the parse tree
	 */
	void enterControlStatus(fortran77Parser.ControlStatusContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlStatus}.
	 * @param ctx the parse tree
	 */
	void exitControlStatus(fortran77Parser.ControlStatusContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlAccess}.
	 * @param ctx the parse tree
	 */
	void enterControlAccess(fortran77Parser.ControlAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlAccess}.
	 * @param ctx the parse tree
	 */
	void exitControlAccess(fortran77Parser.ControlAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlPosition}.
	 * @param ctx the parse tree
	 */
	void enterControlPosition(fortran77Parser.ControlPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlPosition}.
	 * @param ctx the parse tree
	 */
	void exitControlPosition(fortran77Parser.ControlPositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlForm}.
	 * @param ctx the parse tree
	 */
	void enterControlForm(fortran77Parser.ControlFormContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlForm}.
	 * @param ctx the parse tree
	 */
	void exitControlForm(fortran77Parser.ControlFormContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlRecl}.
	 * @param ctx the parse tree
	 */
	void enterControlRecl(fortran77Parser.ControlReclContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlRecl}.
	 * @param ctx the parse tree
	 */
	void exitControlRecl(fortran77Parser.ControlReclContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlBlank}.
	 * @param ctx the parse tree
	 */
	void enterControlBlank(fortran77Parser.ControlBlankContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlBlank}.
	 * @param ctx the parse tree
	 */
	void exitControlBlank(fortran77Parser.ControlBlankContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlExist}.
	 * @param ctx the parse tree
	 */
	void enterControlExist(fortran77Parser.ControlExistContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlExist}.
	 * @param ctx the parse tree
	 */
	void exitControlExist(fortran77Parser.ControlExistContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlOpened}.
	 * @param ctx the parse tree
	 */
	void enterControlOpened(fortran77Parser.ControlOpenedContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlOpened}.
	 * @param ctx the parse tree
	 */
	void exitControlOpened(fortran77Parser.ControlOpenedContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlNumber}.
	 * @param ctx the parse tree
	 */
	void enterControlNumber(fortran77Parser.ControlNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlNumber}.
	 * @param ctx the parse tree
	 */
	void exitControlNumber(fortran77Parser.ControlNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlNamed}.
	 * @param ctx the parse tree
	 */
	void enterControlNamed(fortran77Parser.ControlNamedContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlNamed}.
	 * @param ctx the parse tree
	 */
	void exitControlNamed(fortran77Parser.ControlNamedContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlName}.
	 * @param ctx the parse tree
	 */
	void enterControlName(fortran77Parser.ControlNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlName}.
	 * @param ctx the parse tree
	 */
	void exitControlName(fortran77Parser.ControlNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlSequential}.
	 * @param ctx the parse tree
	 */
	void enterControlSequential(fortran77Parser.ControlSequentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlSequential}.
	 * @param ctx the parse tree
	 */
	void exitControlSequential(fortran77Parser.ControlSequentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlDirect}.
	 * @param ctx the parse tree
	 */
	void enterControlDirect(fortran77Parser.ControlDirectContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlDirect}.
	 * @param ctx the parse tree
	 */
	void exitControlDirect(fortran77Parser.ControlDirectContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlFormatted}.
	 * @param ctx the parse tree
	 */
	void enterControlFormatted(fortran77Parser.ControlFormattedContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlFormatted}.
	 * @param ctx the parse tree
	 */
	void exitControlFormatted(fortran77Parser.ControlFormattedContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlUnformatted}.
	 * @param ctx the parse tree
	 */
	void enterControlUnformatted(fortran77Parser.ControlUnformattedContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlUnformatted}.
	 * @param ctx the parse tree
	 */
	void exitControlUnformatted(fortran77Parser.ControlUnformattedContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#controlNextrec}.
	 * @param ctx the parse tree
	 */
	void enterControlNextrec(fortran77Parser.ControlNextrecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#controlNextrec}.
	 * @param ctx the parse tree
	 */
	void exitControlNextrec(fortran77Parser.ControlNextrecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void enterCloseStatement(fortran77Parser.CloseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#closeStatement}.
	 * @param ctx the parse tree
	 */
	void exitCloseStatement(fortran77Parser.CloseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#closeControl}.
	 * @param ctx the parse tree
	 */
	void enterCloseControl(fortran77Parser.CloseControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#closeControl}.
	 * @param ctx the parse tree
	 */
	void exitCloseControl(fortran77Parser.CloseControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#inquireStatement}.
	 * @param ctx the parse tree
	 */
	void enterInquireStatement(fortran77Parser.InquireStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#inquireStatement}.
	 * @param ctx the parse tree
	 */
	void exitInquireStatement(fortran77Parser.InquireStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#inquireControl}.
	 * @param ctx the parse tree
	 */
	void enterInquireControl(fortran77Parser.InquireControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#inquireControl}.
	 * @param ctx the parse tree
	 */
	void exitInquireControl(fortran77Parser.InquireControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#backspaceStatement}.
	 * @param ctx the parse tree
	 */
	void enterBackspaceStatement(fortran77Parser.BackspaceStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#backspaceStatement}.
	 * @param ctx the parse tree
	 */
	void exitBackspaceStatement(fortran77Parser.BackspaceStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#endfileStatement}.
	 * @param ctx the parse tree
	 */
	void enterEndfileStatement(fortran77Parser.EndfileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#endfileStatement}.
	 * @param ctx the parse tree
	 */
	void exitEndfileStatement(fortran77Parser.EndfileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#rewindStatement}.
	 * @param ctx the parse tree
	 */
	void enterRewindStatement(fortran77Parser.RewindStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#rewindStatement}.
	 * @param ctx the parse tree
	 */
	void exitRewindStatement(fortran77Parser.RewindStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#berFinish}.
	 * @param ctx the parse tree
	 */
	void enterBerFinish(fortran77Parser.BerFinishContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#berFinish}.
	 * @param ctx the parse tree
	 */
	void exitBerFinish(fortran77Parser.BerFinishContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#berFinishItem}.
	 * @param ctx the parse tree
	 */
	void enterBerFinishItem(fortran77Parser.BerFinishItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#berFinishItem}.
	 * @param ctx the parse tree
	 */
	void exitBerFinishItem(fortran77Parser.BerFinishItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#unitIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnitIdentifier(fortran77Parser.UnitIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#unitIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnitIdentifier(fortran77Parser.UnitIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#formatIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFormatIdentifier(fortran77Parser.FormatIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#formatIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFormatIdentifier(fortran77Parser.FormatIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#formatStatement}.
	 * @param ctx the parse tree
	 */
	void enterFormatStatement(fortran77Parser.FormatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#formatStatement}.
	 * @param ctx the parse tree
	 */
	void exitFormatStatement(fortran77Parser.FormatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#fmtSpec}.
	 * @param ctx the parse tree
	 */
	void enterFmtSpec(fortran77Parser.FmtSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#fmtSpec}.
	 * @param ctx the parse tree
	 */
	void exitFmtSpec(fortran77Parser.FmtSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#formatsep}.
	 * @param ctx the parse tree
	 */
	void enterFormatsep(fortran77Parser.FormatsepContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#formatsep}.
	 * @param ctx the parse tree
	 */
	void exitFormatsep(fortran77Parser.FormatsepContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#formatedit}.
	 * @param ctx the parse tree
	 */
	void enterFormatedit(fortran77Parser.FormateditContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#formatedit}.
	 * @param ctx the parse tree
	 */
	void exitFormatedit(fortran77Parser.FormateditContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#editElement}.
	 * @param ctx the parse tree
	 */
	void enterEditElement(fortran77Parser.EditElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#editElement}.
	 * @param ctx the parse tree
	 */
	void exitEditElement(fortran77Parser.EditElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#statementFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementFunctionStatement(fortran77Parser.StatementFunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#statementFunctionStatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementFunctionStatement(fortran77Parser.StatementFunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#sfArgs}.
	 * @param ctx the parse tree
	 */
	void enterSfArgs(fortran77Parser.SfArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#sfArgs}.
	 * @param ctx the parse tree
	 */
	void exitSfArgs(fortran77Parser.SfArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#callStatement}.
	 * @param ctx the parse tree
	 */
	void enterCallStatement(fortran77Parser.CallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#callStatement}.
	 * @param ctx the parse tree
	 */
	void exitCallStatement(fortran77Parser.CallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineCall(fortran77Parser.SubroutineCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subroutineCall}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineCall(fortran77Parser.SubroutineCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#callArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterCallArgumentList(fortran77Parser.CallArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#callArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitCallArgumentList(fortran77Parser.CallArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#callArgument}.
	 * @param ctx the parse tree
	 */
	void enterCallArgument(fortran77Parser.CallArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#callArgument}.
	 * @param ctx the parse tree
	 */
	void exitCallArgument(fortran77Parser.CallArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(fortran77Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(fortran77Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(fortran77Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(fortran77Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#ncExpr}.
	 * @param ctx the parse tree
	 */
	void enterNcExpr(fortran77Parser.NcExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#ncExpr}.
	 * @param ctx the parse tree
	 */
	void exitNcExpr(fortran77Parser.NcExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lexpr0}.
	 * @param ctx the parse tree
	 */
	void enterLexpr0(fortran77Parser.Lexpr0Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lexpr0}.
	 * @param ctx the parse tree
	 */
	void exitLexpr0(fortran77Parser.Lexpr0Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lexprSpec}.
	 * @param ctx the parse tree
	 */
	void enterLexprSpec(fortran77Parser.LexprSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lexprSpec}.
	 * @param ctx the parse tree
	 */
	void exitLexprSpec(fortran77Parser.LexprSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lexpr1}.
	 * @param ctx the parse tree
	 */
	void enterLexpr1(fortran77Parser.Lexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lexpr1}.
	 * @param ctx the parse tree
	 */
	void exitLexpr1(fortran77Parser.Lexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#lexpr2}.
	 * @param ctx the parse tree
	 */
	void enterLexpr2(fortran77Parser.Lexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#lexpr2}.
	 * @param ctx the parse tree
	 */
	void exitLexpr2(fortran77Parser.Lexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aexpr0}.
	 * @param ctx the parse tree
	 */
	void enterAexpr0(fortran77Parser.Aexpr0Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aexpr0}.
	 * @param ctx the parse tree
	 */
	void exitAexpr0(fortran77Parser.Aexpr0Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void enterAexpr1(fortran77Parser.Aexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void exitAexpr1(fortran77Parser.Aexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void enterAexpr2(fortran77Parser.Aexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void exitAexpr2(fortran77Parser.Aexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void enterAexpr3(fortran77Parser.Aexpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void exitAexpr3(fortran77Parser.Aexpr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aexpr4}.
	 * @param ctx the parse tree
	 */
	void enterAexpr4(fortran77Parser.Aexpr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aexpr4}.
	 * @param ctx the parse tree
	 */
	void exitAexpr4(fortran77Parser.Aexpr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arealexpr}.
	 * @param ctx the parse tree
	 */
	void enterArealexpr(fortran77Parser.ArealexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arealexpr}.
	 * @param ctx the parse tree
	 */
	void exitArealexpr(fortran77Parser.ArealexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#astringexpr}.
	 * @param ctx the parse tree
	 */
	void enterAstringexpr(fortran77Parser.AstringexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#astringexpr}.
	 * @param ctx the parse tree
	 */
	void exitAstringexpr(fortran77Parser.AstringexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#aintegerexpr}.
	 * @param ctx the parse tree
	 */
	void enterAintegerexpr(fortran77Parser.AintegerexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#aintegerexpr}.
	 * @param ctx the parse tree
	 */
	void exitAintegerexpr(fortran77Parser.AintegerexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexpr}.
	 * @param ctx the parse tree
	 */
	void enterIexpr(fortran77Parser.IexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexpr}.
	 * @param ctx the parse tree
	 */
	void exitIexpr(fortran77Parser.IexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexprCode}.
	 * @param ctx the parse tree
	 */
	void enterIexprCode(fortran77Parser.IexprCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexprCode}.
	 * @param ctx the parse tree
	 */
	void exitIexprCode(fortran77Parser.IexprCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexpr1}.
	 * @param ctx the parse tree
	 */
	void enterIexpr1(fortran77Parser.Iexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexpr1}.
	 * @param ctx the parse tree
	 */
	void exitIexpr1(fortran77Parser.Iexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexpr2}.
	 * @param ctx the parse tree
	 */
	void enterIexpr2(fortran77Parser.Iexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexpr2}.
	 * @param ctx the parse tree
	 */
	void exitIexpr2(fortran77Parser.Iexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexpr3}.
	 * @param ctx the parse tree
	 */
	void enterIexpr3(fortran77Parser.Iexpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexpr3}.
	 * @param ctx the parse tree
	 */
	void exitIexpr3(fortran77Parser.Iexpr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#iexpr4}.
	 * @param ctx the parse tree
	 */
	void enterIexpr4(fortran77Parser.Iexpr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#iexpr4}.
	 * @param ctx the parse tree
	 */
	void exitIexpr4(fortran77Parser.Iexpr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#constantExpr}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpr(fortran77Parser.ConstantExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#constantExpr}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpr(fortran77Parser.ConstantExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(fortran77Parser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(fortran77Parser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#integerExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(fortran77Parser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#integerExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(fortran77Parser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#intRealDpExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntRealDpExpr(fortran77Parser.IntRealDpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#intRealDpExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntRealDpExpr(fortran77Parser.IntRealDpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arithmeticConstExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticConstExpr(fortran77Parser.ArithmeticConstExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arithmeticConstExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticConstExpr(fortran77Parser.ArithmeticConstExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#intConstantExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntConstantExpr(fortran77Parser.IntConstantExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#intConstantExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntConstantExpr(fortran77Parser.IntConstantExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#characterExpression}.
	 * @param ctx the parse tree
	 */
	void enterCharacterExpression(fortran77Parser.CharacterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#characterExpression}.
	 * @param ctx the parse tree
	 */
	void exitCharacterExpression(fortran77Parser.CharacterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#concatOp}.
	 * @param ctx the parse tree
	 */
	void enterConcatOp(fortran77Parser.ConcatOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#concatOp}.
	 * @param ctx the parse tree
	 */
	void exitConcatOp(fortran77Parser.ConcatOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(fortran77Parser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(fortran77Parser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#logicalConstExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConstExpr(fortran77Parser.LogicalConstExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#logicalConstExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConstExpr(fortran77Parser.LogicalConstExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayElementName}.
	 * @param ctx the parse tree
	 */
	void enterArrayElementName(fortran77Parser.ArrayElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayElementName}.
	 * @param ctx the parse tree
	 */
	void exitArrayElementName(fortran77Parser.ArrayElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subscripts}.
	 * @param ctx the parse tree
	 */
	void enterSubscripts(fortran77Parser.SubscriptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subscripts}.
	 * @param ctx the parse tree
	 */
	void exitSubscripts(fortran77Parser.SubscriptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#varRef}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(fortran77Parser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#varRef}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(fortran77Parser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#varRefCode}.
	 * @param ctx the parse tree
	 */
	void enterVarRefCode(fortran77Parser.VarRefCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#varRefCode}.
	 * @param ctx the parse tree
	 */
	void exitVarRefCode(fortran77Parser.VarRefCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#substringApp}.
	 * @param ctx the parse tree
	 */
	void enterSubstringApp(fortran77Parser.SubstringAppContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#substringApp}.
	 * @param ctx the parse tree
	 */
	void exitSubstringApp(fortran77Parser.SubstringAppContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(fortran77Parser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(fortran77Parser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#arrayName}.
	 * @param ctx the parse tree
	 */
	void enterArrayName(fortran77Parser.ArrayNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#arrayName}.
	 * @param ctx the parse tree
	 */
	void exitArrayName(fortran77Parser.ArrayNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void enterSubroutineName(fortran77Parser.SubroutineNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#subroutineName}.
	 * @param ctx the parse tree
	 */
	void exitSubroutineName(fortran77Parser.SubroutineNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(fortran77Parser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(fortran77Parser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(fortran77Parser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(fortran77Parser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#unsignedArithmeticConstant}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedArithmeticConstant(fortran77Parser.UnsignedArithmeticConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#unsignedArithmeticConstant}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedArithmeticConstant(fortran77Parser.UnsignedArithmeticConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#complexConstant}.
	 * @param ctx the parse tree
	 */
	void enterComplexConstant(fortran77Parser.ComplexConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#complexConstant}.
	 * @param ctx the parse tree
	 */
	void exitComplexConstant(fortran77Parser.ComplexConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#logicalConstant}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConstant(fortran77Parser.LogicalConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#logicalConstant}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConstant(fortran77Parser.LogicalConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(fortran77Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(fortran77Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#to}.
	 * @param ctx the parse tree
	 */
	void enterTo(fortran77Parser.ToContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#to}.
	 * @param ctx the parse tree
	 */
	void exitTo(fortran77Parser.ToContext ctx);
	/**
	 * Enter a parse tree produced by {@link fortran77Parser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(fortran77Parser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link fortran77Parser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(fortran77Parser.KeywordContext ctx);
}