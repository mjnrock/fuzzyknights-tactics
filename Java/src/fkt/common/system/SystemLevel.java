package fkt.common.system;

import fkt.common.component.ComponentLevel;
import fkt.common.entity.AEntity;
import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumMessageState;
import fkt.common.message.AMessage;

public class SystemLevel implements IMessageable, IComponentSystem {
	private static final SystemLevel INSTANCE = new SystemLevel();
	protected static final EnumComponentType COMPONENT_TYPE = EnumComponentType.LEVEL;

	@Override
	public SystemLevel ReceiveMessage(AMessage message) {
		//TODO Process the Message
		
		this.MarkAsCompleted(message);
		return this;
	}
	@Override
	public SystemLevel MarkAsCompleted(AMessage message) {
		message.SetState(EnumMessageState.COMPLETED);
		
		return this;
	}

	@Override
	public ComponentLevel GetComponent(AEntity entity) {
		return (ComponentLevel)SystemEntity.GetInstance().GetEntityComponent(entity, SystemLevel.COMPONENT_TYPE);
	}
	
	
	public int GetLevel(AEntity entity) {
		return this.GetComponent(entity).Experience.Level;
	}
	public SystemLevel SetLevel(AEntity entity, int level) {
		this.GetComponent(entity).Experience.Level = level;
		
		return this;
	}
	
	
	public int GetCurrent(AEntity entity) {
		return this.GetComponent(entity).Experience.Current;
	}
	public SystemLevel SetCurrent(AEntity entity, int current) {
		this.GetComponent(entity).Experience.Current = current;
		
		return this;
	}
	public SystemLevel AddCurrent(AEntity entity, int amount) {
		this.GetComponent(entity).Experience.Current += amount;
		
		return this;
	}
	
	
	public int GetMax(AEntity entity) {
		return this.GetComponent(entity).Experience.Max;
	}
	public SystemLevel SetMax(AEntity entity, int max) {
		this.GetComponent(entity).Experience.Max = max;
		
		return this;
	}
	public SystemLevel AddMax(AEntity entity, int amount) {
		this.GetComponent(entity).Experience.Max += amount;
		
		return this;
	}
		
	
	public int GetXP(AEntity entity) {
		return this.GetComponent(entity).Experience.Current;
	}
	public SystemLevel SetXP(AEntity entity, int amount) {
		this.GetComponent(entity).Experience.Current = amount;
		
		while(this.CanLevelUp(entity)) {
			this.LevelUp(entity);
		}
		
		return this;
	}
	public SystemLevel AddXP(AEntity entity, int amount) {
		this.GetComponent(entity).Experience.Current += amount;
		
		while(this.CanLevelUp(entity)) {
			this.LevelUp(entity);
		}
		
		return this;
	}
	
	public boolean CanLevelUp(AEntity entity) {
		return this.GetComponent(entity).Experience.Current >= this.GetComponent(entity).Experience.Max;
	}
	
	public SystemLevel LevelUp(AEntity entity) {
		//TODO Add the "Level Up" code here
		
		return this;
	}
	
	public static SystemLevel GetInstance() {
		return SystemLevel.INSTANCE;
	}
}