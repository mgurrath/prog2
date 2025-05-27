package main;

public class Modul {
    private String Bezeichnung;
    private int Anzahl;

    private final MengeDynArray<Stud> teilnehmer = new MengeDynArray<Stud>();

    public Modul(String bezeichnung, int anzahl) {
        this.Anzahl = anzahl;
        this.Bezeichnung = bezeichnung;
    }
}
