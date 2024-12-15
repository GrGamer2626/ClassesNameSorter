package me.grgamer2626.classesNameSorter.usosAPI.response;

import me.grgamer2626.classesNameSorter.usosAPI.model.Faculty;

import java.util.List;

public class FacultySearchResponse extends AbstractSearchResponse<Faculty> {
	public FacultySearchResponse() {
	}
	
	public FacultySearchResponse(List<Faculty> items, boolean nextPage) {
		super(items, nextPage);
	}
}
