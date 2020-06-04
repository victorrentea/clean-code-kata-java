package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getPoints();

            result.append("\t").append(rental.toString());
            totalAmount += rental.computeAmount();
        }
        result.append(getFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n"
                + "You earned " + frequentRenterPoints
                + " frequent renter points";
    }
}
