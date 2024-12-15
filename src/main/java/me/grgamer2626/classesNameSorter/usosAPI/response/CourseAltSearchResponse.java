package me.grgamer2626.classesNameSorter.usosAPI.response;

import me.grgamer2626.classesNameSorter.usosAPI.model.CourseAlt;

import java.util.List;

public class CourseAltSearchResponse extends AbstractSearchResponse<CourseAlt> {
	
	public CourseAltSearchResponse() {
	
	}
	
	public CourseAltSearchResponse(List<CourseAlt> items, boolean nextPage) {
		super(items, nextPage);
	}
}
