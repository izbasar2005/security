package org.example.repository;


import jakarta.transaction.Transactional;
import org.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course ,Long> {
}
