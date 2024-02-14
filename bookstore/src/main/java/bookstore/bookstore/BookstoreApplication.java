package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Bookstore;
import bookstore.bookstore.domain.BookstoreRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookstoreRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Bookstore("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 12.0));
			repository.save(new Bookstore("Animal Farm", "George Orwell", 1945, "2212343-5", 13.0));	
			
			log.info("fetch all books");
			for (Bookstore bookstore : repository.findAll()) {
				log.info(bookstore.toString());
			}

		};
	}


}
