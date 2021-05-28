/* The following code was generated by JFlex 1.4.3 on 5/28/21, 4:22 PM */

package Scanner;
import TokenTypes.Symbols;
import TokenTypes.*;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/28/21, 4:22 PM from the specification file
 * <tt>./src/Scanner/LexerCup.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\12\2\0\1\1\22\0\1\1\1\30\1\13\1\0"+
    "\1\2\1\31\1\56\1\15\1\20\1\21\1\17\1\25\1\1\1\6"+
    "\1\0\1\16\1\4\3\5\4\5\2\3\1\0\1\54\1\27\1\26"+
    "\1\27\2\0\6\10\5\2\1\11\13\2\1\7\2\2\1\57\1\0"+
    "\1\60\1\0\1\2\1\0\1\40\1\35\1\42\1\47\1\37\1\14"+
    "\1\51\1\44\1\32\1\2\1\41\1\50\1\2\1\33\1\45\2\2"+
    "\1\36\1\43\1\34\1\46\1\53\1\52\1\7\2\2\1\22\1\55"+
    "\1\23\1\24\162\0\1\0\uff0e\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\2\4\1\5\1\6\1\1"+
    "\1\3\1\1\2\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\12\3\1\21\2\1\1\22"+
    "\1\23\1\0\1\4\1\0\1\4\1\24\2\4\3\0"+
    "\1\3\1\0\1\2\2\0\1\17\1\25\12\3\1\26"+
    "\3\3\1\27\1\30\3\0\2\24\2\4\1\31\4\0"+
    "\1\32\14\3\1\0\1\24\1\4\1\33\1\0\1\24"+
    "\2\0\2\3\1\34\1\35\1\36\5\3\1\37\1\3"+
    "\1\40\1\41\1\24\1\0\1\42\2\3\1\43\1\44"+
    "\2\3\1\45\1\0\1\46\1\3\1\47\2\3\1\50"+
    "\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[135];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\61"+
    "\0\u0157\0\u0188\0\u01b9\0\u01ea\0\61\0\u021b\0\61\0\61"+
    "\0\61\0\61\0\u024c\0\u027d\0\u027d\0\u027d\0\u02ae\0\u02df"+
    "\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\u0405\0\u0436\0\u0467"+
    "\0\61\0\u0498\0\u04c9\0\61\0\61\0\u04fa\0\u052b\0\u055c"+
    "\0\u058d\0\u05be\0\u05ef\0\u0620\0\u0651\0\u0682\0\u06b3\0\u06e4"+
    "\0\u0715\0\u0746\0\u0777\0\u07a8\0\61\0\223\0\u07d9\0\u080a"+
    "\0\u083b\0\u086c\0\u089d\0\u08ce\0\u08ff\0\u0930\0\u0961\0\u0992"+
    "\0\223\0\u09c3\0\u09f4\0\u0a25\0\61\0\61\0\u0a56\0\u0a87"+
    "\0\u0ab8\0\u0ae9\0\u058d\0\u0b1a\0\61\0\223\0\u0b4b\0\u0b7c"+
    "\0\u0bad\0\u0bde\0\223\0\u0c0f\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3"+
    "\0\u0d04\0\u0d35\0\u0d66\0\u0d97\0\u0dc8\0\u0df9\0\u0e2a\0\u0e5b"+
    "\0\u0e8c\0\u0ebd\0\61\0\u0eee\0\61\0\u0f1f\0\u0f50\0\u0f81"+
    "\0\u0fb2\0\223\0\223\0\223\0\u0fe3\0\u1014\0\u1045\0\u1076"+
    "\0\u10a7\0\223\0\u10d8\0\223\0\u1109\0\u113a\0\u116b\0\223"+
    "\0\u119c\0\u11cd\0\223\0\223\0\u11fe\0\u122f\0\223\0\u1260"+
    "\0\223\0\u1291\0\223\0\u12c2\0\u12f3\0\223\0\223";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[135];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\5\1\7\3\4"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\15"+
    "\1\27\2\4\1\30\1\31\1\32\2\4\1\33\1\34"+
    "\3\4\1\35\1\36\1\4\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\62\0\1\3\61\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\22\4\10\0\1\5\1\47"+
    "\1\5\1\50\2\0\1\51\36\0\1\51\13\0\1\52"+
    "\1\53\1\54\1\50\1\55\1\0\1\51\36\0\1\51"+
    "\14\0\1\56\1\0\1\22\52\0\12\57\1\0\46\57"+
    "\2\0\4\4\1\46\3\4\2\0\1\4\15\0\13\4"+
    "\1\60\6\4\5\0\12\61\1\0\46\61\16\0\1\62"+
    "\1\63\47\0\1\64\77\0\1\22\61\0\1\65\34\0"+
    "\4\4\1\46\3\4\2\0\1\66\15\0\1\4\1\67"+
    "\20\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\4\4\1\70\15\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\5\4\1\71\14\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\16\4\1\72\3\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\6\4\1\73"+
    "\3\4\1\74\1\75\6\4\7\0\4\4\1\46\3\4"+
    "\2\0\1\4\15\0\12\4\1\76\5\4\1\77\1\4"+
    "\7\0\4\4\1\46\3\4\2\0\1\4\15\0\5\4"+
    "\1\100\5\4\1\101\6\4\7\0\4\4\1\46\3\4"+
    "\2\0\1\4\15\0\13\4\1\102\6\4\7\0\4\4"+
    "\1\46\3\4\2\0\1\4\15\0\12\4\1\103\7\4"+
    "\7\0\4\4\1\46\3\4\2\0\1\4\15\0\13\4"+
    "\1\104\6\4\62\0\1\105\61\0\1\106\6\0\1\107"+
    "\57\0\1\5\1\47\1\5\1\50\1\110\1\0\1\51"+
    "\36\0\1\51\14\0\1\111\57\0\1\52\1\112\1\52"+
    "\1\50\55\0\1\52\1\112\1\52\1\50\2\0\1\113"+
    "\36\0\1\113\13\0\1\52\1\53\1\54\1\50\1\110"+
    "\1\0\1\51\36\0\1\51\13\0\1\52\1\53\1\54"+
    "\1\50\2\0\1\51\36\0\1\51\13\0\3\114\2\0"+
    "\1\114\57\0\1\55\51\0\13\57\1\115\45\57\2\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\4\4\1\116"+
    "\15\4\5\0\15\61\1\115\43\61\12\62\1\0\46\62"+
    "\17\63\1\117\41\63\3\0\1\120\1\121\1\120\1\122"+
    "\54\0\4\4\1\46\3\4\2\0\1\4\15\0\2\4"+
    "\1\123\17\4\7\0\4\4\1\46\3\4\2\0\1\4"+
    "\15\0\5\4\1\124\14\4\7\0\4\4\1\46\3\4"+
    "\2\0\1\4\15\0\2\4\1\125\17\4\7\0\4\4"+
    "\1\46\3\4\2\0\1\4\15\0\11\4\1\126\10\4"+
    "\7\0\4\4\1\46\3\4\2\0\1\4\15\0\11\4"+
    "\1\127\10\4\7\0\4\4\1\46\3\4\2\0\1\4"+
    "\15\0\6\4\1\130\13\4\7\0\4\4\1\46\3\4"+
    "\2\0\1\4\15\0\1\4\1\131\20\4\7\0\4\4"+
    "\1\46\3\4\2\0\1\4\15\0\13\4\1\132\6\4"+
    "\7\0\4\4\1\46\3\4\2\0\1\4\15\0\1\133"+
    "\21\4\7\0\4\4\1\46\3\4\2\0\1\134\15\0"+
    "\22\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\1\4\1\135\20\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\1\136\21\4\7\0\4\4\1\46\3\4"+
    "\2\0\1\4\15\0\1\137\21\4\14\0\1\140\54\0"+
    "\3\141\2\0\1\141\57\0\1\110\54\0\1\52\1\112"+
    "\1\52\1\50\1\110\1\0\1\113\36\0\1\113\13\0"+
    "\1\114\1\142\1\114\1\50\1\0\1\114\1\51\36\0"+
    "\1\51\10\0\16\63\1\143\1\117\41\63\3\0\1\120"+
    "\1\121\1\120\1\122\2\0\1\144\7\0\1\145\26\0"+
    "\1\144\13\0\1\120\1\121\1\120\1\122\1\146\1\0"+
    "\1\144\7\0\1\145\26\0\1\144\14\0\1\147\56\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\6\4\1\150"+
    "\13\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\14\4\1\151\5\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\5\4\1\152\14\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\5\4\1\153\14\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\4\4\1\154"+
    "\15\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\2\4\1\155\6\4\1\156\10\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\4\4\1\157\15\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\2\4\1\160"+
    "\17\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\6\4\1\161\13\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\17\4\1\162\2\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\16\4\1\163\3\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\15\4\1\164"+
    "\4\4\10\0\3\165\2\0\1\165\53\0\1\141\1\166"+
    "\1\141\1\50\1\0\1\141\1\113\36\0\1\113\13\0"+
    "\1\114\1\142\1\114\1\50\1\110\1\114\1\51\36\0"+
    "\1\51\13\0\1\120\1\121\1\120\1\122\12\0\1\145"+
    "\42\0\3\167\2\0\1\167\57\0\1\146\53\0\4\4"+
    "\1\46\3\4\2\0\1\4\15\0\7\4\1\170\12\4"+
    "\7\0\4\4\1\46\3\4\2\0\1\4\15\0\4\4"+
    "\1\171\15\4\7\0\4\4\1\46\3\4\2\0\1\4"+
    "\15\0\1\172\21\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\2\4\1\173\17\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\2\4\1\174\17\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\10\4\1\175"+
    "\11\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\14\4\1\176\5\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\5\4\1\177\14\4\7\0\4\165\1\46"+
    "\3\165\2\0\1\165\15\0\22\165\10\0\1\141\1\166"+
    "\1\141\1\50\1\110\1\141\1\113\36\0\1\113\13\0"+
    "\1\167\1\200\1\167\1\122\1\0\1\167\1\144\7\0"+
    "\1\145\26\0\1\144\12\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\1\4\1\201\20\4\7\0\4\4\1\46"+
    "\3\4\2\0\1\4\15\0\1\4\1\202\20\4\7\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\12\4\1\203"+
    "\7\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\16\4\1\204\3\4\10\0\1\167\1\200\1\167\1\122"+
    "\1\146\1\167\1\144\7\0\1\145\26\0\1\144\12\0"+
    "\4\4\1\46\3\4\2\0\1\4\15\0\14\4\1\205"+
    "\5\4\7\0\4\4\1\46\3\4\2\0\1\4\15\0"+
    "\2\4\1\206\17\4\7\0\4\4\1\46\3\4\2\0"+
    "\1\4\15\0\5\4\1\207\14\4\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4900];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\5\1\1\11\4\1\1\11\1\1\4\11"+
    "\16\1\1\11\2\1\2\11\1\0\1\1\1\0\4\1"+
    "\3\0\1\1\1\0\1\1\2\0\1\11\17\1\2\11"+
    "\3\0\3\1\1\11\1\1\4\0\15\1\1\0\2\1"+
    "\1\11\1\0\1\11\2\0\17\1\1\0\10\1\1\0"+
    "\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[135];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 150) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 28: 
          { return new Symbol(sym.Else,yychar,yyline,yytext());
          }
        case 42: break;
        case 30: 
          { return new Symbol(sym.Char,yychar,yyline,yytext());
          }
        case 43: break;
        case 31: 
          { return new Symbol(sym.Long,yychar,yyline,yytext());
          }
        case 44: break;
        case 21: 
          { return new Symbol(sym.If,yychar,yyline,yytext());
          }
        case 45: break;
        case 9: 
          { return new Symbol(sym.Parentesis_c,yychar,yyline,yytext());
          }
        case 46: break;
        case 16: 
          { return new Symbol(sym.Not,yychar,yyline,yytext());
          }
        case 47: break;
        case 18: 
          { return new Symbol(sym.Corchete_a, yychar, yyline, yytext());
          }
        case 48: break;
        case 11: 
          { return new Symbol(sym.Llave_c,yychar,yyline,yytext());
          }
        case 49: break;
        case 29: 
          { return new Symbol(sym.Case,yychar,yyline,yytext());
          }
        case 50: break;
        case 25: 
          { return new Symbol(sym.For,yychar,yyline,yytext());
          }
        case 51: break;
        case 14: 
          { return new Symbol(sym.Asignacion,yychar,yyline,yytext());
          }
        case 52: break;
        case 15: 
          { return new Symbol(sym.Relacionales,yychar,yyline,yytext());
          }
        case 53: break;
        case 13: 
          { return new Symbol(sym.Mas,yychar,yyline,yytext());
          }
        case 54: break;
        case 17: 
          { return new Symbol(sym.Scolon,yychar,yyline,yytext());
          }
        case 55: break;
        case 1: 
          { return new Symbol(sym.LEX_ERROR, yychar, yyline, yytext());
          }
        case 56: break;
        case 26: 
          { return new Symbol(sym.Int,yychar,yyline,yytext());
          }
        case 57: break;
        case 35: 
          { return new Symbol(sym.Const,yychar,yyline,yytext());
          }
        case 58: break;
        case 41: 
          { return new Symbol(sym.Continue,yychar,yyline,yytext());
          }
        case 59: break;
        case 37: 
          { return new Symbol(sym.While,yychar,yyline,yytext());
          }
        case 60: break;
        case 24: 
          { return new Symbol(sym.And,yychar,yyline,yytext());
          }
        case 61: break;
        case 39: 
          { return new Symbol(sym.Switch,yychar,yyline,yytext());
          }
        case 62: break;
        case 40: 
          { return new Symbol(sym.Default,yychar,yyline,yytext());
          }
        case 63: break;
        case 19: 
          { return new Symbol(sym.Corchete_c, yychar, yyline, yytext());
          }
        case 64: break;
        case 22: 
          { return new Symbol(sym.Do,yychar,yyline,yytext());
          }
        case 65: break;
        case 12: 
          { return new Symbol(sym.Unarios,yychar,yyline,yytext());
          }
        case 66: break;
        case 34: 
          { return new Symbol(sym.Break,yychar,yyline,yytext());
          }
        case 67: break;
        case 7: 
          { return new Symbol(sym.Timesslash,yychar,yyline,yytext());
          }
        case 68: break;
        case 32: 
          { return new Symbol(sym.Void,yychar,yyline,yytext());
          }
        case 69: break;
        case 8: 
          { return new Symbol(sym.Parentesis_a,yychar,yyline,yytext());
          }
        case 70: break;
        case 38: 
          { return new Symbol(sym.Return,yychar,yyline,yytext());
          }
        case 71: break;
        case 6: 
          { return new Symbol(sym.Linea,yychar,yyline,yytext());
          }
        case 72: break;
        case 36: 
          { return new Symbol(sym.Short,yychar,yyline,yytext());
          }
        case 73: break;
        case 10: 
          { return new Symbol(sym.Llave_a,yychar,yyline,yytext());
          }
        case 74: break;
        case 5: 
          { return new Symbol(sym.Menos,yychar,yyline,yytext());
          }
        case 75: break;
        case 3: 
          { return new Symbol(sym.Identificador,yychar,yyline,yytext());
          }
        case 76: break;
        case 4: 
          { return new Symbol(sym.Literal, yychar, yyline, yytext());
          }
        case 77: break;
        case 2: 
          { /*Ignore*/
          }
        case 78: break;
        case 33: 
          { return new Symbol(sym.Identificador, yychar, yyline, yytext());
          }
        case 79: break;
        case 20: 
          { return new Symbol(sym.Numero, yychar, yyline, yytext());
          }
        case 80: break;
        case 23: 
          { return new Symbol(sym.Or,yychar,yyline,yytext());
          }
        case 81: break;
        case 27: 
          { System.out.println("Bloque de comentarios");
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
