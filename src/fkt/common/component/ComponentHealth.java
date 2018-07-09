package fkt.common.component;

import fkt.common.enums.EnumComponentType;

public class ComponentHealth extends AComponent {
	public int Current;
	public int Max;
	
	public ComponentHealth(int hp, int max) {
		super(EnumComponentType.HEALTH);

		this.Current = hp;
		this.Max = max;
	}
}