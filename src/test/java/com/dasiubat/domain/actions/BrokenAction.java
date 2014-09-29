package com.dasiubat.domain.actions;

import com.dasiubat.domain.Movie;

import javax.persistence.Entity;

/**
 * Created by adam-bat-usr on 29/09/2014.
 */
@Entity
public class BrokenAction extends ActionNotRelatedToCase<Movie> {
    @Override
    public boolean isRelatedToCase() {
        return false;
    }

    @Override
    public String propertyToString(Movie model, String property) {
        throw null;
    }
}

