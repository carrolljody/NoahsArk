package Model;

import java.util.ArrayList;

public interface FriendsModel extends UserModel
{
  ArrayList<String> getFriendsList(String username);
}
