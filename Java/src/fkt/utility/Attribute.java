package fkt.utility;

import fkt.common.enums.EnumAttributeType;

public class Attribute {
	public EnumAttributeType Attribute;
	protected double Current;
	
	//	The Min and Max should clamp any AttributeModifiers
	public double Min;
	public double Max;
	
	/**
	 * 
	 * @param <EnumAttributeType> attribute
	 * @param <double> current
	 * @param <double> min
	 * @param <double> max
	 */
	public Attribute(EnumAttributeType attribute, double current, double max, double min) {
		this.Attribute = attribute;
		this.Current = current;
		this.Min = min;
		this.Max = max;
	}
	public Attribute(EnumAttributeType attribute, double current, double max) {
		this(attribute, current, max, 0);
	}
	public Attribute(EnumAttributeType attribute, double current) {
		this(attribute, current, Double.MAX_VALUE, Double.MIN_VALUE);
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