void main() {

    Library library = new Library("Den sorte diamant ", 1999);

    Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
    Book book2 = new Book("Robert C. Martin", "Clean Code", "9780132350884", 2);
    Book book3 = new Book("Joshua Bloch", "Effective Java", "9780134685991", 3);

    //tilføj bøger til bib via addBook metoden
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    String name1 = IO.readln("Indtast dit navn: ");

    User user1 = new User(name1, 1);

    //tilføj user til bib'et
    library.addUser(user1);

    ConsoleUI consoleUI = new ConsoleUI(library, user1);

    IO.println();

    //kald menu metode
    consoleUI.run();
}