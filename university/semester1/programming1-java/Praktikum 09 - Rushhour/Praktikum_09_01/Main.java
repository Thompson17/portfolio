public class Main {


    public static void main(String[] args){
        Spielfeld game = new Spielfeld();
        game.autoPlatzieren(new Auto(2,0,1, 2));
        game.autoPlatzieren(new Auto(2,1,3, 3));
        game.autoPlatzieren(new Auto(2,4,4, 4));
        game.autoPlatzieren(new Auto(2,2,4, 5));
        game.autoPlatzieren(new Auto(2,3,1, 9));
        game.ausgabeSpielfeld();
        while (!game.gewonnen()){
            game.findCar();
        }
        if(game.gewonnen()){
            System.out.println("Sie haben gewonnen, Glückwunsch!");
        }

    }
}
