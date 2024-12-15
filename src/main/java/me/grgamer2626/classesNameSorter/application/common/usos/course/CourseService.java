package me.grgamer2626.classesNameSorter.application.common.usos.course;

import me.grgamer2626.classesNameSorter.usosAPI.model.Course;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;

import java.util.List;

public interface CourseService {
	
	List<Course> getAllCoursesAltForFaculty(String idFaculty);
	List<Course> getAllCourses(String idFaculty, String idAcademicTerm);
	List<CourseEdition> getCourseEditions(List<Course> courses, String idAcademicTerm);
}
