import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zahl = sc.nextInt();
        switch (zahl){
            case -1:
            case 0:
            case 1:
                System.out.println("nein");
                break;
            case 4:
                System.out.println("weiss nicht");
                break;
            case 5:
            case 6:
                System.out.println("ja");
                break;
            default:
                System.out.println("vielleicht");
                break;
        }
    }
}