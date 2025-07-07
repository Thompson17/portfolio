import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        String vorname = IO.readString("Vorname: ");
        String nachname = IO.readString("Nachname: ");
        IO.print("Hallo " + vorname + " " + nachname + ".\n\n");
        short tag = IO.readShort("Geburtsdatum Tag: ");
        short monat = IO.readShort("Geburtsdatum Monat: ");
        short jahr = IO.readShort("Geburtsdatum Jahr: ");
        LocalDate geburtsdatum = LocalDate.of(jahr, monat, tag);
        LocalDate heute = LocalDate.now();
        long alter = ChronoUnit.DAYS.between(geburtsdatum, heute);
        IO.print("Hallo " + vorname + ", Du bist " + alter + " Tage alt.\n");
    }
}
