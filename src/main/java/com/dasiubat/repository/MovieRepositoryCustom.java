package com.dasiubat.repository;

import com.dasiubat.domain.Movie;

/**
 * Created by Adam on 2014-05-06.
 */

public interface MovieRepositoryCustom {

    Movie findOriginalOne(Long id);
}
