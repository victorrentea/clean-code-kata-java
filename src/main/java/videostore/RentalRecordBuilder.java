package videostore;

import java.util.*;

public class RentalRecordBuilder {
    private final Customer customer;

    public RentalRecordBuilder(Customer customer) {
        this.customer = customer;
    }

    public String build() {
        String header = headerLines();
        String body = bodyLines();
        String footer = footerLines();
        return header + body + footer;
    }

    private String headerLines() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    private String bodyLines() {
        String body = "";
        for (Rental rental: customer.getRentals()) {
            body += "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice() + "\n";
        }
        return body;
    }

    private String footerLines() {
        double totalPrice = 0;
        int frequentRenterPoints = 0;

        for (Rental rental: customer.getRentals()) {
            frequentRenterPoints += rental.getPoints();
            totalPrice += rental.getPrice();
        }

        String result = "Amount owed is " + totalPrice + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
