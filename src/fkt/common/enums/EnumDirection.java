package fkt.common.enums;

public enum EnumDirection {
	NORTH("N", 0d, -1d),
	SOUTH("S", 0d, 1d),
	EAST("E", 1d, 0d),
	WEST("W", -1d, 0d),
	
	NORTHEAST("NE", 1d, -1d),
	NORTHWEST("NW", -1d, -1d),
	SOUTHEAST("SE", 1d, 1d),
	SOUTHWEST("SW", -1d, 1d);

	private final String Code;
	private final double X;
	private final double Y;
	
	private EnumDirection(String code, double x, double y) {
		this.Code = code;
		this.X = x;
		this.Y = y;
	}
	
	public String GetCode() {
		return Code;
	}

	public double GetX() {
		return X;
	}
	public double GetY() {
		return Y;
	}
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumDirection fromString(String text) {
		for (EnumDirection b : EnumDirection.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}