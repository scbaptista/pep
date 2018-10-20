package pep.server.utils.grammar;

// Generated from PEP.g4 by ANTLR 4.7.1

    import java.util.*;
    import java.util.List;
	import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.HashMap;
	import java.util.Map;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PEPParser}.
 */
public interface PEPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PEPParser#plano}.
	 * @param ctx the parse tree
	 */
	void enterPlano(PEPParser.PlanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#plano}.
	 * @param ctx the parse tree
	 */
	void exitPlano(PEPParser.PlanoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#sessoes}.
	 * @param ctx the parse tree
	 */
	void enterSessoes(PEPParser.SessoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#sessoes}.
	 * @param ctx the parse tree
	 */
	void exitSessoes(PEPParser.SessoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#sessao}.
	 * @param ctx the parse tree
	 */
	void enterSessao(PEPParser.SessaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#sessao}.
	 * @param ctx the parse tree
	 */
	void exitSessao(PEPParser.SessaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#infoSessao}.
	 * @param ctx the parse tree
	 */
	void enterInfoSessao(PEPParser.InfoSessaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#infoSessao}.
	 * @param ctx the parse tree
	 */
	void exitInfoSessao(PEPParser.InfoSessaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#titulo}.
	 * @param ctx the parse tree
	 */
	void enterTitulo(PEPParser.TituloContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#titulo}.
	 * @param ctx the parse tree
	 */
	void exitTitulo(PEPParser.TituloContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#tema}.
	 * @param ctx the parse tree
	 */
	void enterTema(PEPParser.TemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#tema}.
	 * @param ctx the parse tree
	 */
	void exitTema(PEPParser.TemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#parteA}.
	 * @param ctx the parse tree
	 */
	void enterParteA(PEPParser.ParteAContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#parteA}.
	 * @param ctx the parse tree
	 */
	void exitParteA(PEPParser.ParteAContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#parteE}.
	 * @param ctx the parse tree
	 */
	void enterParteE(PEPParser.ParteEContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#parteE}.
	 * @param ctx the parse tree
	 */
	void exitParteE(PEPParser.ParteEContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#ordem}.
	 * @param ctx the parse tree
	 */
	void enterOrdem(PEPParser.OrdemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#ordem}.
	 * @param ctx the parse tree
	 */
	void exitOrdem(PEPParser.OrdemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#listaA}.
	 * @param ctx the parse tree
	 */
	void enterListaA(PEPParser.ListaAContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#listaA}.
	 * @param ctx the parse tree
	 */
	void exitListaA(PEPParser.ListaAContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#listaE}.
	 * @param ctx the parse tree
	 */
	void enterListaE(PEPParser.ListaEContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#listaE}.
	 * @param ctx the parse tree
	 */
	void exitListaE(PEPParser.ListaEContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#exerc}.
	 * @param ctx the parse tree
	 */
	void enterExerc(PEPParser.ExercContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#exerc}.
	 * @param ctx the parse tree
	 */
	void exitExerc(PEPParser.ExercContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#idPlano}.
	 * @param ctx the parse tree
	 */
	void enterIdPlano(PEPParser.IdPlanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#idPlano}.
	 * @param ctx the parse tree
	 */
	void exitIdPlano(PEPParser.IdPlanoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#idSessao}.
	 * @param ctx the parse tree
	 */
	void enterIdSessao(PEPParser.IdSessaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#idSessao}.
	 * @param ctx the parse tree
	 */
	void exitIdSessao(PEPParser.IdSessaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#idTema}.
	 * @param ctx the parse tree
	 */
	void enterIdTema(PEPParser.IdTemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#idTema}.
	 * @param ctx the parse tree
	 */
	void exitIdTema(PEPParser.IdTemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PEPParser#idExerc}.
	 * @param ctx the parse tree
	 */
	void enterIdExerc(PEPParser.IdExercContext ctx);
	/**
	 * Exit a parse tree produced by {@link PEPParser#idExerc}.
	 * @param ctx the parse tree
	 */
	void exitIdExerc(PEPParser.IdExercContext ctx);
}