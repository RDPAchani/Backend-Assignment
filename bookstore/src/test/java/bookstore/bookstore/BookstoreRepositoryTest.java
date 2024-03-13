package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.AppUserRepository;
import bookstore.bookstore.domain.Bookstore;
import bookstore.bookstore.domain.BookstoreRepository;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.Category;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookstoreRepositoryTest {


    @Autowired
    private BookstoreRepository repository;

    @Autowired
    private CategoryRepository crepository;
    
    @Test
    public void findByAuthorShouldReturnAuthor() {
        List<Bookstore> bookstores = repository.findByAuthor("Ernest Hemingway");
        
        assertThat(bookstores).hasSize(1);
        assertThat(bookstores.get(0).getTitle()).isEqualTo("A Farewell to Arms");
    }
    
    @Test
    public void createNewBookstore() {
    	Category category = new Category("Thriller");
    	crepository.save(category);
    	Bookstore bookstore = new Bookstore("The Shark", "Andrew Wilson", 1956,"1232323-4", 14.5, category);
    	repository.save(bookstore);
    	assertThat(bookstore.getId()).isNotNull();
    }    
    @Test
    public void deleteNewBookstore() {
		List<Bookstore> bookstores = repository.findByAuthor("Ernest Hemingway");
		Bookstore bookstore = bookstores.get(0);
		repository.delete(bookstore);
		List<Bookstore> newBookstore = repository.findByAuthor("Ernest Hemingway");
		assertThat(newBookstore).hasSize(0);
     }

   


}
