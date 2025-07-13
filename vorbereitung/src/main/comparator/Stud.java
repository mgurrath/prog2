package main.comparator;

public class Stud implements Comparable<Stud>{

    private static int nextNr = 100;

    private int matNr;
    private String name;

    public Stud(String n) {
        name = n;
        matNr = nextNr++;
    }

    public String name() {
        return name;
    }

    public int matNr() {
        return matNr;
    }

    @Override
    public String toString() {
        return name + " ( " + matNr + " ) ";
    }

    @Override
    public int compareTo(Stud o) {
        return this.matNr - o.matNr;
    }
}
