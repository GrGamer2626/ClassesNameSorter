package me.grgamer2626.characterCounter;

import me.grgamer2626.classesNameSorter.application.common.charactersCounter.CharacterCounterService;
import me.grgamer2626.classesNameSorter.application.common.charactersCounter.CharacterCounterServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCounterImplTest {
	
	
	private final CharacterCounterService characterCounterService = new CharacterCounterServiceImpl();
	
	@Test
	public void countSharedCharacters_input1IsNull() {
		//given
		String input1 = null;
		String input2 = "test";
		
		//when / then
		assertThrows(IllegalArgumentException.class, () -> characterCounterService.countSharedCharacters(input1, input2), "Expected IllegalArgumentException when input1 is null.");
	}
	
	@Test
	public void countSharedCharacters_input2IsNull() {
		//given
		String input1 = "test";
		String input2 = null;
		
		//when / then
		assertThrows(IllegalArgumentException.class, () -> characterCounterService.countSharedCharacters(input1, input2), "Expected IllegalArgumentException when input2 is null.");
	}
	
	@Test
	public void countSharedCharacters_input1IsEmpty() {
		//given
		String input1 = "";
		String input2 = "test";
		
		//when / then
		assertThrows(IllegalArgumentException.class, () -> characterCounterService.countSharedCharacters(input1, input2), "Expected IllegalArgumentException when input1 is empty.");
	}
	
	@Test
	public void countSharedCharacters_input2IsEmpty() {
		//given
		String input1 = "test";
		String input2 = "";
		
		//when / then
		assertThrows(IllegalArgumentException.class, () -> characterCounterService.countSharedCharacters(input1, input2), "Expected IllegalArgumentException when input2 is empty.");
	}
	
	@Test
	public void countSharedCharacters_noSharedCharacters() {
		// given
		String input1 = "abc";
		String input2 = "def";
		
		// when
		int result = characterCounterService.countSharedCharacters(input1, input2);
		
		// then
		assertEquals(0, result, "Expected 0 shared characters when there are no common characters.");
	}
	
	@Test
	public void countSharedCharacters_allCharactersShared() {
		// given
		String input1 = "abc";
		String input2 = "abc";
		
		// when
		int result = characterCounterService.countSharedCharacters(input1, input2);
		
		// then
		assertEquals(3, result, "Expected all characters to be shared.");
	}
	
	@Test
	public void countSharedCharacters_partialOverlap() {
		// given
		String input1 = "aabbcc";
		String input2 = "aabxxx";
		
		// when
		int result = characterCounterService.countSharedCharacters(input1, input2);
		
		// then
		assertEquals(3, result, "Expected 3 shared characters when there is partial overlap.");
	}
	
	@Test
	public void countSharedCharacters_commutativeProperty() {
		// given
		String input1 = "aabbcc";
		String input2 = "abc";
		
		// when
		int result1 = characterCounterService.countSharedCharacters(input1, input2);
		int result2 = characterCounterService.countSharedCharacters(input2, input1);
		
		// then
		assertEquals(result1, result2, "Expected the result to be the same regardless of the input order.");
	}
	
	@Test
	public void countSharedCharacters_caseSensitivity() {
		// given
		String input1 = "abc";
		String input2 = "ABC";
		
		// when
		int result = characterCounterService.countSharedCharacters(input1, input2);
		
		// then
		assertEquals(0, result, "Expected 0 shared characters when case sensitivity is considered.");
	}
}
