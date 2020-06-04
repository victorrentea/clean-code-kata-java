package videostore;

import java.util.*;

public class RentalRecordBuilder {
    private final Customer customer;

    public RentalRecordBuilder(Customer customer) {
        this.customer = customer;
    }

    public String build() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = headerLines();
        for (Rental rental: customer.getRentals()) {
            frequentRenterPoints += rental.getPoints();
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice() + "\n";
            totalAmount += rental.getPrice();
        }

        return result + footerLines(totalAmount, frequentRenterPoints);
    }

    private String headerLines() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String footerLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
