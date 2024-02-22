package ru.javawebinar.basejava.sql;

import java.sql.SQLException;
import java.sql.Connection;

public interface ConnectionFactory  {
    Connection getConnection() throws SQLException;
}
