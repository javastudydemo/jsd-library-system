package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.controller.book;

import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book.Book;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository readingListRepository) {
        this.bookRepository = readingListRepository;

    }

    @RequestMapping(value="/{book}", method= RequestMethod.GET)
    public String findByIsbn(
            @PathVariable("isbn") String isbn,
            Model model) {
        List<Book> books = bookRepository.findByIsbn(isbn);
        if (books != null) {
            model.addAttribute("books", books);
        }
        return "/book/books";
    }

    @RequestMapping(value="/book/{isbn}", method=RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("isbn") String isbn, Book book) {

        book.setIsbn(isbn);

        bookRepository.save(book);

        return "redirect:/book/{isbn}";
    }

}