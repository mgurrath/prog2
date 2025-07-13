package main.comparator;

import main.adt.FolgeAlsDynArray;
import main.adt.MengeEVL;
import main.adt.interfaces.Folge;
import main.adt.interfaces.Menge;

/**
 * @author sweil (updated by akless: implemented sort method)
 */

public class StudUtil {

    public static Folge<Stud> sort(Menge<Stud> m) {

        Folge<Stud> f = new FolgeAlsDynArray<>();

        Stud s = m.get();
        m.delete(s);
        f.insert(0, s);

        while (!m.isEmpty()) {
            s = m.get();
            m.delete(s);
            for (int i = 0; i <= f.size(); i++) {
                if (i == f.size() || s.compareTo(f.get(i)) < 0) {
                    f.insert(i, s);
                    break;
                }
            }
        }

        return f;
    }

    public static void main(String[] args) {
        // Erzeugung und Ausgabe einer (unsortierten) Menge
        Menge<Stud> m = createMenge();
        System.out.println("Menge unsortiert: ");
        for(Stud s: m)
            System.out.println(s);
        System.out.println();

        // Aufruf der Sortier-Methode
        Folge<Stud> sortiert = sort(m);

        // Ausgabe
        System.out.println("nach Mat-Nr sortiert: ");
        for(Stud s: sortiert)
            System.out.println(s);
    }

    public static Menge<Stud> createMenge() {

        Stud o = new Stud("Otto");
        Stud d = new Stud("Deniz");
        Stud l = new Stud("Lisa");
        Stud f = new Stud("Fritz");
        Stud e = new Stud("Emil");
        Stud b = new Stud("Ben");
        Stud g = new Stud("Gina");
        Stud c = new Stud("Chris");
        Stud a = new Stud("Anna");

        Menge<Stud> m = new MengeDynArray<>();
        // hier koennte auch folgendes stehen:
        // Menge<Stud> m = new MengeEVL<Stud>();

        m.insert(a);
        m.insert(b);
        m.insert(c);
        m.insert(d);
        m.insert(e);
        m.insert(f);
        m.insert(g);
        m.insert(l);
        m.insert(o);
        return m;
    }
}
