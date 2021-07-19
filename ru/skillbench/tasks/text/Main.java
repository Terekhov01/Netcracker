package ru.skillbench.tasks.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

class Base{
    void test(){
        System.out.println("Base");
    }
}

public class Main extends Base{
    void test(){
        System.out.println("Child");
    }
    public static void main(String[] args) throws ParseException {
        Main child = new Main();
        Base base = (Base) child;
        base.test();
    }
}
