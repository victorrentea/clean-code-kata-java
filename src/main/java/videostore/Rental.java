package videostore;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getPrice() {
        return movie.getCategory().getPrice(daysRented);
    }

    public int getPoints() {
        int frequentRenterPoints = 1;
        if ((movie.getCategory() == Movie.Category.NEW_RELEASE) && daysRented > 1) {
            frequentRenterPoints += 1;
        }
        return frequentRenterPoints;
    }
}