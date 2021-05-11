package UserDemo.dataAccess.concretes;

import UserDemo.dataAccess.abstracts.UserDal;
import UserDemo.entities.concretes.User;

import java.util.List;

public class AbcUserDal implements UserDal {
    @Override
    public void add(User user) {
        System.out.println("abc ile Kaydedildi");

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getId(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEmail(String email) {
        return null;
    }
}
