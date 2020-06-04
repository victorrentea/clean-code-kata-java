package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private final double REGULAR_COST = 2.0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
        rentals.forEach(rental ->
                result.append("\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice() + "\n")
        );
        result.append("Amount owed is " + this.generateCosts())
                .append("\nYou earned " + generateRenterPoints() + " frequent renter points");
        return result.toString();
    }

    private double generateCosts() {
        return rentals.stream().mapToDouble(Rental::getPrice).sum();
    }

    private int generateRenterPoints() {
        return rentals.stream().mapToInt(Rental::getRentalPoints).sum();
    }

}