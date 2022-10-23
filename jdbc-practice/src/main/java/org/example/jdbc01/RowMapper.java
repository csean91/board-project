package org.example.jdbc01;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * packageName    : org.example.jdbc01
 * fileName       : RowMapper
 * author         : swch
 * date           : 2022-09-30
 * description    :
 */
public interface RowMapper {
    Object map(ResultSet resultSet) throws SQLException;
}
