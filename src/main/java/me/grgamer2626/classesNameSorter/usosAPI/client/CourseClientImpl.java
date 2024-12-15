package me.grgamer2626.classesNameSorter.usosAPI.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.grgamer2626.classesNameSorter.usosAPI.model.ClassType;
import me.grgamer2626.classesNameSorter.usosAPI.model.Course;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseAlt;
import me.grgamer2626.classesNameSorter.usosAPI.model.CourseEdition;
import me.grgamer2626.classesNameSorter.usosAPI.response.AbstractSearchResponse;
import me.grgamer2626.classesNameSorter.usosAPI.response.CourseAltSearchResponse;
import me.grgamer2626.classesNameSorter.usosAPI.response.CourseSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CourseClientImpl extends AbstractClient implements CourseClient {
	
	@Autowired
	public CourseClientImpl(RestTemplate restTemplate) {
		super("/courses", restTemplate);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<ClassType> fetchAllClassesType() throws JsonProcessingException {
		String url = urlBase + "/classtypes_index";
		String json = restTemplate.getForObject(url, String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<Map<String,ClassType>> typeReference = new TypeReference<>() {};
		
		Map<String,ClassType> classTypes = objectMapper.readValue(json, typeReference);
		
		return classTypes.values().stream().toList();
	}

	@Override
	public Course fetchCourse(String idCourse) {
		String url = urlBase + "/course?course_id=" + idCourse + "&fields=id|name|terms";
		
		return restTemplate.getForObject(url, Course.class);
	}
	
	@Override
	public List<Course> fetchCourses(String idFaculty, int start, int stop, int num)  {
		List<Course> courses = new ArrayList<>();
		AbstractSearchResponse<?> abstractSearchResponse;
		int currentStart = start;
		do {
			String urlBase = getCourseSearchUrl(idFaculty, currentStart, num);
			try{
				String mainUrl = urlBase + "&fields=id|name|terms";
				CourseSearchResponse courseSearchResponse = restTemplate.getForObject(mainUrl, CourseSearchResponse.class);
				abstractSearchResponse = courseSearchResponse;
				
				courses.addAll(courseSearchResponse.getItems());
			}catch (HttpClientErrorException httpClientErrorException) {
				//TODO dodać sprawdzanie kodu błedu.
				CourseAltSearchResponse courseSearchResponse = restTemplate.getForObject(urlBase, CourseAltSearchResponse.class);
				abstractSearchResponse = courseSearchResponse;
				
				for(CourseAlt courseAlt : courseSearchResponse.getItems()) {
					String idCourse = courseAlt.getIdCourse();
					try{
						Course course = fetchCourse(idCourse);
						courses.add(course);
						
					}catch (Exception e) {
						System.out.println(idCourse);
						e.printStackTrace();
					}
				}
			}
			
			currentStart += num;
			if(stop > 0 & currentStart == stop) {
				break;
			}
		}while (abstractSearchResponse.isNextPage());
		
		return courses;
	}
	
	@Override
	public CourseEdition fetchCourseEdition(String idCourse, String idTerm) {
		String url = urlBase + "/course_edition2?course_id=" + idCourse + "&term_id=" + idTerm + "&fields=course|term|course_units[id|class_groups]";
		
		return restTemplate.getForObject(url, CourseEdition.class);
	}
	
	private String getCourseSearchUrl(String idFaculty, int start, int num) {
		return new StringBuilder(urlBase)
				.append("/search?format=json&lang=pl")
				.append("&fac_id=").append(idFaculty)
				.append("&fac_deep=").append(true)
				.append("&num=").append(num)
				.append("&start=").append(start)
				.toString();
	}
}
