import java.util.Scanner;
/*
*   Dies ist das so genannte Slider-Spiel. Ziel des Spiels ist es, Zahlenplättchen von 1 bis 15 auf einem 4x4 Spielfeld zu ordnen.
*   Dafür lassen sich die Zahlenplättchen verschieben. Es lässt sich immer ein Zahlenplättchen auf das leere Feld verschieben.
*   Zum Schluss soll das leere Feld in der oberen, linken Ecke liegen und die Zahlen sollen in Reihen sortiert sein.
*   Die erste Zeile enthält dann das leere Feld und die Zahlen 1 bis 3. Die zweite Zeile enthält die Zahlen 4 bis 7 usw.
*/

public class Main {

//    Das Spielfeld. Das leere Feld hat den Wert 0. Die -1 bilden den Rand des Spielfelds, um eine out of bounds exception zu vermeiden.
    static int[][] spielfeldWerte =
        {   {-1,-1,-1,-1,-1,-1},
            {-1,11,12,13,14,-1},
            {-1,1,2,3,4,-1},
            {-1,8,7,6,5,-1},
            {-1,0,9,10,15,-1},
            {-1,-1,-1,-1,-1,-1}
        };

/*
// Nur zum Testen der Siegbedingung. Aktualisieren von positionNull nicht vergessen!
        static int[][] spielfeldWerte =
            {   {-1,-1,-1,-1,-1,-1},
                {-1,4,1,2,3,-1},
                {-1,0,5,6,7,-1},
                {-1,8,9,10,11,-1},
                {-1,12,13,14,15,-1},
                {-1,-1,-1,-1,-1,-1}
            };
*/

    static int eingabeZeile;
    static int eingabeSpalte;
    static int[] positionNull = {4,1};
    static boolean spielKorrekt = false;
    static boolean getauscht;

//    Solange die Siegbedingung spielKorrekt nicht erfüllt ist, werden das Spielfeld ausgegeben, die Spielereingaben gefordert, die Felder getauscht und das Spielfeld geprüft.
    public static void main(String[] args) {
        while(!spielKorrekt){
            spielfeldDrucken();
            eingabe();
            tauschen(eingabeZeile,eingabeSpalte);
            if(getauscht){
                spielKorrekt = spielfeldPruefen();
            }
        }
        System.out.println("Herzlichen Glückwunsch, Sie haben das Spiel gewonnen!");
    }

//    Prüft, ob das angegebene Feld benachbart zum leeren Feld liegt.
    static boolean istNachbar(int zeile, int spalte){
        return spielfeldWerte[zeile - 1][spalte] == 0 || spielfeldWerte[zeile + 1][spalte] == 0 || spielfeldWerte[zeile][spalte - 1] == 0 || spielfeldWerte[zeile][spalte + 1] == 0;
    }

//    Prüft, ob das angegebene Feld innerhalb des Spielfeldes liegt.
    static boolean imSpielfeld(int zeile, int spalte){
        return zeile >=1 && zeile <= 4 && spalte >= 1 && spalte <=4;
    }

//    Tauscht das angegebene Feld mit dem leeren Feld.
    static void tauschen(int zeile, int spalte){
        getauscht = false;
        if(istNachbar(zeile, spalte)){
            spielfeldWerte[positionNull[0]][positionNull[1]] = spielfeldWerte[zeile][spalte];
            spielfeldWerte[zeile][spalte] = 0;
            positionNull[0] = zeile;
            positionNull[1] = spalte;
            getauscht = true;
        }else{
            System.out.println("Bitte einen Nachbarn des Leeren Feldes angeben!");
        }
    }

//    Lässt den Spieler das zu verschiebende Feld angeben und prüft diese Eingabe auf Korrektheit.
    static void eingabe(){
        int zeile;
        int spalte;
        boolean korrekteEingabe = false;
        Scanner sc = new Scanner(System.in);
        while(!korrekteEingabe) {
            System.out.print("Welches Feld wollen Sie auf das Leere Feld schieben?\nGeben Sie die Zeile an:\t");
            zeile = sc.nextInt();
            System.out.print("Geben Sie die Spalte an:\t");
            spalte = sc.nextInt();
            if (imSpielfeld(zeile, spalte)) {
                eingabeZeile = zeile;
                eingabeSpalte = spalte;
                korrekteEingabe = true;
            } else {
                System.out.println("Dieses Feld befindet sich nicht im Spielfeld. Bitte geben Sie ein Feld zwischen 1,1 und 4,4 an.");
            }
        }
    }

//    Gibt das Spielfeld auf dem Bildschirm aus.
    static void spielfeldDrucken(){
        System.out.println("+--+--+--+--+");
        for(int i = 1; i <= 4; i++){
            System.out.print("|");
            for(int j = 1; j <= 4; j++){
                switch(spielfeldWerte[i][j]){
                    case 0:
                        System.out.print("  |");
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        System.out.print(spielfeldWerte[i][j] + "|");
                        break;
                    default:
                        System.out.print(" " + spielfeldWerte[i][j] + "|");
                }
            }
            System.out.println("\n+--+--+--+--+");
        }
    }

//    Prüft, ob das Spiel gelöst wurde.
    static boolean spielfeldPruefen(){
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                if(spielfeldWerte[i][j] != (i-1)*4+j-1){
                    return false;
                }
            }
        }
        return true;
    }
}