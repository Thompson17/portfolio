public class Main {

    public static void main(String[] args) {
        int preis = 0;
        int anzahl = IO.readShort("Anzahl Downloads (>=0): ");
        if(anzahl > 5){
            anzahl = anzahl - 5;
            if(anzahl >= 30){
                anzahl = anzahl - 30;
                preis = 30 * 20 + anzahl * 15;

            }else{
                preis = anzahl * 20;
            }
        }
        System.out.printf("Gebuehren = %.2f EURO", preis/100.0);
    }
}
