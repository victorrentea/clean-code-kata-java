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

   public String generateRentalRecord() {
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
        rentals.forEach(rental ->
                result.append("\t" + rental.getMovie().getTitle() + "\t" + rental.getPrice() + "\n")
        );
        result.append("Amount owed is " + generateCosts())
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