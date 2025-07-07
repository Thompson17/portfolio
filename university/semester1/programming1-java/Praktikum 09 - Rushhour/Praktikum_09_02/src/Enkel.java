class Enkel extends Sohn{
    public Enkel(long a) {
        super(a);
    }

    public double werteEnkel(){
        return this.x + this.y + this.z + this.a;
    }

    public double werteAlle(){
        return ((Grossvater)this).x + ((Vater)this).x + this.x + this.y + this.z + this.a;
    }
}
