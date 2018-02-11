package lab03;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Book {
	private int year;
	private String name;
	@Autowired(required=true)
	@Qualifier("bookCharacters")
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

