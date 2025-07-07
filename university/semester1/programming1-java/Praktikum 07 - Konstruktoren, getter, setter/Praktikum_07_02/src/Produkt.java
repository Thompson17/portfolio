public class Produkt {
    String Name;
    int produktnummer;
    double preis;
    Produkt()
    {
    }
    Produkt(double preis)
    {
        this.preis = preis;
    }
    Produkt(int produktnummer)
    {
        this.produktnummer = produktnummer;
    }
    Produkt(String Name)
    {
        this.Name = Name;
    }
    Produkt(String Name, double preis)
    {
        this.Name = Name;
        this.preis = preis;
    }
    Produkt(double Preis, int produktnummer)
    {
        this.produktnummer = produktnummer;
        this.preis = Preis;
    }
    Produkt(int produktnummer, String Name)
    {
        this.Name = Name;
        this.produktnummer = produktnummer;
    }
    Produkt(double preis, int produktnummer, String Name)
    {
        this.Name = Name;
        this.produktnummer = produktnummer;
        this.preis = preis;
    }
}
