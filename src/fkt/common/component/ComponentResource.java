package fkt.common.component;

import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumResourceType;

public class ComponentResource extends AComponent {
	public EnumResourceType ResourceType;
	public int Current;
	public int Max;
	
	public ComponentResource(EnumResourceType resourceType, int hp, int max) {
		super(EnumComponentType.RESOURCE);

		this.ResourceType = resourceType;
		this.Current = hp;
		this.Max = max;
	}	
	public ComponentResource(int hp, int max) {
		this(EnumResourceType.MANA, hp, max);
	}
}