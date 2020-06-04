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
      double totalAmount = 0;
      int frequentRenterPoints = 0;

      Iterator<Rental> rentals = this.rentals.iterator();
      String result = "Rental Record for " + getName() + "\n";
      while (rentals.hasNext()) {
         Rental rental = rentals.next();
         // determine amounts for rental line
         double thisAmount = computeAmmount (rental);
         // add frequent renter points
         frequentRenterPoints++;
         if (rental.shouldAddBonus ())
            frequentRenterPoints++;
         // show figures for this rental
         result += "\t" + rental.getMovie().getTitle() + "\t"
             + thisAmount + "\n";
         totalAmount += thisAmount;
      }
      // add footer lines
      result += "Amount owed is " + totalAmount + "\n";
      result += "You earned " + frequentRenterPoints
          + " frequent renter points";
      return result;
   }

   private double computeAmmount (Rental each) {
      double thisAmount = 0;
      Movie.Category priceCode = each.getMovie ().getPriceCode ();

      switch (priceCode) {
         case REGULAR:
            thisAmount += 2;
            if (each.getDaysRented() > 2)
               thisAmount += (each.getDaysRented() - 2) * 1.5;
            break;
         case NEW_RELEASE:
            thisAmount += each.getDaysRented() * 3;
            break;
         case CHILDREN:
            thisAmount += 1.5;
            if (each.getDaysRented() > 3)
               thisAmount += (each.getDaysRented() - 3) * 1.5;
            break;
      }
      return thisAmount;
   }
}