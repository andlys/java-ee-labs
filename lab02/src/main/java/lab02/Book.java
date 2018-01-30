package lab02;

import java.util.Set;

public class Book {
	private int year;
	private String name;
	private Set<String> characters; 
	public Set<String> getCharacters() {
		return characters;
	}
	public void setCharacters(Set<String> characters) {
		this.characters = characters;
	}
	public Book(int year, String name) {
		this.year = year;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [year=" + year + ", name=" + name + ", characters=" + characters + "]";
	}

}