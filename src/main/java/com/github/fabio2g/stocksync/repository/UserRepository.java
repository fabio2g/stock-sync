package com.github.fabio2g.stocksync.repository;

import com.github.fabio2g.stocksync.dto.UserDTO;
import com.github.fabio2g.stocksync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    User findByLogin(String login);
}
