import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe5 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void kehrUm(){
	linksUm();
	linksUm();
}

void vor2(){
	vor();
	vor();
}

void tauschen(){
	linksUm();
	vor();
	einsHoch();
	vor();
	einsHoch();
	kehrUm();
	vor2();
	zweiRunter();
	linksUm();
}

void einsHoch(){
	while(kornDa()){
		nimm();
	}
	kehrUm();
	vor();
	while(!maulLeer()){
		gib();
	}
	kehrUm();
	vor();
}

void zweiRunter(){
	while(kornDa()){
		nimm();
	}
	kehrUm();
	vor2();
	while(!maulLeer()){
		gib();
	}
	kehrUm();
	vor2();
	}


public void main() {
    while(vornFrei()){
    	tauschen();
    	vor();
    }
    tauschen();
}}