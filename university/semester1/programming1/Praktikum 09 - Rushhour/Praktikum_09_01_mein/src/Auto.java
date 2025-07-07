public class Auto {
    private int posx;
    private int posy;
    private final int laenge;
    private final char ausrichtung;
    private final String farbe;

    public Auto(int x, int y, int laenge, char ausrichtung, String farbe){
        this.posx = x;
        this.posy = y;
        this.laenge = laenge;
        this.ausrichtung = ausrichtung;
        this.farbe = farbe;
    }

    public void bewegen(int entfernung){
        boolean wegFrei = true;
        if(this.ausrichtung == 'h'){
            if(entfernung < 0){

            }
        }else{

        }
    }

    public int getPosx(){
        return this.posx;
    }

    public int getPosy(){
        return this.posy;
    }

}
