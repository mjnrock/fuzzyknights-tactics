package fkt.common.enums;

public enum EnumResourceType {
	HP,
	MANA;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}
}