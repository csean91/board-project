package org.example;

import org.example.jdbc01.ConnectionManager;
import org.example.jdbc01.User;
import org.example.jdbc01.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.example
 * fileName       : UserDaoTest
 * author         : swch
 * date           : 2022-09-29
 * description    :
 */
public class UserDaoTest {
    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        // Dao : Data Access Object
        UserDao userDao = new UserDao();
        userDao.create(new User("testId", "password", "name", "email"));
        User user = userDao.findByUserId("testId");
        assertThat(user).isEqualTo(new User("testId", "password", "name", "email"));
    }
}
