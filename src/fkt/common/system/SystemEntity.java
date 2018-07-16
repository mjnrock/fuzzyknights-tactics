package fkt.common.system;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.component.AComponent;
import fkt.common.entity.AEntity;
import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumMessageState;
import fkt.common.enums.EnumState;
import fkt.common.message.AMessage;

public class SystemEntity implements IMessageable {
	private static final SystemEntity INSTANCE = new SystemEntity();
	@Override
	public SystemEntity ReceiveMessage(AMessage message) {
		//TODO Process the Message
		
		this.MarkAsCompleted(message);
		return this;
	}
	@Override
	public SystemEntity MarkAsCompleted(AMessage message) {
		message.SetState(EnumMessageState.COMPLETED);
		
		return this;
	}
		
	public SystemEntity ConstructEntity(AEntity entity, UUID uuid, AComponent[] components) {
		this.SetUUID(entity, uuid);
		this.SetComponents(entity, components);

		if(SystemState.GetInstance().HasComponent(entity)) {
			SystemState.GetInstance().SetDefaultState(entity, EnumState.NORMAL);
		}
		
		return this;
	}
	public SystemEntity ConstructEntity(AEntity entity, AComponent[] components) {
		this.ConstructEntity(entity, java.util.UUID.randomUUID(), components);
		
		return this;
	}
	
	
	public UUID GetUUID(AEntity entity) {
		return entity.UUID;
	}
	public SystemEntity SetUUID(AEntity entity, UUID uuid) {
		entity.UUID = uuid;
		
		return this;
	}
	public SystemEntity SetUUID(AEntity entity, String uuid) {
		entity.UUID = java.util.UUID.fromString(uuid);
		
		return this;
	}
	public SystemEntity ReseedUUID(AEntity entity) {
		this.SetUUID(entity, java.util.UUID.randomUUID());
		
		return this;
	}	

	public ConcurrentHashMap<EnumComponentType, AComponent> GetComponents(AEntity entity) {
		return entity.Components;
	}
	public SystemEntity SetComponents(AEntity entity, AComponent[] components) {
		for(AComponent component : components) {
			entity.Components.put(component.GetComponentType(), component);
		}
		
		return this;
	}

	public AComponent GetEntityComponent(AEntity entity, EnumComponentType type) {
		return entity.Components.get(type);
	}
	public SystemEntity SetEntityComponent(AEntity entity, AComponent component) {
		entity.Components.put(component.GetComponentType(), component);
		
		return this;
	}
	
	public static SystemEntity GetInstance() {
		return SystemEntity.INSTANCE;
	}
}