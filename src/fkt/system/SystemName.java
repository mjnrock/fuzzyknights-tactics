package fkt.system;

import fkt.component.ComponentName;
import fkt.entity.AEntity;
import fkt.enums.EnumComponentType;

public class SystemName {
	private static final SystemName INSTANCE = new SystemName();
	protected static final EnumComponentType COMPONENT_TYPE = EnumComponentType.NAME;

	public ComponentName GetComponent(AEntity entity) {
		return (ComponentName)SystemEntity.GetInstance().GetComponent(entity, SystemName.COMPONENT_TYPE);
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