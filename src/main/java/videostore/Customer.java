package videostore;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

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
        StatementBuilder builder = new StatementBuilder(name, rentals);
        return builder.build();
    }
}
