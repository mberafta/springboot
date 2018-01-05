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
        jdbcTemplate.execute("CREATE TABLE USERS(id SERIAL, username VARCHAR(255), created TIMESTAMP)");

        String insertPart1 = "INSERT INTO USERS(username, created) VALUES(";
        String insertPart2 = ")";
        String date = "'2018-01-01 00:00:00.00'";
        jdbcTemplate.execute(insertPart1 + "'José'," + date + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'José 2'," + date + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'José 3'," + date + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'José 4'," + date + insertPart2);
        jdbcTemplate.execute(insertPart1 + "'José 5'," + date + insertPart2);
    }

    public List<UserEntity> findAll(){
        List<UserEntity> users = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM USERS", new Object[]{}, (rs, row) -> new UserEntity(rs.getString("username")))
        .forEach(entry -> users.add(entry));
        return users;
    }
}
