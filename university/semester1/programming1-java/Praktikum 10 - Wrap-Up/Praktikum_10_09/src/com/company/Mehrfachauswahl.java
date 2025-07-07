package com.company;

import java.util.ArrayList;

public class Mehrfachauswahl extends Frage{
    String[] antworten; // moegliche Antworten
    boolean[] richtigIndex; // Index der richtigen Antwort
    int richtigAnzahl = 0;
    int richtigGeraten = 0;
    Mehrfachauswahl(String text, int punkte, String[] antworten, boolean[] richtigIndex) {
        super(text, punkte);
        this.antworten = antworten;
        this.richtigIndex = richtigIndex;
        for(int i = 0; i < richtigIndex.length; i++){
            if(richtigIndex[i]){
                this.richtigAnzahl++;
            }
        }
    }
    // Frage auf den Bildschirm ausgeben
    void frageStellen() {
        super.frageStellen();
        for (int f = 0; f < this.antworten.length; f++) {
            IO.println("(" + f + "): " + this.antworten[f]);
        }
    }
    void frageBeantworten(Pruefling person) {
        ArrayList<String> antwort = new ArrayList<String>();
        boolean weiter = true;
        while(weiter == true) {
            antwort.add(IO.readString("Auswahl: "));
            weiter = (IO.readChar("Gibt es eine weitere Antwort? (j/n)") == 'w');
        }
        for(int i = 0; i < antwort.size(); i++){
            for(int j = 0; j < this.antworten.length; j++) {
                if (antwort.get(i).equals(this.antworten[j])) {
                    this.richtigGeraten += 1;
                }
            }
        }
        if(this.richtigAnzahl == this.richtigGeraten) {
            person.neuePunkte(this.punkte);
        }
        System.out.println("Es wurde(n) " + this.richtigGeraten + " Lösungen gefunden und damit " + this.punkte + " Punkt(e) erzielt");
    }
}
