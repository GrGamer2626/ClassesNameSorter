package me.grgamer2626.classesNameSorter.application.common.usos.course;

import me.grgamer2626.classesNameSorter.usosAPI.client.CourseClient;
import me.grgamer2626.classesNameSorter.usosAPI.model.Course;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
	private static final int NUM = 20;
	private final CourseClient courseClient;
	
	@Autowired
	public CourseServiceImpl(CourseClient courseClient) {
		this.courseClient = courseClient;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Course> getAllCoursesAltForFaculty(String idFaculty) {
		List<Course> courseAlts = courseClient.fetchCourses(idFaculty, 0, -1, NUM);
		
		return new HashSet<>(courseAlts).stream().toList();
	}
	
	@Override
	public List<Course> getAllCourses(String idFaculty, String idAcademicTerm) {
		List<Course> courses = getAllCoursesAltForFaculty(idFaculty);
		
		List<Course> currentCourses = new ArrayList<>();
		for (Course course : courses) {
			List<String> idsTerms = course.getTerms().stream()
					.map(map -> map.get("id"))
					.toList();
			
			if(idsTerms.contains(idAcademicTerm)) {
				currentCourses.add(course);
			}
		}
		
		return currentCourses;
	}
	
	@Override
	public List<CourseEdition> getCourseEditions(List<Course> courses, String idAcademicTerm) {
		List<CourseEdition> courseEditions = new ArrayList<>();
		for(Course course :  courses) {
			try {
				CourseEdition courseEdition = courseClient.fetchCourseEdition(course.getIdCourse(), idAcademicTerm);
				courseEditions.add(courseEdition);
				
			}catch (Exception e) {
				System.out.println(course.getIdCourse());
				e.printStackTrace();
			}
		}
		return courseEditions;
	}
}
