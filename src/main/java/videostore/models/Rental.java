package videostore.models;

public class Rental {
    private final static int BONUS_DAYS_THRESHOLD = 1;

    private final Movie movie;
    private final int daysRented;

    public Movie getMovie() {
        return movie;
    }

    public Rental(Movie movie, int daysRented) {
        if (movie == null || daysRented == 0) {
            throw new IllegalArgumentException();
        }
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public boolean hasBonusPoint() {
        return movie.getCategory() == Category.NEW_RELEASE && daysRented > BONUS_DAYS_THRESHOLD;
    }

    public int computePoints() {
        return hasBonusPoint() ? 2 : 1;
    }

    public double computePrice() {
        return movie.getCategory().computePrice(daysRented);
    }
}
