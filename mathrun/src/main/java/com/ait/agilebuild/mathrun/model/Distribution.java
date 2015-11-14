package com.ait.agilebuild.mathrun.model;

import java.util.List;

public class Distribution {
	private List<? extends Number> numbers;

	public Distribution(List<Double> numbers) {
		super();
		this.numbers = numbers;
	}

	public List<? extends Number> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<? extends Number> numbers) {
		this.numbers = numbers;
	}
	
	public double mean(){
		return 0;
	}
	
	public double median(){
		return 0;
	}
	
	public double standardDeviation(){
		return 0;
	}
	
	/**
	 * Returns the distance between the raw score and the population mean in units of the standard deviation. 
	 * z is negative when the raw score is below the mean, positive when above.
	 * It measures the sigma distance of actual data from the average.
	 * The Z value provides an assessment of how off-target a process is operating.
	 * <p>Formula: <b>z = (n - μ) / σ</b></p>
	 * <p>where:</p>
	 * <p>μ is the mean of the population; σ is the standard deviation of the population.</p>
	 * @param raw score n
	 * @return Z-Values
	 */
	public double zValues(Number n){
		
		return 0;
	}
	
}