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
         double thisAmount = 0;
         Rental each = rentals.next();
         // determine amounts for each line
         switch (each.getMovie().getPriceCode()) {
            case REGULAR:
               thisAmount += 2;
               if (each.getDaysRented() > 2)
                  thisAmount += (each.getDaysRented() - 2) * 1.5;
               break;
            case NEW_RELEASE:
               thisAmount += each.getDaysRented() * 3;
               break;
            case CHILDRENS:
               thisAmount += 1.5;
               if (each.getDaysRented() > 3)

                  thisAmount += (each.getDaysRented() - 3) * 1.5;
               break;
         }
         // add frequent renter points
         frequentRenterPoints++;
         // add bonus for a two day new release rental
         if ((each.getMovie().getPriceCode() == Movie.Category.NEW_RELEASE)
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