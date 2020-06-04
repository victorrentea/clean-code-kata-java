package videostore;

import org.apache.commons.lang.StringUtils;

public class Movie {
  public enum Category {
    CHILDREN,
    REGULAR,
    NEW_RELEASE
  }
  private final String title;
  private final Category priceCode;

  public Movie(String title, Category priceCode) {
    if (StringUtils.isBlank(title) || priceCode == null){
      throw new IllegalArgumentException();
    }
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
