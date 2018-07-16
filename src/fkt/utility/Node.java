package fkt.utility;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.entity.AEntity;

public class Node {
	public final int X;
	public final int Y;
	//TODO Terrain should be a priority queue so there is a layering ordinality
	protected final ConcurrentHashMap<UUID, AEntity> Terrain = new ConcurrentHashMap<UUID, AEntity>();
	protected final ConcurrentHashMap<UUID, AEntity> Entities = new ConcurrentHashMap<UUID, AEntity>();
	
	public Node(int x, int y, AEntity[] entities) {
		this.X = x;
		this.Y = y;
		
		for(AEntity entity : entities) {
			this.Entities.put(entity.UUID, entity);
		}
	}
	public Node(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public boolean HasEntity(UUID uuid) {
		return this.Entities.containsKey(uuid);
	}
	public boolean HasEntity(AEntity entity) {
		return this.Entities.containsKey(entity.UUID);
	}

	public Collection<AEntity> GetEntities() {
		return this.Entities.values();
	}
	
	public AEntity GetEntity(UUID uuid) {
		return this.Entities.get(uuid);
	}
	public Node AddEntity(AEntity entity) {
		this.Entities.put(entity.UUID, entity);
		
		return this;
	}
	public Node RemoveEntity(UUID uuid) {
		this.Entities.remove(uuid);
		
		return this;
	}
	public Node RemoveEntity(AEntity entity) {
		this.Entities.remove(entity.UUID);
		
		return this;
	}

	public boolean HasTerrain(UUID uuid) {
		return this.Terrain.containsKey(uuid);
	}
	public boolean HasTerrain(AEntity entity) {
		return this.Terrain.containsKey(entity.UUID);
	}
	
	public AEntity GetTerrain(UUID uuid) {
		return this.Terrain.get(uuid);
	}
	public Node AddTerrain(AEntity entity) {
		this.Terrain.put(entity.UUID, entity);
		
		return this;
	}
	public Node RemoveTerrain(UUID uuid) {
		this.Terrain.remove(uuid);
		
		return this;
	}
}