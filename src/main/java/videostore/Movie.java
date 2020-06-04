package videostore;

public class Movie {
  private final String title;
  private final Category priceCode;

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