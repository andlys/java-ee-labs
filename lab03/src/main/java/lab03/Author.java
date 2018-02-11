package lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Author {
	private String name;
	@Autowired
	@Qualifier("masterpiece")
	private Book book;
	private int yearsLived;
	
	public int getYearsLived() {
		return yearsLived;
	}

	public void setYearsLived(int yearsLived) {
		this.yearsLived = yearsLived;
	}

	public Author(String name, int yearsLived) {
		super();
		this.name = name;
		this.yearsLived = yearsLived;
	}

	public void speak() {
		System.out.println(String.format("I am %s, %d year old. I wrote %s", 
				name, yearsLived, book));
	}
}