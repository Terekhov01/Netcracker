package task1.address;

import java.util.*;

class Data {
    List<Person> persons = new ArrayList<Person>();

    public Data() {
    }

    Data(List<Person> persons){
        this.persons = persons;
    }
    void add(Person... people){
        for (Person p : people){
            persons.add(p);
        }
    }
    void print(){
        for(Person p : persons){
            System.out.println(p);
        }
    }
    void searchByLastName(String lastName){
        int count = 0;
        for(Person p : persons){
            if (p.getLastName().equals(lastName)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void searchByCountry(String country){
        int count = 0;
        for(Person p : persons){
            if (p.getAddress().getCountry().equals(country)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void searchByCity(String city){
        int count=0;
        for(Person p : persons){
            if (p.getAddress().getCity().equals(city)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void searchByStreet(String street){
        int count=0;
        for(Person p : persons){
            if (p.getAddress().getStreet().equals(street)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void searchByAddress(Address address){
        int count=0;
        for(Person p : persons){
            if (p.getAddress().equals(address)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void printBetweenDates(Calendar c1, Calendar c2){
        int count = 0;
        for(Person p : persons){
            if(p.getBirthday().compareTo(c1) >= 0 && p.getBirthday().compareTo(c2) <= 0){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0){
            System.out.println("no such people");
        }
    }
    void youngest(){
        Person youngest = persons.get(0);
        for(Person p : persons){
            if(!p.getBirthday().before(youngest.getBirthday())){
                youngest = p;
            }
        }
        System.out.println(youngest);
    }
    void oldest(){
        Person old = persons.get(0);
        for(Person p : persons){
            if(p.getBirthday().before(old.getBirthday())){
                old = p;
            }
        }
        System.out.println(old);
    }
    void oneStreet(){
        /*
        В моей реализации жить на одной улицу = одинаковые адреса
         */
        Set<Address> streets2 = new HashSet<>();
        List<Person> people2 = new ArrayList<>();
        for(int i=0;i<persons.size();i++){
            if(streets2.contains(persons.get(i).getAddress())) continue;
            people2.add(persons.get(i));
            for(int j=i+1;j<persons.size();j++){
                if (persons.get(i).getAddress().equals(persons.get(j).getAddress())){
                    people2.add(persons.get(j));
                    streets2.add(persons.get(i).getAddress());
                }
            }
            if(people2.size() > 1)
                for(Person p : people2){
                    System.out.println(p);
                }
            people2.clear();
        }
    }
}
