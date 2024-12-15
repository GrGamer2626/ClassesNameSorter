package me.grgamer2626.classesNameSorter.usosAPI.client;

import me.grgamer2626.classesNameSorter.usosAPI.model.AcademicTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AcademicTermClientImpl extends AbstractClient implements AcademicTermClient {
	
	@Autowired
	public AcademicTermClientImpl(RestTemplate restTemplate) {
		super("/terms", restTemplate);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<AcademicTerm> fetchAcademicTerm(String termType, boolean activeOnly) {
		String url = urlBase + "/terms_index?term_type=" + termType + "&active_only=" + activeOnly;
		
		AcademicTerm[] academicTerms = restTemplate.getForObject(url, AcademicTerm[].class);
		
		return Arrays.asList(academicTerms);
	}
}
