package be.bstorm.bf_java_2024_demospringmvc.pl.controllers;

import be.bstorm.bf_java_2024_demospringmvc.pl.models.Book;
import be.bstorm.bf_java_2024_demospringmvc.pl.models.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/book")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("123", "A"));
        books.add(new Book("456", "B"));
        books.add(new Book("789", "C"));
    }

    @GetMapping
    public String book(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{isbn}")
    public String getOne(
            @PathVariable String isbn,
            Model model
    ) {
        try {
            Book book = books.stream()
                    .filter(b -> b.isbn().equals(isbn)).findFirst().orElseThrow();
            model.addAttribute("book", book);
            return "book";
        } catch (NoSuchElementException e) {
            return "error";
        }
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new BookForm());
        return "add";
    }

    @PostMapping("/add")
    public String addBook(
            @ModelAttribute BookForm book
    ) {
        books.add(new Book(book.getIsbn(), book.getTitle()));
        return "redirect:/book";
    }
}
