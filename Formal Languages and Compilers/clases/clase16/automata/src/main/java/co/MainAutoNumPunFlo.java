package co;

/*
 * MainAuotNumPunFlo
 *
 * Punto de entrada para el autómata AutoNumPunFlo.
 *
 * Creación: 25/08/2011.
 * Autor:    fcardona
 * email:    fcardona@eafit.edu.co
 *
 * Registro de modificación:
 *
 * 11/03/2019 - Actualización cosmética
 * 09/03/2018 - Generando un único automata para todos los tipos de implementación
 * 10/03/2016 - Arreglando para funcionar con Maven.
 * 01/03/2012 - Arreglando la identación y algunos cambios menores.
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import co.edu.eafit.dis.st0270.automata.AutoNumPunFlo;
import co.edu.eafit.dis.st0270.automata.AutoNumPunFloT;
import co.edu.eafit.dis.st0270.automata.AutoNumPunFloM;
import co.edu.eafit.dis.st0270.automata.Automata;
import co.edu.eafit.dis.st0270.automata.AutoState;

/**
 * This is a Java Application to show class AutoNumPunFlo works. It reads a command line
 * and decide with kind of Automaton is implemented switch, table and map.
 */

public class MainAutoNumPunFlo {

    private static void usage() {

	System.err.println("Usage: co.MainAutoNumPunFlo " +
			   "[switch|table|map]");
	System.exit(1);
    }

    private static Automata testAutomaton(String [] args) {

	String firstArgument = null;

	switch (args.length) {
	case 0:
	    firstArgument = "switch";
	    break;

	case 1:
	    firstArgument = args[0];
	    break;

	default:
	    usage();
	    break;
	}

	System.out.println("Using automaton implemented with " +
			   firstArgument);

	Automata ret = null;

	switch (firstArgument) {
	case "switch":
	    ret = new AutoNumPunFlo();
	    break;

	case "table":
	    ret = new AutoNumPunFloT();
	    break;

	case "map":
	    ret = new AutoNumPunFloM();
	    break;

	default:
	    usage();
	    break;
	}

	return ret;
    }

    /**
     * <p>main method
     *
     * @param args Only accept one string parameter: "switch", "table", "map" by default "switch"
     */
    public static void main(String [] args)
	throws IOException {

	Automata auto = testAutomaton(args);

	BufferedReader in =
	    new BufferedReader(new InputStreamReader(System.in));

	// Lea y haga echo de las líneas hasta EOF
	System.out.print("Write down a decimal number: ");
	System.out.flush();

	String x = in.readLine();

	while (x != null) {

	    auto.reset();
	    auto.process(x);

	    if (auto.accepted()) {
		System.out.println("String: " + x + " is accepted");
	    }
	    else {
		System.err.println("String: " + x + " is rejected");
	    }

	    System.out.print("Write down a decimal number: ");
	    System.out.flush();
	    x = in.readLine();
	}
    }
}
