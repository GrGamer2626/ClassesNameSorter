package me.grgamer2626.classesNameSorter.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class ClassType {
	@JsonProperty("id")
	private String idClassType;
	@JsonProperty("name")
	private Map<String, String> name;
	
	public ClassType() {
	}
	
	public ClassType(String idClassType, Map<String, String> name) {
		this.idClassType = idClassType;
		this.name = name;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdClassType() {
		return idClassType;
	}
	
	public String getName(String lang) {
		return name.get(lang);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		ClassType classType = (ClassType) o;
		return Objects.equals(idClassType, classType.idClassType) &&
				Objects.equals(name, classType.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idClassType, name);
	}
	
	@Override
	public String toString() {
		return "ClassType{" +
				"idClassType='" + idClassType + '\'' +
				", name=" + name +
				'}';
	}
}
