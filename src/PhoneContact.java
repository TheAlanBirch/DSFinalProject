public class PhoneContact {
    public String SearchKey;
    public int Number;
    public String GivenName;
    public String Surname;
    public String StreetAddress;
    public String City;
    public String State;
    public int ZipCode;
    public String EmailAddress;
    public String TelephoneNumber;

    public PhoneContact(int number, String givenName,
                        String surname, String streetAddress, String city,
                        String state, int zipCode, String emailAddress,
                        String telephoneNumber) {
        Number = number;
        GivenName = givenName;
        Surname = surname;
        StreetAddress = streetAddress;
        City = city;
        State = state;
        ZipCode = zipCode;
        EmailAddress = emailAddress;
        TelephoneNumber = telephoneNumber;
        SearchKey = GivenName + " " + Surname;
    }

    @Override
    public String toString() {
        return "ID #: " + Number + "\n" +
                "Last name: " + Surname + "\n" +
                "First name: " + GivenName + "\n" +
                "Phone #: " + TelephoneNumber + "\n" +
                "ZipCode: " + ZipCode;
    }
}
