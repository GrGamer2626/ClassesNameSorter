package me.grgamer2626.classesNameSorter.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course {
	@JsonProperty("id")
	private String idCourse;
	@JsonProperty("name")
	private Map<String,String> courseName;
	@JsonProperty("terms")
	private List<Map<String, String>> terms;

	public Course() {
	}
	
	public Course(String idCourse, Map<String,String>  courseName, List<Map<String, String>> terms) {
		this.idCourse = idCourse;
		this.courseName = courseName;
		this.terms = terms;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getIdCourse() {
		return idCourse;
	}
	
	public String getCourseName(String lang) {
		return courseName.get(lang);
	}
	
	public List<Map<String, String>> getTerms() {
		return terms;
	}
	
	public void setTerms(List<Map<String, String>> terms) {
		this.terms = terms;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Course course = (Course) obj;
		return Objects.equals(idCourse, course.idCourse) &&
				Objects.equals(courseName, course.courseName) &&
				Objects.equals(terms, course.terms);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCourse, courseName, terms);
	}
	
	@Override
	public String toString() {
		return "Course{" +
				"idCourse='" + idCourse + '\'' +
				", courseName=" + courseName +
				", terms=" + terms +
				'}';
	}
}
