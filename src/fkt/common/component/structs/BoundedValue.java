package fkt.common.component.structs;

import fkt.common.enums.EnumAttributeType;
import fkt.utility.Helper;

public class BoundedValue extends Value {
	public double Min;
	public double Max;
	
	/**
	 * 
	 * @param <EnumAttributeType> attribute
	 * @param <double> current
	 * @param <double> min
	 * @param <double> max
	 */
	public BoundedValue(EnumAttributeType attribute, double current, double min, double max) {
		super(attribute, current);

		this.Min = min;
		this.Max = max;
	}
	
	@Override
	public double GetCurrent() {
		return this.Current;
	}
	@Override
	public BoundedValue SetCurrent(double current) {
		this.Current = Helper.clamp(current, this.Min, this.Max);
		
		return this;
	}
}