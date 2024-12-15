package me.grgamer2626.classesNameSorter.usosAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class AbstractSearchResponse<T> {
	@JsonProperty("items")
	private List<T> items;
	@JsonProperty("next_page")
	private boolean nextPage;
	
	public AbstractSearchResponse() {
	}
	
	public AbstractSearchResponse(List<T> items, boolean nextPage) {
		this.items = items;
		this.nextPage = nextPage;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<T> getItems() {
		return items;
	}
	
	public boolean isNextPage() {
		return nextPage;
	}
}
