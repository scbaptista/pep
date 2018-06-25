package pep.server.utils.grammar;

// Generated from PEP.g4 by ANTLR 4.7.1

    import java.util.*;
    import java.sql.*;
    import java.util.logging.Level;
	import java.util.logging.Logger;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PEPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, WS=16, INT=17, 
		STRING=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "WS", "INT", "STRING", 
		"ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT"
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


	    ArrayList<String> sessoes, exs;
	    StringBuilder sessao;
	    int i, flagOrd;


	public PEPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PEP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\6\22"+
		"u\n\22\r\22\16\22v\3\23\3\23\3\23\7\23|\n\23\f\23\16\23\177\13\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\5\24\u0087\n\24\3\24\3\24\5\24\u008b\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0096\n\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\2+\2"+
		"-\2\3\2\7\5\2\13\f\17\17\"\"\3\2$$\7\2ddhhppttvv\4\2))^^\5\2\62;CHch\2"+
		"\u00a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\3/\3\2\2\2\5\65\3\2\2\2\79\3\2\2\2\t@\3\2\2\2\13"+
		"B\3\2\2\2\rH\3\2\2\2\17Q\3\2\2\2\21Z\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27"+
		"e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#t"+
		"\3\2\2\2%x\3\2\2\2\'\u008a\3\2\2\2)\u0095\3\2\2\2+\u0097\3\2\2\2-\u009e"+
		"\3\2\2\2/\60\7R\2\2\60\61\7n\2\2\61\62\7c\2\2\62\63\7p\2\2\63\64\7q\2"+
		"\2\64\4\3\2\2\2\65\66\7H\2\2\66\67\7k\2\2\678\7o\2\28\6\3\2\2\29:\7U\2"+
		"\2:;\7G\2\2;<\7U\2\2<=\7U\2\2=>\7\uffff\2\2>?\7Q\2\2?\b\3\2\2\2@A\7/\2"+
		"\2A\n\3\2\2\2BC\7V\2\2CD\7G\2\2DE\7O\2\2EF\7C\2\2FG\7<\2\2G\f\3\2\2\2"+
		"HI\7R\2\2IJ\7C\2\2JK\7T\2\2KL\7V\2\2LM\7G\2\2MN\7\"\2\2NO\7C\2\2OP\7<"+
		"\2\2P\16\3\2\2\2QR\7R\2\2RS\7C\2\2ST\7T\2\2TU\7V\2\2UV\7G\2\2VW\7\"\2"+
		"\2WX\7G\2\2XY\7<\2\2Y\20\3\2\2\2Z[\7Q\2\2[\\\7T\2\2\\]\7F\2\2]^\7G\2\2"+
		"^_\7O\2\2_`\7<\2\2`\22\3\2\2\2ab\7C\2\2b\24\3\2\2\2cd\7G\2\2d\26\3\2\2"+
		"\2ef\7.\2\2f\30\3\2\2\2gh\7A\2\2h\32\3\2\2\2ij\7R\2\2j\34\3\2\2\2kl\7"+
		"U\2\2l\36\3\2\2\2mn\7V\2\2n \3\2\2\2op\t\2\2\2pq\3\2\2\2qr\b\21\2\2r\""+
		"\3\2\2\2su\4\62;\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w$\3\2\2\2x"+
		"}\7$\2\2y|\5\'\24\2z|\n\3\2\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2"+
		"\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7$\2\2\u0081&\3\2"+
		"\2\2\u0082\u0086\7^\2\2\u0083\u0087\t\4\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0087\t\5\2\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2"+
		"\2\2\u0087\u008b\3\2\2\2\u0088\u008b\5+\26\2\u0089\u008b\5)\25\2\u008a"+
		"\u0082\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b(\3\2\2\2"+
		"\u008c\u008d\7^\2\2\u008d\u008e\4\62\65\2\u008e\u008f\4\629\2\u008f\u0096"+
		"\4\629\2\u0090\u0091\7^\2\2\u0091\u0092\4\629\2\u0092\u0096\4\629\2\u0093"+
		"\u0094\7^\2\2\u0094\u0096\4\629\2\u0095\u008c\3\2\2\2\u0095\u0090\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096*\3\2\2\2\u0097\u0098\7^\2\2\u0098\u0099"+
		"\7w\2\2\u0099\u009a\5-\27\2\u009a\u009b\5-\27\2\u009b\u009c\5-\27\2\u009c"+
		"\u009d\5-\27\2\u009d,\3\2\2\2\u009e\u009f\t\6\2\2\u009f.\3\2\2\2\t\2v"+
		"{}\u0086\u008a\u0095\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}