package task3.address;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.setFieldsSplit("Cntr1,reg1,city1,street1,house1,building1,flat1");
        System.out.println(address1);

        Address address2 = new Address();
        address2.setFields("Cntr2;reg2;city2;street2;house2;building2;flat2");
        System.out.println(address2);

        Address address3 = new Address();
        address3.setFields("Cntr3.reg3.city3.street3.house3.building3.flat3");
        System.out.println(address3);

        Address address4 = new Address();
        address4.setFields("Cntr4-reg4-city4-street4-house4-building4-flat4");
        System.out.println(address4);
    }
}
