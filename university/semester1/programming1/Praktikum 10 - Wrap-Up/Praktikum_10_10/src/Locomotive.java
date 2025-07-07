/*
    A class for locomotives.
*/

public class Locomotive {

//    The length of the locomotive in metres.
    private final int length;
//    The type number of the locomotive.
    private final int type;
//    The first car behind the locomotive.
    private Car first;

//    Locomotive constructor
    public Locomotive(int length, int type){
        this.length = length;
        this.type = type;
    }

//    Getters and Setters
    public Car getFirst() {
        return this.first;
    }

    public void setFirst(Car first) {
        this.first = first;
    }

    public int getType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }
}