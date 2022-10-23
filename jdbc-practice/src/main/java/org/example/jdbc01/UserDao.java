package org.example.jdbc01;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * packageName    : org.example
 * fileName       : UserDao
 * author         : swch
 * date           : 2022-09-29
 * description    :
 */
public class UserDao {

    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, new PreparedStatementSetter() {
            @Override
            public void setter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getUserId());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getName());
                preparedStatement.setString(4, user.getEmail());
            }
        });

        // JdbcTemplate의 executeUpdate 함수로 이동하고 PreparedStatementSetter를 만들어 위 코드와 같이 해결
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = ConnectionManager.getConnection();
//            String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUserId());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getName());
//            preparedStatement.setString(4, user.getEmail());
//
//            preparedStatement.executeUpdate();
//        } finally {
//            if (preparedStatement != null)
//                preparedStatement.close();
//            if (connection != null)
//                connection.close();
//        }
    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
        User user = (User) jdbcTemplate.executeQuery(sql,
                pstmt -> {
                    pstmt.setString(1, userId);
                }, resultSet -> new User(
                        resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                ));
        return user;

        // JdbcTemplate의 executeQuery 함수로 이동하고 위 코드와 같이 해결결
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = ConnectionManager.getConnection();
//            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, userId);
//            resultSet = preparedStatement.executeQuery();
//
//            User user = null;
//            if (resultSet.next()) {
//                user = new User(resultSet.getString("userId"), resultSet.getString("password"),
//                        resultSet.getString("name"), resultSet.getString("email"));
//            }
//            return user;
//        } finally {
//            if (resultSet != null)
//                resultSet.close();
//            if (preparedStatement != null)
//                preparedStatement.close();
//            if (connection != null)
//                connection.close();
//        }
    }
}
