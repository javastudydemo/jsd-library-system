package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.controller.reader;

import java.util.List;

import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book.Book;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.reader.Reader;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.properties.AmazonProperties;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.book.BookRepository;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.reader.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
//@EnableConfigurationProperties
//@ConfigurationProperties("amazon")
public class ReadingListController {

    private BookRepository bookRepository;

    private AmazonProperties amazonConfig;

    @Autowired
    public ReadingListController(BookRepository bookRepository,
                                 AmazonProperties amazonConfig) {
        this.bookRepository = bookRepository;
        this.amazonConfig = amazonConfig;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fail")
    public void fail() {
        throw new RuntimeException();
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String error() {
        return "error/error";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = bookRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonConfig.getAssociateId());
        }
        return "book/books";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/";
    }

}
