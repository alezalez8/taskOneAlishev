package org.shunin.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.shunin.models.Book;
import org.shunin.util.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(book_name, author, year) VALUES (?,?,?)",
                book.getBookName(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET book_name=?, author=?, year=? WHERE id=?",
                book.getBookName(), book.getAuthor(), book.getYear(), book.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    //=======================================================
    public List<Book> index1() {
        return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());

    }

    public Optional<Book> show1(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public List<Book> getList(int id) {  // id = fk, user_id
        return jdbcTemplate.query("SELECT * FROM Book WHERE user_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));

    }
//=======================================================

}
