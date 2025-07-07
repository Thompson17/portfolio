/*
    A class for passenger cars.
*/

public class Car {

//    The length of the car in metres.
    private final int length;
//    The passenger capacity of the car.
    private final int capacity;
//    The car following this car.
    private Car next;

//    Car constructor
    public Car(int length, int capacity){
        this.length = length;
        this.capacity = capacity;
    }

//    Getters and Setters
    public Car getNext() {
        return this.next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    public int getLength() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}