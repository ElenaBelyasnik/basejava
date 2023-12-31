package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Sinleton instance = Sinleton.valueOf("INSTANCE");
        System.out.println(instance.name());
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Sinleton {
        INSTANCE
    }
}
