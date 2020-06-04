package videostore;

public class Rental {
  private final static int BONUS_DAYS_THRESHOLD = 1;

  private final Movie movie;
  private final int daysRented;

  public Rental(Movie movie, int daysRented) {
    if (movie == null || daysRented == 0) {
      throw new IllegalArgumentException();
    }
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public boolean hasBonusPoint(){
    return this.movie.getPriceCode() == Movie.Category.NEW_RELEASE && this.daysRented > BONUS_DAYS_THRESHOLD;
  }
}
