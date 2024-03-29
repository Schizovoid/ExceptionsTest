public class PersonalData {

    public String getSurname() {
        return surname;
    }

    String surname;

    public String getFirstName() {
        return firstName;
    }

    String firstName;

    public String getPatronymic() {
        return patronymic;
    }

    String patronymic;

    public String getDOB() {
        return DOB;
    }

    String DOB;

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    Long phoneNumber;

    public char getGender() {
        return gender;
    }

    char gender;

    public PersonalData(String surname, String firstName, String patronymic, String DOB, Long phoneNumber, char gender) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String toString(){
        return String.format("<%s> <%s> <%s> <%s> <%d> <%s> \n", this.getSurname(), this.getFirstName(), this.getPatronymic(), this.getDOB(), this.getPhoneNumber(),
                this.getGender());
    }
    public int getPhoneNumberLength(){
        return String.valueOf(this.phoneNumber).length();
    }
}
