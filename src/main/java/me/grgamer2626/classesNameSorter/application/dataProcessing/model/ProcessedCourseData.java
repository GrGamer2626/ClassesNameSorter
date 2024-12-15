package me.grgamer2626.classesNameSorter.application.dataProcessing.model;

import java.util.List;
import java.util.Objects;

public class ProcessedCourseData {
	private String courseName;
	private List<String> fullLecturerNames;
	private int sharedCharacterPairs;
	
	public ProcessedCourseData(String courseName, List<String>  fullLecturerNames, int sharedCharacterPairs) {
		this.courseName = courseName;
		this.fullLecturerNames = fullLecturerNames;
		this.sharedCharacterPairs = sharedCharacterPairs;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public List<String> getFullLecturerName() {
		return fullLecturerNames;
	}
	
	public void setFullLecturerName(List<String> fullLecturerNames) {
		this.fullLecturerNames = fullLecturerNames;
	}
	
	public int getSharedCharacterPairs() {
		return sharedCharacterPairs;
	}
	
	public void setSharedCharacterPairs(int sharedCharacterPairs) {
		this.sharedCharacterPairs = sharedCharacterPairs;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		ProcessedCourseData processedCourseData = (ProcessedCourseData) o;
		return sharedCharacterPairs == processedCourseData.sharedCharacterPairs &&
				Objects.equals(courseName, processedCourseData.courseName) &&
				Objects.equals(fullLecturerNames, processedCourseData.fullLecturerNames);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseName, fullLecturerNames, sharedCharacterPairs);
	}
	
	@Override
	public String toString() {
		return "ProcessedCourseData{" +
				"courseName='" + courseName + '\'' +
				", fullLecturerNames=" + fullLecturerNames +
				", sharedCharacterPairs=" + sharedCharacterPairs +
				'}';
	}
}
