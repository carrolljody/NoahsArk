package View.SearchStrategy;

import Model.ClientModel;
import Model.SearchModel;
import ViewModel.SearchViewModel;

public interface Strategy
{
  void search(SearchViewModel vm, SearchModel model);
}
