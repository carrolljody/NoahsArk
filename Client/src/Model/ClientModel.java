package Model;


import utility.observer.listener.LocalListener;
import utility.observer.subject.LocalSubject;

public interface ClientModel extends
    LocalListener<String, String>,
    CreateProfileModel,
    EditProfileModel,
    FAQModel,
    ForumModel,
    FriendsModel,
    HomeModel,
    LoginModel,
    ProfileModel,
    SearchModel
{
   void loadFromServer();
}
