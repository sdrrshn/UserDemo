package UserDemo.business.concretes;

import UserDemo.business.abstracts.UserService;
import UserDemo.core.GoogleService;
import UserDemo.dataAccess.abstracts.UserDal;
import UserDemo.entities.concretes.User;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    UserDal userDal;
    private GoogleService googleService;

    public UserManager(UserDal userDal,GoogleService googleService) {
        this.userDal = userDal;
         this.googleService = googleService;
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        if (CheckIfEmailValid(user.getEmail()) && ChekIfEMailEx(user.getEmail()))
            if (chekIfPassword(user.getPassword()))
                if (ChekIfNameAndLastName(user.getName(), user.getLastName())) {
                    System.out.println("Doğrulama e postası gönerildi.");


                } else System.out.println("adınız  ve soy adınız en az iki harf olmalıdır ");
            else System.out.println("şifreniz en az 6 karakterden oluşmalıdır.");
        else System.out.println("geçersiz e posta veya kullanılmış e posta olmamalıdır");
        if (emailVerification(user.getEmail())) {

            this.userDal.add(user);

            result = true;
        } else System.out.println("yanlış giriş");
        this.googleService.addGoogle("eklendi");


        return result;


    }

    @Override
    public void update(User user) {
        this.userDal.update(user);

    }

    @Override
    public void delete(User user) {
        this.userDal.delete(user);

    }

    @Override
    public boolean sigin(User user) {
        boolean result = false;
        if (user.getEmail() != null && user.getPassword() != null)
            result = true;
        System.out.println("sisteme giriş yapıldı");
        return result;


    }

    @Override
    public User getId(int id) {
        return this.userDal.getId(id);


    }

    @Override
    public List<User> getAll() {
        return this.userDal.getAll();

    }

    @Override
    public User getEmail(String email) {
        return this.userDal.getEmail(email);
    }





    public boolean chekIfPassword(String password) {
        boolean result = false;
        if (password.length() > 6)
            result = true;
        return result;
    }

    public boolean CheckIfEmailValid(String email) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            result = true;
        }
        return result;
    }

    public boolean ChekIfEMailEx(String email) {
        boolean result = false;
        if (this.userDal.getEmail(email) == null)
            result = true;


        return result;

    }

    public boolean ChekIfNameAndLastName(String name, String lastName) {
        boolean result = false;
        if (name.length() >= 2 && lastName.length() >= 2)
            result = true;
        return result;
    }

    public boolean emailVerification(String Email) {
        boolean result = false;
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a < 10)
            result = true;
        return result;


    }


}
