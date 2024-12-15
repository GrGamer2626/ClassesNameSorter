package me.grgamer2626.classesNameSorter.web.controllers;

import me.grgamer2626.classesNameSorter.application.common.usos.academicTerm.AcademicTermService;
import me.grgamer2626.classesNameSorter.application.dataProcessing.model.ProcessedCourseData;
import me.grgamer2626.classesNameSorter.application.dataProcessing.service.CourseDataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	private final AcademicTermService academicTermService;
	private final CourseDataProcessingService courseDataProcessingService;
	
	@Autowired
	public ApiRestController(AcademicTermService academicTermService, CourseDataProcessingService courseDataProcessingService) {
		this.academicTermService = academicTermService;
		this.courseDataProcessingService = courseDataProcessingService;
	}
	
	@GetMapping("/courses")
	public List<String> getCoursesSortedList() {
		String idCurrentSemester = academicTermService.getCurrentAcademicSemesterId();
		
		List<ProcessedCourseData> processedCoursesList = new ArrayList<>(new HashSet<>(courseDataProcessingService.getProcessedCourseData(idCurrentSemester, "CW")));
		processedCoursesList = courseDataProcessingService.sort(processedCoursesList);
		List<ProcessedCourseData> resultList = courseDataProcessingService.getTopTenProcessedCourseData(processedCoursesList);
		
		return resultList.stream()
				.map(ProcessedCourseData::getCourseName)
				.toList();
	}
}
