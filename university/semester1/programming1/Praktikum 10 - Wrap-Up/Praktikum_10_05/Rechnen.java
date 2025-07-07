package Aufgabe5;

public class Rechnen {

    private int a;

    public Rechnen(){

    }

    protected int addieren(int a, int b){
        return this.a = a + b;
    }
    protected int subtrahieren(int a, int b){
        return this.a = a - b;
    }


    protected int multiplizieren(int a, int b){
        return this.a = a * b;
    }
    protected int dividieren(int a, int b){
        if((a * b) > 0){
            return this.a = a / b;
        }
        else{
            System.out.println("Dividieren durch Null ist nicht möglich!");
            return 0;
        }
    }
    protected int modulo(int a, int b){
        if((a * b) > 0){
            return this.a = a % b;
        }
        else{
            System.out.println("Modulo durch Null ist nicht möglich!");
            return 0;
        }
    }
}
