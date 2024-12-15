package me.grgamer2626.classesNameSorter.usosAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Group {
	@JsonProperty("class_type_id")
	private String idClassType;
	@JsonProperty("course_name")
	private Map<String,String> courseName;
	@JsonProperty("lecturers")
	private List<Lecturer> lecturers;
	
	public Group() {
	}
	
	public Group(String idClassType, Map<String, String> courseName, List<Lecturer> lecturers) {
		this.idClassType = idClassType;
		this.courseName = courseName;
		this.lecturers = lecturers;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getIdClassType() {
		return idClassType;
	}
	
	public Map<String, String> getCourseName() {
		return courseName;
	}
	
	public List<Lecturer> getLecturers() {
		return lecturers;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		Group group = (Group) o;
		return Objects.equals(idClassType, group.idClassType) &&
				Objects.equals(courseName, group.courseName) &&
				Objects.equals(lecturers, group.lecturers);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idClassType, courseName, lecturers);
	}
	
	@Override
	public String toString() {
		return "Group{" +
				"idClassType='" + idClassType + '\'' +
				", courseName=" + courseName +
				", lecturers=" + lecturers +
				'}';
	}
}
