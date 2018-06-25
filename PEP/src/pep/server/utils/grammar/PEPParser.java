package pep.server.utils.grammar;

// Generated from PEP.g4 by ANTLR 4.7.1

    import java.util.*;
    import java.sql.*;
    import java.util.logging.Level;
	import java.util.logging.Logger;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PEPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, WS=16, INT=17, 
		STRING=18;
	public static final int
		RULE_plano = 0, RULE_sessoes = 1, RULE_sessao = 2, RULE_infoSessao = 3, 
		RULE_titulo = 4, RULE_tema = 5, RULE_parteA = 6, RULE_parteE = 7, RULE_ordem = 8, 
		RULE_listaA = 9, RULE_listaE = 10, RULE_exerc = 11, RULE_idPlano = 12, 
		RULE_idSessao = 13, RULE_idTema = 14, RULE_idExerc = 15;
	public static final String[] ruleNames = {
		"plano", "sessoes", "sessao", "infoSessao", "titulo", "tema", "parteA", 
		"parteE", "ordem", "listaA", "listaE", "exerc", "idPlano", "idSessao", 
		"idTema", "idExerc"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Plano'", "'Fim'", "'SESS\uFFFDO'", "'-'", "'TEMA:'", "'PARTE A:'", 
		"'PARTE E:'", "'ORDEM:'", "'A'", "'E'", "','", "'?'", "'P'", "'S'", "'T'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "WS", "INT", "STRING"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PEP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    ArrayList<String> sessoes, exs;
	    StringBuilder sessao;
	    int i, flagOrd;

	public PEPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PlanoContext extends ParserRuleContext {
		public ArrayList<String> exercs;
		public IdPlanoContext idPlano() {
			return getRuleContext(IdPlanoContext.class,0);
		}
		public SessoesContext sessoes() {
			return getRuleContext(SessoesContext.class,0);
		}
		public PlanoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PlanoContext(ParserRuleContext parent, int invokingState, ArrayList<String> exercs) {
			super(parent, invokingState);
			this.exercs = exercs;
		}
		@Override public int getRuleIndex() { return RULE_plano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterPlano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitPlano(this);
		}
	}

	public final PlanoContext plano(ArrayList<String> exercs) throws RecognitionException {
		PlanoContext _localctx = new PlanoContext(_ctx, getState(), exercs);
		enterRule(_localctx, 0, RULE_plano);
		 i = 0; sessoes = new ArrayList<String>(); exs = new ArrayList<String>(exercs); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			idPlano();
			setState(34);
			sessoes();
			setState(35);
			match(T__1);
			 
						   	 for(int j=0; j<i; j++)
						   		System.out.println(sessoes.get(j));
						   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SessoesContext extends ParserRuleContext {
		public List<SessaoContext> sessao() {
			return getRuleContexts(SessaoContext.class);
		}
		public SessaoContext sessao(int i) {
			return getRuleContext(SessaoContext.class,i);
		}
		public SessoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sessoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterSessoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitSessoes(this);
		}
	}

	public final SessoesContext sessoes() throws RecognitionException {
		SessoesContext _localctx = new SessoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sessoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				sessao();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SessaoContext extends ParserRuleContext {
		public InfoSessaoContext infoSessao() {
			return getRuleContext(InfoSessaoContext.class,0);
		}
		public TemaContext tema() {
			return getRuleContext(TemaContext.class,0);
		}
		public ParteAContext parteA() {
			return getRuleContext(ParteAContext.class,0);
		}
		public ParteEContext parteE() {
			return getRuleContext(ParteEContext.class,0);
		}
		public OrdemContext ordem() {
			return getRuleContext(OrdemContext.class,0);
		}
		public SessaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sessao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterSessao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitSessao(this);
		}
	}

	public final SessaoContext sessao() throws RecognitionException {
		SessaoContext _localctx = new SessaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sessao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__2);
			setState(44);
			infoSessao();
			setState(45);
			tema();
			setState(46);
			parteA();
			setState(47);
			parteE();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(48);
				ordem();
				}
			}

			 
						  	if (flagOrd == 0) {
						  		sessao.append("\"ordem\": \"E, A\"");
						  	}	
						  	sessao.append("}");
						  	sessoes.add(sessao.toString()); 
						  	i++; 
						  	flagOrd = 0; 
						  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfoSessaoContext extends ParserRuleContext {
		public TituloContext titulo;
		public IdSessaoContext idSessao() {
			return getRuleContext(IdSessaoContext.class,0);
		}
		public TituloContext titulo() {
			return getRuleContext(TituloContext.class,0);
		}
		public InfoSessaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infoSessao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterInfoSessao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitInfoSessao(this);
		}
	}

	public final InfoSessaoContext infoSessao() throws RecognitionException {
		InfoSessaoContext _localctx = new InfoSessaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_infoSessao);
		 sessao = new StringBuilder(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			idSessao();
			setState(54);
			match(T__3);
			setState(55);
			((InfoSessaoContext)_localctx).titulo = titulo();
			 // {"sessao": "Introdu��o a Arrays",
					  	  	sessao.append("{\"sessao\": " + (((InfoSessaoContext)_localctx).titulo!=null?_input.getText(((InfoSessaoContext)_localctx).titulo.start,((InfoSessaoContext)_localctx).titulo.stop):null) + ", "); 
					  	  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TituloContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PEPParser.STRING, 0); }
		public TituloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_titulo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterTitulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitTitulo(this);
		}
	}

	public final TituloContext titulo() throws RecognitionException {
		TituloContext _localctx = new TituloContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_titulo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemaContext extends ParserRuleContext {
		public IdTemaContext idTema() {
			return getRuleContext(IdTemaContext.class,0);
		}
		public TemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterTema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitTema(this);
		}
	}

	public final TemaContext tema() throws RecognitionException {
		TemaContext _localctx = new TemaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tema);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__4);
			setState(61);
			idTema();
			 
						  	String t = "BD";
						  	// "tema": "Arrays", 
						  	sessao.append("\"tema\": " + t + ", "); 
						  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParteAContext extends ParserRuleContext {
		public ListaAContext listaA() {
			return getRuleContext(ListaAContext.class,0);
		}
		public ParteAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parteA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterParteA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitParteA(this);
		}
	}

	public final ParteAContext parteA() throws RecognitionException {
		ParteAContext _localctx = new ParteAContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parteA);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__5);
			 sessao.append("\"partea\": {"); 
			setState(66);
			listaA();
			 sessao.append("}, "); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParteEContext extends ParserRuleContext {
		public ListaEContext listaE() {
			return getRuleContext(ListaEContext.class,0);
		}
		public ParteEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parteE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterParteE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitParteE(this);
		}
	}

	public final ParteEContext parteE() throws RecognitionException {
		ParteEContext _localctx = new ParteEContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parteE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__6);
			 sessao.append("\"partee\": {"); 
			setState(71);
			listaE();
			 sessao.append("}, "); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrdemContext extends ParserRuleContext {
		public Token x;
		public Token y;
		public OrdemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterOrdem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitOrdem(this);
		}
	}

	public final OrdemContext ordem() throws RecognitionException {
		OrdemContext _localctx = new OrdemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ordem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__7);
			setState(75);
			((OrdemContext)_localctx).x = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
				((OrdemContext)_localctx).x = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(76);
			match(T__10);
			setState(77);
			((OrdemContext)_localctx).y = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
				((OrdemContext)_localctx).y = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 //	"ordem": "A, E" }
						  	flagOrd = 1;
						  	sessao.append("\"ordem\": \"" + (((OrdemContext)_localctx).x!=null?((OrdemContext)_localctx).x.getText():null) + ", " + (((OrdemContext)_localctx).y!=null?((OrdemContext)_localctx).y.getText():null) + "\""); 
						  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaAContext extends ParserRuleContext {
		public List<ExercContext> exerc() {
			return getRuleContexts(ExercContext.class);
		}
		public ExercContext exerc(int i) {
			return getRuleContext(ExercContext.class,i);
		}
		public ListaAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterListaA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitListaA(this);
		}
	}

	public final ListaAContext listaA() throws RecognitionException {
		ListaAContext _localctx = new ListaAContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listaA);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(80);
					match(T__11);
					}
				}

				setState(83);
				exerc();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 || _la==T__11 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaEContext extends ParserRuleContext {
		public List<ExercContext> exerc() {
			return getRuleContexts(ExercContext.class);
		}
		public ExercContext exerc(int i) {
			return getRuleContext(ExercContext.class,i);
		}
		public ListaEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterListaE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitListaE(this);
		}
	}

	public final ListaEContext listaE() throws RecognitionException {
		ListaEContext _localctx = new ListaEContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listaE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				exerc();
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExercContext extends ParserRuleContext {
		public IdExercContext idExerc() {
			return getRuleContext(IdExercContext.class,0);
		}
		public ExercContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exerc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterExerc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitExerc(this);
		}
	}

	public final ExercContext exerc() throws RecognitionException {
		ExercContext _localctx = new ExercContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exerc);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				idExerc();
				setState(94);
				match(T__10);
				 sessao.append(","); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				idExerc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdPlanoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PEPParser.INT, 0); }
		public IdPlanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idPlano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterIdPlano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitIdPlano(this);
		}
	}

	public final IdPlanoContext idPlano() throws RecognitionException {
		IdPlanoContext _localctx = new IdPlanoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idPlano);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__12);
			setState(101);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdSessaoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PEPParser.INT, 0); }
		public IdSessaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idSessao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterIdSessao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitIdSessao(this);
		}
	}

	public final IdSessaoContext idSessao() throws RecognitionException {
		IdSessaoContext _localctx = new IdSessaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_idSessao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__13);
			setState(104);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdTemaContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PEPParser.INT, 0); }
		public IdTemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idTema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterIdTema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitIdTema(this);
		}
	}

	public final IdTemaContext idTema() throws RecognitionException {
		IdTemaContext _localctx = new IdTemaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_idTema);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__14);
			setState(107);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdExercContext extends ParserRuleContext {
		public Token e;
		public TerminalNode INT() { return getToken(PEPParser.INT, 0); }
		public IdExercContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idExerc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).enterIdExerc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PEPListener ) ((PEPListener)listener).exitIdExerc(this);
		}
	}

	public final IdExercContext idExerc() throws RecognitionException {
		IdExercContext _localctx = new IdExercContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_idExerc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__9);
			setState(110);
			((IdExercContext)_localctx).e = match(INT);
			 
							if(exs.contains((((IdExercContext)_localctx).e!=null?((IdExercContext)_localctx).e.getText():null))) {
								sessao.append("{\"id\": \"E" + (((IdExercContext)_localctx).e!=null?((IdExercContext)_localctx).e.getText():null) + "\"}");
							} else {
								throw new RuntimeException("$$$$$$ ERRO $$$$$$");
								//System.out.println("$$$$$$ ERRO $$$$$$");
								//System.exit(1);
							}
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24t\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13T\n\13\3\13\6\13W"+
		"\n\13\r\13\16\13X\3\f\6\f\\\n\f\r\f\16\f]\3\r\3\r\3\r\3\r\3\r\5\re\n\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\13\f\2i\2\"\3"+
		"\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b\67\3\2\2\2\n<\3\2\2\2\f>\3\2\2\2\16B\3"+
		"\2\2\2\20G\3\2\2\2\22L\3\2\2\2\24V\3\2\2\2\26[\3\2\2\2\30d\3\2\2\2\32"+
		"f\3\2\2\2\34i\3\2\2\2\36l\3\2\2\2 o\3\2\2\2\"#\7\3\2\2#$\5\32\16\2$%\5"+
		"\4\3\2%&\7\4\2\2&\'\b\2\1\2\'\3\3\2\2\2(*\5\6\4\2)(\3\2\2\2*+\3\2\2\2"+
		"+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-.\7\5\2\2./\5\b\5\2/\60\5\f\7\2\60\61"+
		"\5\16\b\2\61\63\5\20\t\2\62\64\5\22\n\2\63\62\3\2\2\2\63\64\3\2\2\2\64"+
		"\65\3\2\2\2\65\66\b\4\1\2\66\7\3\2\2\2\678\5\34\17\289\7\6\2\29:\5\n\6"+
		"\2:;\b\5\1\2;\t\3\2\2\2<=\7\24\2\2=\13\3\2\2\2>?\7\7\2\2?@\5\36\20\2@"+
		"A\b\7\1\2A\r\3\2\2\2BC\7\b\2\2CD\b\b\1\2DE\5\24\13\2EF\b\b\1\2F\17\3\2"+
		"\2\2GH\7\t\2\2HI\b\t\1\2IJ\5\26\f\2JK\b\t\1\2K\21\3\2\2\2LM\7\n\2\2MN"+
		"\t\2\2\2NO\7\r\2\2OP\t\2\2\2PQ\b\n\1\2Q\23\3\2\2\2RT\7\16\2\2SR\3\2\2"+
		"\2ST\3\2\2\2TU\3\2\2\2UW\5\30\r\2VS\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2"+
		"\2\2Y\25\3\2\2\2Z\\\5\30\r\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2"+
		"^\27\3\2\2\2_`\5 \21\2`a\7\r\2\2ab\b\r\1\2be\3\2\2\2ce\5 \21\2d_\3\2\2"+
		"\2dc\3\2\2\2e\31\3\2\2\2fg\7\17\2\2gh\7\23\2\2h\33\3\2\2\2ij\7\20\2\2"+
		"jk\7\23\2\2k\35\3\2\2\2lm\7\21\2\2mn\7\23\2\2n\37\3\2\2\2op\7\f\2\2pq"+
		"\7\23\2\2qr\b\21\1\2r!\3\2\2\2\b+\63SX]d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}