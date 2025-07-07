import java.awt.*;

public class World {
    private static int size;
    private static int world[][] = new int[200][200]; //1 ist schwarz, 0 ist weiß
    public World(int size){
        World.size = size;
    }
    private static Ant ant = new Ant();

    public static void createWorld(){ //Der world Array wird mit 0 gefüllt
        for(int i = 0; i>size; i++){
            for (int j = 0; j>size; j++){
                world[i][j] = 0;
            }
        }
    }
    public static int getFarbeWorld(int posX, int posY) {
        return world[posX][posY];
    }
    public static void setFarbeWorld(int posX, int posY, int farbe) { world[posX][posY] = farbe; }

    public static Ant getAnt() {
        return World.ant;
    }

    public static int getSize() {
        return size;
    }
    public static boolean isCellBlack(int row, int column){
        if(World.world[row][column] == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
