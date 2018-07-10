package fkt.common.enums;

public enum EnumComponentType {
	NAME,
	ATTRIBUTES,
	HEALTH,
	RESOURCES,
	STATE,
	AI;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}
}