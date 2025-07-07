import java.util.concurrent.ThreadLocalRandom;

public class Zahlenanalyse {

    public static boolean istTeilerVon(int n, int z){
        if(n == 0){
            return false;
        }
        return z % n == 0;
    }

    public static void alleTeilerVon(int n){
        if(n >= 1) {
            System.out.println("Die Teiler von " + n + " sind:");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) System.out.println(i);
            }
        }
    }

    public static void groeesterGemeinsamerTeiler(int a, int b){
        int ggt = 0;
        if(a >= 1 && b >=1){
            if(a <= b){
                for(int i = 1; i <= a; i++){
                    if(a % i == 0 && b % i == 0){
                        ggt = i;
                    }
                }
            }
            else{
                for(int i = 1; i <= b; i++){
                    if(a % i == 0 && b % i == 0){
                        ggt = i;
                    }
                }
            }
        }
        System.out.println("Der größte gemeinsame Teiler von " + a + " und " + b + " ist: " + ggt);
    }

    public static void statistiken(){
        double current;
        double min;
        double max;
        double total;
        double avg;
        double n = 1.0;
        do{
            current = IO.readDouble("Geben Sie einen Wert ein: ");
            if(current < -100.0 || current > 100.0){
                IO.println("Die Zahl muss zwischen -100.0 und 100.0 liegen");
            }else if(current == -1.0){
                return;
            }
        }while(current < -100.0 || current > 100.0);
        min = current;
        max = current;
        total = current;
        avg = current;
        IO.println("Minimum: " + min + "  Maximum: " + max + "  Schnitt: " + avg);
        while(current != -1.0){
            current = IO.readDouble("Geben Sie einen Wert ein: ");
            if(current < -100.0 || current > 100.0) {
                IO.println("Die Zahl muss zwischen -100.0 und 100.0 liegen");
            }else if(current == -1.0){
                return;
            }else{
                if(current < min){
                    min = current;
                }
                if(current > max){
                    max = current;
                }
                total = total + current;
                n = n + 1.0;
                avg = total / n;
                IO.println("Minimum: " + min + "  Maximum: " + max + "  Schnitt: " + avg);
            }
        }
    }

    public static void zahlenRaten(){
        int loesung = ThreadLocalRandom.current().nextInt(1,101);
        int versuch = 0;
        int antwort;
        do{
            versuch ++;
            antwort = IO.readInt(versuch + ". Versuch: Zahl raten: ");
            if(antwort < loesung){
                IO.println("zu tief");
            }else if(antwort > loesung){
                IO.println("zu hoch");
            }else{
                IO.println("Bravo, getroffen");
            }
        }while (antwort != loesung);
    }
}