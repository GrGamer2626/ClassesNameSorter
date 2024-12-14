package me.grgamer2626.classesNameSorter.application.normalizer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StringNormalizer implements Normalizer<String>{
	
	/**
	 * Removes all characters that are not letters or numbers and changes all characters to lowercase.
	 *
	 * @param input string to normalize
	 *
	 * @return normalize string
	 */
	@NonNull
	@Override
	public String normalize(@NonNull String input) {
		Assert.notNull(input, "the input for normalization must not be null.");
		
		return input.toLowerCase().replaceAll("[^a-z0-9]", "");
	}
}
