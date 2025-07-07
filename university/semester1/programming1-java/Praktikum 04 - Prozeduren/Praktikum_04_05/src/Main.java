import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int punkteSpieler = 0;
    static int punkteComputer = 0;
    static int handSpieler;
    static int handComputer;
    static String[] nameHand = {"Schere", "Stein", "Papier", "Echse", "Spock"};
    //Sieger: 0 = Unentschieden, 1 = Spieler, 2 = Computer
    static int[][] siegerMatrix = {
            {0,2,1,1,2},
            {1,0,2,1,2},
            {2,1,0,2,1},
            {2,2,1,0,1},
            {1,1,2,2,0}
    };
    public static void auswahlSpieler(){
        handSpieler = -1;
        while(handSpieler < 0 || handSpieler > 4){
            IO.println("0 = Schere, 1 = Stein, 2 = Papier, 3 = Echse, 4 = Spock");
            handSpieler = IO.readInt("Wähle deine Hand: ");
            if(handSpieler < 0 || handSpieler > 4){
                IO.println("Falsche Eingabe!");
            }
        }
    }
    public static void auswahlComputer(){
        handComputer = ThreadLocalRandom.current().nextInt(0,5);
    }
    public static void siegerRunde(){
        IO.println("Hand Spieler: " + nameHand[handSpieler]);
        IO.println("Hand Computer: " + nameHand[handComputer]);
        switch (siegerMatrix[handSpieler][handComputer]){
            case 0:
                IO.println("Unentschieden!");
                break;
            case 1:
                IO.println("Spieler gewinnt!");
                break;
            case 2:
                IO.println("Computer gewinnt!");
                break;
            default:
                IO.println("Fehlerhafte Eingabe");
                break;
        }
    }
    public static void spielstand(){
        switch (siegerMatrix[handSpieler][handComputer]){
            case 1:
                punkteSpieler++;
                break;
            case 2:
                punkteComputer++;
                break;
            default:
                break;
        }
        IO.println("Aktueller Spielstand:\nSpieler: " + punkteSpieler + "\nComputer: " + punkteComputer + "\n");
    }
    public static void siegerSpiel(){
        if(punkteSpieler == 10){
            IO.println("Herzlichen Glückwunsch, Du hast das Spiel gewonnen!");
        }else{
            IO.println("Vorbei! Leider hat der Computer gewonnen.");
        }
    }

    public static void main(String[] args) {
        while(punkteSpieler < 10 && punkteComputer < 10){
            auswahlSpieler();
            auswahlComputer();
            siegerRunde();
            spielstand();
        }
        siegerSpiel();
    }
}