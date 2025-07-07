package com.company;

public class Ordnungsfrage extends Frage{
    int anzahl;//Anzahl der Möglichkeiten
    int[] index;//Liste an Ordnungszahlen
    String[] antworten;//Liste an Antworten
    Ordnungsfrage(String frage, int anzahl, String[] antworten, int[] index, int punkte) {
        super(frage, punkte);
        this.antworten = antworten;
        this.anzahl = anzahl;
        this.index = index;
    }
    void frageStellen() {
        super.frageStellen();
        for(int i = 0; i<this.anzahl;i++){
            System.out.println("(" + i + ") : " + this.antworten[i] + " ");//Alle Eingaben werden ausgegeben
        }
    }
    void frageBeantworten(Pruefling person) {
        int[] geraten = new int[anzahl];//Array mit geratenden Werten
        for(int i = 0; i<this.anzahl;i++){
            geraten[i] = IO.readInt(i + ". : ");//Raten der Werte
        }
        boolean richtig = true;//Hilfsvariable zur Auswertung
        for(int i = 0; i<this.anzahl;i++){
            if(index[i] == geraten[i]){//Vergleich von richtigen Antworten und Geratendem
                richtig = true;
            }
            else
            {
                richtig = false;
                break;
            }
        }
        if (richtig == true){
            person.neuePunkte(this.punkte);
            System.out.println("Richtige Reihenfolge: " + this.punkte + " Punkt(e)");
        }
        else{
            System.out.println("Leider falsch");
        }
    }
}
