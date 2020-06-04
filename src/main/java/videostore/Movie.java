package videostore;

public class Movie {
    public enum Category {
        CHILDREN() {
            @java.lang.Override
            public double getPrice(int daysRented) {
                if (daysRented > 3) {
                    return 1.5 + (daysRented - 3) * 1.5;
                }
                return 1.5;
            }
        },
        REGULAR() {
            @java.lang.Override
            public double getPrice(int daysRented) {
                if (daysRented > 2) {
                    return 2 + (daysRented - 2) * 1.5;
                } else {
                    return 2;
                }
            }
        },
        NEW_RELEASE() {
            @java.lang.Override
            public double getPrice(int daysRented) {
                return daysRented * 3;
            }
        };

        public abstract double getPrice(int daysRented);
    }

    private final String title;
    private final Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }
}