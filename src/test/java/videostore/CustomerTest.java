package videostore;

import org.junit.Assert;
import org.junit.Test;
import videostore.contollers.StatementController;
import videostore.models.Category;
import videostore.models.Customer;
import videostore.models.Movie;
import videostore.models.Rental;

import java.util.Arrays;
import java.util.List;


public class CustomerTest {
    @Test
    public void characterizationTest() {
        Customer customer = new Customer("John Doe");
        List<Rental> rentals = Arrays.asList(
                new Rental(new Movie("Star Wars", Category.NEW_RELEASE), 6),
                new Rental(new Movie("Sofia", Category.CHILDREN), 7),
                new Rental(new Movie("Inception", Category.REGULAR), 5)
        );
        StatementController statementController = new StatementController();
        
        String expected = "Rental Record for John Doe\n"
                + "	Star Wars	18.0\n"
                + "	Sofia	7.5\n"
                + "	Inception	6.5\n"
                + "Amount owed is 32.0\n"
                + "You earned 4 frequent renter points";
        
        Assert.assertEquals(expected, statementController.getStatement(customer.getName(), rentals));
    }
}
