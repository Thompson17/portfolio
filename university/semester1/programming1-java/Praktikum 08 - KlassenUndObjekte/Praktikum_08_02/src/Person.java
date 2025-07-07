public class Person {

    private String nachname;
    private String vorname;

//    Erstellen einer neuen Person. Eine Person hat IMMER einen Vor- und Nachnamen
    public Person(String nachname, String vorname){
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public String getNachname(){
        return this.nachname;
    }

    public String getVorname(){
        return this.vorname;
    }

//    Überprüfung zweier Personen auf gleichen Vor- und Nachnamen
    public boolean equals(Person original){
        return original != null && this.nachname.equals(original.nachname) && this.vorname.equals(original.vorname);
    }
}
