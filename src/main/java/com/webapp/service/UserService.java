package com.webapp.service;

import com.webapp.domain.User;
import com.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }
}
