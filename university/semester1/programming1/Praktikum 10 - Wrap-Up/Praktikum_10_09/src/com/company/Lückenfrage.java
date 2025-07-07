package com.company;

import java.util.ArrayList;

public class Lückenfrage extends Frage{
    String text1;
    String text2;
    String textMissing;
    Lückenfrage(String text1, String text2, String textMissing, int punkte) {
        super(text1 + " x " + text2, punkte);
        this.text1 = text1;
        this.text2 = text2;
        this.textMissing = textMissing;
    }
    void frageStellen() {
        super.frageStellen();
        System.out.println("Welches Wort fehlt?");
    }
    void frageBeantworten(Pruefling person) {
        String geraten = IO.readString("Antwort: ");
        if(geraten.equals(this.textMissing)) {
            person.neuePunkte(this.punkte);
            System.out.println("Es wurde richtig geraten und damit " + this.punkte + " Punkt(e) erzielt");
        }
        else{
            System.out.println("Leider falsch, es wäre "+ this.textMissing + " gewesen");
        }
    }
}
