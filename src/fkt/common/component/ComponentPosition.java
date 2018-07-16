package fkt.common.component;

import fkt.common.enums.EnumDirection;

public class ComponentPosition {
	public double X;
	public double Y;
	public double Z;
	public EnumDirection Facing;
	
	public ComponentPosition(int x, int y, int z, EnumDirection facing) {
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.Facing = facing;
	}
	public ComponentPosition(int x, int y, EnumDirection facing) {
		this(x, y, 0, facing);
	}
	public ComponentPosition(int x, int y) {
		this(x, y, 0, EnumDirection.SOUTH);
	}
	public ComponentPosition() {
		this(0, 0, 0, EnumDirection.SOUTH);
	}
}