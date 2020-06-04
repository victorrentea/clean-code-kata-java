package videostore;

import java.util.*;
import java.util.stream.Collectors;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<> ();

    public Customer (String name) {
        this.name = name;
    }

    public void addRental (Rental arg) {
        rentals.add (arg);
    }

    public String statement () {
        StringBuilder result = new StringBuilder ("Rental Record for " + name + "\n");
        result.append (getFiguresForRental ());
        double totalPrice = rentals.stream ().mapToDouble (this::computePrice).sum ();
        result.append (getFooterLines (totalPrice, computeTotalFrequentPoints ()));
        return result.toString ();
    }

    private String getFiguresForRental () {
        return rentals.stream ()
                .map (this::formatStatementLine)
                .collect (Collectors.joining ());
    }

    private String formatStatementLine (final Rental rental) {
        return String.format ("\t%s\t%s\n", rental.getMovie ().getTitle (), computePrice (rental));
    }

    String getFooterLines (final double totalPrice, final int frequentRenterPoints) {
        return String.format ("Amount owed is %s\nYou earned %s frequent renter points", totalPrice, frequentRenterPoints);
    }


    private int computeTotalFrequentPoints () {
        return this.rentals.stream ()
                .mapToInt (Rental::computeFrequentPoints)
                .sum ();
    }

    private double computePrice (Rental rental) {
        return rental.getMovie ().getCategory ().compute (rental);
    }

}
