package ru.javawebinar.basejava.sql;

import org.postgresql.util.PSQLException;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.sql.SQLException;

public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static StorageException convertException(SQLException e) {
        // https://www.postgresql.org/docs/current/errcodes-appendix.html
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageException(null);
            }
        }
        return new StorageException(e);
    }

    public static StorageException convertException(SQLException e, Resume r) {
        // https://www.postgresql.org/docs/current/errcodes-appendix.html
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageException(r.getUuid());
            }
        }
        return new StorageException(e);
    }

}
