package main;

public class Stud extends Person {

    private static int zaehler = 100;

    private int matNr;

    /* Konstruktoren */

    public Stud(String name, int geburtsjahr) {
        super(name, geburtsjahr);
        matNr = zaehler++;
    }

    /* Instanzmethoden */

    public int matNr() {
        return matNr;
    }

    @Override
    public String toString() {
        return matNr + " " + this.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Stud stud = (Stud) o;
        return matNr == stud.matNr;
    }
}
