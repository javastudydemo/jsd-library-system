package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.reader.Reader;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @ManyToOne
    private Reader reader;

    private String isbn;
    private String title;
    private String author;
    private String description;

}