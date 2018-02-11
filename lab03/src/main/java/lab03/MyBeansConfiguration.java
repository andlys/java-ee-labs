package lab03;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeansConfiguration {
	@Bean
	@Qualifier("bookCharacters")
    public Set<String> getCharactersSet(){
        Set<String> set = new HashSet<String>();
        set.add("Count Kirill Vladimirovich Bezukhov");
        set.add("Countess Natalya Ilyinichna \"Natasha\" Rostova");
        set.add("Prince Nikolai Andreich Bolkonsky");
        set.add("Prince Vasily Sergeyevich Kuragin");
        set.add("Adolf Karlovich Berg");
		return set;
    }
	
	@Bean(name="leo")
	public Author getAuthor() {
		return new Author("Leo Tolstoy", 82);
	}
	
	@Bean(name="masterpiece")
	public Book getBook() {
		return new Book(1867, "War and Peace");
	}
}