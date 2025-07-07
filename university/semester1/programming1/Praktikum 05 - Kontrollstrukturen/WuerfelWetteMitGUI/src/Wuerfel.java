import java.util.concurrent.ThreadLocalRandom;

/**
 * Simulation eines 6-seitigen Würfels
 * Die oben liegende Zahl ist die gewürfelte Zahl
 * 
 * TODO
 * Verallgemeinerung auf beliebige "Würfel" - DONE
 * 
 * @author Friedhelm Tappe, Prof. Dr.-Ing. Heiko Tapken
 * @version 25.10.2014
 *
 */

public class Wuerfel {

	private int gewuerfelteZahl;
	private int seitenAnzahlWuerfel = 6;
	
	public Wuerfel() {
		this.wuerfeln();
	}
	
	public Wuerfel(int oben) {
		this.gewuerfelteZahl = oben;
	}
	
	public void wuerfeln() {
		//todo: 
		//weisen Sie der Variablen gewuerfelteZahl wir ein zufälliger Wert zwischen 1 und 6 (Integer) zu - DONE
		gewuerfelteZahl = ThreadLocalRandom.current().nextInt(1, seitenAnzahlWuerfel + 1);
	}

	public int getOben() {
		return gewuerfelteZahl;
	}
	
}
