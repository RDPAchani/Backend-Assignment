package bookstore.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.bookstore.domain.Bookstore;
import bookstore.bookstore.domain.BookstoreRepository;

import bookstore.bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {

    @Autowired
	private BookstoreRepository repository; 

       @Autowired
    private CategoryRepository crepository;

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	


    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model) {	
        model.addAttribute("bookstores", repository.findAll());
        return "booklist";
    }


// RESTful service to get all books
    @RequestMapping(value="/bookstores", method = RequestMethod.GET)
    public @ResponseBody List<Bookstore> bookListRest() {	
        return (List<Bookstore>) repository.findAll();
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/bookstores/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Bookstore> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }  






      @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("bookstore", new Bookstore());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Bookstore bookstore){
        repository.save(bookstore);
        return "redirect:booklist";
    }    
    
 @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }     

    @GetMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("bookstore", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "updatebook";
    }

}

