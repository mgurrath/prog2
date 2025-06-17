/**
 * @author akless
 * @licence MIT
 */

public class Boxer extends Sportler {

    /* Konstruktoren */

    public Boxer(String name, int geburtsjahr, int groesse, double gewicht) {
        super(name, geburtsjahr, groesse, gewicht);
    }

    /* Instanzmethoden */

    public String gewichtsklasse() {
        return getGewicht() <= 70 ? "Leicht" : (getGewicht() <= 90 ? "Mittel" : "Schwer");
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String info() {
        return gewichtsklasse();
    }
}
