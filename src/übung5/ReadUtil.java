package util;

/**
 * Hilfsklasse zum Einlesen der elementaren Datentypen - hier nur int, double, BigDecimal und String
 * Für andere Datentypen kann man analog implementieren!
 * @author tran
 * @version 1.0
 */
import java.math.BigDecimal;
import java.util.Scanner;

public class ReadUtil {
    // Klassenobjekt zum Einlesen der grundlegenden Daten aus der Konsole
    // System.in ist der Byte-Lieferant. Scanner-Objekt benötigt sie,
    // um die Zeichen einzulesen und sie umzuwandeln
    public static Scanner sIn;

    /**
     * liest eine ganzzahlige Zahl. Die Methode wird nur verlassen, wenn der
     * Benutzer eine ganzzahlige Zahl richtig eingibt
     * 
     * @param txt Aufforderungstext
     * @return eine ganzzahlige Zahl vom Typ int
     */
    public static int nextInt(String txt) {
        while (true) {
            try {
                System.out.print(txt); // Aufforderung ausgeben
                return sIn.nextInt(); // Zahl einlesen
            } catch (Exception ex) {
                sIn.next(); // Schmeiß die letzte Zeichenkette weg!
                System.out.println("Bitte nur eine ganze Zahl zwischen " + Integer.MIN_VALUE + " und "
                        + Integer.MAX_VALUE + " eingeben");
            }
        }
    }

    /**
     * liest eine ganzzahlige Zahl aus [von..bis]. Die Methode wird nur
     * verlassen, wenn der Benutzer eine ganzzahlige Zahl richtig eingibt
     * 
     * @param txt Aufforderungstext
     * @param von der kleinste Wert des Zahlenbereichs
     * @param bis der größte Wert des Zahlenbereichs
     * @return eine ganzzahlige Zahl vom Typ int in dem angegebenen Wertebereich
     */
    public static int nextInt(String txt, int von, int bis) {
        // Überprüfung der eingegebenen Werte
        if (von > bis) { // Andere Möglichkeit ist assert! Siehe später
            // Eine Ausnahme wird erzeugt ung geworfen
            // Das Programm wird abgestürzt, falls die Ausnahme nicht behandelt
            // wird
            throw new IllegalArgumentException("Falsche Grenzen");
        }
        while (true) {
            try {
                System.out.println(txt + "(" + von + ".." + bis + ")");

                int zahl = sIn.nextInt();
                // Eine Überprüfung ist wichtig
                if (zahl >= von && zahl <= bis) {
                    return zahl;
                } else {
                    System.out.println("Die eingebene Zahl ist nicht im erlaubten Zahlenbereich");
                }
            } catch (Exception ex) {
                sIn.next(); // fehlerhafte Eingabe überlesen
                System.out.println("Bitte nur eine ganze Zahl zwischen " + von + " und " + bis + " eingeben");
            }

        }
    }

    /**
     * Hilfsmethode zum Einlesen einer ganzzahligen, positiven Zahl
     * 
     * @param txt Aufforderungstext
     * @return eine positive Zahl
     */
    public static int nextPosInt(String txt) {
        return nextInt(txt, 0, Integer.MAX_VALUE);
    }

    /**
     * Hilfsmethode zum Einlesen einer Gleitkommazahl. Die Methode wird nur
     * verlassen, wenn sie der Benutzer richtig eingibt
     * 
     * @param txt Aufforderungstext
     * @return eine ganzzahlige Zahl vom Typ int
     */
    public static double nextDouble(String txt) {
        while (true) {
            try {
                System.out.print(txt); // Aufforderung ausgeben
                return sIn.nextDouble(); // Zahl einlesen
            } catch (Exception ex) {
                sIn.next(); // Schmeiß die letzte Zeichenkette weg!
                System.out.println("Bitte nur eine Gleitkommazahl, etwa 1.3, -7.3 etc. eingeben");
            }
        }
    }

    /**
     * Hilfsmethode zum Einlesen einer beliebigen großen Zahl
     * 
     * @param txt Aufforderungstext
     * @return ein BigDecimal-Objekt
     */
    public static BigDecimal nextBigDecimal(String txt) {
        while (true) {
            try {
                System.out.println(txt);
                String s = sIn.next();
                return new BigDecimal(s);
            } catch (Exception ex) {
                System.out.println("Geben Sie bitte eine Zahl, etwa 12345.67 ein");
            }
        }
    }

    /**
     * Hilfsmethode zum Einlesen einer Zeichenkette
     * 
     * @param txt Aufforderungstext
     * @return ein String-Objekt
     */
    public static String nextString(String txt) {
        System.out.println(txt);
        return sIn.next();
    }
}
