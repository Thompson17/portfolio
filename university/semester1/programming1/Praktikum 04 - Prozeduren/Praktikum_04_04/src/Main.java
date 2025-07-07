import java.util.Scanner;

public class Main {

    static int loesung;

    public static void main(String[] args) {
        int punkte = 0;
        System.out.println("Start des Mathetrainers");
        while (punkte < 10) {
            if(frageBearbeiten()){
                punkte++;
            }else{
                System.out.println("Leider falsch! Korrektes Ergebnis ist " + loesung);
            }
            System.out.println("Richtig!\nKorrekte Antworten: " + punkte);
        }
        System.out.println("Ende des Mathetrainers");
    }

        static boolean frageBearbeiten(){
            Scanner scan = new Scanner(System.in);
            int a = generiereZahl();
            int b = generiereZahl();
            char operator;
            if(b != 0){
                operator = generiereOperator();
            }else{
                operator = '*';
            }
            if(operator == '*'){
                loesung = a * b;
            }else{
                loesung = a / b;
            }
            System.out.print(a + " " + operator + " " + b + " = ");
            int eingabe = scan.nextInt();
            return eingabe == loesung;
        }

        static int generiereZahl(){
            return new java.util.Random().nextInt(9 + 1);
        }

        static char generiereOperator(){
            int operator = new java.util.Random().nextInt(1 + 1);
            if(operator == 1){
                return '/';
            }
            return '*';
        }
}