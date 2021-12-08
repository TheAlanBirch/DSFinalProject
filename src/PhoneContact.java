public class PhoneContact {
    public String SearchKey;
    public String Number;
    public String GivenName;
    public String Surname;
    public String StreetAddress;
    public String City;
    public String State;
    public String ZipCode;
    public String EmailAddress;
    public String TelephoneNumber;

    public PhoneContact(String number, String givenName,
                        String surname, String streetAddress, String city,
                        String state, String zipCode, String emailAddress,
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
    }

    public void setSearchKey(String searchKey) {
        SearchKey = searchKey;
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
