package com.dasiubat.service;

import com.dasiubat.domain.Movie;
import com.dasiubat.domain.actions.Action;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Adam on 2014-05-06.
 */

@Service
@Transactional
public class ActionService {
    @Autowired
    private MovieService movieService;

    List<String> actionProperties = Arrays.asList("title");

    public void audit(Movie movie) {
        String s = null;
        boolean flag = s.equals(null);
        Movie original = movieService.findOriginalOne(movie.getId());
        try {
            Map<String, Object> map = PropertyUtils.describe(movie);
            Map<String, Object> originalMap = PropertyUtils.describe(original);
            Collection<String> properties = map.keySet();

            List<String> modifiedProperties = modifiedProperties(map, originalMap);

            Action action = Action.create(modifiedProperties);
            if ()


        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("fds");
        // get original entity from db using new session
        // map entity to property map
        // map orginal to property map

        // get tracked fields
        // compare
    }

    private List<String> modifiedProperties(Map<String, Object> first, Map<String, Object> second) {
        List<String> modifiedProperties = new ArrayList<>();
        for (String property : first.keySet()) {
            if (isModified(property, first, second)) {
                modifiedProperties.add(property);
            }
        }

        return modifiedProperties;
    }

    private boolean isModified(String property, Map<String, Object> first, Map<String, Object> second) {
        Object firstVal = first.get(property);
        Object secondVal = second.get(property);

        return !firstVal.equals(secondVal);
    }
}
