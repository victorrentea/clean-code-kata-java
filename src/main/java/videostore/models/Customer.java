package videostore.models;

public class Customer {

    public Customer(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
