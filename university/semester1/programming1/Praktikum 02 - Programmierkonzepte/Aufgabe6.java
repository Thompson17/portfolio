import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe6 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void rechtsUm(){
	linksUm();
	linksUm();
	linksUm();
}

void kehrUm(){
	linksUm();
	linksUm();
}

void tauschen(){
	int rechts = 0;
	int links = 0;
	while(kornDa()){
		nimm();
		rechts++;
	}
	rechtsUm();
	vor();
	while(kornDa()){
		nimm();
		links++;
	}
	while(rechts > 0){
		gib();
		rechts--;
	}
	kehrUm();
	vor();
	while(links > 0){
		gib();
		links--;
	}
	rechtsUm();
}

void zumStart(){
	kehrUm();
	while(zeilen > 0){
		vor();
		zeilen--;
	}
	kehrUm();
}

int zeilen = 0;

public void main() { 
    for(int i=0; i<2; i++){
    	while(vornFrei()){
    		tauschen();
    		vor();
    		zeilen++;
    	}
    	tauschen();
    	zumStart();
    }
}}