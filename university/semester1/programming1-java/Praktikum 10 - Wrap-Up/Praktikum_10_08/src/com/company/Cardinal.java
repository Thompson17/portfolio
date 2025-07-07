package com.company;


public class Cardinal {
    public int wert;
    public Cardinal(int wert){
        this.wert = wert;
    }
    public Cardinal(Cardinal c){
        this.wert = c.wert;
    }
    public Cardinal clone(){
        Cardinal c = new Cardinal(this.wert);
        return c;
    }
    public boolean equals(Cardinal c){
        if(this.wert == c.wert)return true;
        else return false;
    }
    public String toString(){
        return "Der Kardinalswert beträgt "+this.wert;
    }
    public static int sub(Cardinal c1, Cardinal c2){
        return c1.wert - c2.wert;
    }
    public void sub(Cardinal c){
        this.wert -= c.wert;
    }
}
