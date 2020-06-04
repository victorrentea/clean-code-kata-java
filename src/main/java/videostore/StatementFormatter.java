package videostore;

import java.util.stream.Collectors;

public class StatementFormatter {

    private final Customer customer;

    public StatementFormatter(Customer customer) {
        this.customer = customer;
    }

    public String getGeneratedStatement() {
        return generateHeader() + "\n" + generateStatementBody() + "\n" + generateFooter();
    }

    private String generateFooter() {
        return "Amount owed is " + customer.generateCosts() +
                "\nYou earned " + customer.generateRenterPoints() + " frequent renter points";
    }

    private String generateHeader() {
        return "Rental Record for " + customer.getName();
    }


    private String generateStatementBody() {
        return customer.getRentals().stream().map(this::generateRentalStatement).collect(Collectors.joining("\n"));
    }

    private String generateRentalStatement(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice();
    }
}
