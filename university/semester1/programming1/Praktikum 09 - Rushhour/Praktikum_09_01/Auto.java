public class Auto {

    private int carSize;
    private int posx;
    private int posy;
    private int name;

    public Auto(int carSize, int posx, int posy, int name){
        this.name = name;
        this.carSize = carSize;
        this.posx = posx;
        this.posy = posy;

    }
    public Auto(Auto autox){
        this.name = autox.name;
        this.carSize = autox.carSize;
        this.posx = autox.posx;
        this.posy = autox.posy;
    }
    public int getName(){
        return this.name;
    }
    public int getCarSize(){
        return this.carSize;
    }
    public int getPosx(){
        return this.posx;
    }

    public int getPosy() {
        return posy;
    }
}
