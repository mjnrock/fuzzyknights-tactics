package fkt.utility;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.entity.AEntity;

public class Node {
	public int X;
	public int Y;
	public ConcurrentHashMap<UUID, AEntity> Entities = new ConcurrentHashMap<UUID, AEntity>();
	
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
	
	public AEntity GetEntity(UUID uuid) {
		return this.Entities.get(uuid);
	}
}