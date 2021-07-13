package task1.address;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar1 = new GregorianCalendar(2001, 0,14);
        Address address1 = new Address("Russia", "Moscow", "Lenina");
        Person p1 = new Person("Alexey", "Volkov", calendar1, address1);

        Calendar calendar2 = new GregorianCalendar(1999, 3,5);
        Address address2 = new Address("Russia", "Moscow", "Lenina");
        Person p2 = new Person("Sergey", "Petrov", calendar2, address2);

        Calendar calendar3 = new GregorianCalendar(1975, 5,6);
        Address address3 = new Address("Italy", "Rome", "Main");
        Person p3 = new Person("ItalicName", "ItalicSurname", calendar3, address3);

        Calendar calendar4 = new GregorianCalendar(2006, 9,25);
        Address address4 = new Address("USA", "New-York", "Wall");
        Person p4 = new Person("Jhon", "Walker", calendar4, address4);

        Data data = new Data();
        data.add(p1,p2,p3,p4);

        data.print();
        System.out.println("\n");

        System.out.println("SEARCHING last name: ItalicSurname");
        data.searchByLastName("ItalicSurname");

        System.out.println("SEARCHING city: NY");
        data.searchByCity("New-York");

        System.out.println("SEARCHING country: Russia");
        data.searchByCountry("Russia");

        System.out.println("SEARCHING street: Wall");
        data.searchByStreet("Wall");

        System.out.println("SEARCHING city: Zelenograd");
        data.searchByCity("Zelenograd");

        System.out.println("BETWEEN DATES: 13.07.1990 AND 25.09.2007");
        data.printBetweenDates(new GregorianCalendar(1990,6,13),
                new GregorianCalendar(2007, 8, 26));

        System.out.println("YOUNGEST:");
        data.youngest();

        System.out.println("OLDEST: ");
        data.oldest();

        System.out.println("ON ONE STREET: ");
        data.oneStreet();
    }
}
