package videostore;

public enum Category {
    CHILDREN {
        @Override
        public double getPrice(int rentedDays) {
            double amount = 1.5;
            if (rentedDays > 3) {
                amount += (rentedDays - 3) * 1.5;
            }
            return amount;
        }
    },
    REGULAR {
        @Override
        public double getPrice(int rentedDays) {
            double amount = 2.0;
            if (rentedDays > 2) {
                amount += (rentedDays - 2) * 1.5;
            }
            return amount;
        }
    },
    NEW_RELEASE {
        @Override
        public double getPrice(int rentedDays) {
            return rentedDays * 3.0;
        }
    };

    public abstract double getPrice(int rentedDays);

}
