package fkt.common.component;

import fkt.common.enums.EnumComponentType;

public class ComponentAttributes extends AComponent {
	public int Strength;
	public int Toughness;
	
	public int Power;
	public int Resistance;
	
	public ComponentAttributes(int STR, int TGH, int PWR, int RES) {
		super(EnumComponentType.ATTRIBUTES);

		this.Strength = STR;
		this.Toughness = TGH;
		this.Power = PWR;
		this.Resistance = RES;
	}
}