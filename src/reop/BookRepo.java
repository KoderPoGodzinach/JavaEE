package reop;

import dao.BookDao;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepo implements BookDao {

    List<Book> bookList = new ArrayList<Book>();

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List getAllBook() {
        return bookList;
    }

    @Override
    public Book findBook(String id) {
        Book book = new Book();
        for (Book b : bookList) {
            if (b.getId().equals(id))
                return b;
            book = b;
            break;
        }
        return book;
    }

    @Override
    public void removeBook(String id) {
        for (Book b : bookList) {
            if (b.getId().equals(id))
                bookList.remove(b);
            break;
        }
    }

    @Override
    public void updateBook(Book book) {
        for (Book b : bookList){
            if (b.getId().equals(book.getId()));
            {
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
        }
    }
}
