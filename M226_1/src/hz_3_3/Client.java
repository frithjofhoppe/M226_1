package hz_3_3;

public class Client {
    private String firstName;
    private String lastName;
    private int clientNr;

    public Client(String firstName, String lastName, int clientNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientNr = clientNr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getClientNr() {
        return clientNr;
    }
}
