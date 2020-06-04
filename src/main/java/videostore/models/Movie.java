package videostore.models;

import org.apache.commons.lang.StringUtils;

public class Movie {
    private final String title;
    private final Category category;

    public Movie(String title, Category category) {
        if (StringUtils.isBlank(title) || category == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }
}
