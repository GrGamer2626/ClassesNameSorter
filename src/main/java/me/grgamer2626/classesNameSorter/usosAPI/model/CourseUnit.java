package me.grgamer2626.classesNameSorter.usosAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class CourseUnit {
	@JsonProperty("id")
	private String idCourseUnit;
	@JsonProperty("class_groups")
	private List<ClassGroup> classGroups;
	public CourseUnit() {
	}
	
	public CourseUnit(String idCourseUnit, List<ClassGroup> classGroups) {
		this.idCourseUnit = idCourseUnit;
		this.classGroups = classGroups;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getIdCourseUnit() {
		return idCourseUnit;
	}
	
	public List<ClassGroup> getClassGroups() {
		return classGroups;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		CourseUnit that = (CourseUnit) o;
		return Objects.equals(idCourseUnit, that.idCourseUnit) && Objects.equals(classGroups, that.classGroups);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idCourseUnit, classGroups);
	}
	
	@Override
	public String toString() {
		return "CourseUnit{" +
				"idCourseUnit='" + idCourseUnit + '\'' +
				", classGroups=" + classGroups +
				'}';
	}
}
