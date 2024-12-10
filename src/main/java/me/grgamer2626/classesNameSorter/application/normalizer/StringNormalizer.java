package me.grgamer2626.classesNameSorter.application.normalizer;

public class StringNormalizer implements Normalizer<String>{
	
	/**
	 * Removes all whitespace and changes all characters to lowercase.
	 *
	 * @param input string to normalize
	 *
	 * @return normalize string
	 */
	@Override
	public String normalize(String input) {
		return input.toLowerCase().replaceAll("\\s+", "");
	}
}
