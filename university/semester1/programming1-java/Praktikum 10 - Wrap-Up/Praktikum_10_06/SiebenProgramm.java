package Aufgabe6;

public class SiebenProgramm extends SiebenSpieler {

    public SiebenProgramm(){
        super("Paul");
    }
    @Override
    public int naechsteZahl(int vorherigeZahl) {
        int aktuelleZahl = vorherigeZahl;
        boolean isRightNumber = false;
        while (isRightNumber != true) {
            aktuelleZahl++;
            int temp = 0;
            int tempAktu = aktuelleZahl;
            //Integer.toString(aktuelleZahl).contains("7");
            for (int i = 0; i <= Integer.toString(aktuelleZahl).length(); i++) {
                temp = tempAktu % 10;
                tempAktu = tempAktu / 10;
                if (temp == 7 || (aktuelleZahl % 7) == 0) {
                    isRightNumber = false;
                    break;

                } else {
                    isRightNumber = true;
                }
            }

        }
        return aktuelleZahl;
    }
}
