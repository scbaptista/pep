package go.server.utils.grammar;

// Generated from PEP.g4 by ANTLR 4.7.1

    import java.util.*;
    import java.util.List;
	import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.HashMap;
	import java.util.Map;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, WS=33, INT=34, STRING=35;
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
		null, "'P'", "'p'", "'L'", "'l'", "'A'", "'a'", "'N'", "'n'", "'O'", "'o'", 
		"'F'", "'f'", "'I'", "'i'", "'M'", "'m'", "'S'", "'s'", "'E'", "'e'", 
		"'\u00C3'", "'\u00E3'", "'-'", "'T'", "'t'", "':'", "'R'", "'r'", "'D'", 
		"'d'", "','", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "WS", "INT", "STRING"
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


		int i, err;
	    HashMap<String, String> sessoes;
	    ArrayList<String> exs, tms;
	    ByteArrayOutputStream baos;
	    PrintStream ps, oldOut, oldErr;
	    String descr;
	    StringBuilder sessao;

	public PEPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PlanoContext extends ParserRuleContext {
		public ArrayList<String> exercs;
		public ArrayList<String> temas;
		public String console;
		public int error;
		public HashMap<String, String> sessions;
		public IdPlanoContext idPlano() {
			return getRuleContext(IdPlanoContext.class,0);
		}
		public SessoesContext sessoes() {
			return getRuleContext(SessoesContext.class,0);
		}
		public PlanoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PlanoContext(ParserRuleContext parent, int invokingState, ArrayList<String> exercs, ArrayList<String> temas) {
			super(parent, invokingState);
			this.exercs = exercs;
			this.temas = temas;
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

	public final PlanoContext plano(ArrayList<String> exercs,ArrayList<String> temas) throws RecognitionException {
		PlanoContext _localctx = new PlanoContext(_ctx, getState(), exercs, temas);
		enterRule(_localctx, 0, RULE_plano);
		 i = 0; err = 0;
			     //sessoes = new ArrayList<String>();
				 exs = exercs;
				 tms = temas;
				 sessoes = new HashMap<String, String>();
				 
				 // Alterar stream de erros e output
				 baos = new ByteArrayOutputStream();
				 ps = new PrintStream(baos);
				 oldOut = System.out;
				 oldErr = System.err;
				 System.setOut(ps);
				 System.setErr(ps);
				
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(33);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(36);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(37);
			idPlano();
			setState(38);
			sessoes();
			setState(39);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(41);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 
						     ((PlanoContext)_localctx).sessions =  sessoes;
						   	 ((PlanoContext)_localctx).error =  err;
						   	 ((PlanoContext)_localctx).console =  baos.toString();
						   	 
						   	 // Repor stream de erros e output
						     System.out.flush();
						     System.setOut(oldOut);
						     System.setErr(oldErr);
						   
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				sessao();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__17 );
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
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(51);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(52);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(53);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__20) | (1L << T__21))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(55);
			infoSessao();
			setState(56);
			tema();
			setState(57);
			parteA();
			setState(58);
			parteE();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__9) {
				{
				setState(59);
				ordem();
				}
			}

			 
						  	try {
						  		//String value = new String(sessao.toString().getBytes("UTF-8"));
						  		sessoes.put(descr, sessao.toString()); 
						  	} catch (Exception ex) {
						  		System.out.println("AnTLR error!");
						  	}
						  	i++;  
						  	descr = new String();
						  
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
			setState(64);
			idSessao();
			setState(65);
			match(T__22);
			setState(66);
			((InfoSessaoContext)_localctx).titulo = titulo();
			 // {"sessao": "Introdução a Arrays",
					  	  	sessao.append("{\"sessao\": " + (((InfoSessaoContext)_localctx).titulo!=null?_input.getText(((InfoSessaoContext)_localctx).titulo.start,((InfoSessaoContext)_localctx).titulo.stop):null) + ", "); 
					  	  	descr = (((InfoSessaoContext)_localctx).titulo!=null?_input.getText(((InfoSessaoContext)_localctx).titulo.start,((InfoSessaoContext)_localctx).titulo.stop):null);
					  	  
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
			setState(69);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(T__25);
			setState(76);
			idTema();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(81);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(82);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(84);
			match(T__25);
			 sessao.append("\"partea\": {"); 
			setState(86);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(93);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(94);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(95);
			match(T__25);
			 sessao.append("\"partee\": {"); 
			setState(97);
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
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(101);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==T__28 || _la==T__29) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(103);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(105);
			match(T__25);
			setState(106);
			((OrdemContext)_localctx).x = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__18) ) {
				((OrdemContext)_localctx).x = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(107);
			match(T__30);
			setState(108);
			((OrdemContext)_localctx).y = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__18) ) {
				((OrdemContext)_localctx).y = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 //	"ordem": "A, E" }
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
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(111);
					match(T__31);
					}
				}

				setState(114);
				exerc();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__18 || _la==T__31 );
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
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				exerc();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__18 );
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
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				idExerc();
				setState(125);
				match(T__30);
				 sessao.append(","); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
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
			setState(131);
			match(T__0);
			setState(132);
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
			setState(134);
			match(T__16);
			setState(135);
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
		public Token t;
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
			setState(137);
			match(T__23);
			setState(138);
			((IdTemaContext)_localctx).t = match(INT);
			 
							if(tms.contains((((IdTemaContext)_localctx).t!=null?((IdTemaContext)_localctx).t.getText():null))) {
						  		// "tema": "Arrays", 
						  		sessao.append("\"tema\": " + (((IdTemaContext)_localctx).t!=null?((IdTemaContext)_localctx).t.getText():null) + ", "); 
							} else {
								err = 1;
								System.out.println("ERRO: O tema 'T" + (((IdTemaContext)_localctx).t!=null?((IdTemaContext)_localctx).t.getText():null) + "' não existe!");
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
			setState(141);
			match(T__18);
			setState(142);
			((IdExercContext)_localctx).e = match(INT);
			 
							if(exs.contains((((IdExercContext)_localctx).e!=null?((IdExercContext)_localctx).e.getText():null))) {
								sessao.append("{\"id\": \"E" + (((IdExercContext)_localctx).e!=null?((IdExercContext)_localctx).e.getText():null) + "\"}");
							} else {
								err = 1;
								System.out.println("ERRO: O exercício 'E" + (((IdExercContext)_localctx).e!=null?((IdExercContext)_localctx).e.getText():null) + "' não existe!");
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0094\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\60\n\3\r\3\16\3\61\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13s\n\13\3\13\6\13v\n\13\r"+
		"\13\16\13w\3\f\6\f{\n\f\r\f\16\f|\3\r\3\r\3\r\3\r\3\r\5\r\u0084\n\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\21\3\2\3\4\3\2\5"+
		"\6\3\2\7\b\3\2\t\n\3\2\13\f\3\2\r\16\3\2\17\20\3\2\21\22\3\2\23\24\3\2"+
		"\25\26\4\2\7\b\27\30\3\2\32\33\3\2\35\36\3\2\37 \4\2\7\7\25\25\2\u0089"+
		"\2\"\3\2\2\2\4/\3\2\2\2\6\63\3\2\2\2\bB\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2"+
		"\16P\3\2\2\2\20[\3\2\2\2\22f\3\2\2\2\24u\3\2\2\2\26z\3\2\2\2\30\u0083"+
		"\3\2\2\2\32\u0085\3\2\2\2\34\u0088\3\2\2\2\36\u008b\3\2\2\2 \u008f\3\2"+
		"\2\2\"#\t\2\2\2#$\t\3\2\2$%\t\4\2\2%&\t\5\2\2&\'\t\6\2\2\'(\5\32\16\2"+
		"()\5\4\3\2)*\t\7\2\2*+\t\b\2\2+,\t\t\2\2,-\b\2\1\2-\3\3\2\2\2.\60\5\6"+
		"\4\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63"+
		"\64\t\n\2\2\64\65\t\13\2\2\65\66\t\n\2\2\66\67\t\n\2\2\678\t\f\2\289\t"+
		"\6\2\29:\5\b\5\2:;\5\f\7\2;<\5\16\b\2<>\5\20\t\2=?\5\22\n\2>=\3\2\2\2"+
		">?\3\2\2\2?@\3\2\2\2@A\b\4\1\2A\7\3\2\2\2BC\5\34\17\2CD\7\31\2\2DE\5\n"+
		"\6\2EF\b\5\1\2F\t\3\2\2\2GH\7%\2\2H\13\3\2\2\2IJ\t\r\2\2JK\t\13\2\2KL"+
		"\t\t\2\2LM\t\4\2\2MN\7\34\2\2NO\5\36\20\2O\r\3\2\2\2PQ\t\2\2\2QR\t\4\2"+
		"\2RS\t\16\2\2ST\t\r\2\2TU\t\13\2\2UV\t\4\2\2VW\7\34\2\2WX\b\b\1\2XY\5"+
		"\24\13\2YZ\b\b\1\2Z\17\3\2\2\2[\\\t\2\2\2\\]\t\4\2\2]^\t\16\2\2^_\t\r"+
		"\2\2_`\t\13\2\2`a\t\13\2\2ab\7\34\2\2bc\b\t\1\2cd\5\26\f\2de\b\t\1\2e"+
		"\21\3\2\2\2fg\t\6\2\2gh\t\16\2\2hi\t\17\2\2ij\t\13\2\2jk\t\t\2\2kl\7\34"+
		"\2\2lm\t\20\2\2mn\7!\2\2no\t\20\2\2op\b\n\1\2p\23\3\2\2\2qs\7\"\2\2rq"+
		"\3\2\2\2rs\3\2\2\2st\3\2\2\2tv\5\30\r\2ur\3\2\2\2vw\3\2\2\2wu\3\2\2\2"+
		"wx\3\2\2\2x\25\3\2\2\2y{\5\30\r\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2"+
		"\2\2}\27\3\2\2\2~\177\5 \21\2\177\u0080\7!\2\2\u0080\u0081\b\r\1\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0084\5 \21\2\u0083~\3\2\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\31\3\2\2\2\u0085\u0086\7\3\2\2\u0086\u0087\7$\2\2\u0087\33\3\2"+
		"\2\2\u0088\u0089\7\23\2\2\u0089\u008a\7$\2\2\u008a\35\3\2\2\2\u008b\u008c"+
		"\7\32\2\2\u008c\u008d\7$\2\2\u008d\u008e\b\20\1\2\u008e\37\3\2\2\2\u008f"+
		"\u0090\7\25\2\2\u0090\u0091\7$\2\2\u0091\u0092\b\21\1\2\u0092!\3\2\2\2"+
		"\b\61>rw|\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}