/*
    Dies ist ein Testprogramm für die Klasse Menge.

    Hinweis: Aufgabe f wird nicht explizit getestet, da Menge.equals() und Person.equals() in anderen Tests aufgerufen werden.

*/

public class Main {

    public static void main(String[] args) {
//	    Testpersonen
        Person simpson = new Person("Simpson", "Thomas");
	    Person moenter = new Person("Mönter", "Manuel");
	    Person cirksena = new Person("Cirksena", "Tim");
	    Person landwehr = new Person("Landwehr", "Martin");
	    Person domke = new Person("Domke", "Ksenia");
	    Person tapken = new Person("Tapken", "Heiko");

	    System.out.println("Es gibt folgende Personen:");
	    System.out.println(simpson.getVorname() +" " + simpson.getNachname());
	    System.out.println(moenter.getVorname() +" " + moenter.getNachname());
	    System.out.println(cirksena.getVorname() +" " + cirksena.getNachname());
	    System.out.println(landwehr.getVorname() +" " + landwehr.getNachname());
	    System.out.println(domke.getVorname() +" " + domke.getNachname());
	    System.out.println(tapken.getVorname() +" " + tapken.getNachname() + "\n");

//	    Aufgabe a
        System.out.println("\nAufgabe A:");
        Menge a = new Menge(5);
        System.out.println("Die Menge a:");
        ausgabeMenge(a);

//      Aufgabe b
        System.out.println("\nAufgabe B");
        Menge b1 = new Menge(2);
        b1.addPerson(simpson);
        b1.addPerson(moenter);
        Menge b2 = new Menge(b1);
        System.out.println("Menge b1:");
        ausgabeMenge(b1);
        System.out.println("Menge b2:");
        ausgabeMenge(b2);

//      Aufgabe c
        System.out.println("\nAufgabe c:");
        Menge c1 = new Menge(2);
        c1.addPerson(moenter);
        c1.addPerson(simpson);
        Menge c2 = new Menge(3);
        c2.addPerson(simpson);
        c2.addPerson(moenter);
        c2.addPerson(cirksena);
        System.out.println("Menge b1:");
        ausgabeMenge(b1);
        System.out.println("Menge c1:");
        ausgabeMenge(c1);
        System.out.println("Menge c2:");
        ausgabeMenge(c2);
        System.out.println("Sind b1 und c1 gleich? " + b1.equals(c1));
        System.out.println("Sind b1 und c2 gleich? " + b1.equals(c2));

//      Aufgabe d
        System.out.println("\nAufgabe d:");
        Menge d = new Menge(2);
        d.addPerson(simpson);
        d.addPerson(moenter);
        d.addPerson(cirksena);
        ausgabeMenge(d);

//      Aufgabe e
        System.out.println("\nAufgabe e:");
        System.out.println("Menge c2:");
        ausgabeMenge(c2);
        System.out.println("Menge c2 nach Entfernen von Manuel Mönter:");
        c2.entfernePerson(moenter);
        ausgabeMenge(c2);

//      Aufgabe g
        System.out.println("\nAufgabe g:");
        Menge g1 = new Menge(3);
        g1.addPerson(cirksena);
        g1.addPerson(landwehr);
        g1.addPerson(domke);
        Menge g2 = new Menge(3);
        g2.addPerson(landwehr);
        g2.addPerson(domke);
        g2.addPerson(tapken);
        System.out.println("Menge d:");
        ausgabeMenge(d);
        System.out.println("Menge g1:");
        ausgabeMenge(g1);
        System.out.println("Menge g2:");
        ausgabeMenge(g2);
        System.out.println("Schnittmenge von d und g1:");
        ausgabeMenge(d.schnittmenge(g1));
        System.out.println("Schnittmenge von d und g2:");
        ausgabeMenge(d.schnittmenge(g2));

//      Aufgabe h
        System.out.println("\nAufgabe h:");
        System.out.println("Vereinigung von d und g1:");
        ausgabeMenge(d.vereinigung(g1));
        System.out.println("Vereinigung von d und g2:");
        ausgabeMenge(d.vereinigung(g2));

//      Aufgabe i
        System.out.println("\nAufgabe h:");
        System.out.println("Differenz von d und g1:");
        ausgabeMenge(d.differenz(g1));
        System.out.println("Differenz von d und g2:");
        ausgabeMenge(d.differenz(g2));
    }

//    Ausgabe der Vor- und Nachnamen aller Personen einer Menge
    static void ausgabeMenge(Menge menge){
        Person[] tmp = menge.getMenge();
        int anzahl = menge.getAnzahlPersonen();
        for (int i = 0; i < anzahl; i++) {
            System.out.println(tmp[i].getVorname() + " " + tmp[i].getNachname());
        }
        if(anzahl==0){
            System.out.println("Die Menge ist leer!");
        }
    }
}
