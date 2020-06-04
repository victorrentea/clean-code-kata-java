package videostore;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<> ();

    public Customer (String name) {
        this.name = name;
    }

    public void addRental (Rental arg) {
        rentals.add (arg);
    }

    public String getName () {
        return name;
    }

    public String statement () {
        double totalPrice = 0;
        int frequentRenterPoints = computeTotalFrequentPoints ();

        StringBuilder result = new StringBuilder ("Rental Record for " + name  + "\n");

        for (final Rental rental : rentals) {
            // determine amounts for rental line
            double price = computeAmount (rental);
            // show figures for this rental
            result.append ("\t").append (rental.getMovie ().getTitle ()).append ("\t").append (price).append ("\n");
            totalPrice += price;
        }

        // add footer lines
        getFooterLines (totalPrice, frequentRenterPoints, result);
        return result.toString ();
    }

    void getFooterLines (final double totalPrice, final int frequentRenterPoints, final StringBuilder result) {
        result.append ("Amount owed is ").append (totalPrice).append ("\n");
        result.append ("You earned ").append (frequentRenterPoints).append (" frequent renter points");
    }


    private int computeTotalFrequentPoints () {
        return this.rentals.stream ()
                .mapToInt (Rental::computeFrequentPoints)
                .sum ();
    }

    private double computeAmount (Rental each) {
        double thisAmount = 0;
        Movie.Category priceCode = each.getMovie ().getPriceCode ();

        switch (priceCode) {
            case REGULAR:
                thisAmount += 2;
                if (each.getDaysRented () > 2)
                    thisAmount += (each.getDaysRented () - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += each.getDaysRented () * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (each.getDaysRented () > 3)
                    thisAmount += (each.getDaysRented () - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
