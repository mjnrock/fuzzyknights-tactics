package fkt.common.enums;

public enum EnumDiscipline {
	NONE,		// Functionally an internal flag, as this should only be present on, like, meta-level stuff.
	PHYSICAL,
	MAGICAL,
	HYBRID;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumDiscipline fromString(String text) {
		for (EnumDiscipline b : EnumDiscipline.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}