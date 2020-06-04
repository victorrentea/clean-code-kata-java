package videostore;

public class Movie {
  public enum Category {
    CHILDRENS,
    REGULAR,
    NEW_RELEASE
  }
  private String title;
  private Category priceCode;

  public Movie(String title, Category priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public Category getPriceCode() {
    return priceCode;
  }


  public String getTitle() {
    return title;
  }
}