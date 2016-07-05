package gl.test;

/**
 * Created by shwetaa on 04/07/2016.
 */
public class MyPersonDetails {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //private String firstName;
    private String id;

    private String firstName;
    private String lastName;

    public String toString(){
        return "Person{"+
                "firstName=" + firstName +
                        "}";
    }
}
