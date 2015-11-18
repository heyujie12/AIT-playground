package com.ait.agilebuild.mathrun.model;

import java.util.ArrayList;
import java.util.List;

public class Progression<T> {
	
	private List<T> progression;

	public Progression(List<T> list) {
		this.progression = list;
	}

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
