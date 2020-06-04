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

    public boolean hasBonusPoint() {
        return movie.getPriceCode() == Movie.Category.NEW_RELEASE && daysRented > BONUS_DAYS_THRESHOLD;
    }

    public int getPoints() {
        return hasBonusPoint() ? 2 : 1;
    }

    public double computeAmount() {
        return movie.getPriceCode().computeAmount(daysRented);
    }

    public String toString() {
        return movie.getTitle() + "\t" + computeAmount() + "\n";
    }
}
