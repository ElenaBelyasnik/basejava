package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.storage.PathStorage;
import ru.javawebinar.basejava.storage.serializer.XmlStreamSerializer;

import java.io.*;
import java.time.Month;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = addResumeTestData(null, "Григорий Кислин");

        //resumeOutput(resume);
        resumeXmlOutput(resume, "C:\\TEMP\\resume.xml");
    }

    public static void resumeXmlOutput(Resume resume, String fileName) {
        XmlStreamSerializer xmlStreamSerializer = new XmlStreamSerializer();

        try (OutputStream os = new FileOutputStream(fileName)) {
            xmlStreamSerializer.doWrite(resume, os);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void resumeOutput(Resume resume) {
        // output...
        System.out.println(resume);

        // contacts
        System.out.println(resume.getContact(ContactType.PHONE));
        System.out.println(resume.getContact(ContactType.SKYPE));
        System.out.println(resume.getContact(ContactType.MAIL));
        System.out.println(resume.getContact(ContactType.LINKEDIN));
        System.out.println(resume.getContact(ContactType.GITHUB));
        System.out.println(resume.getContact(ContactType.STATCKOVERFLOW));
        System.out.println(resume.getContact(ContactType.HOME_PAGE));

        //Sections
        System.out.println(resume.getSection(SectionType.OBJECTIVE));
        System.out.println(resume.getSection(SectionType.PERSONAL));
        System.out.println(resume.getSection(SectionType.ACHIEVEMENT));
        System.out.println(resume.getSection(SectionType.QUALIFICATIONS));
        System.out.println(resume.getSection(SectionType.EXPERIENCE));
        System.out.println(resume.getSection(SectionType.EDUCATION));
    }

    public static Resume addResumeTestData(String uuid, String fullName) {
        Resume resume;
        if (uuid == null) {
            resume = new Resume(fullName);
        } else {
            resume = new Resume(uuid, fullName);
        }

        resume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.addContact(ContactType.STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addContact(ContactType.HOME_PAGE, "http://gkislin.ru/");


        resume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(
                "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет"
                , "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников."
                , "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."
                , "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."
                , "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга."
                , "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)."
                , "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"
                , "Version control: Subversion, Git, Mercury, ClearCase, Perforce"
                , "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB"
                , "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy"
                , "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts"
                , "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)."
                , "Python: Django."
                , "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js"
                , "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka"
                , "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT."
                , "Инструменты: Maven + plugin development, Gradle, настройка Ngnix"
                , "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer"
                , "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования"
                , "Родной русский, английский \"upper intermediate\""
        ));


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

        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(organization1, organization2));

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

        resume.addSection(SectionType.EDUCATION, new OrganizationSection(education1, education2));
        return resume;
    }
}
