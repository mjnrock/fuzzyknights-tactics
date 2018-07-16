package fkt.utility;

import fkt.common.entity.AEntity;

public class Grid {
	protected int Width;
	protected int Height;
	protected Node[][] Grid;
	
	public Grid(int width, int height) {
		this.Width = width;
		this.Height = height;
	}
	
	public int GetWidth() {
		return this.Width;
	}
	public int GetHeight() {
		return this.Height;
	}
	public int GetSize() {
		return this.Width * this.Height;
	}
}