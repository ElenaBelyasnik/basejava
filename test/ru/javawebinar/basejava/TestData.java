package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");

        R4.addContact(ContactType.PHONE, "44444");
        R4.addContact(ContactType.SKYPE, "Skype");

        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));

        Organization organization1 = new Organization("Java Online Projects"
                , "http://javaops.ru/"
                , new Organization.Position(new Period(2013, Month.of(10))
                , "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.")
        );

        Organization organization2 = new Organization("Wrike"
                , "https://www.wrike.com/"
                , new Organization.Position(new Period(2014, Month.of(10), 2016, Month.of(1))
                , "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")
        );

        R1.addSection(SectionType.EXPERIENCE, new OrganizationSection(organization1, organization2));

        Organization education1 = new Organization("Coursera"
                , "http://javaops.ru/"
                , new Organization.Position(new Period(2013, Month.of(3), 2013, Month.of(5))
                , "'Functional Programming Principles in Scala' by Martin Odersky", "")
        );

        Organization education2 = new Organization("Luxoft"
                , "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"
                , new Organization.Position(new Period(2011, Month.of(3), 2011, Month.of(4))
                , "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", "")
        );

        R1.addSection(SectionType.EDUCATION, new OrganizationSection(education1, education2));


        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
    }
}
