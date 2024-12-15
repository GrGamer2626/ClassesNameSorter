package me.grgamer2626.classesNameSorter.usosAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Lecturer {
	@JsonProperty("id")
	private String idLecturer;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("user_id")
	private String idUser;
	
	public Lecturer() {
	}
	
	public Lecturer(String lecturerId, String firstName, String lastName, String idUser) {
		this.idLecturer = lecturerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idUser = idUser;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdLecturer() {
		return idLecturer;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getIdUser() {
		return idUser;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		Lecturer lecturer = (Lecturer) o;
		return Objects.equals(idLecturer, lecturer.idLecturer) &&
				Objects.equals(firstName, lecturer.firstName) &&
				Objects.equals(lastName, lecturer.lastName) &&
				Objects.equals(idUser, lecturer.idUser);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idLecturer, firstName, lastName, idUser);
	}
	
	@Override
	public String toString() {
		return "Lecturer{" +
				"idLecturer='" + idLecturer + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", idUser='" + idUser + '\'' +
				'}';
	}
}
