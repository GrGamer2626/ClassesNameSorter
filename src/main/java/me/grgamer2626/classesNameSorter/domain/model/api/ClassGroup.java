package me.grgamer2626.classesNameSorter.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ClassGroup {
	@JsonProperty("course_unit_id")
	private String idClassGroup;
	@JsonProperty("number")
	private int number;
	
	public ClassGroup() {
	}
	
	public ClassGroup(String idClassGroup, int number) {
		this.idClassGroup = idClassGroup;
		this.number = number;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdClassGroup() {
		return idClassGroup;
	}
	
	public int getNumber() {
		return number;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		ClassGroup classGroup = (ClassGroup) o;
		return number == classGroup.number &&
				Objects.equals(idClassGroup, classGroup.idClassGroup);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idClassGroup, number);
	}
	
	@Override
	public String toString() {
		return "ClassGroup{" +
				"idClassGroup='" + idClassGroup + '\'' +
				", number=" + number +
				'}';
	}
}
