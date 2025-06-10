package main;

public class Stud extends Person {

    private static int zaehler = 100;

    private int matNr;

    private int bel_module = 0;

    public Stud(String name, int geburtsjahr) {
        super(name, geburtsjahr);
        matNr = zaehler++;
    }

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

    public void anmelden(Modul m) {
        m.teilnehmer.insert(this);
        this.bel_module++;
    }

    public void abmelden(Modul m) {
        m.teilnehmer.delete(this);
        this.bel_module--;
    }

    public int belegt() {
        return this.bel_module;
    }
}
