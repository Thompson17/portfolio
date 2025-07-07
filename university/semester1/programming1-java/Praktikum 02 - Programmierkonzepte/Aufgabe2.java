import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void rechtsUm(){
	linksUm();
	linksUm();
	linksUm();
}

void kehrUm(){
	linksUm();
	linksUm();
}

void vorOft(int schritte){
	for(int i=0; i < schritte; i++){
		vor();
	}
}

void nimmOft(int anzahl){
	for(int i=0; i < anzahl; i++){
		nimm();
	}
}

public void main() { 
    rechtsUm();
    vorOft(7);
    nimm();
    kehrUm();
    vorOft(4);
    rechtsUm();
    vor();
    nimm();
    rechtsUm();
    vor();
    linksUm();
    vorOft(2);
    rechtsUm();
    vorOft(2);
    nimm();
    kehrUm();
    vorOft(6);
    nimm();
    kehrUm();
    vorOft(3);
    linksUm();
    vorOft(5);
    linksUm();
    vor();
    nimm();
    kehrUm();
    vorOft(2);
    nimmOft(3);
    kehrUm();
    vor();
    linksUm();
    vorOft(2);
    rechtsUm();
    vorOft(3);
    rechtsUm();
    vorOft(5);
    nimm();
    rechtsUm();
    vorOft(3);
    nimm();
    vorOft(4);
    nimm();
}}