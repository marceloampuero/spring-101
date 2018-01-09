package io.people23.academy.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.people23.academy.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);

	Page<Course> findAll(Pageable pageable);

}
