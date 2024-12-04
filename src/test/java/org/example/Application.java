package org.example;


import org.example.dto.CourseDTO;


import org.example.mapper.CourseMapper;
import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApp {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void checkCourseDto() {
        Course course = new Course();
        course.setId(777L);
        course.setName("Java EE");
        course.setDescription("Very Good");
        course.setPrice(8988);

        CourseDTO courseDTO = courseMapper.toDto(course);

        Assertions.assertEquals(course.getName(), courseDTO.getCourseName());
        Assertions.assertEquals(course.getId(), courseDTO.getId());
        Assertions.assertEquals(course.getDescription(), courseDTO.getDescription());
        Assertions.assertEquals(course.getPrice(), courseDTO.getPrice());
    }


    @Test
    void checkInsertIntoDb() {

        courseRepository.deleteAll();

        String courseName = "Java EE";
        String courseDescription = "Very Good";
        int coursePrice = 8988;

        Course course = new Course();
        course.setName(courseName);
        course.setDescription(courseDescription);
        course.setPrice(coursePrice);

        CourseDTO newCourse=courseService.addCourse(courseMapper.toDto(course));

        Assertions.assertNotNull(newCourse);
        Assertions.assertNotNull(newCourse.getId());
        Assertions.assertEquals(courseName, newCourse.getCourseName());
        Assertions.assertEquals(courseDescription, newCourse.getDescription());
        Assertions.assertEquals(coursePrice, newCourse.getPrice());

        courseService.deleteCourse(newCourse.getId());
    }
}


