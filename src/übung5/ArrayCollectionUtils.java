package util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayCollectionUtils {

  /**
   * Hilfsmethode wie in Python und ein äquidistantes Werte-Array zu erzeugen
   * 
   * @param intervallbegin Beginn des Intervalls
   * @param endIntervallExklusiv Ende des Intervalls (nicht mitgerechnet)
   * @param anzPunkte Anzahl der Punkte im Intervall
   * @return
   */
  public double[] aRange(double intervallbegin, double endIntervallExklusiv, int anzPunkte) {
    assert intervallbegin < endIntervallExklusiv;
    final double inc = (endIntervallExklusiv - intervallbegin) / anzPunkte;
    return punktArrayErzeugen(intervallbegin, anzPunkte, inc);
  }

  /**
   * Hilfsmethode wie in Python und ein äquidistantes Werte-Array zu erzeugen
   * 
   * @param intervallbegin Beginn des Intervalls
   * @param endIntervallInklusiv Ende des Intervalls (mitgerechnet)
   * @param anzPunkte Anzahl der Punkte im Intervall
   * @return
   */
  public double[] linSpace(double intervallbegin, double endIntervallInklusiv, int anzPunkte) {
    assert intervallbegin < endIntervallInklusiv && anzPunkte > 1;
    final double inc = (endIntervallInklusiv - intervallbegin) / (anzPunkte - 1);
    return punktArrayErzeugen(intervallbegin, anzPunkte, inc);
  }

  // Hilfsmethode
  private double[] punktArrayErzeugen(double start, int anzPunkte, final double inc) {
    double[] erg = new double[anzPunkte];
    double x = start;
    for (int i = 0; i < erg.length; i++) {
      erg[i] = x;
      x += inc;
    }
    return erg;
  }

  /**
   * Erzeugung und Berechnung der Funktionswerte einer geg. Funktion
   * 
   * @param xArray Array von x-Werten
   * @param f eine Funktion {@link IFunction}
   * @return ein Array der entsprechenden Funktionswerte
   */
  public static double[] berechnen(double[] xArray, IFunction f) {
    double[] y = new double[xArray.length];
    for (int i = 0; i < xArray.length; i++) {
      y[i] = f.berechnen(xArray[i]);
    }
    return y;
  }

  /**
   * Hilfsmethode, um den Mittetlwert und die Varianz eines double-Arrays zu
   * bestimmen
   * 
   * @param a ein Array von double-Werten
   * @return ein Array der Länge 2 für den Mittelwert und die Varianz
   */
  public static double[] mittelwertUndVarianzBerechnen(double[] a) {
    assert a.length > 1;
    double summe = 0;
    double quadSumme = 0;
    for (double e : a) {
      summe += e;
      quadSumme += e * e;
    }
    double mittelwert = summe / a.length;
    double varianz = (quadSumme - summe * mittelwert) / (a.length - 1);

    return new double[] { mittelwert, varianz };
  }

//	public static void reverse(int[] a) {
//		for (int i = 0, j = a.length - 1; i < j; i++, j--) {
//			int tmp = a[i];
//			a[i] = a[j];
//			a[j] = tmp;
//		}
//	}
  /**
   * generic-Methode, um den Inhalt eines Arrays umzudrehen
   * 
   * @param a ein non-null Array
   */
  public static void reverse(Object a) {
    int n = Array.getLength(a);
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      Object tmp = Array.get(a, i);
      Array.set(a, i, Array.get(a, j));
      Array.set(a, j, tmp);
    }
  }

  /**
   * Eine generic-Methode, um die Darstellung eines beliebigen Objekts zu
   * bekommen. Wenn das Objekt ein Array ist, dann müssen die Elemente die
   * toString-Methode haben Die Besonderheit dieser Methode ist, dass sie auch
   * für Array von Array usw. funktionieren
   * 
   * @param a ein Objekt
   * @return die Darstellung des Objekts
   */
  public static String toString(Object a) {
    if (a == null)
      return "null";
    if (isArray(a) == false)
      return a.toString();
    int n = Array.getLength(a);
    StringBuilder b = new StringBuilder(2 * n);
    b.append("[");
    for (int i = 0; i < n; i++) {
      b.append(toString(Array.get(a, i)));
      if (i != n - 1)
        b.append(',');
      else
        b.append(']');
    }
    return b.toString();
  }
//	public static String toString(int[] a) {
//		StringBuilder b = new StringBuilder(2 * a.length);
//		b.append("[");
//		for (int i = 0; i < a.length; i++) {
//			b.append(a[i]);
//			if (i != a.length - 1)
//				b.append(',');
//			else
//				b.append(']');
//		}
//		return b.toString();
//	}
//
//	public static String toString(double[] a) {
//		StringBuilder b = new StringBuilder(2 * a.length);
//		b.append("[");
//		for (int i = 0; i < a.length; i++) {
//			b.append(a[i]);
//			if (i != a.length - 1)
//				b.append(',');
//			else
//				b.append(']');
//		}
//		return b.toString();
//	}

//	public static boolean contains(double[] a, double x) {
//		for (double e : a)
//			if (x == e)
//				return true;
//		return false;
//	}
  /**
   * Überprüft, ob ein Element x in einem Array a liegt Die Besonderheit dieser
   * Methode ist, dass sie für alle Array-Typen funktioniert
   * 
   * @param a ein beliebiges Array
   * @param x ein beliebiges Objekt
   * @return true, falls x in a liegt
   */
  public static boolean contains(Object a, Object x) {
    int n = Array.getLength(a);
    for (int i = 0; i < n; i++)
      if (x.equals(Array.get(a, i)))
        return true;
    return false;
  }

  /**
   * Hilfsmethode, um min und max aus einem double-Array zu bestimmen
   * 
   * @param a ein nicht-null double-Array
   * @return ein Array der Länge 2 für min und max
   */
  public static double[] findMinUndMax(double[] a) {
    double min = a[0];
    double max = a[0];
    for (double e : a) {
      if (e > max)
        max = e;
      else if (e < min)
        min = e;
    }
    return new double[] { min, max };
  }

  /**
   * Hilfsmethode, um aus einem int-Array eine entsprechende Liste zu erzeugen
   * 
   * @param a ein int-Array, darf nicht null sein
   * @return die entsprechende <code>List<Integer>/code>
   */
  public static List<Integer> asList(int[] a) {
    assert (a != null);
    List<Integer> ret = new ArrayList<>(a.length);
    for (int e : a)
      ret.add(e);
    return ret;
  }

  /**
   * Hilfsmethode, um ein int-Array aus einer Integer-Collection zu konstruieren
   * 
   * @param a eine Collection - darf nich Null sein
   * @return das entsprechende int-Array
   */
  public static int[] toArray(Collection<Integer> a) {
    assert (a != null);
    int[] ret = new int[a.size()];
    int i = 0;
    for (int e : a)
      ret[i++] = e;
    return ret;
  }

  /**
   * Überprüft, ob obj ein Array ist
   * 
   * @param obj das zu prüfende Objekt
   * @return true falls obj ein Array ist
   */
  public static boolean isArray(Object obj) {
    if (obj == null)
      return false;
    Class<?> cls = obj.getClass();
    return cls.isArray();
  }

  public static int maxPos(int[] a) {
    int pos = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > a[pos])
        pos = i;
    }
    return pos;
  }

  public static int minPos(double[] a) {
    int pos = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < a[pos])
        pos = i;
    }
    return pos;
  }
}
