package videostore;

public class Movie {

    public enum Category {
        CHILDREN {
            @Override
            double compute (final Rental rental) {
                double price = 1.5;
                if (rental.getDaysRented () > 3) {
                    price += (rental.getDaysRented () - 3) * 1.5;
                }
                return price;
            }
        },
        REGULAR {
            @Override
            double compute (final Rental rental) {
                double price = 2;
                if (rental.getDaysRented () > 2) {
                    price += (rental.getDaysRented () - 2) * 1.5;
                }
                return price;
            }
        },
        NEW_RELEASE {
            @Override
            double compute (final Rental rental) {
                return rental.getDaysRented () * 3;
            }
        };

        abstract double compute (Rental rental);
    }

    private final String title;
    private final Category category;

    public Movie (String title, Category priceCode) {
        this.title = title;
        this.category = priceCode;
    }

    public Category getCategory () {
        return category;
    }

    public String getTitle () {
        return title;
    }

    boolean isNewRelease () {
        return this.category == Movie.Category.NEW_RELEASE;
    }
}