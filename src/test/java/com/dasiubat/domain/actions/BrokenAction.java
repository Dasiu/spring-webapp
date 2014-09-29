package com.dasiubat.domain.actions;

import com.dasiubat.domain.Movie;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by adam-bat-usr on 29/09/2014.
 */
@Entity
public class BrokenAction extends ActionNotRelatedToCase<Movie> {
    @Override
    public String propertyToString(Movie model, String property) {
        throw null;
    }

    @Override
    public Collection<String> getExcludedProperties() {
        return new ArrayList<>();
    }
}

