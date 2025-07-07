public class Aufgabe5_5 {
	public static void main(String[] args) {
		int anzahl = IO.readInt("Anzahl der Städte eingeben: "); 
		String[] amount = new String[anzahl];
		for (int i = 0; i < amount.length; i++) {
			amount[i] = IO.readString("Stadt " + (i + 1) + " : ");
			System.out.println(amount[i]);
		}
		int l = IO.readInt("Anzahl der Direktverbindungen: ");
		String[][] direct = new String[l][2];
		for (int i = 0; i < l; i++) {
			System.out.println("Direktverbindung " + (i + 1) + ": \n");
			direct[i][0] = zielEingabe(i, amount, "Start: ");
			direct[i][1] = zielEingabe(i, amount, "Ziel: ");
		}
		System.out.println("Auskunft: ");
		do {
		String david = IO.readString("Start: ");
		String rene = IO.readString("Ziel: ");
		String ausgabe = "Es gibt keine Direktverbindung!";
		for (String[] stadte : direct) {
			if (stadte[0].equals(david) && stadte[1].equals(rene)
					|| stadte[1].equals(david) && stadte[0].equals(rene)) {
				ausgabe = "Es gibt eine Direktverbindung!";
			}
		}
		System.out.println(ausgabe);
		}while(true);
	}
	public static String zielEingabe(int i, String[] amount, String ausgabe) {
		String temp = IO.readString(ausgabe);
		for (String stadt : amount) {
			if (stadt.equals(temp)) {
				return temp;
			}
		}
		return zielEingabe(i, amount, ausgabe);
	}
}