package me.grgamer2626.normalizer;

import me.grgamer2626.classesNameSorter.application.common.normalizer.Normalizer;
import me.grgamer2626.classesNameSorter.application.common.normalizer.StringNormalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringNormalizerTest {
	private final Normalizer<String> stringNormalizer = new StringNormalizer();
	
	@Test
	public void normalize_inputIsNull() {
		//given
		String input = null;
		
		//when / then
		Assertions.assertThrows(IllegalArgumentException.class, () -> stringNormalizer.normalize(input), "Expected IllegalArgumentException when input is null");
	}
	
	@Test
	public void normalize_inputContainsUpperCaseCharacters() {
		//given
		String input = "AaA";
		
		//when
		String result = stringNormalizer.normalize(input);
	
		//then
		Assertions.assertEquals("aaa", result, "All characters should be lowercase.");
	}
	
	@Test
	public void normalize_inputContainsWhitespaces() {
		//given
		String input = " a\ta  a\n ";
		
		//when
		String result = stringNormalizer.normalize(input);
		
		//then
		Assertions.assertEquals("aaa", result, "All whitespaces should be removed.");
	}
	
	@Test
	public void normalize_inputContainsSpecialCharacters() {
		//given
		String input = " \"a-.,!aa'|\\";
		
		//when
		String result = stringNormalizer.normalize(input);
		
		//then
		Assertions.assertEquals("aaa", result, "All whitespaces should be removed.");
	}
}
