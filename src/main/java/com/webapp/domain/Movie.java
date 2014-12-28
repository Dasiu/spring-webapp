package com.webapp.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends AuditableEntity {
    private String title;

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        return !(title != null ? !title.equals(movie.title) : movie.title != null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
