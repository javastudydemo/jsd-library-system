package org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.reader;

import lombok.Data;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.base.BaseModel;
import org.ijiangtao.tech.jsd.spring.boot.library.jsdlibrarysystem.model.book.Book;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Reader implements UserDetails {

    @Id
    private String username;

    private String fullname;

    private String password;
    private List<Book> readingBooks;

    // UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    //不过期，不加锁，不禁用
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }


}
