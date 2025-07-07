public class Haendler {
    private double warenpreis;
    private int verkauft = 0;

    public Haendler(double preis){
        this.warenpreis = preis;
    }

    public void kaufen(int anzahl){
        this.verkauft = verkauft + anzahl;
    }

    public double liefereEinnahmen(){
        return verkauft * warenpreis;
    }
}