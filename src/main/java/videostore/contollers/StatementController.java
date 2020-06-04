package videostore.contollers;

import videostore.models.Rental;

import java.util.List;
import java.util.stream.Collectors;

public class StatementController {

    public String getStatement(String customerName, List<Rental> rentals) {
        String result = "Rental Record for " + customerName + "\n";
        int frequentRenterPoints = rentals.stream().mapToInt(Rental::computePoints).sum();
        result += rentals.stream().map(this::getRentalRow).collect(Collectors.joining());
        double totalPrice = rentals.stream().mapToDouble(Rental::computePrice).sum();
        return result + getFooter(totalPrice, frequentRenterPoints);
    }

    private String getRentalRow(Rental rental) {
        return String.format("\t%s\t%s\n", rental.getMovie().getTitle(), rental.computePrice());
    }

    private String getFooter(double totalPrice, int frequentRenterPoints) {
        return "Amount owed is " + totalPrice + "\n"
                + "You earned " + frequentRenterPoints
                + " frequent renter points";
    }
}
