package fkt.common.enums;

public enum EnumComponentType {
	NAME,
	ATTRIBUTES,
	HEALTH,
	RESOURCE,
	STATE,
	AI;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}
}