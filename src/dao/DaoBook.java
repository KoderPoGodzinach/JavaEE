package dao;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface DaoBook {
    void showAll() throws Exception;

    void addNewBook() throws Exception;

    void addNewBook2(Book book) throws SQLException, ClassNotFoundException;

    void addNewBook3() throws SQLException, ClassNotFoundException;

    void findBookByTitle(String title) throws Exception;

    Book findBook(String id) throws Exception;

    void findBookByAutor(String autor) throws Exception;

    Book updateBook(Book book) throws SQLException, ClassNotFoundException;

    void deleteBook() throws SQLException, ClassNotFoundException;

    void deleteBookById(int id) throws SQLException, ClassNotFoundException;

    void removeBook(String id) throws SQLException, ClassNotFoundException;

    List getAllBook() throws Exception;

}
