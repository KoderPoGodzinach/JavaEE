package reop;

import dao.DaoBook;
import model.Book;
import model.DbConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookRepository implements DaoBook {
    DbConfiguration dbConfiguration = new DbConfiguration();
    ResultSet resultSet;


    // Displaying information in rows in the table
    public void showAll() throws Exception {
        resultSet = dbConfiguration.dbExecuteQuery("Select * From book");

        while (resultSet.next()) {
            System.out.println("title: " + (resultSet.getString(2)) + " autor: " + (resultSet.getString(3)));
        }
    }

    // adding a book to the library
    public void addNewBook() throws Exception {
        dbConfiguration.dbExecuteUpdateQuery("INSERT INTO `library`.`book` (`idBook`, `title`, `autor`) VALUES ('8'," +
                " 'GOT', 'R.R.Martin')");
    }

    // adding a book to the library
    public void addNewBook2(Book book) throws SQLException, ClassNotFoundException {
        dbConfiguration.dbExecuteUpdateQuery("INSERT Into `library`.`book` (`id`, `title`, `author`,`price`) Values " + "('" + book.getId() + "'," + "'" + book.getTitle() + "'," + "'" + book.getAuthor() + "'," + "'" + book.getPrice() + "')");
    }

    // adding a book to the library
    public void addNewBook3() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id the new book");
        int id = scanner.nextInt();
        System.out.println("Title the new book");
        String title = scanner.next();
        System.out.println("Autor the new book");
        String autor = scanner.next();

        dbConfiguration.dbExecuteUpdateQuery("INSERT Into `library`.`book` (`idBook`, `title`, `autor`) Values " + "("
                + id + ",'" + title + "'," + "'" + autor + "')");
    }

    // Find a book by title
    public void findBookByTitle(String title) throws Exception {
        resultSet = dbConfiguration.dbExecuteQuery("Select * From `library`.`book` Where title= " + "'" + title + "'");
        while (resultSet.next()) {
            System.out.println("idBook: " + (resultSet.getString(1)) + " Title: " + (resultSet.getString(2)) + " autor: " +
                    (resultSet.getString(3)));
        }
    }

    public Book findBook(String id) throws Exception {
        resultSet = dbConfiguration.dbExecuteQuery("Select * From `library`.`book` Where id= " + "'" + id + "'");
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getString(1));
            book.setAuthor(resultSet.getString(2));
            book.setTitle(resultSet.getString(3));
            book.setPrice(resultSet.getString(4));
        }
        return book;
    }


    // Find a book by autor
    public void findBookByAutor(String autor) throws Exception {
        resultSet = dbConfiguration.dbExecuteQuery("Select * From `library`.`book` Where title= " + "'" + autor + "'");
        while (resultSet.next()) {
            System.out.println("idBook: " + (resultSet.getString(1)) + " title" + (resultSet.getString(2)) + " autor" +
                    (resultSet.getString(3)));
        }
    }

    // Update book
    public Book updateBook(Book book) throws SQLException, ClassNotFoundException {

        dbConfiguration.dbExecuteUpdateQuery("UPDATE `library`.`book` SET `id`='" + book.getId() + "', `title`='" + book.getTitle() + "'," +
                "`author`='" + book.getAuthor() + "'," + "`price`='" + book.getPrice() + "' WHERE `id`='" + book.getId() + "'");
        return book;
    }

    // Delete model.Book
    public void deleteBook() throws SQLException, ClassNotFoundException {
        dbConfiguration.dbExecuteUpdateQuery("DELETE FROM `library`.`book` WHERE `idbook`='7'");
    }

    // Delete model.Book by Id
    public void deleteBookById(int id) throws SQLException, ClassNotFoundException {
        dbConfiguration.dbExecuteUpdateQuery("DELETE FROM `library`.`book` WHERE `idperson`=" + "'" + id + "'");
    }

    @Override
    public void removeBook(String id) throws SQLException, ClassNotFoundException {
        dbConfiguration.dbExecuteUpdateQuery("DELETE FROM `library`.`book` WHERE `id`='" + id + "'");

    }

    @Override
    public List getAllBook() throws Exception {
        resultSet = dbConfiguration.dbExecuteQuery("Select * From book");

        List<Book> list = new ArrayList();
        Book book = new Book();
        while (resultSet.next()) {
            book.setId(resultSet.getString(1));
            book.setAuthor(resultSet.getString(2));
            book.setTitle(resultSet.getString(3));
            book.setPrice(resultSet.getString(4));

            list.add(book);
        }
        return list;
    }
}
