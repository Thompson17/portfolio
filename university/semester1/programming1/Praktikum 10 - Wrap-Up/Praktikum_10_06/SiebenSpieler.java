package Aufgabe6;

public class SiebenSpieler {

        private String name;
        private boolean ausgeschieden;
        public SiebenSpieler(String name) {
            this.name = name;
            this.ausgeschieden = false;
        }
        public String toString() {
            return this.name;
        }
        public int naechsteZahl(int vorherigeZahl) {
            return IO.readInt(this + ": Zahl nach " + vorherigeZahl + ": ");
        }
        public void ausscheiden() {
            this.ausgeschieden = true;
        }
        public boolean istAusgeschieden() {
            return this.ausgeschieden;
        }
    }
