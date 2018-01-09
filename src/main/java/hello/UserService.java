package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData() {
        jdbcTemplate.execute("DROP TABLE USERS IF EXISTS");
        jdbcTemplate
                .execute("CREATE TABLE USERS(id SERIAL, username VARCHAR(255), role  VARCHAR(255), created TIMESTAMP)");

        String insertPart1 = "INSERT INTO USERS(username, created, role) VALUES(";
        String insertPart2 = ")";
        String date = "'2018-01-01 00:00:00.00'";

        jdbcTemplate.execute(insertPart1 + "'User'," + date + "," + "'ADMIN'," + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'User 2'," + date + "," + "'ADMIN'," + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'User 3'," + date + "," + "'SUPER ADMIN'," + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'User 4'," + date + "," + "'ADMIN'," + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'User 5'," + date + "," + "'NOOB'," + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'User 6'," + date + "," + "'ADMIN'," + insertPart2);
    }

    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        jdbcTemplate
                .query("SELECT * FROM USERS", new Object[] {},
                        (rs, row) -> new UserEntity(rs.getString("username"), rs.getString("role")))
                .forEach(entry -> users.add(entry));
        return users;
    }

    public UserEntity findByUserame(String username) {
        String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
        UserEntity user = (UserEntity) jdbcTemplate.queryForObject(sql, new Object[] { username },
                (rs, row) -> new UserEntity(rs.getString("username"), rs.getString("role")));
        return user;
    }

}
