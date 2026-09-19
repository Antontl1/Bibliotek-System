import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();
    String name;
    int year;

    Library(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    //Tjek om bog er hjemme
    public Book getBook(int bookId) {
        for (Book book : books) {
            if (bookId == book.id()) {
                return book;
            }
        }
        return null;
    }

    //Tjek om bruger er oprettet
    public User getUser(int userId) {
        for (User user : users) {
            if (userId == user.Id()) {
                return user;
            }
        }
        return null;
    }

    // Lån bog fra bib hvis bruger er oprettet og bog ikke er udlånt
    public boolean loanBook(int bookId, int userId) {
        Book book = getBook(bookId);
        User user = getUser(userId);

        if (book == null || user == null) {
            return false;
        }

        for (Loan loan : loans) {
            if (loan.book.id() == bookId) {
                return false;
            }

        }
        Loan loan = new Loan(book, user, LocalDate.now());
        addLoan(loan);
        return true;
    }

    //retuner bog hvis bogen er udlånt og fjern den fra loan listen
    public boolean returnBook(int bookId, int userId) {
        for (Loan loan : loans) {
            if (loan.book.id() == bookId) {
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }

    //Find alle lån for et medlem
    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> foundLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.borrowedBy.Id() == memberId) {
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }


    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printUsers() {
        for (User user : users) {
            IO.println(user);
        }
    }
    public String toString() {
        return String.format("%s %s",name,year);
    }
}
