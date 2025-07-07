package Aufgabe5;

public class TaschenrechnerTest {
    public static void main(String[] args) {

        Rechnen r = new Rechnen();

        System.out.println(r.addieren(10,5));
        System.out.println(r.subtrahieren(10,5));
        System.out.println(r.multiplizieren(10,5));
        System.out.println(r.dividieren(10,0));
        System.out.println(r.modulo(10,0));
    }
}
