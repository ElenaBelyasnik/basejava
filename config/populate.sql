INSERT INTO public.resume (uuid, full_name)
VALUES ('1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'Name1');
INSERT INTO public.resume (uuid, full_name)
VALUES ('bfb2e618-55e7-4e90-8dc2-4298452085d1', 'Name2');
INSERT INTO public.resume (uuid, full_name)
VALUES ('85325bd1-b76a-42e4-9801-adcdf55ab345', 'Name3');

INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3023, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'PHONE', '+7(921) 855-0482');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3024, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'MOBILE', '+7 921 222-22-22');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3025, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'SKYPE', 'NewSkype');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3026, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'MAIL', 'mail1@google.com');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3027, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'LINKEDIN',
        'https://www.linkedin.com/in/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3028, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'GITHUB', 'https://github.com/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3029, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'STATCKOVERFLOW',
        'https://stackoverflow.com/users/548473');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3030, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'HOME_PAGE', 'http://gkislin.ru/');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3031, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'PHONE', '+7(921) 855-0482');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3032, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'SKYPE', 'skype:grigory.kislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3033, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'MAIL', 'gkislin@yandex.ru');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3034, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'LINKEDIN',
        'https://www.linkedin.com/in/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3035, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'GITHUB', 'https://github.com/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3036, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'STATCKOVERFLOW',
        'https://stackoverflow.com/users/548473');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3037, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'HOME_PAGE', 'http://gkislin.ru/');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3038, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'PHONE', '+7(921) 855-0482');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3039, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'SKYPE', 'skype:grigory.kislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3040, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'MAIL', 'gkislin@yandex.ru');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3041, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'LINKEDIN',
        'https://www.linkedin.com/in/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3042, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'GITHUB', 'https://github.com/gkislin');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3043, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'STATCKOVERFLOW',
        'https://stackoverflow.com/users/548473');
INSERT INTO public.contact (id, resume_uuid, type, value)
VALUES (3044, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'HOME_PAGE', 'http://gkislin.ru/');

INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (384, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'OBJECTIVE',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (379, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'PERSONAL',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (380, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'OBJECTIVE',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (381, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'ACHIEVEMENT',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет","С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.","Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.","Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.","Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.","Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).","Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."]}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (382, '1da5f60b-a06f-4a8f-b508-bc1c115abfc9', 'QUALIFICATIONS',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2","Version control: Subversion, Git, Mercury, ClearCase, Perforce","DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB","Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy","XML/XSD/XSLT, SQL, C/C++, Unix shell scripts","Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).","Python: Django.","JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js","Scala: SBT, Play2, Specs2, Anorm, Spray, Akka","Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.","Инструменты: Maven + plugin development, Gradle, настройка Ngnix","администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer","Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования","Родной русский, английский \"upper intermediate\""]}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (383, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'PERSONAL',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (385, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'ACHIEVEMENT',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет","С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.","Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.","Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.","Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.","Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).","Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."]}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (386, 'bfb2e618-55e7-4e90-8dc2-4298452085d1', 'QUALIFICATIONS',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2","Version control: Subversion, Git, Mercury, ClearCase, Perforce","DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB","Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy","XML/XSD/XSLT, SQL, C/C++, Unix shell scripts","Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).","Python: Django.","JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js","Scala: SBT, Play2, Specs2, Anorm, Spray, Akka","Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.","Инструменты: Maven + plugin development, Gradle, настройка Ngnix","администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer","Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования","Родной русский, английский \"upper intermediate\""]}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (387, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'PERSONAL',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (388, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'OBJECTIVE',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.TextSection","INSTANCE":{"content":"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (389, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'ACHIEVEMENT',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет","С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.","Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.","Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.","Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.","Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).","Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."]}}');
INSERT INTO public.section (id, resume_uuid, type, content)
VALUES (390, '85325bd1-b76a-42e4-9801-adcdf55ab345', 'QUALIFICATIONS',
        '{"CLASSNAME":"ru.javawebinar.basejava.model.ListSection","INSTANCE":{"items":["JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2","Version control: Subversion, Git, Mercury, ClearCase, Perforce","DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB","Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy","XML/XSD/XSLT, SQL, C/C++, Unix shell scripts","Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).","Python: Django.","JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js","Scala: SBT, Play2, Specs2, Anorm, Spray, Akka","Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.","Инструменты: Maven + plugin development, Gradle, настройка Ngnix","администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer","Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования","Родной русский, английский \"upper intermediate\""]}}');

