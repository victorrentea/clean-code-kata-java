package videostore;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return movie.getCategory().getPrice(daysRented);
    }

    public int getRentalPoints() {
        return qualifiesForExtraRentalPoint() ? 2 : 1;
    }

    private boolean qualifiesForExtraRentalPoint() {
        return movie.getCategory() == Category.NEW_RELEASE &&
                daysRented > 1;
    }

}