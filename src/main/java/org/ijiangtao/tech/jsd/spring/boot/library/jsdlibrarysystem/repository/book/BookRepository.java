package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.book;

import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book.Book;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.reader.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbn(String isbn);

    List<Book> findByReader(Reader reader);

}
