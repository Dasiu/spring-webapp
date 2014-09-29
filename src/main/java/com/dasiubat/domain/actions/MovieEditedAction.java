package com.dasiubat.domain.actions;

import com.dasiubat.domain.Movie;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class MovieEditedAction extends ActionNotRelatedToCase<Movie> {
    @Override
    public String propertyToString(Movie movie, String property) {
        switch (property) {
            case "title":
                return movie.getTitle();
            case "roles":
                return (Arrays.toString(movie.getRoles().toArray()));
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public Collection<String> getExcludedProperties() {
        return Arrays.asList("address");
    }
}
