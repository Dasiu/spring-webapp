package com.dasiubat.domain.actions;

import com.dasiubat.domain.CustomObject;
import com.dasiubat.domain.Movie;

import javax.persistence.Entity;

@Entity
public class MovieEditedAction extends ActionNotRelatedToCase<Movie> {
    @Override
    public boolean isRelatedToCase() {
        return false;
    }

    @Override
    public String propertyToString(Movie movie, String property) {
        switch (property) {
            case "title":
                return movie.getTitle();
            case "customObject":
                CustomObject customObject = movie.getCustomObject();
                return (customObject != null) ? customObject.toString() : "";
            default: throw new RuntimeException();
        }
    }
}
