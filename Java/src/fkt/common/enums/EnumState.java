package fkt.common.enums;

public enum EnumState {
	NORMAL,		// The default behavior of the Entity
	WAITING,	// The default "time out" of the Entity
	TALKING,	// Talking with another Entity
	WALKING,	// Walking around a map (otherwise contextual)
	RUNNING,	// Running around a map (otherwise contextual)
	DEAD,		// Dead Entity
	
	CASTING,	// Basic casting sequence
	ATTACKING,	// Basic attacking sequence

	LEVEL_UP,	// Called when the Entity levels up
	WINNING,	// Called if that Entity wins the match, celebration
	LOSING;		// Called if that Entity loses the match, pouting
	
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