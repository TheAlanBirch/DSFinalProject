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

    public PhoneContact(String searchKey, int number, String givenName, String surname, String streetAddress, String city, String state, int zipCode, String emailAddress, String telephoneNumber) {

        SearchKey = searchKey;
        Number = number;
        GivenName = givenName;
        Surname = surname;
        StreetAddress = streetAddress;
        City = city;
        State = state;
        ZipCode = zipCode;
        EmailAddress = emailAddress;
        TelephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneContact [Number=" + Number + ", GivenName=" + GivenName
                + ", Surname=" + Surname + ", StreetAddress=" + StreetAddress
                + ", City=" + City + ", State=" + State + ", ZipCode="
                + ZipCode + ", EmailAddress=" + EmailAddress
                + ", TelephoneNumber=" + TelephoneNumber + "]";
    }
}
