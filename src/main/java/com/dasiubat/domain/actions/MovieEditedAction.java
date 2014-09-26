package com.dasiubat.domain.actions;

import com.dasiubat.domain.BaseModel;
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
            case "title": movie.getTitle();
        }
        return "";
    }
}
