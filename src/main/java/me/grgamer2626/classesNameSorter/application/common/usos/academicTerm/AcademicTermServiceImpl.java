package me.grgamer2626.classesNameSorter.application.common.usos.academicTerm;

import me.grgamer2626.classesNameSorter.usosAPI.client.AcademicTermClient;
import me.grgamer2626.classesNameSorter.usosAPI.model.AcademicTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicTermServiceImpl implements AcademicTermService {
	private final AcademicTermClient academicTermClient;
	
	@Autowired
	public AcademicTermServiceImpl(AcademicTermClient academicTermClient) {
		this.academicTermClient = academicTermClient;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public List<AcademicTerm> getAllActiveAcademicSemesters() {
		return academicTermClient.fetchAcademicTerm("semester", true);
	}
	
	@Override
	public AcademicTerm getCurrentAcademicSemester() {
		List<AcademicTerm> activeAcademicSemester = getAllActiveAcademicSemesters();
		
		return activeAcademicSemester.isEmpty() ? null : activeAcademicSemester.get(0);
	}
	
	@Override
	public String getCurrentAcademicSemesterId() {
		AcademicTerm academicTerm = getCurrentAcademicSemester();
		
		return (academicTerm != null) ? academicTerm.getIdAcademicTerm() : "";
	}
}
