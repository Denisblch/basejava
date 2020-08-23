package com.urise.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlExecution<T> {
    T execution(PreparedStatement ps) throws SQLException;
}
