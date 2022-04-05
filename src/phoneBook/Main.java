package phoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main implements Commands{
    private static final Main main = new Main();
    private static final ContactCrudService contactService = new ContactCrudService();
    private static final Scanner scanner;
    private static boolean isRun;

    public Main() {
    }

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        while(isRun) {
            main.showCommands();
            switch (scanner.nextLine()) {
                case "0":
                    System.out.println("Bye!");
                    isRun = false;
                    break;
                case "1":
                    createNewContact();
                    break;
                case "2":
                    contactService.read();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                default:
                    System.out.println("WRONG COMMAND");
            }
        }

    }

    private static void deleteContact() {
        System.out.println("INPUT CONTACT'S COMPANY NAME");
        String company = scanner.nextLine();
        User user = contactService.getByCompany(company);
        contactService.delete(user);
        System.out.println("USER SUCCESSFULLY DELETED");
    }

    private static void updateContact() {
        System.out.println("INPUT CONTACT'S COMPANY NAME");
        String company = scanner.nextLine();
        User user = getUser(company);
        contactService.update(user);
        System.out.println("CONTACT SUCCESSFULLY UPDATED");
    }

    private static void createNewContact() {
        System.out.println("INPUT THE COMPANY NAME");
        String company = scanner.nextLine();
        User user = getUser(company);
        contactService.create(user);
        System.out.println("CONTACT SUCCESSFULLY CREATED");
    }

    private static User getUser(String company) {
        System.out.println("INPUT THE PHONE NUMBERS SEPARATED BY COMMA");
        String phoneNumbersFromInput = scanner.nextLine();
        String[] splitPhoneNumbers = phoneNumbersFromInput.split(",");
        List<String> phoneNumbers = new ArrayList<>(Arrays.asList(splitPhoneNumbers));
        System.out.println("INPUT THE PHONE NUMBER TYPE");
        PhoneNumberType phoneNumberType = PhoneNumberType.valueOf(scanner.nextLine());
        System.out.println("INPUT EMAILS SEPARATED BY COMMA");
        String emailsFromInput = scanner.nextLine();
        String[] splitEmails = emailsFromInput.split(",");
        List<String> emails = new ArrayList<>(Arrays.asList(splitEmails));
        System.out.println("INPUT THE EMAIL TYPE");
        EmailType emailType = EmailType.valueOf(scanner.nextLine());
        return new User(phoneNumbers, phoneNumberType, company, emails, emailType);
    }

    static {
        scanner = new Scanner(System.in);
        isRun = true;
    }
}
