package Aufgabe1;

public class Radio extends RundFunkEmpfangsGeraet{
    private double frequenz;
    public Radio(){
        super();
        frequenz = 87.5;
    }
    void waehleSender(double newFrequenz){
        if(this.eingeschaltet == true){
            this.frequenz = newFrequenz;
        }
        else
        {
            System.out.println("Bitte schalten Sie das Radio ein.");
        }
    }

    @Override
    public String toString() {
        return "Radio{" +
                "frequenz=" + frequenz +
                ", lautstaerke=" + lautstaerke +
                ", eingeschaltet=" + eingeschaltet +
                '}';
    }
}
