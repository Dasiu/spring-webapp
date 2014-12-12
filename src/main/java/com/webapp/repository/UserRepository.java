package com.webapp.repository;

import com.icupad.repository.BaseRepository;
import com.webapp.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByLogin(String login);
}
