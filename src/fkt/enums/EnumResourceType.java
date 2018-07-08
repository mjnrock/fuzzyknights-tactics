package fkt.enums;

public enum EnumResourceType {
	MANA;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}
}