package ru.javawebinar.basejava.sql;

import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.sql.Connection;

public interface ConnectionFactory  {
    Connection getConnection() throws SQLException;
}
