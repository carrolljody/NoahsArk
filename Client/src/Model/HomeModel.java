package Model;

import Model.Home.ArticleList;

public interface HomeModel extends UserModel
{
  ArticleList getArticles();

}
