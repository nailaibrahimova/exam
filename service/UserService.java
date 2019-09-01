package exam.service;

import exam.exception.WrongUserException;
import exam.model.User;
import exam.repo.UserRepo;

import java.util.List;

public class UserService {
    private UserRepo userRepo = new UserRepo();

    public List<User> usersList() {
        return userRepo.usersList();
    }

    public void addUser(User user) {
        userRepo.addUser(user);
    }

    public void signin(User user) throws WrongUserException {
        if (userRepo.signin(user) == false) throw new WrongUserException("Wrong login or password!!!! Try again");
    }

    public void signup(User user) throws WrongUserException {
        if (usersList().contains(user)) {
            throw new WrongUserException("Such user exists");
        } else {
            userRepo.addUser(user);
        }
    }
}
