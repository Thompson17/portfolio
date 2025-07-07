import java.util.Random;

public class Spielfeld {
    private int[][] spielflaeche = {{0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};

    public Spielfeld() {
    }

    public void ausgabeSpielfeld() {
        System.out.println("+---+---+---+---+---+---+");
        for (int y = 0; y < spielflaeche.length; y++) {
            for (int x = 0; x < spielflaeche[y].length; x++) {
                if (spielflaeche[y][x] == 0) {
                    System.out.print("|   ");
                } else {
                    System.out.print("| " + spielflaeche[y][x] + " ");
                }

            }
            System.out.print("|");
            System.out.print("\n+---+---+---+---+---+---+");
            System.out.println();

        }
    }

    public void autoPlatzieren(Auto auto) {
        if (auto.getName() % 2 == 0) {
            for (int i = 0; i < auto.getCarSize(); i++) {
                spielflaeche[auto.getPosy() + i][auto.getPosx()] = new Auto(auto).getName();
            }
        } else {
            for (int i = 0; i < auto.getCarSize(); i++) {
                spielflaeche[auto.getPosy()][auto.getPosx() + i] = new Auto(auto).getName();
            }
        }
    }

    public boolean isThereCarLeft(int posy, int posx) {
        if (spielflaeche[posy][posx - 1] == 0) {
            return true;
        } else {
            System.out.println("Verursachen Sie bitte keinen Unfall!");
            return false;
        }
    }

    public boolean isThereCarRight(int posy, int posx) {
        if (spielflaeche[posy][posx + 2] == 0) {
            return true;
        } else {
            System.out.println("Verursachen Sie bitte keinen Unfall!");
            return false;
        }
    }

    public boolean isThereCarTop(int posy, int posx) {
        if (spielflaeche[posy - 1][posx] == 0) {
            return true;
        } else {
            System.out.println("Verursachen Sie bitte keinen Unfall!");
            return false;
        }
    }

    public boolean isThereCarBottom(int posy, int posx) {
        if (spielflaeche[posy + 2][posx] == 0) {
            return true;
        } else {
            System.out.println("Verursachen Sie bitte keinen Unfall!");
            return false;
        }
    }

    public void findCar() {
        int suche = IO.readInt("Welches Auto wollen Sie bewegen?");
        int posy;
        int posx;
        if (1 <= suche && suche <= 9) {
            for (int y = 0; y < spielflaeche.length; y++) {
                for (int x = 0; x < spielflaeche[y].length; x++) {
                    if (spielflaeche[y][x] == suche) {
                        posy = y;
                        posx = x;
                        moveCar(posy, posx, suche);
                        ausgabeSpielfeld();
                        return;
                    }
                }
            }
        } else {
            System.out.println("Bitte ein Auto im Spielfeld eingeben!");
        }

    }

    public void moveCar(int posy, int posx, int suche) {
        char bewegen = IO.readChar("Wohin wollen Sie das Auto bewegen? (r = rechts; l = links; o = oben; u = unten)");
        switch (bewegen) {
            case 'r':
                if (!isVertical(suche) && isThereCarRight(posy, posx)) {
                    try {
                        spielflaeche[posy][posx + 2] = suche;
                        spielflaeche[posy][posx] = 0;
                        break;
                    } catch (Exception e) {
                        System.out.println("Hören Sie auf gegen Wände zu fahren!");
                        break;
                    }


                } else {
                    System.out.println("Dieses Auto kann leider nur nach oben oder unten verschoben werden!");
                    findCar();
                    break;
                }
            case 'l':
                if (!isVertical(suche) && isThereCarLeft(posy, posx)) {
                    try {
                        spielflaeche[posy][posx - 1] = suche;
                        spielflaeche[posy][posx + 1] = 0;
                        break;
                    } catch (Exception e) {
                        System.out.println("Hören Sie auf gegen Wände zu fahren!");
                        break;
                    }
                } else {
                    System.out.println("Dieses Auto kann leider nur nach oben oder unten verschoben werden!");
                    findCar();
                    break;
                }
            case 'o':
                if (isVertical(suche) && isThereCarTop(posy, posx)) {
                    try {
                        spielflaeche[posy - 1][posx] = suche;
                        spielflaeche[posy + 1][posx] = 0;
                        break;
                    } catch (Exception e) {
                        System.out.println("Hören Sie auf gegen Wände zu fahren!");
                        break;
                    }

                } else {
                    System.out.println("Dieses Auto kann leider nur nach rechts und links verschoben werden!");
                    findCar();
                    break;
                }
            case 'u':
                if (isVertical(suche) && isThereCarBottom(posy, posx)) {
                    try {
                        spielflaeche[posy + 2][posx] = suche;
                        spielflaeche[posy][posx] = 0;
                        break;
                    } catch (Exception e) {
                        System.out.println("Hören Sie auf gegen Wände zu fahren!");
                        break;
                    }
                } else {
                    System.out.println("Dieses Auto kann leider nur nach rechts und links verschoben werden!");
                    findCar();
                    break;
                }

            default:
                System.out.println("Bitte l r u o eingeben!");
                break;
        }
    }


    public boolean gewonnen() {
        boolean win = false;
        int posy = 0;
        int posx = 0;
        for (int y = 0; y < spielflaeche.length; y++) {
            for (int x = 0; x < spielflaeche[y].length; x++) {
                if (spielflaeche[y][x] == 9) {
                    posy = y;
                    posx = x;
                }
            }
        }
        if (spielflaeche[posy][posx] == spielflaeche[1][0] || spielflaeche[posy][posx] == spielflaeche[1][5]) {
            return win = true;
        }
        return win = false;
    }

    public boolean isVertical(int suche) {
        if (suche % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
