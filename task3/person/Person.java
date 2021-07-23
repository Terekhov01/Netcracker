package task3.person;

public class Person {
    private String name;
    private String surname;
    private String patronymic;

    public Person(String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Person(String surname){
        this.surname = surname;
        name = "";
        patronymic = "";
    }

    public String getFullName(){
        if(name.isEmpty() || patronymic.isEmpty()){
            return surname;
        }
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
