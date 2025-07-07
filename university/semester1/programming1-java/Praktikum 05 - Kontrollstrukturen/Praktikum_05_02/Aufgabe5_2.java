public class Aufgabe5_2 {
	private static int n1 = 1;
	private static int n2 = 1;

	public static void main(String args[]) {
		int auswahl = IO.readInt("Für Fibonacci Rechnen <1>:" + "\nFür Runden            <2>:"
				+ "\nFür Primezahlen       <3>:" + "\nFür CheckSeven 	      <4>:" + "\nFür Summe      	      <5>:"
				+ "\nFür Runden Nachkomma  <5>:" + "\nFür Uhrzeiten         <6>:");
		switch (auswahl) {
		case 1:
			int a = IO.readInt("Ist diese Zahl eine Fibonacci Zahl? ");
			System.out.println(fibonacciRechnen(a));
			break;
		case 2:
			float b = IO.readFloat("Welche Zahl wollen Sie runden? ");
			System.out.println(round(b));
			break;
		case 3:
			int c = IO.readInt("Von welcher Prime Zahl soll der Vorgänger angezeigt werden? ");
			System.out.println(primeNumbersBefore(c));
			break;
		case 4:
			int d = IO.readInt("Geben Sie die Zahl ein die überprüft werden soll: ");
			System.out.println(checkSeven(d));
			break;
//		case 5:
//			int e   = IO.readInt("Bitte geben Sie <die Anzahl> der Werte an die addiert werden sollen: ");
//			float[] f = new float[e]; 
//			f[e] = IO.readFloat("Jetzt <die Werte> eingeben (Bei mehreren mit ',' trenen): ");
//			System.out.println(summe(e,f[e]));
//			break;
		case 5:
			int g = IO.readInt("Auf wie viele Nachkommastellen soll gerundet werden? ");
			float h = IO.readFloat("Eine Zahl <von 0 bis 1000> eingeben: ");
			vielRunden(g, h);
			break;
		case 6:
			float i = IO.readFloat("Erste Uhrzeit <HH.MM> eingeben: ");
			float j = IO.readFloat("Zweite Uhrzeit <HH.MM> eingeben: ");
			time(i, j);
			break;
		default:
			System.out.println("Gültige Eingabe bitte!");
		}
//		System.out.println(fibonacciRechnen(21));
//		chance(10.0, 20.0);
//		round(-2.4f);
//		primeNumbers(17);
//		System.out.println(checkSeven(-200006));
// 		System.out.println(primeNumbersBefore(20));
//		System.out.println(summe(3, 1.5f,1.4f,5.2f));
//		System.out.println(vielRunden(9.123669f, 2));
//		time(10.25f, 10.25f);
	}

	public static int fibonacci() { // Nummer 2.1
		do { // Berechnung aller Fibonacci-Zahlen
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			return n3;
		} while (true);
	}

	public static boolean fibonacciRechnen(int n) { // Nummer 2.1
		int x = 3;
		switch (n) {
		case 0:
		case 1:
		case 2:
			n1 = 1; // Setz die Globalen Variablen auf 1 zurück
			n2 = 1;
			return true; // Die Fälle 1 und 2 sind immer true
		default:
			do {
				x = fibonacci(); // übergibt die aktuelle Fibonacci-Zahl
				if (n == x) { // überprüft ob unsere Zahl eine Fibonacci-Zahl ist
					n1 = 1;
					n2 = 1;
					return true;
				} else if (x > n) { //
					n1 = 1;
					n2 = 1;
					return false;
				}
			} while (x <= n);
			n1 = 1;
			n2 = 1;
			return false;
		}
	}

	public static double chance(double a, double b) { // Nummer 2.2 unlösbar da keine zwei Werte returned werden können.
		double result = a;
		a = b;
		b = result;
		System.out.println("a hat den Wert von b: " + a + " und b hat den Wert von a: " + b);
		return result;
	}

	public static int round(double a) { // Nummer 2.3
		int result = (int) Math.round(a);// rundet den double in einen int mit casten
		result = Math.abs(result); // nimmt den Betrag des Ergebnisses
		return result;
	}

	public static boolean primeNumbers(int number) { // Nummer 2.4
		int zaehler = number - 1; // Zähler speichert number - 1
		int zwischen;
		while (zaehler > 1) {
			zwischen = number % zaehler; // Das Zwischenergebnis ist der rest aus unserer Primzahl geteilt durch Zähler
			if (zwischen == 0) { // Wenn der Rest 0 ist, return false
				return false;
			}
			zaehler--; // Es gibt Rest dann wird Zähler minus 1 gerechnet und wiederholt
		}
		return true; // Wenn Zähler kleiner gleich 1 ist, return true
	}

	public static int primeNumbersBefore(int number) {// Nummer 2.4
		int zwischen = number - 1; // Das zwischenergebnis bekommt die Primzahl minus 1
		while (primeNumbers(zwischen) == false) { // Methode wird aufgerufen und auf Primzahl geprüft, falls false wird
													// zwischen minus 1 gerechnet
			zwischen--;
		}
		return zwischen; // wenn die nächstkleinere Primzahl gefunden wurde, wird zwischen returned.
	}

	public static boolean checkSeven(int number) { // Nummer 2.5

		if (number > 0) { // Wenn Number größer null ist
			checkSeven(number / 10); // Number wird durch 10 geteilt.
			if (number % 10 == 7) { // wenn unsere Number geteilt durch 10 rest 7 hat, return true
				return true;
			}
			return false; // falls unsere Number nicht rest 7 hat, return false

		} else if (number < 0) { // Wenn Number kleiner null ist
			number *= (-1); // Number wird *-1 gerechnet, somit positiv
			checkSeven(number / 10);
			if (number % 10 == 7) {
				return true;
			}
			return false;

		} else { // falls Number 0 ist.
			return false;
		}
	}

	/*
	 * Aufgabe 2.6, nicht möglich mit unseren Programmierkenntnisen. Eine Funktion
	 * als Parameter anzugeben
	 * 
	 * Aufgabe 2.7, nicht möglich mit unseren Programmierkenntnisen. Als Rückgabe
	 * Wert einen boolschen Wert und einen Intenger zu liefern, haben wir noch nicht
	 * kennengelernt.
	 */

	public static float summe(int n, float... fl) { // Aufgabe 2.8
		// Halb lösbar, das Problem, sofern mehr float parameter angeben werden als der
		// N wert, wird nicht mehr addiert.
		float zwischen = 0;
		for (int i = 0; i < n; i++) {
			zwischen += fl[i];
		}
		return zwischen;
	}

	public static float vielRunden(int n, float x) { // Aufgabe 2.9
		float zwischen = 0;
		int n2 = 1;
		if (x > Float.MAX_VALUE || x < Float.MIN_VALUE) { // Zahl ist zu klein oder zu groß
			System.out.println("Bitte eine gültige Zahl");
			return 0;
		} else if (0 <= x && x <= 1000) { // wenn Zahl im Bereich liegt
			for (int i = 0; i < n; i++) {
				n2 = n2 * 10; // n2 wird für Nachkommastellen um eine Stelle erweitert
			}
			zwischen = (float) Math.round(x * n2) / n2; // Die n-te Nachkommastelle wird gerundet

			return zwischen;
		}
		return zwischen; // Falls Zahl nicht gerundet werden konnte.
	}

	public static float time(float d, float e) {
		float Stunden = (float) (Math.floor(d) + (Math.floor(e))); // Stunden werden berechnet, Nachkomma fällt weg
		float Minuten = (float) ((d - Math.floor(d)) + (e - Math.floor(e))); // Vor dem Komma wird subtrahiert
		float Ergebnis = 0;
		Minuten = vielRunden(2, Minuten);
		if (Minuten >= 1) { // Falls Minuten größer als eins sind
			Minuten = Minuten - (0.6f); // "60 Minuten" werden abgezogen
			Minuten++; // 0,59 + 0,59 = 1,58 (Sinnbildich eine Stunde 58 Minuten
		} else if (Minuten >= 0.6f) {
			Minuten = Minuten - (0.6f);
			Minuten++;
		}
		if (Stunden >= 24) { // Wenn 24 Stunden überschritten werden
			Stunden = Stunden - (24); // Neuer Tag wird berechnet
		}
		Ergebnis = Minuten + Stunden; // Ergebnis wird aus Minuten und Stunden berechnet
		Ergebnis = vielRunden(2, Ergebnis);
		System.out.println("Die Uhrzeit beträgt: " + Ergebnis);
		return Ergebnis;
	}

	public static void addSub(int a, int b) { // Nicht lösbar, weil keine zwei Werte returned werden können.
		int add = a + b;
		int sub = a - b;
		System.out.println("Addition: " + add + "Differenz: " + sub);
	}
}
