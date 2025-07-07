/*
    A program for handling trains and their respective locomotives and cars.
*/

public class Main {

    public static void main(String[] args){

//        Creating a locomotive "Big Chief" with no. 5311 and length 23m.
        Locomotive bigChief = new Locomotive(23, 5311);

//        Creating a train "Santa Fe" with locomotive "Big Chief"
        Train santaFe = new Train(bigChief);

//        Adding three cars to "Santa Fe" with the lengths 12m, 15m, 20m and the capacities 50, 75, 100 pax.
        Car car1 = new Car(12, 50);
        Car car2 = new Car(15, 75);
        Car car3 = new Car(20, 100);
        santaFe.add(car3);
        santaFe.add(car2);
        santaFe.add(car1);
        System.out.print("\nSanta Fe:");
        santaFe.print();

//        Creating a locomotive "Steel Horse" with no. 5409 and length 21m.
        Locomotive steelHorse = new Locomotive(21, 5409);

//        Creating a train "Rio Grande Express" with locomotive "Steel Horse".
        Train rioGrandeExpress = new Train(steelHorse);

//        Adding two cars to "Rio Grande Express" with the lengths 13m, 18m and the capacities 60, 80 pax.
        Car car4 = new Car(13, 60);
        Car car5 = new Car(18, 80);
        rioGrandeExpress.add(car5);
        rioGrandeExpress.add(car4);
        System.out.print("\nRio Grande Express:");
        rioGrandeExpress.print();

//        Relinking all cars from "Santa Fe" to "Rio Grande Express".
        rioGrandeExpress.relink(santaFe);
        System.out.print("\nSanta Fe after relink:");
        santaFe.print();
        System.out.print("\nRio Grande Express after relink:");
        rioGrandeExpress.print();

//        Reverting the order of cars in "Rio Grande Express".
        rioGrandeExpress.revert();
        System.out.print("\nRio Grande Express after revert:");
        rioGrandeExpress.print();

    }
}
