package me.grgamer2626.classesNameSorter.domain.model;

public class Lecturer {
	
	private String lecturerId;
	private String first_name;
	private String last_name;
	
	public Lecturer(String lecturerId, String first_name, String last_name) {
		this.lecturerId = lecturerId;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getLecturerId() {
		return lecturerId;
	}
	
	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}
