package me.grgamer2626.classesNameSorter.application.dataProcessing.sorter;

import me.grgamer2626.classesNameSorter.application.dataProcessing.model.ProcessedCourseData;

import java.util.Comparator;

public class ProcessedCourseDataComparator implements Comparator<ProcessedCourseData> {
	@Override
	public int compare(ProcessedCourseData o1, ProcessedCourseData o2) {
		return Integer.compare(o2.getSharedCharacterPairs(), o1.getSharedCharacterPairs());
	}
}
