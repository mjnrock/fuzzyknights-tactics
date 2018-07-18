package fkt.utility;

public class Grid<T> {
	protected int Width;
	protected int Height;
	protected T[][] Grid;
	
	public Grid(int width, int height) {
		this.Width = width;
		this.Height = height;
		
		this.Grid = (T[][]) new Object[width][height];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				this.Grid[i][j] = null;
			}
		}
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

	public T GetNode(int x, int y) {
		return (T) this.Grid[x][y];
	}
	public Grid<T> SetNode(int x, int y, T value) {
		this.Grid[x][y] = value;
		
		return this;
	}
}