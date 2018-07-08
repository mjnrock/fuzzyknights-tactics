package fkt.enums;

public enum EnumState {
	NORMAL,
	WEAK;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumState fromString(String text) {
		for (EnumState b : EnumState.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}