package fkt.common.system;

import fkt.common.component.ComponentName;
import fkt.common.entity.AEntity;
import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumMessageState;
import fkt.common.message.AMessage;

public class SystemName implements IMessageable, IComponentSystem {
	private static final SystemName INSTANCE = new SystemName();
	protected static final EnumComponentType COMPONENT_TYPE = EnumComponentType.NAME;

	@Override
	public SystemName ReceiveMessage(AMessage message) {
		//TODO Process the Message
		
		this.MarkAsCompleted(message);
		return this;
	}
	@Override
	public SystemName MarkAsCompleted(AMessage message) {
		message.SetState(EnumMessageState.COMPLETED);
		
		return this;
	}

	@Override
	public ComponentName GetComponent(AEntity entity) {
		return (ComponentName)SystemEntity.GetInstance().GetEntityComponent(entity, SystemName.COMPONENT_TYPE);
	}
	
	
	public String GetNomen(AEntity entity) {
		return this.GetComponent(entity).Nomen;
	}
	public SystemName SetNomen(AEntity entity, String nomen) {
		this.GetComponent(entity).Nomen = nomen;
		
		return this;
	}
	
	public String GetName(AEntity entity) {
		return this.GetComponent(entity).Name;
	}
	public SystemName SetName(AEntity entity, String name) {
		this.GetComponent(entity).Name = name;
		
		return this;
	}
	
	public static SystemName GetInstance() {
		return SystemName.INSTANCE;
	}
}