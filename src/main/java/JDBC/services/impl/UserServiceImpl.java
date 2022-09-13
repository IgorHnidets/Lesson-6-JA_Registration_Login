package JDBC.services.impl;


import JDBC.dao.UserDao;
import JDBC.entiti.User;
import JDBC.exceptions.IncorectCredentialException;
import JDBC.models.UserCredentials;
import JDBC.services.UserService;

import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


//  TODO implement login method using method getByEmail from DAO
    @Override
    public User login(UserCredentials userCredentials) throws IncorectCredentialException {
        try {
            Optional<User> getbyEmail = userDao.getbyEmail(userCredentials.getEmail());
            if (getbyEmail.isPresent()){
                User user = getbyEmail.get();

                if (user.getPassword().equals(userCredentials.getPassword())){
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        throw new IncorectCredentialException();
    }

    @Override
    public void save(User user) {
        try {
            userDao.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    @Override
//    public void save(Car user) {
//        try {
//            carDao.save(user);
//        } catch (SQLException e){
//           throw new  e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void remove(int id) {
//        try {
//            carDao.remove(id);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
}
