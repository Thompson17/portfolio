import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class Aufgabe4 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void nimm4(){
	if(kornDa()){
		nimm();
		if(kornDa()){
			nimm();
			if(kornDa()){
				nimm();
				if(kornDa()){
					nimm();
					if(kornDa()){
						gib();
						gib();
						gib();
						gib();
					}
				}else{
					gib();
					gib();
					gib();
				}
			}else{
				gib();
				gib();
			}
		}else{
			gib();
		}
	}
}

void rechtsUm(){
	linksUm();
	linksUm();
	linksUm();
}

void zweiReihen(){
    nimm4();
    vor();
    nimm4();
    vor();
    nimm4();
    vor();
    nimm4();
    rechtsUm();
    vor();
    rechtsUm();
    nimm4();
    vor();
    nimm4();
    vor();
    nimm4();
    vor();
    nimm4();
}

public void main() {
    zweiReihen();
    linksUm();
    vor();
    linksUm();
    zweiReihen();
}
}