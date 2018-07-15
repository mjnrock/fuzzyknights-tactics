package fkt.utility;

import fkt.common.enums.EnumAttributeType;

public class Attribute {
	public EnumAttributeType Attribute;
	protected double Current;
	public double Min;
	public double Max;
	
	/**
	 * 
	 * @param <EnumAttributeType> attribute
	 * @param <double> current
	 * @param <double> min
	 * @param <double> max
	 */
	public Attribute(EnumAttributeType attribute, double current, double min, double max) {
		this.Attribute = attribute;
		this.Current = current;
		this.Min = min;
		this.Max = max;
	}
	
	public double GetCurrent() {
		return this.Current;
	}
	public Attribute SetCurrent(double current) {
		this.Current = Helper.clamp(current, this.Min, this.Max);
		
		return this;
	}
	public Attribute AddCurrent(double amount) {
		this.Current = Helper.clamp(this.Current + amount, this.Min, this.Max);
		
		return this;
	}
}