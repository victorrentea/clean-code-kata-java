package videostore;

import java.util.stream.Collectors;

public class StatementFormatter {

    private final Customer customer;

    public StatementFormatter(Customer customer) {
        this.customer = customer;
    }

    public String getGeneratedStatement() {
        String header = "Rental Record for " + customer.getName();
        String body = generateStatementBody();
        String footer = "Amount owed is " + customer.generateCosts() +
                "\nYou earned " + customer.generateRenterPoints() + " frequent renter points";
        return header + "\n" + body + "\n" + footer;
    }

    private String generateStatementBody() {
        return customer.getRentals().stream().map(this::generateRentalStatement).collect(Collectors.joining("\n"));
    }

    private String generateRentalStatement(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice();
    }
}
