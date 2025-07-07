package com.company;

public class Spielfeld {
    static int groesse; //spalten und zeilen
    int[][] werte; //Spielermatrix
    static int schiffsAnzahl; //Anzahl an benötigten Schiffen
    int zwischenstand = 0; //Punktestand eines Spielers
    static int gesamtpunkte; //Die zum Sieg benötigten Punkte
    int spielernummer; //Die Nummer des zugeordneten ratenden Spielers

    public static void schiffsAnzahlBerechnen()
    {
        schiffsAnzahl = (groesse*groesse)/Main.sAnzahl;
    }

    public static int getSchiffsAnzahl() {
        return schiffsAnzahl;
    }

    public static void gridErstellen(int[][] grid) //Erstellung des Spielfelds
    {
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Zeile 1: Ausgabe der Spaltenbezeichnungen
            System.out.print("   " + i);
        }
        System.out.print("\n  "); //Zeilenumbruch
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Zwischenzeile(Border)
            System.out.print("----");
        }
        System.out.print('\n');
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Spaltenausgabe
            System.out.print(i + " |");//Spalte 1: Ausgabe der Zeilenbezeichnungen
            for (int j = 0; j <= Spielfeld.groesse-1; j++) {
                switch (grid[i][j])//Ausgabe der Spielzellen + Prüfung auf Status
                {
                    case 0:
                    case 1: System.out.print("   |");
                        break;
                    case 2: System.out.print(" 1 |");
                        break;
                    case 3: System.out.print(" 3 |");
                }
            }
            System.out.print("\n  ");
            for (int k = 0; k <= Spielfeld.groesse-1; k++) {
                System.out.print("----");
            }
            System.out.print('\n');
        }
    }
    public void schiffVersenken() //Methode zur Überprüfung des Feldstatus
    {
        int zeileR = IO.readInt("x"); //Einlesen der geratenden Zeile
        int spalteR = IO.readInt("y"); //Einlesen der geratenden Spalte
        if(this.werte[zeileR][spalteR] == 0) //Ins Leere getroffen
        {
            this.werte[zeileR][spalteR] = 3;
        }
        else if(this.werte[zeileR][spalteR] == 1) //Boot getroffen
        {
            this.werte[zeileR][spalteR] = 2;
            System.out.println("TREFFER");
            this.zwischenstand += 1; //Zwischenstand wird erhöht
        }
        else if(this.werte[zeileR][spalteR] == 2 ||this.werte[zeileR][spalteR] == 3) //Ein schonmal geratendes Feld wird erneut versucht
        {
            System.out.println("Hier wurde bereits hingeschossen!");
        }
        System.out.println("Spieler " + this.spielernummer +" hat " + this.zwischenstand + " von " + Spielfeld.gesamtpunkte + " Punkte."); //Zwischenergebnis
    }
    static void siegerAusgabe(int sp1Zwischen, int sp2Zwischen)
    {
        if(sp1Zwischen > sp2Zwischen)//Der Spieler mit mehr Punkten muss der Gewinner sein, da diese Methode erst nach dem Ende des Spiels benutzt wird.
        {
            System.out.println("Der Sieger ist Spieler 1");
        }
        else
        {
            System.out.println("Der Sieger ist Spieler 2");
        }
    }

    public void endGrid(int[][] grid) //Erstellung der Endgrids
    {
        System.out.println("Anordnung von Spieler " + this.spielernummer);
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Zeile 1: Ausgabe der Spaltenbezeichnungen
            System.out.print("   " + i);
        }
        System.out.print("\n  "); //Zeilenumbruch
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Zwischenzeile(Border)
            System.out.print("----");
        }
        System.out.print('\n');
        for (int i = 0; i <= Spielfeld.groesse-1; i++) { //Spaltenausgabe
            System.out.print(i + " |");//Spalte 1: Ausgabe der Zeilenbezeichnungen
            for (int j = 0; j <= Spielfeld.groesse-1; j++) {
                switch (grid[i][j])//Ausgabe der Spielzellen + Prüfung auf Status
                {
                    case 0: System.out.print("   |");
                        break;
                    case 1:
                    case 2: System.out.print(" 1 |");
                        break;
                    case 3: System.out.print("  |");
                }
            }
            System.out.print("\n  ");
            for (int k = 0; k <= Spielfeld.groesse-1; k++) {
                System.out.print("----");
            }
            System.out.print('\n');
        }
    }
}
