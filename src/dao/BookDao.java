package dao;

import model.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    List getAllBook();

    Book findBook(String id);

    void removeBook(String id);

    void updateBook(Book book);
}
