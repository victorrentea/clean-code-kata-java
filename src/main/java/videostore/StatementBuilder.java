package videostore;

import java.util.*;

public class StatementBuilder {

    private final String name;
    private final List<Rental> rentals;

    public StatementBuilder(String name, List<Rental> rentals) {
        //TODO add validations?
        this.name = name;
        this.rentals = rentals;
    }

    public String build() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        String result = "Rental Record for " + name + "\n";
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            double thisAmount = each.getPrice();
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getCategory() == Movie.Category.NEW_RELEASE)
                    && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        return result + addFooterLines(totalAmount, frequentRenterPoints);
    }

    private String addFooterLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }


}
