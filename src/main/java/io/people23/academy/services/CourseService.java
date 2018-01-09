package io.people23.academy.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.people23.academy.models.Course;

public interface CourseService {

	List<Course> findAll();

	Page<Course> findPaginated(String filter, Pageable pageable);

	Course findOne(Integer id);

	Course create(Course course);

	Course update(Integer id, Course course);

	String delete(Integer id);

}
