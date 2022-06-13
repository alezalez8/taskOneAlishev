package org.shunin.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;


    @NotEmpty(message = "Название книги не может быть пустым")
    @Size(min = 3, max = 100, message = "Длина названия книги должна быть в диапазоне от 3 до 100 символов")
    private String bookName;


    @NotEmpty(message = "Имя автора не может быть пустым")
    @Size(min = 2, max = 100, message = "Длина имени автора должна быть в диапазоне от 3 до 100 символов")
    private String author;

    @Min(value = 1600, message = "Год книги не может быть меньше 1600 года")
    @Max(value = 2023, message = "Год книги не может быть больше 2023 года")
    private int year;

    public Book() {
    }

    public Book(int id, String bookName, String author, int year) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.year = year;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
