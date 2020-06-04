package videostore;

import java.util.*;

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
      double totalAmount = 0;
      int frequentRenterPoints = 0;
      Iterator<Rental> rentals = this.rentals.iterator();
      String result = "Rental Record for " + getName() + "\n";
      while (rentals.hasNext()) {
         Rental each = rentals.next();
         // determine amounts for each line
         double thisAmount = each.getPrice();
         // add frequent renter points
         frequentRenterPoints++;
         // add bonus for a two day new release rental
         if ((each.getMovie().getCategory() == Category.NEW_RELEASE)
             && each.getDaysRented() > 1)
            frequentRenterPoints++;
         // show figures for this rental
         result += "\t" + each.getMovie().getTitle() + "\t"
             + thisAmount + "\n";
         totalAmount += thisAmount;
      }
      // add footer lines
      result += "Amount owed is " + totalAmount + "\n";
      result += "You earned " + String.valueOf(frequentRenterPoints)
          + " frequent renter points";
      return result;
   }

}