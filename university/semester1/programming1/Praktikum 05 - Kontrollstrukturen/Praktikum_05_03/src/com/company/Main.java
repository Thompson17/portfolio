package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Bitte geben Sie die Länge des pascalschen Dreiecks ein: ");
        int l = s.nextInt();
        s.close();
        pascalschesDreieck(l);
        /*System.out.println("Bitte geben Sie eine Zahl für n und k ein:");
        int n = s.nextInt();
        int k = s.nextInt();
        s.close();
        System.out.println(binomialk(n, k));*/
    }

    public static int binomialk(int n, int k)
    {
        int nF = 1; // Variable n Fakultät
        int kF = 1;
        int nkF = 1;
        for(int i = 1; i < n; i++) //Berechnung von Fakultät n
        {
            nF *= i;
        }
        for(int i = 1; i < k; i++)
        {
            kF *= i;
        }
        for(int i = 1; i < (n - k); i++)
        {
            nkF *= i;
        }
        return nF/(kF*nkF);
    }

    public static void pascalschesDreieck(int laenge)
    {
        int n = 0;
        int k = 0;
        for(int i = 0; i < laenge; i++) //Berechnung einer Zeile
        {
            for(int o = 0; o < laenge-n; o++)System.out.print(" "); // Leerstellen vor dem Dreieck werden erzeugt
            for(int j = 0; j < n + 1; j++) //Berechnung einzelner Binomialkoeffizienten in einer Zeile
            {
                System.out.print(binomialk(n, k) + " ");
                k++;
            }
            n++; //n bestimmt die Zeile
            k = 0; //k wird auf 0 gesetzt, da k in jeder neuen Zeile wieder 0 wird
            System.out.print("\n"); //Zeilenumbruch
        }
    }
}