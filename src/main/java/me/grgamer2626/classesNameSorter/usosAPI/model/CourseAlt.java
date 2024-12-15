package me.grgamer2626.classesNameSorter.usosAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CourseAlt {
	@JsonProperty("course_id")
	private String idCourse;
	@JsonProperty("match")
	private String courseName;
	
	
	public CourseAlt() {
	}
	
	public CourseAlt(String idCourse, String courseName) {
		this.idCourse = idCourse;
		this.courseName = courseName;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdCourse() {
		return idCourse;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseAlt courseAlt = (CourseAlt) o;
		return Objects.equals(idCourse, courseAlt.idCourse) &&
				Objects.equals(courseName, courseAlt.courseName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCourse, courseName);
	}
	
	@Override
	public String toString() {
		return "CourseAlt{" +
				"idCourse='" + idCourse + '\'' +
				", courseName='" + courseName + '\'' +
				'}';
	}
}
