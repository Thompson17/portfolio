package Aufgabe7;

import Aufgabe6.IO;

import java.util.Objects;

public class Konto implements Cloneable {
    private int kontostand;
    private int kreditrahmen;

    public Konto() {
        this.kontostand = 0;
        this.kreditrahmen = 0;
    }

    public Konto(int Geld, int Credit) {
        this.kontostand = Geld;
        this.kreditrahmen = Credit;
    }

    public Object clone() throws CloneNotSupportedException {        //Objekt wird neu zurückgegeben, aber nicht die Adresse
        return new Konto(this);
    }

    public Konto(Konto konto) {
        if (konto == null) {
            new Konto();
        } else {
            this.kontostand = konto.getKontostand();
            this.kreditrahmen = konto.kreditrahmen;
        }
    }

    public int getKontostand() {
        return this.kontostand;
    }

    public int getKreditrahmen() {
        return this.kreditrahmen;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Konto konto = (Konto) o;
//        return kontostand == konto.kontostand && kreditrahmen == konto.kreditrahmen;
//    }

    public boolean istGleich(Konto s) {
        if (s == null) {
            return false;
        }
        if (this.kontostand == s.kontostand) {
            return true;
        } else {
            return false;
        }
    }

    public String kontostandAktuell() {
        return Integer.toString(kontostand);
    }

    public void einzahlen(int cash) {
        if (cash <= 0) {
            return;
        }
        if (this.kontostand + cash > 10000) {
            kreditrahmen = 3000;
        }
        kontostand += cash;
    }

    public int auszahlen(int cash) {
        if (cash < 0) {
            return 0;
        }
        if (kontostand + kreditrahmen < cash) {
            return 0;
        }

        kontostand -= cash;

        return kontostand;
    }

    public void ueberweisung(Konto empfaenger, int betrag) {
        if (this.getKontostand() > betrag) {
            this.kontostand -= betrag;
            empfaenger.kontostand += betrag;
        } else {
            System.out.println("Sie haben nicht genug Kapital um diese Überweisung durchzuführen");
        }
    }
}
