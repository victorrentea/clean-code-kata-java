package videostore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatementFormatter {

    private final String customerName;
    private final List<Rental> rentals = new ArrayList<>();

    public StatementFormatter(String customerName, List<Rental> rentals) {
        this.customerName = customerName;
        this.rentals.addAll(rentals);
    }

    public String getGeneratedStatement() {
        return generateHeader() + "\n" + generateStatementBody() + "\n" + generateFooter();
    }

    private String generateFooter() {
        return "Amount owed is " + generateCosts() +
                "\nYou earned " + generateRenterPoints() + " frequent renter points";
    }

    private String generateHeader() {
        return "Rental Record for " + customerName;
    }

    private String generateStatementBody() {
        return rentals.stream().map(this::generateRentalStatement).collect(Collectors.joining("\n"));
    }

    private String generateRentalStatement(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice();
    }

    public double generateCosts() {
        return rentals.stream().mapToDouble(Rental::getPrice).sum();
    }

    public int generateRenterPoints() {
        return rentals.stream().mapToInt(Rental::getRentalPoints).sum();
    }
}
