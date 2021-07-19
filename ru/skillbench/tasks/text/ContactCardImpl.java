package ru.skillbench.tasks.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContactCardImpl implements ContactCard{
    private String fn;
    private String org;
    private Map<String, String> data = new HashMap<>();
    public ContactCardImpl(Scanner scanner){
        getInstance(scanner);
    }
    public ContactCardImpl(String data){
        getInstance(data);
    }
    public ContactCardImpl(){}
    @Override
    public ContactCard getInstance(Scanner scanner) {
        boolean beginPresence = false;
        boolean endPresence = false;
        boolean fnPresence = false;
        boolean orgPresence = false;
        String s;
        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            if(!s.contains(":")){
                throw new InputMismatchException();
            }
            String[] tmp = s.split(":");
            if(s.equals("BEGIN:VCARD")){
                beginPresence = true;
            } else if(s.equals("END:VCARD")){
                endPresence = true;
            } else if(tmp[0].equals("FN")){
                fnPresence = true;
                fn = tmp[1];
            } else if(tmp[0].equals("ORG")){
                orgPresence = true;
                org = tmp[1];
            } else if(tmp[0].contains("TEL") && !tmp[1].matches("\\d{10}")){
                throw new InputMismatchException();
            } else if(tmp[0].equals("BDAY") && !tmp[1].matches("\\d{2}-\\d{2}-\\d{4}")){
                throw new InputMismatchException();
            } else if(tmp[0].equals("GENDER") && !(tmp[1].equals("F") || tmp[1].equals("M"))){
                throw new InputMismatchException();
            } else {
                data.put(tmp[0], tmp[1]);
            }
        }
        if(!beginPresence || !endPresence || !fnPresence || !orgPresence){
            throw new NoSuchElementException();
        }
        return this;
    }

    @Override
    public ContactCard getInstance(String data) {
        return getInstance(new Scanner(data));
    }

    @Override
    public String getFullName() {
        return fn;
    }

    @Override
    public String getOrganization() {
        return org;
    }

    @Override
    public boolean isWoman() {
        if(data.containsKey("GENDER")){
            return data.get("GENDER").equals("F");
        }
        return false;
    }

    @Override
    public Calendar getBirthday() {
        if (!data.containsKey("BDAY")){
            throw new NoSuchElementException();
        }
        Calendar calendar = null;
        Date date;
        try {
            String dateString = data.get("BDAY");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = dateFormat.parse(dateString);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    @Override
    public Period getAge() {
        if (!data.containsKey("BDAY")){
            throw new NoSuchElementException();
        }
        LocalDate current = LocalDate.now();
        String dateString = data.get("BDAY");
        LocalDate bday = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return Period.between(bday, current);
    }

    @Override
    public int getAgeYears() {
        if (!data.containsKey("BDAY")){
            throw new NoSuchElementException();
        }
        LocalDate current = LocalDate.now();
        String dateString = data.get("BDAY");
        LocalDate bday = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return Period.between(bday, current).getYears();
    }

    @Override
    public String getPhone(String type) {
        for(String key : data.keySet()){
            if(key.contains("TEL")){
                String foundType = key.split("=")[1];
                if(foundType.equals(type)){
                    char[] tmp = data.get(key).toCharArray();
                    return "(" + tmp[0] + tmp[1] + tmp[2] +
                            ") " + tmp[3] + tmp[4] + tmp[5] +
                            "-" + tmp[6] + tmp[7] + tmp[8] + tmp[9];
                }
            }
        }
        throw new NoSuchElementException();
    }
}
