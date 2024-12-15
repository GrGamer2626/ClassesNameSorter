package me.grgamer2626.classesNameSorter.usosAPI.client;

import me.grgamer2626.classesNameSorter.usosAPI.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GroupClientImpl extends AbstractClient implements GroupClient {
	
	@Autowired
	public GroupClientImpl(RestTemplate restTemplate) {
		super("/groups", restTemplate);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Group fetchGroup(String idCourseUnit, int groupNumber) {
		String url = urlBase + "/group?course_unit_id=" + idCourseUnit +
				"&group_number=" + groupNumber +
				"&fields=class_type_id|course_name|lecturers";
		
		return restTemplate.getForObject(url, Group.class);
	}
}
