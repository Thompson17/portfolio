public class Menge {

    private Person[] menge;
    private int anzahlPersonen = 0;


//    Erzeugen einer neuen leeren Menge
    public Menge(int groesse){
        this.menge = new Person[groesse];
    }

//    Erzeugen einer neuen Menge mit einer bereits existierenden (flache Kopie)
    public Menge(Menge original){
        menge = original.getMenge();
        this.anzahlPersonen = original.getAnzahlPersonen();
    }

//    Überprüfen auf Gleicheit zweier Mengen
    public boolean equals(Menge original){
        if(original == null || this.anzahlPersonen != original.getAnzahlPersonen()){
            return false;
        }
        for(int i = 0; i < this.anzahlPersonen; i++) {
            if(!original.enthaeltPerson(this.menge[i])){
                return false;
            }
        }
        return true;
    }

//    Hinzufügen einer Person zu einer Menge
    public void addPerson(Person person){
        if(!this.enthaeltPerson(person)) {
            if (this.anzahlPersonen < this.menge.length) {
                this.menge[anzahlPersonen] = person;
                anzahlPersonen ++;
            } else {
                Person[] tmp = this.menge;
                int groesse = tmp.length;
                this.menge = new Person[groesse + 1];
                for (int i = 0; i < groesse; i++) {
                    menge[i] = tmp[i];
                }
                menge[groesse] = person;
                anzahlPersonen ++;
            }
        }
    }

//    Entfernen einer Person aus einer Menge
    public void entfernePerson(Person person){
        int position = Integer.MAX_VALUE;
        if(this.enthaeltPerson(person)){
            for(int i = 0; i < this.anzahlPersonen; i++){
                if(this.menge[i].equals(person)){
                    position = i;
                }
            }
            for(int i = position; i < this.anzahlPersonen - 1; i++){
                this.menge[i] = this.menge[i + 1];
            }
            this.menge[anzahlPersonen - 1] = null;
            anzahlPersonen --;
        }else{
            System. out.println("Diese Person ist nicht in der Menge enthalten!");
        }
    }

//    Überprüfung anhand des Vor- und Nachnamens, ob eine bestimmte Person in der Menge enthalten ist
    public boolean enthaeltPerson(Person person){
        if(person != null) {
            for (int i = 0; i < this.anzahlPersonen; i++) {
                if (this.menge[i].equals(person)) {
                    return true;
                }
            }
        }
        return false;
    }

//    Schnittmengenbildung zweier Mengen
    public Menge schnittmenge(Menge menge2){
        Menge schnitt = new Menge(1);
        for(int i = 0; i < this.anzahlPersonen; i++){
            if(menge2.enthaeltPerson(this.menge[i])){
                schnitt.addPerson(this.menge[i]);
            }
        }
        return schnitt;
    }

//    Vereinigung zweier Mengen
    public Menge vereinigung(Menge menge2){
        Menge vereinigung = new Menge(1);
        for(int i = 0; i < this.anzahlPersonen; i++){
            vereinigung.addPerson(this.menge[i]);
        }
        Person[] tmp = menge2.getMenge();
        for(int i = 0; i < tmp.length; i++){
            vereinigung.addPerson(tmp[i]);
        }
        return vereinigung;
    }

//    Differenzbildung zweier Mengen
    public Menge differenz(Menge menge2){
        Menge differenz = new Menge(1);
        for(int i = 0; i < this.anzahlPersonen; i++){
            if(!menge2.enthaeltPerson(this.menge[i])){
                differenz.addPerson(this.menge[i]);
            }
        }
        return differenz;
    }


    public Person[] getMenge(){
        return this.menge;
    }

    public int getAnzahlPersonen(){
        return anzahlPersonen;
    }

}
