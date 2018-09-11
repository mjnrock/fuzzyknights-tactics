package fkt.common.entity;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.component.AComponent;
import fkt.common.enums.EnumComponentType;
import fkt.common.events.EntityEvents;
import fkt.common.system.SystemEntity;

public abstract class AEntity {
	public UUID UUID;
	public final ConcurrentHashMap<EnumComponentType, AComponent> Components = new ConcurrentHashMap<EnumComponentType, AComponent>();
	
	public AEntity(UUID uuid, AComponent[] components) {
		SystemEntity.GetInstance().ConstructEntity(this, uuid, components);
		
		EntityEvents.GetInstance().EntityConstruction(this);
	}
	public AEntity(AComponent[] components) {
		this(java.util.UUID.randomUUID(), components);
	}	
}