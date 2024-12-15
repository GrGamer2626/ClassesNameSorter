package me.grgamer2626.classesNameSorter.application.common.usos.group;

import me.grgamer2626.classesNameSorter.usosAPI.client.GroupClient;
import me.grgamer2626.classesNameSorter.usosAPI.model.ClassGroup;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseUnit;
import me.grgamer2626.classesNameSorter.usosAPI.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
	
	private final GroupClient groupClient;
	
	@Autowired
	public GroupServiceImpl(GroupClient groupClient) {
		this.groupClient = groupClient;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Group> getAllGroups(List<CourseEdition> courseEditions) {
		List<Group> groups = new ArrayList<>();
		for(CourseEdition courseEdition : courseEditions) {
			for(CourseUnit courseUnit : courseEdition.getCourseUnits()) {
				for (ClassGroup classGroup : courseUnit.getClassGroups()) {
					Group group = groupClient.fetchGroup(classGroup.getIdClassGroup(), classGroup.getNumber());
					groups.add(group);
				}
			}
		}
		return groups;
	}
	
	@Override
	public List<Group> getAllClasTypeGroups(List<CourseEdition> courseEditions, String idClassType) {
		List<Group> groups = getAllGroups(courseEditions);
		return groups.stream()
				.filter(group -> group.getIdClassType().equals(idClassType))
				.toList();
	}
	
	@Override
	public List<Group> getAllClasTypesGroups(List<CourseEdition> courseEditions, List<String> idsClassType) {
		List<Group> groups = getAllGroups(courseEditions);
		return groups.stream()
				.filter(group ->  idsClassType.contains(group.getIdClassType()))
				.toList();
	}
}
