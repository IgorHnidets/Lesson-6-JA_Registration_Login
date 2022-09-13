package JDBC.dao;


import JDBC.entiti.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public interface UserDao {
    Optional<User> getbyEmail(String email) throws SQLException;
    void insert(User user) throws SQLException;
}
