package com.ait.agilebuild.mathrun.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

public class Distribution {
	private List<? extends Number> numbers;

	public Distribution(List<? extends Number> numbers) {
		super();
		Collections.sort(numbers, new Comparator<Number>() {
			public int compare(Number n1, Number n2) {
				return (int) (n1.doubleValue() - n2.doubleValue());
			}
		});
		this.numbers = numbers;
	}

	public List<? extends Number> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<? extends Number> numbers) {
		this.numbers = numbers;
	}

	public double mean() {
		if (numbers == null || numbers.size() == 0) {
			throw new IllegalStateException("Numbers are not set or are empty");
		}
		double total = 0;
		for (Number n : numbers) {
			total += n.doubleValue();
		}
		return total / numbers.size();
	}

	public double median() {
		if (numbers == null || numbers.size() == 0) {
			throw new IllegalStateException("Numbers are not set or are empty");
		}
		final int midIndex = (numbers.size() - 1) / 2;
		final int remainder = (numbers.size() - 1) % 2;
		if (remainder == 0) {
			return numbers.get(midIndex).doubleValue();
		} else {
			return (numbers.get(midIndex).doubleValue() + numbers.get(
					midIndex + 1).doubleValue()) / 2;
		}
	}

	public double standardDeviation() {
		double sigma = 0;
		double mean = mean();
		for (Number n : numbers) {
			sigma += (n.doubleValue() - mean) * (n.doubleValue() - mean);
		}
		double covariance = sigma / numbers.size();
		return Math.sqrt(covariance);
	}

	/**
	 * Returns the distance between the raw score and the population mean in
	 * units of the standard deviation. z is negative when the raw score is
	 * below the mean, positive when above. It measures the sigma distance of
	 * actual data from the average. The Z value provides an assessment of how
	 * off-target a process is operating.
	 * <p>
	 * Formula: <b>z = (n - μ) / σ</b>
	 * </p>
	 * <p>
	 * where:
	 * </p>
	 * <p>
	 * μ is the mean of the population; σ is the standard deviation of the
	 * population.
	 * </p>
	 * 
	 * @param raw
	 *            score n
	 * @return Z-Score
	 */
	public double zScore(Number n) {
		return (n.doubleValue() - mean()) / standardDeviation();
	}

	/**
	 * The calculation is done here. Example: From 1.96 (Z-score) to 0.975
	 * (P-value) From -1.96 (Z-score) to 0.025
	 *
	 * @return double a p value
	 */
	public static double cumulativeProbability(Distribution obj, Number n) {
		NormalDistribution dist = new NormalDistributionImpl();
        double lQuantile = 0;
        try {
            lQuantile = dist.cumulativeProbability(obj.zScore(n));
        } catch (MathException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return lQuantile;
	}

}