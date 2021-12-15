package Model;

public interface LoginModel extends UserModel
{
  void login(String username, String password);
}
