
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Scanner;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\020\003\000\002\020" +
    "\003\000\002\020\003\000\002\003\003\000\002\002\006" +
    "\000\002\002\005\000\002\002\004\000\002\004\011\000" +
    "\002\006\005\000\002\006\002\000\002\034\003\000\002" +
    "\010\005\000\002\033\004\000\002\033\002\000\002\023" +
    "\005\000\002\023\005\000\002\023\003\000\002\023\003" +
    "\000\002\023\003\000\002\023\003\000\002\030\003\000" +
    "\002\030\003\000\002\030\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\012\005\010\010\007\022\012\040\004\001" +
    "\002\000\002\001\002\000\004\040\056\001\002\000\004" +
    "\002\055\001\002\000\004\027\uffff\001\002\000\004\027" +
    "\000\001\002\000\004\027\022\001\002\000\004\027\ufffe" +
    "\001\002\000\002\001\002\000\010\005\010\010\007\022" +
    "\012\001\002\000\004\040\016\001\002\000\004\002\ufffb" +
    "\001\002\000\010\005\010\010\007\022\012\001\002\000" +
    "\004\040\021\001\002\000\004\002\ufffc\001\002\000\004" +
    "\031\023\001\002\000\004\032\024\001\002\000\004\035" +
    "\025\001\002\000\012\005\010\010\007\022\012\036\ufff7" +
    "\001\002\000\004\036\054\001\002\000\004\027\034\001" +
    "\002\000\004\040\031\001\002\000\012\005\010\010\007" +
    "\022\012\036\ufff7\001\002\000\004\036\ufff6\001\002\000" +
    "\004\036\ufff8\001\002\000\006\040\ufff3\042\036\001\002" +
    "\000\004\040\ufff5\001\002\000\020\027\043\030\041\031" +
    "\042\041\045\046\047\047\040\050\044\001\002\000\014" +
    "\032\uffed\040\uffed\046\uffed\047\uffed\050\uffed\001\002\000" +
    "\024\027\uffeb\030\uffeb\031\uffeb\032\uffeb\040\uffeb\041\uffeb" +
    "\046\uffeb\047\uffeb\050\uffeb\001\002\000\014\032\uffef\040" +
    "\uffef\046\uffef\047\uffef\050\uffef\001\002\000\020\027\043" +
    "\030\041\031\042\041\045\046\047\047\040\050\044\001" +
    "\002\000\014\032\ufff0\040\ufff0\046\ufff0\047\ufff0\050\ufff0" +
    "\001\002\000\024\027\uffea\030\uffea\031\uffea\032\uffea\040" +
    "\uffea\041\uffea\046\uffea\047\uffea\050\uffea\001\002\000\014" +
    "\032\uffee\040\uffee\046\uffee\047\uffee\050\uffee\001\002\000" +
    "\012\040\ufff4\046\047\047\040\050\044\001\002\000\024" +
    "\027\uffec\030\uffec\031\uffec\032\uffec\040\uffec\041\uffec\046" +
    "\uffec\047\uffec\050\uffec\001\002\000\020\027\043\030\041" +
    "\031\042\041\045\046\047\047\040\050\044\001\002\000" +
    "\014\032\ufff2\040\ufff2\046\047\047\040\050\044\001\002" +
    "\000\012\032\053\046\047\047\040\050\044\001\002\000" +
    "\014\032\ufff1\040\ufff1\046\ufff1\047\ufff1\050\ufff1\001\002" +
    "\000\004\040\ufff9\001\002\000\004\002\001\001\002\000" +
    "\004\002\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\054\000\014\002\005\003\012\004\004\005\013\020" +
    "\010\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\016\001\001\000\006" +
    "\004\014\020\010\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\004\017\020\010\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\006\025\010\027\020\026\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\006\031\010\027\020\026\034\032\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\033\034\001\001\000" +
    "\002\001\001\000\006\023\045\030\036\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\023" +
    "\051\030\036\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\030\047\001\001\000\002\001" +
    "\001\000\006\023\050\030\036\001\001\000\004\030\047" +
    "\001\001\000\004\030\047\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private Symbol s;
    
    public void syntax_error(Symbol s){
        this.s = s;
    }

    public Symbol getS(){
        return this.s;
}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
                XMLElement RESULT;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location EOF1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location EOF1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object EOF1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("_START",0,(XMLElement)start_val);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // TIPO ::= Int 
            {
                XMLElement RESULT;
		Location Int0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Int0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Int0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("TIPO",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPO",14, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // TIPO ::= Char 
            {
                XMLElement RESULT;
		Location Char0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Char0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Char0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("TIPO",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPO",14, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // TIPO ::= Void 
            {
                XMLElement RESULT;
		Location Void0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Void0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Void0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("TIPO",2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TIPO",14, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // GLOBALES ::= Scolon 
            {
                XMLElement RESULT;
		Location Scolon0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Scolon0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Scolon0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("GLOBALES",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("GLOBALES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INICIO ::= GLOBALES DECLARACION_FUNCION MAIN Scolon 
            {
                XMLElement RESULT;
		Location GLOBALES0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xleft;
		Location GLOBALES0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xright;
		Object GLOBALES0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		Location DECLARACION_FUNCION1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location DECLARACION_FUNCION1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object DECLARACION_FUNCION1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location MAIN2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location MAIN2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object MAIN2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location Scolon3xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Scolon3xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Scolon3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("INICIO",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INICIO ::= DECLARACION_FUNCION MAIN Scolon 
            {
                XMLElement RESULT;
		Location DECLARACION_FUNCION0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location DECLARACION_FUNCION0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object DECLARACION_FUNCION0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location MAIN1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location MAIN1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object MAIN1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location Scolon2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Scolon2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Scolon2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("INICIO",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INICIO ::= MAIN Scolon 
            {
                XMLElement RESULT;
		Location MAIN0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location MAIN0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object MAIN0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location Scolon1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Scolon1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Scolon1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("INICIO",2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // MAIN ::= TIPO Identificador Parentesis_a Parentesis_c Llave_a SENTENCIA Llave_c 
            {
                XMLElement RESULT;
		Location TIPO0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).xleft;
		Location TIPO0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).xright;
		Object TIPO0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		Location Identificador1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).xleft;
		Location Identificador1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).xright;
		Object Identificador1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		Location Parentesis_a2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).xleft;
		Location Parentesis_a2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).xright;
		Object Parentesis_a2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		Location Parentesis_c3xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xleft;
		Location Parentesis_c3xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xright;
		Object Parentesis_c3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		Location Llave_a4xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location Llave_a4xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object Llave_a4 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location SENTENCIA5xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location SENTENCIA5xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object SENTENCIA5 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location Llave_c6xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Llave_c6xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Llave_c6 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("MAIN",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("MAIN",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // SENTENCIA ::= DECLARACION_VAR Scolon DECL_AUX 
            {
                XMLElement RESULT;
		Location DECLARACION_VAR0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location DECLARACION_VAR0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object DECLARACION_VAR0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location Scolon1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location Scolon1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object Scolon1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location DECL_AUX2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location DECL_AUX2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object DECL_AUX2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("SENTENCIA",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SENTENCIA",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // SENTENCIA ::= 
            {
                XMLElement RESULT;

                RESULT = new XMLElement.NonTerminal("SENTENCIA",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SENTENCIA",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // DECL_AUX ::= SENTENCIA 
            {
                XMLElement RESULT;
		Location SENTENCIA0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location SENTENCIA0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object SENTENCIA0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("DECL_AUX",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECL_AUX",26, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // DECLARACION_VAR ::= TIPO Identificador DECLARACION_VAR_AUX 
            {
                XMLElement RESULT;
		Location TIPO0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location TIPO0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object TIPO0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location Identificador1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location Identificador1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object Identificador1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location DECLARACION_VAR_AUX2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location DECLARACION_VAR_AUX2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object DECLARACION_VAR_AUX2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("DECLARACION_VAR",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLARACION_VAR",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // DECLARACION_VAR_AUX ::= Asignacion EXP 
            {
                XMLElement RESULT;
		Location Asignacion0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location Asignacion0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object Asignacion0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location EXP1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location EXP1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object EXP1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("DECLARACION_VAR_AUX",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLARACION_VAR_AUX",25, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // DECLARACION_VAR_AUX ::= 
            {
                XMLElement RESULT;

                RESULT = new XMLElement.NonTerminal("DECLARACION_VAR_AUX",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLARACION_VAR_AUX",25, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXP ::= EXP OPERADOR EXP 
            {
                XMLElement RESULT;
		Location EXP0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location EXP0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object EXP0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location OPERADOR1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location OPERADOR1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object OPERADOR1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location EXP2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location EXP2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object EXP2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXP ::= Parentesis_a EXP Parentesis_c 
            {
                XMLElement RESULT;
		Location Parentesis_a0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location Parentesis_a0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object Parentesis_a0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location EXP1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location EXP1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Object EXP1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location Parentesis_c2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Parentesis_c2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Parentesis_c2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXP ::= Identificador 
            {
                XMLElement RESULT;
		Location Identificador0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Identificador0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Identificador0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXP ::= Literal 
            {
                XMLElement RESULT;
		Location Literal0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Literal0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Literal0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",3);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXP ::= Numero 
            {
                XMLElement RESULT;
		Location Numero0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Numero0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Numero0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",4);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXP ::= OPERADOR 
            {
                XMLElement RESULT;
		Location OPERADOR0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location OPERADOR0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object OPERADOR0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("EXP",5);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // OPERADOR ::= Mas 
            {
                XMLElement RESULT;
		Location Mas0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Mas0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Mas0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("OPERADOR",0);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("OPERADOR",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OPERADOR ::= Menos 
            {
                XMLElement RESULT;
		Location Menos0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Menos0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Menos0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("OPERADOR",1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("OPERADOR",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OPERADOR ::= Timesslash 
            {
                XMLElement RESULT;
		Location Timesslash0xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location Timesslash0xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Object Timesslash0 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;

                RESULT = new XMLElement.NonTerminal("OPERADOR",2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("OPERADOR",22, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
