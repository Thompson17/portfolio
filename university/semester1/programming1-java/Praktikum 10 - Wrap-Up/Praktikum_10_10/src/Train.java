/*
    A class for Trains. A train consists of exactly one locomotive and any number of cars.
*/


public class Train {

//    The train's locomotive.
    private final Locomotive locomotive;

//    Train constructor
    public Train (Locomotive locomotive){
        this.locomotive = locomotive;
    }

//    Adds a car in the first position after the locomotive.
    public void add(Car newCar){
        Car oldFirst = this.locomotive.getFirst();
        this.locomotive.setFirst(newCar);
        newCar.setNext(oldFirst);
    }

//    Displays a detailed list of the train's locomotive and cars.
    public void print() {
        System.out.println("\nThis train contains:");
        System.out.println("Locomotive:\tType: " + this.locomotive.getType() + "\tLength: " + this.locomotive.getLength() + "m");
        Car car1 = this.locomotive.getFirst();
        if (car1 != null) {
            System.out.println("Car 1:\tCapacity: " + car1.getCapacity() + "\tLength: " + car1.getLength() + "m");
            Car current = car1.getNext();
            int number = 2;
            while (current != null) {
               System.out.println("Car " + number + ":\tCapacity: " + current.getCapacity() + "\tLength: " + current.getLength() + "m");
               number++;
               current = current.getNext();
            }
        }
        System.out.println("Total:\tCapacity: " + this.getPassengers() + "\tLength: " + this.getLength() + "m");
    }

//    Returns the total passenger capacity.
    public int getPassengers(){
        int totalCapacity = 0;
        if (this.locomotive.getFirst() != null) {
            Car car1 = this.locomotive.getFirst();
            totalCapacity = car1.getCapacity();
            Car current = car1.getNext();
            while (current != null) {
                totalCapacity = totalCapacity + current.getCapacity();
                current = current.getNext();
            }
        }
        return totalCapacity;
    }

//    Returns the total train length.
    public int getLength(){
        int totalLength = this.locomotive.getLength();
        if (this.locomotive.getFirst() != null) {
            Car car1 = this.locomotive.getFirst();
            totalLength = totalLength + car1.getLength();
            Car current = car1.getNext();
            while (current != null) {
                totalLength = totalLength + current.getLength();
                current = current.getNext();
            }
        }
        return totalLength;
    }

//    Removes the car in the first position behind the locomotive.
    public Car removeFirst(){
        if(this.locomotive.getFirst() == null){
            return null;
        }
        Car first = this.locomotive.getFirst();
        Car second = first.getNext();
        this.locomotive.setFirst(second);
        first.setNext(null);
        return first;
    }

//    Re-links all cars from oldTrain to this train. The order of cars stays the same.
    public void relink(Train oldTrain){
        if(oldTrain == null){
            System.out.println("The train doesn't exist!");
        }else {
            Locomotive oldLoco = oldTrain.getLocomotive();
            Car oldFirst = oldLoco.getFirst();
            oldLoco.setFirst(null);
            if (this.locomotive.getFirst() == null) {
                this.locomotive.setFirst(oldFirst);
            } else {
                Car lastCar = this.locomotive.getFirst();
                while (lastCar.getNext() != null) {
                    lastCar = lastCar.getNext();
                }
                lastCar.setNext(oldFirst);
            }
        }
    }

//    Reverts the order of all cars in this train.
    public void revert(){
        if(this.locomotive.getFirst() == null){
            System.out.println("This train has no cars to revert.");
        }else{
            Train temp = new Train(new Locomotive(0, 0));
            while (this.locomotive.getFirst() != null) {
                temp.add(this.removeFirst());
            }
            this.relink(temp);
        }
    }

//    Returns this train's locomotive.
    public Locomotive getLocomotive() {
        return this.locomotive;
    }
}