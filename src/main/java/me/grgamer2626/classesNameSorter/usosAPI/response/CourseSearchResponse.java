package me.grgamer2626.classesNameSorter.usosAPI.response;

import me.grgamer2626.classesNameSorter.usosAPI.model.Course;

import java.util.List;

public class CourseSearchResponse extends AbstractSearchResponse<Course> {
	
	public CourseSearchResponse() {
	
	}
	
	public CourseSearchResponse(List<Course> items, boolean nextPage) {
		super(items, nextPage);
	}
}
