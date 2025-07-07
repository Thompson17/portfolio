public class Main {

    static Auto auto1 = new Auto(3, 2, 2, 'h', "rot");
    static Auto auto2 = new Auto(0, 0, 3, 'v', "gelb");
    static Auto auto3 = new Auto(1, 0, 2, 'h',"hellgrün");
    static Auto auto4 = new Auto(4, 0, 2, 'v',"orange");
    static Auto auto5 = new Auto(1, 1, 2, 'v',"hellblau");
    static Auto auto6 = new Auto(2, 1, 2, 'v',"rosa");
    static Auto auto7 = new Auto(5, 1, 3, 'v',"flieder");
    static Auto auto8 = new Auto(0, 3, 3, 'h',"dunkelblau");
    static Auto auto9 = new Auto(3, 3, 2, 'v',"violett");
    static Auto auto10 = new Auto(2, 4, 2, 'v',"dunkelgrün");
    static Auto auto11 = new Auto(4, 4, 2, 'h',"schwarz");
    static Auto auto12 = new Auto(0, 5, 2, 'h',"braun");
    static Auto auto13 = new Auto(3, 5, 2, 'h',"grüngelb");

    private boolean rotAmRechtenRand = false;

    public static void main(String[] args){
        Spielfeld spiel = new Spielfeld();
        spiel.ausgabe();
    }


    private boolean geloest(){
        if(auto1.getPosx() == 4){
            rotAmRechtenRand = true;
        }
        return rotAmRechtenRand;
    }
}
