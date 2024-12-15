package me.grgamer2626.classesNameSorter.application.common.usos.faculty;

import me.grgamer2626.classesNameSorter.usosAPI.model.Faculty;

import java.util.List;

public interface FacultyService {

	List<Faculty> getAllFaculties();
	
	List<String> getIdsFaculty();
}
