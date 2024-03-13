package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.bookstore.web.BookstoreController;

@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
    private BookstoreController BookstoreController;
	@Test
	public void contexLoads() throws Exception {
		assertThat(BookstoreController).isNotNull();
	}

}
