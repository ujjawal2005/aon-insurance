package com.org.aon.to;

import java.util.List;

public class Insurer {
	private String name;
	private List<Integer> excludedPostCodes;
	private List<String> excludedOccupation;
	private int minimumTurnOver;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getExcludedPostCodes() {
		return excludedPostCodes;
	}
	public void setExcludedPostCodes(List<Integer> excludedPostCodes) {
		this.excludedPostCodes = excludedPostCodes;
	}
	public List<String> getExcludedOccupation() {
		return excludedOccupation;
	}
	public void setExcludedOccupation(List<String> excludedOccupation) {
		this.excludedOccupation = excludedOccupation;
	}
	public int getMinimumTurnOver() {
		return minimumTurnOver;
	}
	public void setMinimumTurnOver(int minimumTurnOver) {
		this.minimumTurnOver = minimumTurnOver;
	}
	
}
