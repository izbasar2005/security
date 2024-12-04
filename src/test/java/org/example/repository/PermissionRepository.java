package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
