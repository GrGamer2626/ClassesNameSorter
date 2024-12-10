package me.grgamer2626.classesNameSorter.application.charactersCounter;

import org.springframework.lang.NonNull;

public interface CharacterCounterService {

	int countSharedCharacters(@NonNull final String input1, @NonNull final String input2);
}
