package org.example.jdbc01;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * packageName    : org.example.jdbc01
 * fileName       : PreparedStatementSetter
 * author         : swch
 * date           : 2022-09-30
 * description    :
 */
public interface PreparedStatementSetter {
    void setter(PreparedStatement preparedStatement) throws SQLException;
}
