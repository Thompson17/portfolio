public class Ant {
    private int posX = 100;
    private int posY = 100;
    private int ausrichtung = 0;
    public Ant(){
    }
    public void drehenSchwarz(){
        if (this.ausrichtung == 360){
            this.ausrichtung = 90;
        }
        else{
            this.ausrichtung += 90;
        }
    }
    public void drehenWeiß(){
        if (this.ausrichtung == 0){
            this.ausrichtung = 270;
        }
        else{
            this.ausrichtung -= 90;
        }
    }
    public void gehen(int ausrichtung){ //geht in die ausgerichtete Richtung, wenn die Ameise am Rand ist, wird sie an den gegenüberliegenden Rand gesetzt
        if(ausrichtung == 0){
            if(this.posY != World.getSize()-1) {
                this.posY = this.posY + 1;
            }
            else this.posY = 0;
        }
        else if(ausrichtung == 90){
            if(this.posX != World.getSize()-1) {
                this.posX = this.posX + 1;
            }
            else this.posX = 0;
        }
        else if(ausrichtung == 180){
            if(this.posY != 0) {
                this.posY = this.posY - 1;
            }
            else this.posY = World.getSize()-1;
        }
        else if(ausrichtung == 270){
            if(this.posX != 0) {
                this.posX = posX - 1;
            }
            else this.posX = World.getSize()-1;
        }
        else{
            if(this.posY != World.getSize()-1) {
                this.posY = this.posY + 1;
            }
            else this.posY = 0;
        }
    }
    public void nextStep(){
        World.createWorld();
            if ((World.getFarbeWorld(this.posX, this.posY)) == 1) {
                World.setFarbeWorld(this.posX, this.posY, 0);
                drehenWeiß();
                gehen(this.ausrichtung);
            } else {
                World.setFarbeWorld(this.posX, this.posY, 1);
                drehenSchwarz();
                gehen(this.ausrichtung);
            }

    }
}
