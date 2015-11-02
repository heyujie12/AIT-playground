package com.ait.agilebuild.mathrun.model;

import java.util.List;

public class Progression<T> {
	
	private List<T> progression;

	public List<T> getProgression() {
		return progression;
	}

	public void setProgression(List<T> progression) {
		this.progression = progression;
	}
	
	public void add(T t){
		progression.add(t);
	}

	public T get(int index){
		return progression.get(index);
	}

	public int size(){
		return progression.size();
	}
}
