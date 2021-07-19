package ru.skillbench.tasks.basics.entity;

public class Main {
    public static void main(String[] args) {
        Location location = new LocationImpl();
        location.setType(Location.Type.BUILDING);
        location.setName("10 к. 1");
        System.out.println(location.getAddress());
    }
}
