package me.grgamer2626.classesNameSorter.application.dataProcessing.service;

import me.grgamer2626.classesNameSorter.application.dataProcessing.model.ProcessedCourseData;

import java.util.List;

public interface CourseDataProcessingService {
	
	List<ProcessedCourseData> getProcessedCourseData(String idAcademicTerm, String idClassType);
	
	List<ProcessedCourseData> sort(List<ProcessedCourseData> processedCoursesData);
	
	List<ProcessedCourseData> getTopTenProcessedCourseData(List<ProcessedCourseData> processedCoursesList);
}
