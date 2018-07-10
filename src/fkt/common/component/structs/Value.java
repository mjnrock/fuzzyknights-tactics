package fkt.common.component.structs;

import fkt.common.enums.EnumAttributeType;

public class Value {
	public EnumAttributeType Attribute;
	protected double Current;
	
	public Value(EnumAttributeType attribute, double current) {
		this.Attribute = attribute;
		this.Current = current;
	}
	
	public double GetCurrent() {
		return this.Current;
	}
	public Value SetCurrent(double current) {
		this.Current = current;
		
		return this;
	}
}