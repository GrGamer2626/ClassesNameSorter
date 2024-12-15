package me.grgamer2626.classesNameSorter.usosAPI.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.grgamer2626.classesNameSorter.usosAPI.model.ClassType;
import me.grgamer2626.classesNameSorter.usosAPI.model.Course;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;

import java.util.List;

public interface CourseClient {
	List<ClassType> fetchAllClassesType() throws JsonProcessingException;
	Course fetchCourse(String idCourse);
	List<Course> fetchCourses(String idFaculty, int start, int stop, int num);
	CourseEdition fetchCourseEdition(String idCourse, String idTerm);
}
