package phoneBook;

public interface Commands {
    String EXIT = "0";
    String CREATE = "1";
    String READ = "2";
    String UPDATE = "3";
    String DELETE = "4";

    default void showCommands() {
        System.out.println("PRESS 0 TO EXIT THE PROGRAM");
        System.out.println("PRESS 1 TO CREATE A NEW CONTACT");
        System.out.println("PRESS 2 TO SEE YOUR CONTACTS");
        System.out.println("PRESS 3 TO UPDATE A CONTACT");
        System.out.println("PRESS 4 TO DELETE A CONTACT");
    }
}
