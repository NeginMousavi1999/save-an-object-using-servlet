package service;

import dao.UserDao;
import enumuration.Gender;
import model.User;

/**
 * @author Negin Mousavi
 */
public class UserService {
    UserDao userDao = new UserDao();

    public int saveUser(String name, String family, String age, String gender, String pass) {
        Gender userGender;
        try {
            userGender = Gender.valueOf(gender);
        } catch (IllegalArgumentException e) {
            userGender = Gender.NOT_SET;
        }
        User user = User.builder()
                .firstName(name)
                .lastName(family)
                .age(age)
                .gender(userGender)
                .password(pass)
                .build();
        return userDao.save(user);
    }
}
