package com.company;

public class Zahlenfolge extends Frage{
    int anzahl;
    int[] zahlen;
    int folgezahl;
    Zahlenfolge(int anzahl, int[] zahlen, int folgezahl, int punkte) {
        super("Identifizieren Sie die Zahlenfolge und geben Sie die nächste Zahl der" + "Folge ein!", punkte);
        this.zahlen = zahlen;
        this.anzahl = anzahl;
        this.folgezahl = folgezahl;
    }
    void frageStellen() {
        super.frageStellen();
        for(int i = 0; i<this.anzahl;i++){
            System.out.print(zahlen[i] + " ");
        }
    }
    void frageBeantworten(Pruefling person) {
        int geraten = IO.readInt();
        if(geraten == this.folgezahl) {
            person.neuePunkte(this.punkte);
            System.out.println("Es wurde richtig geraten und damit " + this.punkte + " Punkt(e) erzielt");
        }
        else{
            System.out.println("Leider falsch, es wäre "+ this.folgezahl + " gewesen");
        }
    }
}
