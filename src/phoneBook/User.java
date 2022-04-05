package phoneBook;

import java.util.List;
import java.util.Objects;

public class User {
    private List<String> phoneNumbers;
    private PhoneNumberType phoneNumberType;
    private String company;
    private List<String> emails;
    private EmailType emailType;

    public User(List<String> phoneNumbers, PhoneNumberType phoneNumberType, String company, List<String> emails, EmailType emailType) {
        this.phoneNumbers = phoneNumbers;
        this.phoneNumberType = phoneNumberType;
        this.company = company;
        this.emails = emails;
        this.emailType = emailType;
    }

    public User() {
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public PhoneNumberType getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getEmails() {
        return this.emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public EmailType getEmailType() {
        return this.emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            User user = (User)o;
            return Objects.equals(this.phoneNumbers, user.phoneNumbers) && this.phoneNumberType == user.phoneNumberType && Objects.equals(this.company, user.company) && Objects.equals(this.emails, user.emails) && this.emailType == user.emailType;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.phoneNumbers, this.phoneNumberType, this.company, this.emails, this.emailType});
    }

    public String toString() {
        return "phoneBook.User{phoneNumbers=" + this.phoneNumbers + ", phoneNumberType=" + this.phoneNumberType + ", company='" + this.company + '\'' + ", emails=" + this.emails + ", emailType=" + this.emailType + '}';
    }
}
