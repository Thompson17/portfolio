package com.company;

public class Main {

    public static final int sAnzahl = 10; //Prozentualanteil der Schiffe(konstant)

    public static void main(String[] args) {
        Spielfeld.groesse = IO.readInt("Bitte geben Sie die Größe der Spielfelder an: ");
        Spielfeld sp1 = new Spielfeld();
        Spielfeld sp2 = new Spielfeld();
        sp1.spielernummer = 1;
        sp2.spielernummer = 2;
	    sp1.werte = new int[Spielfeld.groesse][Spielfeld.groesse];
        sp2.werte = new int[Spielfeld.groesse][Spielfeld.groesse];
	    Spielfeld.schiffsAnzahlBerechnen();
	    Spielfeld.gesamtpunkte = Spielfeld.getSchiffsAnzahl();
	    Schiff p1[] = new Schiff[Spielfeld.getSchiffsAnzahl() + 1];
	    for(int i = 1; i <= Spielfeld.getSchiffsAnzahl(); i++) //Erstellung der Schiffe für Spieler 1 und Festlegung der Postitionen
        {
            p1[i] = new Schiff(); //Objektarray wird erstellt
            p1[i].bootPlazieren(i, sp2.werte, sp1.spielernummer ); //Die einzelnden Boote aus dem Array bekommen eine Position
        }
        Schiff p2[] = new Schiff[Spielfeld.getSchiffsAnzahl() + 1];
        for(int i = 1; i <= Spielfeld.getSchiffsAnzahl(); i++) //Erstellung der Schiffe für Spieler 1 und Festlegung der Postitionen
        {
            p2[i] = new Schiff();
            p2[i].bootPlazieren(i, sp1.werte, sp2.spielernummer);
        }
	    while(sp1.zwischenstand != Spielfeld.gesamtpunkte && sp2.zwischenstand != Spielfeld.gesamtpunkte) //Während Spieler 1 noch nicht gewonnen hat
	    {
	        int temp = -1;
	        while(temp != sp1.zwischenstand && sp1.zwischenstand != Spielfeld.gesamtpunkte) {//Während der Zwischenstand sich verändert, darf der Spieler noch einmal raten
	            temp = sp1.zwischenstand;
                System.out.println("Spieler 1 ist dran: ");
                Spielfeld.gridErstellen(sp1.werte); //Grid wird erstellt, mit den Booten von Sp2
                sp1.schiffVersenken();
            }
            if(sp1.zwischenstand != Spielfeld.gesamtpunkte) //Wenn Spieler 1 noch nicht gewonnen hat in dieser Runde
            {
                temp = -1;
                while(temp != sp2.zwischenstand && sp2.zwischenstand != Spielfeld.gesamtpunkte) {
                    System.out.println("Spieler 2 ist dran: ");
                    Spielfeld.gridErstellen(sp2.werte);
                    sp2.schiffVersenken();
                }
            }
        }
	    Spielfeld.siegerAusgabe(sp1.zwischenstand, sp2.zwischenstand);
	    sp1.endGrid(sp1.werte);
	    sp2.endGrid(sp2.werte);
    }
}
