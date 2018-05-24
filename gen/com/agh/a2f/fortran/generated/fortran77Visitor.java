// Generated from /home/daniel/Desktop/antlr4-fortran/src/main/java/com/agh/a2f/fortran/generated/fortran77.g4 by ANTLR 4.7
package com.agh.a2f.fortran.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fortran77Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface fortran77Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(fortran77Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#executableUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutableUnit(fortran77Parser.ExecutableUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#mainProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainProgram(fortran77Parser.MainProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#functionSubprogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSubprogram(fortran77Parser.FunctionSubprogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subroutineSubprogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineSubprogram(fortran77Parser.SubroutineSubprogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#blockdataSubprogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockdataSubprogram(fortran77Parser.BlockdataSubprogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#otherSpecificationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherSpecificationStatement(fortran77Parser.OtherSpecificationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#executableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutableStatement(fortran77Parser.ExecutableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#programStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramStatement(fortran77Parser.ProgramStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#seos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeos(fortran77Parser.SeosContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#entryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntryStatement(fortran77Parser.EntryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(fortran77Parser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#blockdataStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockdataStatement(fortran77Parser.BlockdataStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subroutineStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineStatement(fortran77Parser.SubroutineStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#namelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamelist(fortran77Parser.NamelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(fortran77Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subprogramBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprogramBody(fortran77Parser.SubprogramBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#wholeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWholeStatement(fortran77Parser.WholeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#endStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndStatement(fortran77Parser.EndStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dimensionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensionStatement(fortran77Parser.DimensionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclarator(fortran77Parser.ArrayDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclarators(fortran77Parser.ArrayDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaratorExtents(fortran77Parser.ArrayDeclaratorExtentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayDeclaratorExtent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaratorExtent(fortran77Parser.ArrayDeclaratorExtentContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#equivalenceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalenceStatement(fortran77Parser.EquivalenceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#equivEntityGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivEntityGroup(fortran77Parser.EquivEntityGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#equivEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivEntity(fortran77Parser.EquivEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#commonStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonStatement(fortran77Parser.CommonStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#commonName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonName(fortran77Parser.CommonNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#commonItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonItem(fortran77Parser.CommonItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#commonItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonItems(fortran77Parser.CommonItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#commonBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonBlock(fortran77Parser.CommonBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatement(fortran77Parser.TypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatementNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatementNameList(fortran77Parser.TypeStatementNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatementName(fortran77Parser.TypeStatementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatementNameCharList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatementNameCharList(fortran77Parser.TypeStatementNameCharListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatementNameChar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatementNameChar(fortran77Parser.TypeStatementNameCharContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typeStatementLenSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatementLenSpec(fortran77Parser.TypeStatementLenSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypename(fortran77Parser.TypenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(fortran77Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#typenameLen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypenameLen(fortran77Parser.TypenameLenContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#pointerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerStatement(fortran77Parser.PointerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#pointerDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerDecl(fortran77Parser.PointerDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitStatement(fortran77Parser.ImplicitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitSpec(fortran77Parser.ImplicitSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitSpecs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitSpecs(fortran77Parser.ImplicitSpecsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitNone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitNone(fortran77Parser.ImplicitNoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitLetter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitLetter(fortran77Parser.ImplicitLetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitRange(fortran77Parser.ImplicitRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#implicitLetters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicitLetters(fortran77Parser.ImplicitLettersContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lenSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenSpecification(fortran77Parser.LenSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#characterWithLen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterWithLen(fortran77Parser.CharacterWithLenContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#cwlLen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCwlLen(fortran77Parser.CwlLenContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#parameterStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterStatement(fortran77Parser.ParameterStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(fortran77Parser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#paramassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamassign(fortran77Parser.ParamassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#externalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalStatement(fortran77Parser.ExternalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#intrinsicStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntrinsicStatement(fortran77Parser.IntrinsicStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#saveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveStatement(fortran77Parser.SaveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#saveEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaveEntity(fortran77Parser.SaveEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataStatement(fortran77Parser.DataStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataStatementItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataStatementItem(fortran77Parser.DataStatementItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataStatementMultiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataStatementMultiple(fortran77Parser.DataStatementMultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataStatementEntity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataStatementEntity(fortran77Parser.DataStatementEntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dse1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDse1(fortran77Parser.Dse1Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dse2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDse2(fortran77Parser.Dse2Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataImpliedDo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataImpliedDo(fortran77Parser.DataImpliedDoContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataImpliedDoRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataImpliedDoRange(fortran77Parser.DataImpliedDoRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataImpliedDoList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataImpliedDoList(fortran77Parser.DataImpliedDoListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#dataImpliedDoListWhat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataImpliedDoListWhat(fortran77Parser.DataImpliedDoListWhatContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#gotoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(fortran77Parser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#unconditionalGoto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnconditionalGoto(fortran77Parser.UnconditionalGotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#computedGoto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedGoto(fortran77Parser.ComputedGotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lblRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLblRef(fortran77Parser.LblRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#labelList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelList(fortran77Parser.LabelListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#assignedGoto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignedGoto(fortran77Parser.AssignedGotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(fortran77Parser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arithmeticIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticIfStatement(fortran77Parser.ArithmeticIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#logicalIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalIfStatement(fortran77Parser.LogicalIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#blockIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIfStatement(fortran77Parser.BlockIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#firstIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstIfBlock(fortran77Parser.FirstIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(fortran77Parser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(fortran77Parser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#endIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndIfStatement(fortran77Parser.EndIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(fortran77Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#doVarArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoVarArgs(fortran77Parser.DoVarArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#doWithLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWithLabel(fortran77Parser.DoWithLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#doBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoBody(fortran77Parser.DoBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#doWithEndDo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWithEndDo(fortran77Parser.DoWithEndDoContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#enddoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnddoStatement(fortran77Parser.EnddoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(fortran77Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#stopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStopStatement(fortran77Parser.StopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#pauseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPauseStatement(fortran77Parser.PauseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(fortran77Parser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(fortran77Parser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(fortran77Parser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(fortran77Parser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlInfoList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlInfoList(fortran77Parser.ControlInfoListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlErrSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlErrSpec(fortran77Parser.ControlErrSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlInfoListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlInfoListItem(fortran77Parser.ControlInfoListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#ioList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoList(fortran77Parser.IoListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#ioListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoListItem(fortran77Parser.IoListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#ioImpliedDoList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoImpliedDoList(fortran77Parser.IoImpliedDoListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#openStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenStatement(fortran77Parser.OpenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#openControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenControl(fortran77Parser.OpenControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlFmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlFmt(fortran77Parser.ControlFmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlUnit(fortran77Parser.ControlUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlRec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlRec(fortran77Parser.ControlRecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlEnd(fortran77Parser.ControlEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlErr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlErr(fortran77Parser.ControlErrContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlIostat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlIostat(fortran77Parser.ControlIostatContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlFile(fortran77Parser.ControlFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStatus(fortran77Parser.ControlStatusContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlAccess(fortran77Parser.ControlAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlPosition(fortran77Parser.ControlPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlForm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlForm(fortran77Parser.ControlFormContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlRecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlRecl(fortran77Parser.ControlReclContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlBlank}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlBlank(fortran77Parser.ControlBlankContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlExist(fortran77Parser.ControlExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlOpened}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlOpened(fortran77Parser.ControlOpenedContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlNumber(fortran77Parser.ControlNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlNamed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlNamed(fortran77Parser.ControlNamedContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlName(fortran77Parser.ControlNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlSequential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlSequential(fortran77Parser.ControlSequentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlDirect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlDirect(fortran77Parser.ControlDirectContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlFormatted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlFormatted(fortran77Parser.ControlFormattedContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlUnformatted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlUnformatted(fortran77Parser.ControlUnformattedContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#controlNextrec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlNextrec(fortran77Parser.ControlNextrecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#closeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseStatement(fortran77Parser.CloseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#closeControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseControl(fortran77Parser.CloseControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#inquireStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInquireStatement(fortran77Parser.InquireStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#inquireControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInquireControl(fortran77Parser.InquireControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#backspaceStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackspaceStatement(fortran77Parser.BackspaceStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#endfileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndfileStatement(fortran77Parser.EndfileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#rewindStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRewindStatement(fortran77Parser.RewindStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#berFinish}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBerFinish(fortran77Parser.BerFinishContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#berFinishItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBerFinishItem(fortran77Parser.BerFinishItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#unitIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitIdentifier(fortran77Parser.UnitIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#formatIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatIdentifier(fortran77Parser.FormatIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#formatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatStatement(fortran77Parser.FormatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#fmtSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFmtSpec(fortran77Parser.FmtSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#formatsep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatsep(fortran77Parser.FormatsepContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#formatedit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormatedit(fortran77Parser.FormateditContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#editElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEditElement(fortran77Parser.EditElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#statementFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFunctionStatement(fortran77Parser.StatementFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#sfArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSfArgs(fortran77Parser.SfArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#callStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStatement(fortran77Parser.CallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subroutineCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineCall(fortran77Parser.SubroutineCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#callArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgumentList(fortran77Parser.CallArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#callArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgument(fortran77Parser.CallArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(fortran77Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(fortran77Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#ncExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcExpr(fortran77Parser.NcExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lexpr0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr0(fortran77Parser.Lexpr0Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lexpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr1(fortran77Parser.Lexpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr2(fortran77Parser.Lexpr2Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr3(fortran77Parser.Lexpr3Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#lexpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexpr4(fortran77Parser.Lexpr4Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aexpr0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr0(fortran77Parser.Aexpr0Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aexpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr1(fortran77Parser.Aexpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr2(fortran77Parser.Aexpr2Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr3(fortran77Parser.Aexpr3Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aexpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr4(fortran77Parser.Aexpr4Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arealexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArealexpr(fortran77Parser.ArealexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#astringexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAstringexpr(fortran77Parser.AstringexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#aintegerexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAintegerexpr(fortran77Parser.AintegerexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexpr(fortran77Parser.IexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexprCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexprCode(fortran77Parser.IexprCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexpr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexpr1(fortran77Parser.Iexpr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexpr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexpr2(fortran77Parser.Iexpr2Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexpr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexpr3(fortran77Parser.Iexpr3Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#iexpr4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIexpr4(fortran77Parser.Iexpr4Context ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#constantExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpr(fortran77Parser.ConstantExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(fortran77Parser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#integerExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpr(fortran77Parser.IntegerExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#intRealDpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntRealDpExpr(fortran77Parser.IntRealDpExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arithmeticConstExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticConstExpr(fortran77Parser.ArithmeticConstExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#intConstantExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConstantExpr(fortran77Parser.IntConstantExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#characterExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterExpression(fortran77Parser.CharacterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#concatOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatOp(fortran77Parser.ConcatOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(fortran77Parser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#logicalConstExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalConstExpr(fortran77Parser.LogicalConstExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementName(fortran77Parser.ArrayElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subscripts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscripts(fortran77Parser.SubscriptsContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#varRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(fortran77Parser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#varRefCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRefCode(fortran77Parser.VarRefCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#substringApp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstringApp(fortran77Parser.SubstringAppContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(fortran77Parser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#arrayName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayName(fortran77Parser.ArrayNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#subroutineName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubroutineName(fortran77Parser.SubroutineNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(fortran77Parser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(fortran77Parser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#unsignedArithmeticConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedArithmeticConstant(fortran77Parser.UnsignedArithmeticConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#complexConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexConstant(fortran77Parser.ComplexConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#logicalConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalConstant(fortran77Parser.LogicalConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(fortran77Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(fortran77Parser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link fortran77Parser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(fortran77Parser.KeywordContext ctx);
}