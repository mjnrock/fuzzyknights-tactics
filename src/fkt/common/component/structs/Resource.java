package fkt.common.component.structs;

import fkt.common.enums.EnumResourceType;

public class Resource {
	public EnumResourceType ResourceType;
	public int Current;
	public int Max;
	
	public Resource(EnumResourceType resourceType, int hp, int max) {
		this.ResourceType = resourceType;
		this.Current = hp;
		this.Max = max;
	}	
	public Resource(int hp, int max) {
		this(EnumResourceType.MANA, hp, max);
	}
}