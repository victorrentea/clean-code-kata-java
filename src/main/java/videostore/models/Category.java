package videostore.models;

public enum Category {
    REGULAR {
        @Override
        public double computePrice(int daysRented) {
            double rentalPrice = 2;
            if (daysRented > 2) {
                rentalPrice += (daysRented - 2) * 1.5;
            }
            return rentalPrice;
        }
    },
    NEW_RELEASE {
        @Override
        public double computePrice(int daysRented) {
            return daysRented * 3;
        }
    },
    CHILDREN {
        @Override
        public double computePrice(int daysRented) {
            double rentalPrice = 1.5;
            if (daysRented > 3) {
                rentalPrice += (daysRented - 3) * 1.5;
            }
            return rentalPrice;
        }
    };

    public abstract double computePrice(int daysRented);

}
