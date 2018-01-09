package io.people23.academy.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.people23.academy.models.Course;
import io.people23.academy.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private CourseRepository repository;

	@Autowired
	private CourseServiceImpl(CourseRepository repository) {
		this.repository = repository;
	}

	@Override
	public Page<Course> findPaginated(String filter, Pageable pageable) {
		logger.info("Paginated Courses");

		if (filter != null && !filter.isEmpty()) {
			return this.repository.findByNameContainingIgnoreCase(filter, pageable);
		}

		return this.repository.findAll(pageable);

	}

	@Override
	public List<Course> findAll() {
		logger.info("All Courses");
		return (List<Course>) this.repository.findAll();
	}

	@Override
	public Course findOne(Integer id) {
		logger.info("Find by Id");
		return this.repository.findOne(id);
	}

	@Override
	public Course create(Course course) {
		logger.info("Create Course");

		this.repository.save(course);

		return course;
	}

	@Override
	public Course update(Integer id, Course course) {
		logger.info("Update Course");
		Course c = this.repository.findOne(id);

		c.setName(course.getName());

		this.repository.save(c);

		return c;
	}

	@Override
	public String delete(Integer id) {
		logger.info("Delete Course");

		this.repository.delete(id);

		return "{\"message\": \"ok\"}";
	}

}
