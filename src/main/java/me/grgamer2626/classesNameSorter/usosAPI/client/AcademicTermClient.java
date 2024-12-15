package me.grgamer2626.classesNameSorter.usosAPI.client;

import me.grgamer2626.classesNameSorter.usosAPI.model.AcademicTerm;

import java.util.List;

public interface AcademicTermClient {
	List<AcademicTerm> fetchAcademicTerm(String termType, boolean activeOnly);
}
