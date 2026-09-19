public class ConsoleUI {

    private Library library;
    private User user;

    public ConsoleUI(Library library, User user) {
        this.library = library;
        this.user = user;
    }
    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg:"));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen");
            }
        }
    }
    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    //Lån bog fra menu metode
    private void borrowBook() {
    int bookId = Integer.parseInt(IO.readln("Indtast id'et på bogen du vil låne:"));
        if (library.loanBook(bookId, user.Id())) {
            IO.println("Bogen er lånt");
        } else {
            IO.println("Bogen kunne ikke lånes");
        }
    }

    //Aflever bog fra menu metode
    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast id'et på bogen du vil låne:"));
        if (library.returnBook(bookId, user.Id())) {
            IO.println("Bogen er afleveret");
        } else {
            IO.println("Bogen kunne ikke afleveres");
        }
    }


    private void showLoans() {
    int userId = Integer.parseInt(IO.readln("indstat dit bruger id:"));
    if(library.findLoansByMemberId(userId).size()!=0) {
        IO.println("dine lån er: "+ library.findLoansByMemberId(userId));
    }
    else {
        IO.println("du har ingen lån");
    }
    }
}
