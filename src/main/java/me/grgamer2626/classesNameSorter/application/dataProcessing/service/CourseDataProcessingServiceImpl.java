package me.grgamer2626.classesNameSorter.application.dataProcessing.service;

import me.grgamer2626.classesNameSorter.application.common.charactersCounter.CharacterCounterService;
import me.grgamer2626.classesNameSorter.application.common.normalizer.Normalizer;
import me.grgamer2626.classesNameSorter.application.common.usos.course.CourseService;
import me.grgamer2626.classesNameSorter.application.common.usos.group.GroupService;
import me.grgamer2626.classesNameSorter.application.dataProcessing.model.ProcessedCourseData;
import me.grgamer2626.classesNameSorter.application.dataProcessing.sorter.ProcessedCourseDataComparator;
import me.grgamer2626.classesNameSorter.usosAPI.model.Course;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;
import me.grgamer2626.classesNameSorter.usosAPI.model.Group;
import me.grgamer2626.classesNameSorter.usosAPI.model.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CourseDataProcessingServiceImpl implements CourseDataProcessingService {
	private final CourseService courseService;
	private final GroupService groupService;
	private final Normalizer<String> stringNormalizer;
	private final CharacterCounterService characterCounterService;
	
	@Autowired
	public CourseDataProcessingServiceImpl(CourseService courseService, GroupService groupService, Normalizer<String> stringNormalizer, CharacterCounterService characterCounterService) {
		this.courseService = courseService;
		this.groupService = groupService;
		this.stringNormalizer = stringNormalizer;
		this.characterCounterService = characterCounterService;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<ProcessedCourseData> getProcessedCourseData(String idAcademicTerm, String idClassType) {
		List<Group> groups = getAllGroupForClassType("UJ", idAcademicTerm, "CW");
		
		Map<String, Set<Lecturer>> groupedData = groupGroupsData(groups);
		
		List<ProcessedCourseData> processedCoursesData = new ArrayList<>();
		for(Map.Entry<String, Set<Lecturer>> entry : groupedData.entrySet()) {
			String courseName = entry.getKey();
			List<String> lecturerFullNames = getLecturerFullNames(entry.getValue());
			
			String normalizedCourseName = stringNormalizer.normalize(courseName);
			List<String> normalizedLecturerFullNames = normalizeStringList(lecturerFullNames);
			
			int sharedCharacterPairs = 0;
			
			for(String fullName : normalizedLecturerFullNames) {
				int count = characterCounterService.countSharedCharacters(fullName, normalizedCourseName);
				if(count > sharedCharacterPairs) {
					sharedCharacterPairs = count;
				}
			}
			
			ProcessedCourseData processedCourseData = new ProcessedCourseData(courseName, lecturerFullNames, sharedCharacterPairs);
			processedCoursesData.add(processedCourseData);
		}
		
		return processedCoursesData;
	}
	
	@Override
	public List<ProcessedCourseData> sort(List<ProcessedCourseData> processedCoursesData) {
		processedCoursesData.sort(new ProcessedCourseDataComparator());
		return processedCoursesData;
	}
	
	@Override
	public List<ProcessedCourseData> getTopTenProcessedCourseData(List<ProcessedCourseData> processedCoursesList) {
		int dataSize = processedCoursesList.size();
		if (dataSize <= 10) {
			return processedCoursesList;
		}
		
		int shardedCharacterPairs = processedCoursesList.get(9).getSharedCharacterPairs();
		
		List<ProcessedCourseData> resultList = new ArrayList<>(processedCoursesList.subList(0, 10));
		for (ProcessedCourseData courseData : processedCoursesList) {
			int index =  processedCoursesList.indexOf(courseData);
			if(index < 10) {
				continue;
			}
			
			if(courseData.getSharedCharacterPairs() < shardedCharacterPairs) {
				break;
			}
			
			resultList.add(courseData);
		}
		return resultList;
	}
	
	private List<String> getLecturerFullNames(Collection<Lecturer> lecturers) {
		return lecturers.stream()
				.map(lecturer -> lecturer.getFirstName() + " " + lecturer.getLastName())
				.collect(Collectors.toList());
	}
	
	private List<String> normalizeStringList(List<String> list) {
		return list.stream()
				.map(stringNormalizer::normalize)
				.toList();
	}
	
	private List<Group> getAllGroupForClassType(String idFaculty, String idCurrentAcademicTerm, String idClassType) {
		List<Course> courses = courseService.getAllCourses(idFaculty, idCurrentAcademicTerm);
		List<CourseEdition> courseEditions = courseService.getCourseEditions(courses, idCurrentAcademicTerm);
		
		return new ArrayList<>(new LinkedHashSet<>(groupService.getAllClasTypeGroups(courseEditions, idClassType)));
	}
	
	private Map<String, Set<Lecturer>> groupGroupsData(List<Group> groups) {
		Map<String, Set<Lecturer>> courseData = new HashMap<>();
		for(Group group : groups) {
			String courseName = group.getCourseName().get("pl");
			if(!courseData.containsKey(courseName)) {
				Set<Lecturer> lecturers = new HashSet<>(group.getLecturers());
				courseData.put(courseName, lecturers);
				continue;
			}
			Set<Lecturer> lecturers = courseData.get(courseName);
			lecturers.addAll(group.getLecturers());
		}
		return courseData;
	}
}
