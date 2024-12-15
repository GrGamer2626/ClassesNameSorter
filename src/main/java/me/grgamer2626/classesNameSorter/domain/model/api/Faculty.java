package me.grgamer2626.classesNameSorter.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class Faculty {
	@JsonProperty("id")
	private String idFaculty;
	@JsonProperty("name")
	private Map<String,String> name;
	
	public Faculty() {
	}
	
	public Faculty(String idFaculty, Map<String, String> name) {
		this.idFaculty = idFaculty;
		this.name = name;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdFaculty() {
		return idFaculty;
	}
	
	public String getName(String lang) {
		return name.get(lang);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		Faculty faculty = (Faculty) o;
		return Objects.equals(idFaculty, faculty.idFaculty) &&
				Objects.equals(name, faculty.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idFaculty, name);
	}
	
	@Override
	public String toString() {
		return "Faculty{" +
				"idFaculty='" + idFaculty + '\'' +
				", name=" + name +
				'}';
	}
}
