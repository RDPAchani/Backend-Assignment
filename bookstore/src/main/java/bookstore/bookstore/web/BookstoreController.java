package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import bookstore.bookstore.domain.Bookstore;
import bookstore.bookstore.domain.BookstoreRepository;

@Controller
public class BookstoreController {

    @Autowired
	private BookstoreRepository repository; 
	
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model) {	
        model.addAttribute("bookstores", repository.findAll());
        return "booklist";
    }

}
