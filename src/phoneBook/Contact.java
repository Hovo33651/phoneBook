package phoneBook;

import java.util.Objects;

public class Contact {
    private String userName;
    private User user;

    public Contact(String userName, User user) {
        this.userName = userName;
        this.user = user;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Contact contact = (Contact)o;
            return Objects.equals(this.userName, contact.userName) && Objects.equals(this.user, contact.user);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userName, this.user});
    }
}
