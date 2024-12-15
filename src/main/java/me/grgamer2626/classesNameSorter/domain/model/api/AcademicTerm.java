package me.grgamer2626.classesNameSorter.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class AcademicTerm {
	@JsonProperty("id")
	private String idAcademicTerm;
	@JsonProperty("name")
	private Map<String, String> name;
	@JsonProperty("start_date")
	private Date startDate;
	@JsonProperty("end_date")
	private Date endDate;
	@JsonProperty("order_key")
	private int orderKey;
	@JsonProperty("finish_date")
	private Date finishDate;
	@JsonProperty("is_active")
	private boolean active;
	
	
	public AcademicTerm() {
	}
	
	public AcademicTerm(String academicTermId, Map<String, String> name, Date startDate, Date endDate, int orderKey, Date finishDate, boolean active) {
		this.idAcademicTerm = academicTermId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderKey = orderKey;
		this.finishDate = finishDate;
		this.active = active;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getIdAcademicTerm() {
		return idAcademicTerm;
	}
	
	public Map<String, String> getName() {
		return name;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public int getOrderKey() {
		return orderKey;
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public boolean isActive() {
		return active;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		AcademicTerm academicTerm = (AcademicTerm) o;
		return orderKey == academicTerm.orderKey &&
				active == academicTerm.active &&
				Objects.equals(idAcademicTerm, academicTerm.idAcademicTerm) &&
				Objects.equals(name, academicTerm.name) &&
				Objects.equals(startDate, academicTerm.startDate) &&
				Objects.equals(endDate, academicTerm.endDate) &&
				Objects.equals(finishDate, academicTerm.finishDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAcademicTerm, name, startDate, endDate, orderKey, finishDate, active);
	}
	
	@Override
	public String toString() {
		return "AcademicTerm{" +
				"idAcademicTerm='" + idAcademicTerm + '\'' +
				", name=" + name +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", orderKey=" + orderKey +
				", finishDate=" + finishDate +
				", active=" + active +
				'}';
	}
}
