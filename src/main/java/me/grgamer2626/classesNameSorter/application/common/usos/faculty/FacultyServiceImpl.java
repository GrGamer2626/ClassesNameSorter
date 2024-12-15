package me.grgamer2626.classesNameSorter.application.common.usos.faculty;

import me.grgamer2626.classesNameSorter.usosAPI.client.FacultyClient;
import me.grgamer2626.classesNameSorter.usosAPI.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
	
	private final FacultyClient facultyClient;
	
	@Autowired
	public FacultyServiceImpl(FacultyClient facultyClient) {
		this.facultyClient = facultyClient;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Faculty> getAllFaculties() {
		return facultyClient.fetchAllFaculties();
	}
	
	@Override
	public List<String> getIdsFaculty() {
		
		return getAllFaculties().stream()
				.map(Faculty::getIdFaculty)
				.collect(Collectors.toList());
	}
}
