package fkt.utility;

import java.util.HashMap;

import fkt.common.entity.AEntity;

public class Map {
	protected int Width;
	protected int Height;
	protected Node[][] Grid;
	
	protected final HashMap<AEntity, Object> EntityManager = new HashMap<AEntity, Object>();
	
	public Map(int width, int height) {
		this.Width = width;
		this.Height = height;
		
		this.Grid = new Node[width][height];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				this.Grid[i][j] = new Node(i, j);
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

	public Node GetNode(int x, int y) {
		return this.Grid[x][y];
	}

	public Map MoveEntity(AEntity entity, int x0, int y0, int x1, int y1) {
		Node From = this.GetNode(x0, y0);
		Node To = this.GetNode(x1, y1);
		
		if(From.HasEntity(entity)) {
			From.RemoveEntity(entity);
			To.AddEntity(entity);
		}
		
		return this;
	}
}