package UserDemo.business.abstracts;

import UserDemo.entities.concretes.User;

import java.util.List;

public interface UserService {
    boolean add(User user);
    void update(User user);
    void delete(User user);
    boolean sigin(User user);
    User getId(int id   );
    List<User> getAll();
    User getEmail(String email);


}
