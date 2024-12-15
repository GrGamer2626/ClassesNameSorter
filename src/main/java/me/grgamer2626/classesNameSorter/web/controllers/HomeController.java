package me.grgamer2626.classesNameSorter.web.controllers;

import me.grgamer2626.classesNameSorter.application.common.usos.academicTerm.AcademicTermService;
import me.grgamer2626.classesNameSorter.application.dataProcessing.service.CourseDataProcessingService;
import me.grgamer2626.classesNameSorter.application.dataProcessing.model.ProcessedCourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
	private final AcademicTermService academicTermService;
	private final CourseDataProcessingService courseDataProcessingService;
	
	@Autowired
	public HomeController(AcademicTermService academicTermService, CourseDataProcessingService courseDataProcessingService) {
		this.academicTermService = academicTermService;
		this.courseDataProcessingService = courseDataProcessingService;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		String idCurrentSemester = academicTermService.getCurrentAcademicSemesterId();
		
		List<ProcessedCourseData> processedCoursesList = new ArrayList<>(new HashSet<>(courseDataProcessingService.getProcessedCourseData(idCurrentSemester, "CW")));
		processedCoursesList = courseDataProcessingService.sort(processedCoursesList);
		List<ProcessedCourseData> resultList = courseDataProcessingService.getTopTenProcessedCourseData(processedCoursesList);
		
		List<String> courseNames = resultList.stream()
				.map(ProcessedCourseData::getCourseName)
				.collect(Collectors.toList());
		
		model.addAttribute("courseNames", courseNames);
		
		return "home";
	}
}
