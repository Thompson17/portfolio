package Aufgabe1;

public class RundFunkEmpfangsGeraet {
    int lautstaerke;
    boolean eingeschaltet;

    RundFunkEmpfangsGeraet() {
        lautstaerke = 0;
        eingeschaltet = false;
    }
    /**
     * verändere Lautstaerke um x nach oben oder unten, je nach
     Vorzeichen von x
     */
    void volume(int x) {
        if(x < 0 && eingeschaltet == true){
            for(int i = 0; i > x; i--){
                leiser();
            }
        }
        else if(x > 0 && eingeschaltet == true){
            for(int i = 0; i < x; i++){
                lauter();
            }
        }
        else{
            System.out.println("Schalten Sie das Gerät zuerst an!");
        }
    }
    /** Erhöhe Lautstaerke um 1 */
    void lauter() {
        this.lautstaerke = lautstaerke +1;
    }
// getter und setter
    /** Vermindere Lautstaerke um 1. */
    void leiser() {
        this.lautstaerke = lautstaerke -1;
    }
    /** Schalte ein. */
    void an() {
        this.eingeschaltet = true;
    }
    /** Schalte aus */
    void aus() {
        this.eingeschaltet = false;
    }
    /** an oder aus? */
    boolean istAn() {
        if(eingeschaltet == true){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "RundFunkEmpfangsGeraet{" +
                "lautstaerke=" + lautstaerke +
                ", eingeschaltet=" + eingeschaltet +
                '}';
    }
}


