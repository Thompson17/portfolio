import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int runden = (5 + getRandomNumber(5));
        int fehler = 0;
        char ausgabe;
        char eingabe;
        long start;
        long ende;
        long zeit;
        long gesamt = 0;
        float schnitt;
        long min = getMaxLongNumber();
        long max = getMinLongNumber();
        Scanner sc = new Scanner(System.in);

        System.out.println("Achtung: Start");
        for(int i = 0; i < runden; i++){
            ausgabe = (char)(97 + getRandomNumber(25));
            wait((2 + getRandomNumber(3)));
            System.out.println(ausgabe);
            start = getMilliSeconds();
            eingabe = sc.next().charAt(0);
            ende = getMilliSeconds();
            if(eingabe == ausgabe){
                System.out.println("Richtig!");
                zeit = ende - start;
                gesamt = gesamt + zeit;
                if(zeit < min) min = zeit;
                if(zeit > max) max = zeit;
            }else{
                System.out.println("Fehler!");
                fehler++;
            }
        }
        schnitt = (float)gesamt / (float)(runden - fehler);
        System.out.println("Geschafft: Ende!");
        System.out.println("Fehlversuche: " + fehler + " von " + runden);
        System.out.println("Reaktionszeit-Mittelwert: " + (schnitt/1000.0) + " Sekunden");
        System.out.println("Langsamter Versuch: " + (max/1000.0) + " Sekunden");
        System.out.println("Schnellster Versuch: " + (min/1000.0) + " Sekunden");
    }

    // liefert eine Zahl, die die aktuelle Zeit in Millisek repräsentiert
    static long getMilliSeconds() {
        return new java.util.Date().getTime();
    }

    // liefert eine Zufallszahl zwischen 0 und max (einschließlich)
    static int getRandomNumber(int max) {
        return new java.util.Random().nextInt(max + 1);
    }

    // hält das Programm seconds Sekunden an
    static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception exc) {
        }
    }

    // liefert den größt-möglichen long-Wert
    static long getMaxLongNumber() {
        return Long.MAX_VALUE;
    }

    static long getMinLongNumber() {
        return Long.MIN_VALUE;
    }
}
