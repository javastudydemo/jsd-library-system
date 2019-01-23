package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.repository.reader;

import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.reader.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
   public Reader findOne(String username);
}
