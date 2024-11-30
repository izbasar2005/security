package org.example.mapper;

import org.example.dto.CourseDTO;
import org.example.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "name",target = "courseName")
//    @Mapping(target = "price", ignore = true)
    CourseDTO toDto(Course course);

    @Mapping(source = "courseName",target ="name")
    Course toModel(CourseDTO courseDTO);


    List<CourseDTO> toDtoList(List<Course> courseList);

    List<Course> toModelList(List<CourseDTO> courseList);

}
