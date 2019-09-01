package exam.repo;

import exam.model.User;

import java.util.List;

import static exam.db.MockDB.users;

public class UserRepo {
    public List<User> usersList() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean signin(User user) {
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword() == user.getPassword()) return true;
        }
        return false;
    }
}
