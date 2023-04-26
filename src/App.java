import db.DB;
import model.dao.BookDao;
import model.dao.DaoFactory;
import model.entities.Book;

public class App {
    public static void main(String[] args) throws Exception {
        BookDao bookDao = DaoFactory.createBookDao();

        Book book1 = new Book(null, "Dom Casmurro", "Machado de Assis", 1899);
        Book book2 = new Book(null, "Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881);
        Book book3 = new Book(null, "A Hora da Estrela", "Clarice Lispector", 1977);

        bookDao.insert(book1);
        bookDao.insert(book2);
        bookDao.insert(book3);
    }
}
