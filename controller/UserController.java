package exam.controller;

import exam.exception.WrongUserException;
import exam.model.User;
import exam.service.UserService;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public List<User> usersList() {
        return userService.usersList();
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void signin(User user) throws WrongUserException {
        userService.signin(user);
    }

    public void signup(User user) throws WrongUserException {
        userService.signup(user);
    }
}
