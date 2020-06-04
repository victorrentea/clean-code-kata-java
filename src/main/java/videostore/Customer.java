package videostore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(rentals);
    }

    public String generateRentalRecord() {
        return new StatementFormatter(this).getGeneratedStatement();
    }

    public double generateCosts() {
        return rentals.stream().mapToDouble(Rental::getPrice).sum();
    }

    public int generateRenterPoints() {
        return rentals.stream().mapToInt(Rental::getRentalPoints).sum();
    }

}