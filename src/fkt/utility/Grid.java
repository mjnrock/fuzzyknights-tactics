package fkt.utility;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import fkt.common.entity.AEntity;

public class Grid {
	protected int Width;
	protected int Height;
	protected Node[][] Grid;
	
	protected final HashMap<AEntity, Object> EntityManager = new HashMap<AEntity, Object>();
	
	public Grid(int width, int height) {
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

	public Collection<AEntity> GetEntities(int x, int y) {
		return this.GetNode(x, y).GetEntities();	
	}

	public boolean HasEntity(UUID uuid, int x, int y) {
		return this.GetNode(x, y).HasEntity(uuid);
	}
	public boolean HasEntity(AEntity entity, int x, int y) {
		return this.GetNode(x, y).HasEntity(entity);
	}
	
	public Grid AddEntity(AEntity entity, int x, int y) {
		this.GetNode(x, y).AddEntity(entity);
		
		return this;		
	}
	public Grid RemoveEntity(UUID uuid, int x, int y) {
		this.GetNode(x, y).RemoveEntity(uuid);
		
		return this;		
	}
	public Grid RemoveEntity(AEntity entity, int x, int y) {
		this.GetNode(x, y).RemoveEntity(entity);
		
		return this;		
	}
	public Grid MoveEntity(AEntity entity, int x0, int y0, int x1, int y1) {
		Node From = this.GetNode(x0, y0);
		Node To = this.GetNode(x1, y1);
		
		if(From.HasEntity(entity)) {
			From.RemoveEntity(entity);
			To.AddEntity(entity);
		}
		
		return this;
	}
}