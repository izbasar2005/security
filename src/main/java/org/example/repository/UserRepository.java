package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
