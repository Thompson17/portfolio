package Aufgabe1;

public class main {
    public static void main(String[] args) {
        RundFunkEmpfangsGeraet l = new RundFunkEmpfangsGeraet();
        Radio r = new Radio();
        Fernseher f = new Fernseher();

        f.an();
        r.an();
        f.waehleKanal(2);
        r.waehleSender(100.5);
        l.an();
        l.volume(-5);
        System.out.println(l.toString());
        System.out.println(r.toString());
        System.out.println(f.toString());
    }
}
