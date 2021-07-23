package task3.phone;

public class Phone {
    String phone;
    int areaCode;
    public Phone(String number){
        if(number.matches("\\+[1-9][0-9]*\\d{10}")){
            areaCode = Integer.parseInt(number.substring(1,number.length() - 10));
            phone = number.substring(number.length() - 10);
        }
        else if(number.matches("8\\d{10}")){
            areaCode = 7;
            phone = number.substring(1);
        }
    }

    @Override
    public String toString() {
        return "+" + areaCode + phone.substring(0,3) + "-" + phone.substring(3, 6) +
                "-" + phone.substring(6);
    }
}
