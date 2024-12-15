package me.grgamer2626.classesNameSorter.application.common.usos.group;

import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;
import me.grgamer2626.classesNameSorter.usosAPI.model.Group;

import java.util.List;

public interface GroupService {
	List<Group> getAllGroups(List<CourseEdition> courseEditions);
	List<Group> getAllClasTypeGroups(List<CourseEdition> courseEditions, String idClassType);
	List<Group> getAllClasTypesGroups(List<CourseEdition> courseEditions, List<String> idsClassType);
}
