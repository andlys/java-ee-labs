package lab02;

public class Author {
	private String name;
	private Book book;
	private int yearsLived;
	
	public int getYearsLived() {
		return yearsLived;
	}

	public void setYearsLived(int yearsLived) {
		this.yearsLived = yearsLived;
	}

	public Author(String name, Book book) {
		super();
		this.name = name;
		this.book = book;
	}

	public void speak() {
		System.out.println(String.format("I am %s, %d year old. I wrote %s", 
				name, yearsLived, book));
	}
}