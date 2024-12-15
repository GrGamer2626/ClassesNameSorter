package me.grgamer2626.classesNameSorter.usosAPI.client;

import me.grgamer2626.classesNameSorter.usosAPI.model.Group;

public interface GroupClient {
	Group fetchGroup(String idCourseUnit, int groupNumber);
}
