package UserDemo.dataAccess.abstracts;

import UserDemo.entities.concretes.User;

import java.util.List;

public interface UserDal {
    void add(User user);
    void update(User user);
    void delete(User user);
    User getId(int id);
    List<User>getAll();
    User getEmail(String email);

}
