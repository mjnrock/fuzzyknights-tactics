package fkt.common.component;

import fkt.common.enums.EnumComponentType;

public abstract class AComponent {
	protected EnumComponentType ComponentType;
	
	public AComponent(EnumComponentType type) {
		this.SetComponentType(type);
	}
	
	public EnumComponentType GetComponentType() {
		return this.ComponentType;
	}
	public AComponent SetComponentType(EnumComponentType type) {
		this.ComponentType = type;
		
		return this;
	}

	public int GetFlag() {
		return this.ComponentType.GetFlag();
	}
}