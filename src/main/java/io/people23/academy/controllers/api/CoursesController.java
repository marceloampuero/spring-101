package io.people23.academy.controllers.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.people23.academy.models.Course;
import io.people23.academy.repositories.CourseRepository;
import io.people23.academy.services.CourseService;

@Controller
@RequestMapping("/api/courses")
public class CoursesController {

	private static Logger logger = LoggerFactory.getLogger(CoursesController.class);

	private CourseRepository repository;

	private CourseService service;

	@Autowired
	private CoursesController(CourseService service) {
		this.service = service;
	}

	// Return paginated list of courses
	@GetMapping
	public @ResponseBody Page<Course> home(Pageable pageable, String filter) {

		logger.info("Controller Find Page");

		return this.service.findPaginated(filter, pageable);

	}

	// Return all courses, for use in select lists
	@GetMapping("/all")
	public @ResponseBody List<Course> all() {

		return this.service.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Course findById(@PathVariable(value = "id") Integer id) {

		return this.service.findOne(id);

	}

	@PostMapping
	public @ResponseBody Course create(@Valid @RequestBody Course model) {

		return this.service.create(model);

	}

	@PutMapping("/{id}")
	public @ResponseBody Course update(@PathVariable(value = "id") Integer id, @RequestBody Course course) {

		return this.service.update(id, course);

	}

	@DeleteMapping("/{id}")
	public @ResponseBody String delete(@PathVariable(value = "id") Integer id) {

		return this.service.delete(id);

	}

}
