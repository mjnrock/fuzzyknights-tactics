package fkt.entity;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fkt.component.AComponent;
import fkt.enums.EnumComponentType;
import fkt.system.SystemEntity;

public abstract class AEntity {
	public UUID UUID;
	public final ConcurrentHashMap<EnumComponentType, AComponent> Components = new ConcurrentHashMap<EnumComponentType, AComponent>();
	
	public AEntity(UUID uuid, AComponent[] components) {
		SystemEntity.GetInstance().ConstructEntity(this, uuid, components);
	}
	public AEntity(AComponent[] components) {
		this(java.util.UUID.randomUUID(), components);
	}	
}