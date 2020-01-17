package repository.impl;

import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import repository.UserRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User logIn(String username, String password) {

        try {
        String query = "select * from user WHERE username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(query, new Object[]{username,password}, new UserMapper());
        return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public boolean register(User user) {
        try {
            String query = "INSERT INTO user VALUES (?,?,?,?,?)";
            jdbcTemplate.update("INSERT INTO user VALUES (?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getFirstname(),
                    user.getLastname(),user.getEmail());
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error trying to add new user");
            return false;
        }
    }

    @Override
    public String doesExist(User user) {
        try {
            String query = "select * from user WHERE username = ?";
            if(!jdbcTemplate.query(query, new Object[]{user.getUsername()}, new UserMapper()).isEmpty())
                return "Username already taken";
            query = "select * from user WHERE email = ?";
            if(!jdbcTemplate.query(query, new Object[]{user.getEmail()}, new UserMapper()).isEmpty())
                return "Account with this email already exists";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
        return "OK";
    }

    class UserMapper implements RowMapper<User>{

        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
}
