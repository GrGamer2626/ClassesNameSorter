package me.grgamer2626.classesNameSorter.application.charactersCounter;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounterServiceImpl implements CharacterCounterService {
	
	/**
	 * Calculates the number of characters that are shared between two input strings,
	 * considering the frequency of each character in both strings, case and whitespace.
	 * <p>
	 * Examples:
	 * <pre>
	 * String str1 = "axxx";
	 * String str2 = "ayy";
	 * Then shared characters will be 1 ('a').
	 * </pre>
	 * <pre>
	 * String str1 = "axxx";
	 * String str2 = "ayay";
	 * Then shared characters count still will be 1 ('a') because in str1 'a' appears only once.
	 * </pre>
	 * <pre>
	 * String str1 = "axax";
	 * String str2 = "aayy";
	 * Then shared characters will be 2 ('a') because letter 'a' appears twice in both string.
	 * </pre>
	 *
	 * @param input1 the first input string to compare
	 * @param input2 the second input string to compare
	 *
	 * @return the total number of shared characters between {@link String input1} and {@link String input2} considering the frequency of each character.
	 */
	@Override
	public int countSharedCharacters(@NonNull final String input1, @NonNull final String input2) {
		Assert.notNull(input1, "The input1 string must not be null");
		Assert.notNull(input2, "The input2 string must not be null");
		Assert.hasText(input1, "The input1 string must not be empty");
		Assert.hasText(input2, "The input2 string must not be empty");
		
		Map<Character, Integer> input1CharCount = countCharacterFrequencies(input1);
		int sharedCount = 0;
		
		for (char character : input2.toCharArray()) {
			if (input1CharCount.containsKey(character) && input1CharCount.get(character) > 0) {
				sharedCount++;
				
				int count = input1CharCount.get(character) - 1;
				input1CharCount.put(character, count);
			}
		}
		
		return sharedCount;
	}
	
	/**
	 * Counts the frequency of each character in the given string.
	 *
	 * @param input the string for which character frequencies are calculated; must not be {@code null}
	 *
	 * @return a {@link Map map} where the keys are {@link Character characters} from the input string and the values are their {@link Integer frequencies}
	 */
	private Map<Character, Integer> countCharacterFrequencies(String input) {
		Map<Character, Integer> inputCharCount = new HashMap<>();
		for (char character : input.toCharArray()) {
			int count = inputCharCount.getOrDefault(character, 0) + 1;
			inputCharCount.put(character, count);
		}
		
		return inputCharCount;
	}
}
