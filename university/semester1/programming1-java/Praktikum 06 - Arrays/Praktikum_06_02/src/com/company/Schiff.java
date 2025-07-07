package com.company;

public class Schiff {
    private int zeile;
    private int spalte;
    private boolean zerstört = false; //Abfrage, ob Schiff zerstört ist

    public void setSpalte(int spalte) {
        this.spalte = spalte;
    }
    public void setZeile(int zeile) {
        this.zeile = zeile;
    }

    public int getSpalte() {
        return spalte;
    }

    public int getZeile() {
        return zeile;
    }

    public void bootPlazieren(int i, int[][] werte, int splnmr)
    {
        System.out.println("Geben Sie die Postion des " + i +" Schiffes von Spieler "+ splnmr +" an: ");
        do {
            this.setZeile(IO.readInt("Zeile des " + i + " Schiffes: "));
            this.setSpalte(IO.readInt("Spalte des " + i + " Schiffes: "));
        }while(this.getZeile() == 0 && this.getSpalte() == 0);//Auf Feld 0/0 darf kein Boot erraten werden
        werte[zeile][spalte] = 1;//Postion des Boots wird auf 1 gesetzt(Boot vorhanden, nicht getroffen)
    }
}
