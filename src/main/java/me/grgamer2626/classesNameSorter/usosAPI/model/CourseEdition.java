package me.grgamer2626.classesNameSorter.usosAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class CourseEdition {
	@JsonProperty("course")
	private Course course;
	@JsonProperty("term")
	private AcademicTerm academicTerm;
	@JsonProperty("course_units")
	private List<CourseUnit> courseUnits;
	
	public CourseEdition() {
	}
	
	public CourseEdition(List<CourseUnit> courseUnits) {
		this.courseUnits = courseUnits;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Course getCourse() {
		return course;
	}
	
	public AcademicTerm getAcademicTerm() {
		return academicTerm;
	}
	
	public List<CourseUnit> getCourseUnits() {
		return courseUnits;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		CourseEdition courseEdition = (CourseEdition) o;
		return Objects.equals(course, courseEdition.course) &&
				Objects.equals(academicTerm, courseEdition.academicTerm) &&
				Objects.equals(courseUnits, courseEdition.courseUnits);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(course, academicTerm, courseUnits);
	}
	
	@Override
	public String toString() {
		return "CourseEdition{" +
				"course=" + course +
				", academicTerm=" + academicTerm +
				", courseUnits=" + courseUnits +
				'}';
	}
}
