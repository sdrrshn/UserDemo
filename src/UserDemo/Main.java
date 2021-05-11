package UserDemo;

import UserDemo.Google.GoogleManager;
import UserDemo.business.abstracts.UserService;
import UserDemo.business.concretes.UserManager;
import UserDemo.core.GoogleManagerAdapter;
import UserDemo.dataAccess.concretes.AbcUserDal;
import UserDemo.entities.concretes.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("15454335");
        user.setEmail("sidarsahin817@gmail.com");
        user.setId(1);
        user.setName("s54654");
        user.setLastName("şahin");

        UserService userService = new UserManager(new AbcUserDal(),new GoogleManagerAdapter());

        userService.sigin(user);








    }
}
