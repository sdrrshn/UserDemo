package UserDemo.core;

import UserDemo.Google.GoogleManager;
import UserDemo.entities.concretes.User;

public class GoogleManagerAdapter implements GoogleService{

    @Override
    public void addGoogle(String message) {
        GoogleManager googleManager=new GoogleManager();
        googleManager.Google(message);



    }
}
