import java_cup.runtime.*;
import java.io.*;

public class Main {
    public static void main(String [] args) {
	try{
	Lexer lexer = new Lexer(new StringReader("3+4*5"));
	parser p = new parser(lexer);
	Symbol s = p.parser();
	Integer i = (Integer) s.value;
	System.out.println("El resultado es:" + i);
	}
	catch (Exception e){
	    System.err.println("Excepcion: " + e);
	}
    }
}
    
