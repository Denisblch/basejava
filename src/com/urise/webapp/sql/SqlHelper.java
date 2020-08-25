package com.urise.webapp.sql;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.StorageException;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    public final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public <T> T execution(String string, SqlExecution<T> se) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(string)) {
            return se.execution(ps);
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                //System.out.println(e.getSQLState());
                throw new ExistStorageException(e);
            }
            throw new StorageException(e);
        }
    }
}
