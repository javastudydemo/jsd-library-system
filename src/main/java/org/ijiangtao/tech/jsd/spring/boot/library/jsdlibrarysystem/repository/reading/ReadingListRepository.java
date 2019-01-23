package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.reading;

import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
