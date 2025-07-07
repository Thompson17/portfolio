package Aufgabe7;

public class KontoTest {

    public static void main(String[] args) {
        Konto fritz = new Konto(2000,1500);
        Konto f = new Konto(2000, 3000);

        Konto l = new Konto(f);

        System.out.println("Kontostand: "+ l.getKontostand());
        System.out.println("Kontostand: "+f.getKontostand());
        System.out.println("Kontostand: "+fritz.getKontostand());
        System.out.println(f.istGleich(fritz));

        System.out.println("Kontostand: "+fritz.kontostandAktuell());
        System.out.println("Kreditrahmen: "+fritz.getKreditrahmen());

        fritz.einzahlen(9000);

        System.out.println("Kontostand: "+fritz.kontostandAktuell());
        System.out.println("Kreditrahmen: "+fritz.getKreditrahmen());

        fritz.auszahlen(7000);
        System.out.println("Kontostand: "+fritz.kontostandAktuell());
        System.out.println("Kontostand: " +fritz.getKontostand());

        f.ueberweisung(fritz,1500);
        System.out.println("Kontostand: "+fritz.getKontostand());

    }
}
