import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe3 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void rechtsUm(){
	linksUm();
	linksUm();
	linksUm();
}

void kehrUm(){
	linksUm();
	linksUm();
}

void vorNimm(int schritte){
	for(int i=0; i < schritte; i++){
		while(kornDa()){
			nimm();
			maul++;
		}
		vor();
	}
}

int maul = 0;

public void main() { 
    rechtsUm();
    vorNimm(6);
    linksUm();
    vorNimm(6);
    kehrUm();
    vorNimm(6);
    rechtsUm();
    vorNimm(2);
    rechtsUm();
    vorNimm(11);
    linksUm();
    vorNimm(2);
    linksUm();
    vorNimm(11);
    rechtsUm();
    vorNimm(2);
    rechtsUm();
    vorNimm(11);
    rechtsUm();
    vorNimm(6);
    while(maul > 0){
    	gib();
    	maul--;
    }
}}