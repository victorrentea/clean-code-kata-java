package videostore;

import java.util.*;

public class RentalRecordBuilder {

    private final String name;
    private final List<Rental> rentals;

    public RentalRecordBuilder(String name, List<Rental> rentals) {
        //TODO add validations?
        this.name = name;
        this.rentals = rentals;
    }

    public String build() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = headerLines();
        for (Rental rental: rentals) {
            frequentRenterPoints += rental.getPoints();
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice() + "\n";
            totalAmount += rental.getPrice();
        }

        return result + footerLines(totalAmount, frequentRenterPoints);
    }

    private String headerLines() {
        return "Rental Record for " + name + "\n";
    }

    private String footerLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
