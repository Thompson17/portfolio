public class Spielfeld {

    private int[][] feld = {{2,3,3,0,4,0},
                            {2,5,6,0,4,7},
                            {2,5,6,1,1,7},
                            {8,8,8,9,0,7},
                            {0,0,10,9,11,11},
                            {12,12,10,13,13,0}};

    public Spielfeld(){

    }

    public void ausgabe(){
        System.out.print("+--+--+--+--+--+--+");
        for(int y = 0; y < feld.length; y++){
            System.out.print("\n|");
            for(int x = 0; x < feld[0].length; x++){
                switch(feld[y][x]){
                    case 0:
                        System.out.print("  |");
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        System.out.print(feld[y][x] + "|");
                        break;
                    default:
                        System.out.print(" " + feld[y][x] + "|");
                        break;
                }
            }
            System.out.print("\n+--+--+--+--+--+--+");
        }
    }

    public int[][] getFeld(){
        return this.feld;
    }
}
