package fkt.enums;

public enum EnumComponentType {
	NAME,
	ATTRIBUTES,
	HEALTH,
	RESOURCE,
	STATE;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}
}