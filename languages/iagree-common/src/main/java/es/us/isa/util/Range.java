package es.us.isa.util;

public class Range {
	
	public String min;
	public String max;
	
	public Range() {}


	public Range(String min, String max) {
		super();
		this.min = min;
		this.max = max;
	}


	public String getMin() {
		return min;
	}


	public void setMin(String min) {
		this.min = min;
	}


	public String getMax() {
		return max;
	}


	public void setMax(String max) {
		this.max = max;
	}

}
