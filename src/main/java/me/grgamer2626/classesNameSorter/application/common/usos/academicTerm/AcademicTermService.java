package me.grgamer2626.classesNameSorter.application.common.usos.academicTerm;

import me.grgamer2626.classesNameSorter.usosAPI.model.AcademicTerm;

import java.util.List;

public interface AcademicTermService {
	
	List<AcademicTerm> getAllActiveAcademicSemesters();
	
	AcademicTerm getCurrentAcademicSemester();
	
	String getCurrentAcademicSemesterId();
}
