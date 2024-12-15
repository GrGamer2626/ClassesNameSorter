package me.grgamer2626.classesNameSorter.usosAPI.client;

import me.grgamer2626.classesNameSorter.usosAPI.model.Faculty;
import me.grgamer2626.classesNameSorter.usosAPI.response.FacultySearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacultyClientImpl extends AbstractClient implements FacultyClient {
	
	@Autowired
	public FacultyClientImpl(RestTemplate restTemplate) {
		super("/fac", restTemplate);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Faculty> fetchAllFaculties() {
		List<Faculty> faculties = new ArrayList<>();
		int start = 0;
		int num = 20;
		FacultySearchResponse facultySearchResponse;
		do {
			String url = getFacultySearchUrl("pl", start, num) + "&fields=id|name";
			facultySearchResponse = restTemplate.getForObject(url, FacultySearchResponse.class);
			
			faculties.addAll(facultySearchResponse.getItems());
			start += num;
		}while (facultySearchResponse.isNextPage());
		
		return faculties;
	}
	
	private String getFacultySearchUrl(String lang, int start, int num) {
		return new StringBuilder(urlBase).append("/search?")
				.append("format=json")
				.append("&lang=").append(lang)
				.append("&num=").append(num)
				.append("&start=").append(start)
				.toString();
	}
}
