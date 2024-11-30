package org.example.api;


import lombok.RequiredArgsConstructor;
import org.example.dto.CourseDTO;
import org.example.model.Course;
import org.example.service.CourseService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping(value = "/get-course-list")
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping(value = "/add-course")
    public CourseDTO addCourse(@RequestBody CourseDTO course) {
        return courseService.addCourse(course);
    }




}
