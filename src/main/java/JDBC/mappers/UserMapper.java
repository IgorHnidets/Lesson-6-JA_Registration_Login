package JDBC.mappers;

import JDBC.entiti.Role;
import JDBC.entiti.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper {
    public static User mapUsersFromResultSet(ResultSet resultSet) throws SQLException{
       User user = null;
        while (resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirstname(resultSet.getString(2));
            user.setLastname(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setRole(Role.valueOf(resultSet.getString(6)));
        }
        return user;
    }

}
