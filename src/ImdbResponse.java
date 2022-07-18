import java.util.List;

public class ImdbResponse {

  private List<FilmData> items;
  private String errorMessage;

  public List<FilmData> getItems() {
    return items;
  }

  public void setItems(List<FilmData> items) {
    this.items = items;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
  
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
}
