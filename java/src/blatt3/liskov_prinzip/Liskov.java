package blatt3.liskov_prinzip;

import java.util.Collection;
import java.util.LinkedList;

class NoUsernameException extends RuntimeException {
    public NoUsernameException() {
        super("Not registered user has no username");
    }
}

class NoEmailException extends RuntimeException {
    public NoEmailException() {
        super("Not registered user has no email");
    }
}

class User {
    private static int ID = 0;
    protected String _username;
    protected String _email;
    protected final int _id;

    public User() {
        this(null, null);
    }

    public User(String username) {
        this(username, null);
    }

    public User(String username, String email) {
        this._username = username;
        this._email = email;
        this._id = ID++;
    }

    /**
     * Get the username of this user. This will never be null!
     */
    public String getUsername() {
        if(this._username == null) {
            throw new NoUsernameException();
        } else {
            return this._username;
        }
    }

    /**
     * Get the email of this user. This will never be null!
     */
    public String getEmail() {
        if(this._email == null) {
            throw new NoEmailException();
        } else {
            return this._email;
        }
    }

    /**
     * returns generated ID of this user
     */
    public int getID(){
        return this._id;
    }

    public void printUser() {
        if(this._username == null && this._email == null) {
            System.out.println("_id=" + this.getID() + ", _username={NULL}" + ", _email={NULL}");
        } else {
            try {
                System.out.println("_id=" + this.getID() + ", _username=" + this.getUsername() + ", _email=" + this.getEmail());
            } catch(NoUsernameException e) {
                System.out.println("_id=" + this.getID() + ", _username={NULL}" + ", _email=" + this.getEmail());
            } catch(NoEmailException e) {
                System.out.println("_id=" + this.getID() + ", _username=" + this.getUsername() + ", _email={NULL}");
            }
        }
    }
}

class EnterpriseUser extends User {
    private String _personalAssistant;

    public EnterpriseUser(String username, String personalAssistant) {
        super(username);
        this._personalAssistant = personalAssistant;
    }

    public String getPersonalAssistant() {
        return this._personalAssistant;
    }

    @Override
    public void printUser() {
        System.out.println("_id=" + this.getID() + ", _username=" + this.getUsername() + ", _personalAssistant=" + this.getPersonalAssistant());
    }
}


public class Liskov {
    public static void main(String[] args) {
        final Collection<User> users = new LinkedList<>();
        users.add(new EnterpriseUser("enterprise-customer", "CEO"));
        users.add(new User("max", "max.mustermann@mail.io"));
        users.add(new User());
        users.add(new User("test1"));
        users.add(new User(null, "testmail2"));

        for (final User user : users) {
            user.printUser();
        }
    }

}
