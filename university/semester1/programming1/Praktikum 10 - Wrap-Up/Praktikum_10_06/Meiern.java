package Aufgabe6;

public class Meiern {
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "a";
        args[1] = "b";
        // ueber die Argumente werden die Spielernamen uebergeben
        if (args.length < 2) {
            IO.println("Bitte mindestens zwei Spielernamen uebergeben");
            return;
        }
        // Spieler erzeugen
        SiebenSpieler[] spieler = new SiebenSpieler[args.length+1];
        for (int i = 0; i < args.length; i++) {
            spieler[i] = new SiebenSpieler(args[i]);
        }
        spieler[spieler.length-1] = new SiebenProgramm();
        // Spiel durchfuehren
        spielen(spieler);
    }

    // Durchfuehrung eines kompletten Spiels mit den
// uebergebenen Spielern
    public static void spielen(SiebenSpieler[] spieler) {
        int anzahlAusgeschieden = 0;
        int zahl = 0; // begonnen wird mit der Zahl 0
        hauptschleife:
        while (zahl < 10000) {
            // ab 10000 wird noch eine Runde gespielt
            // alle Spieler kommen nacheinander an die Reihe
            for (int i = 0; i < spieler.length; i++) {
                if (!spieler[i].istAusgeschieden()) {
                    int ergebnis = spieler[i].naechsteZahl(zahl);
                    if (!check(zahl, ergebnis)) {
                        spieler[i].ausscheiden();
                        IO.println("Falsch! " + spieler[i]
                                + " ist ausgeschieden!");
                        anzahlAusgeschieden++;
                        if (anzahlAusgeschieden ==
                                spieler.length - 1) {
                            // alle bis auf einen Spieler sind
//                            ausgeschieden
                            break hauptschleife; // Spiel
//                            zuende
                        }
                    } else { // eingegebene Zahl war korrekt
                        zahl = ergebnis; // zahl hochsetzen
                    }
                }
            }
        }
        gibSiegerBekannt(spieler);
    }

    // Bekanntgabe der/des Siegers (wer nicht ausgeschieden ist)
    public static void gibSiegerBekannt(SiebenSpieler[] spieler) {
        for (int i = 0; i < spieler.length; i++) {
            if (!spieler[i].istAusgeschieden()) {
                IO.println(spieler[i] + " ist Sieger!");
            }
        }
    }

    /**
     * Ueberpruefung eines Spielzugs
     *
     * @param aktuelleZahl   die aktuelle Zahl des Spiels
     * @param gelieferteZahl die vom Spieler angegebene Zahl
     * @return genau dann true, wenn gelieferteZahl die naechst hoehere
     * Zahl
     * nach aktuelleZahl ist, die keine Ziffer 7 enthaelt und
     * nicht
     * durch 7 teilbar ist
     */
    public static boolean check(int aktuelleZahl, int gelieferteZahl) {
        boolean isRightNumber = false;
        while (isRightNumber != true){
            aktuelleZahl++;
            int temp = 0;
            int tempAktu = aktuelleZahl;
            //Integer.toString(aktuelleZahl).contains("7");
            for (int i = 0; i <= Integer.toString(aktuelleZahl).length(); i++) {
                temp = tempAktu % 10;
                tempAktu = tempAktu / 10;
                if (temp == 7 || (aktuelleZahl % 7) == 0) {
                    isRightNumber =false;
                    break;

                }
                else {
                    isRightNumber = true;
                }
            }

        }
        if (gelieferteZahl == aktuelleZahl) {
            return true;
        }
        return false;
    }


}


