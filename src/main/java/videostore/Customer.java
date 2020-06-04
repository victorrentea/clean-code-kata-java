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

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String generateRentalRecord() {
        return new StatementFormatter(name, Collections.unmodifiableList(rentals)).getGeneratedStatement();
    }
}