package ru.javawebinar.basejava.web;

import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.AbstractStorage;
import ru.javawebinar.basejava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        //response.setHeader("Content-Type", "text/html; charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write(
                """
                        <html>
                        <head>
                            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                            <link rel="stylesheet" href="css/style.css">
                            <title>Список всех резюме</title>
                        </head>
                        <body>
                        <section>
                        <table border="1" cellpadding="8" cellspacing="0">
                            <tr>
                                <th>Имя</th>
                                <th>Email</th>
                            </tr>
                        """);
        for (Resume resume : storage.getAllSorted()) {
            writer.write(
                    "<tr>\n" +
                            "     <td><a href=\"resume?uuid=" + resume.getUuid() + "\">" + resume.getFullName() + "</a></td>\n" +
                            "     <td>" + resume.getContact(ContactType.MAIL) + "</td>\n" +
                            "</tr>\n");
        }
        writer.write("""
                </table>
                </section>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) {

    }
}
