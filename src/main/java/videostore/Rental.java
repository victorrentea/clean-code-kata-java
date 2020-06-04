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

        switch (this.getMovie().getCategory()) {
            case REGULAR:
                if (this.getDaysRented() > 2) {
                    return 2 + (this.getDaysRented() - 2) * 1.5;
                } else {
                    return 2;
                }
            case NEW_RELEASE:
                return this.getDaysRented() * 3;
            case CHILDREN:
                if (this.getDaysRented() > 3) {
                    return 1.5 + (this.getDaysRented() - 3) * 1.5;
                }
                return 1.5;
            default:
                return 0;
        }
    }

    public int getPoints() {
        int frequentRenterPoints = 1;
        if ((movie.getCategory() == Movie.Category.NEW_RELEASE) && daysRented > 1) {
            return frequentRenterPoints + 1;
        } else {
            return frequentRenterPoints;
        }
    }
}