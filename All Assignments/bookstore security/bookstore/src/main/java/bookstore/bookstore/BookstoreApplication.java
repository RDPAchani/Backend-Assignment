package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import bookstore.bookstore.domain.Bookstore;
import bookstore.bookstore.domain.BookstoreRepository;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.AppUserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookstoreRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {


			Category category1 = new Category("Romance");
			Category category2 = new Category("Horror");
		
			
			crepository.save(category1);
			crepository.save(category2);
			
			log.info("save a couple of books");
			repository.save(new Bookstore("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 12.5, category1));
			repository.save(new Bookstore("Animal Farm", "George Orwell", 1945, "2212343-5", 13.0, category2));	
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","daniel@gmail.com" ,"USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "sohan@gmail.com","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Bookstore bookstore : repository.findAll()) {
				log.info(bookstore.toString());
			}

			log.info("haetaan kaikki Naamiot");
			for (Bookstore bookstore : repository.findByAuthor("George Orwell")) {
				log.info(bookstore.toString());
			}


		};
	}


}