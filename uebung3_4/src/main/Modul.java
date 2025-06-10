package main;

public class Modul {
    private String Bezeichnung;
    private int Anzahl;

    public final MengeDynArray<Stud> teilnehmer = new MengeDynArray<Stud>();

    public Modul(String bezeichnung, int ects_punkte) {
        this.Anzahl = ects_punkte;
        this.Bezeichnung = bezeichnung;
    }
}
