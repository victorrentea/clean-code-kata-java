package videostore;

import org.apache.commons.lang.StringUtils;

public class Movie {
    public enum Category {
        REGULAR {
            @Override
            public double computeAmount(int daysRented) {
                double rentalAmount = 2;
                if (daysRented > 2) {
                    rentalAmount += (daysRented - 2) * 1.5;
                }
                return rentalAmount;
            }
        },
        NEW_RELEASE {
            @Override
            public double computeAmount(int daysRented) {
                return daysRented * 3;
            }
        },
        CHILDREN {
            @Override
            public double computeAmount(int daysRented) {

                double rentalAmount = 1.5d;
                if (daysRented > 3) {
                    rentalAmount += (daysRented - 3) * 1.5;
                }
                return rentalAmount;
            }
        };

        public abstract double computeAmount(int daysRented);
    }

    private final String title;
    private final Category priceCode;

    public Movie(String title, Category priceCode) {
        if (StringUtils.isBlank(title) || priceCode == null) {
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
