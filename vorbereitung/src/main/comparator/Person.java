package main.comparator;

import java.util.Objects;

 
public class Person implements Comparable<Person> {
	
	private String name;
	private int gebJahr;
	
	public Person(String n, int g) {
		this.name = n;
		this.gebJahr = g;
	}
	
	public String name() {
		return this.name;
	}
	
	public int gebJahr() {
		return this.gebJahr;
	}
	
	@Override
	public String toString() {
		return this.name + " (" + this.gebJahr + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return gebJahr == person.gebJahr && Objects.equals(name, person.name);
	}

	@Override
	public int compareTo(Person other) {
		int i = this.name().compareTo(other.name());
		return i == 0 ? this.gebJahr() - other.gebJahr() : i;
	}
}
