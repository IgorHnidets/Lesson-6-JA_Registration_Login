package JDBC.dao.impl;




import JDBC.connections.mySQLConnector;
import JDBC.dao.UserDao;
import JDBC.entiti.User;
import JDBC.mappers.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final Connection connection;

    public UserDaoImpl() {
        connection = mySQLConnector.getConnection();
    }

    @Override
    public Optional<User> getbyEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT id, first_name, last_name,email,password,role FROM user WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        User user = UserMapper.mapUsersFromResultSet(resultSet);

        statement.close();
        return Optional.ofNullable(user);
    }

    @Override
    public void insert(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO user(first_name, last_name,email,password, role) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, user.getFirstname());
        statement.setString(2, user.getLastname());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getRole().name());
        statement.execute();
        statement.close();
    }
}
