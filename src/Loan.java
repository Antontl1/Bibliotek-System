import java.time.LocalDate;

public class Loan {
    Book book;
    LocalDate borrowedDate;
    User borrowedBy; // Hvem har lånt bogen?

    public Loan(Book book, User user, LocalDate localDate) {
        this.borrowedBy = user;
        this.borrowedDate = localDate;
        this.book = book;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue() {
        if (LocalDate.now().isAfter(getDueDate())) {
            return true;
        }
        return false;
    }


    //ledigheds metode
    public boolean isAvailable() {
        return borrowedBy == null;
    }

    //aflever bog metode
    public void returnBook(User user) {
        if (borrowedBy == user) {
            borrowedBy = null;
            borrowedDate = null;
            IO.println("din bog er afleveret");
        }
        else {
            IO.println("du kan ikke aflever andres bøger");
        }
    }

    public String toString() {
        //sæt true og false til..
        String status = "Borrowed by " + borrowedBy + " At: " + borrowedDate;
        // %s erstattes med værdierne nedenfor.
        return String.format("%s %s", book, status);
    }
}