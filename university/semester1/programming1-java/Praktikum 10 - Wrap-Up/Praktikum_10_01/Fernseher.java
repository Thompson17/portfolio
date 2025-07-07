package Aufgabe1;

public class Fernseher extends RundFunkEmpfangsGeraet{
    private int kanal;
    public Fernseher(){
        super();
        kanal = 1;
    }
    void waehleKanal(int newKanal){
        if(this.eingeschaltet == true){
            this.kanal = newKanal;
        }
        else
        {
            System.out.println("Bitte schalten Sie den Fernseher ein.");
        }
    }

    @Override
    public String toString() {
        return "Fernseher{" +
                "kanal=" + kanal +
                ", lautstaerke=" + lautstaerke +
                ", eingeschaltet=" + eingeschaltet +
                '}';
    }
}
