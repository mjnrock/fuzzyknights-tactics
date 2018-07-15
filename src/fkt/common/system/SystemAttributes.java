package fkt.common.system;

import fkt.common.component.ComponentAttributes;
import fkt.common.entity.AEntity;
import fkt.common.enums.EnumAttributeType;
import fkt.common.enums.EnumComponentType;
import fkt.utility.BoundedValue;

public class SystemAttributes {
	private static final SystemAttributes INSTANCE = new SystemAttributes();
	protected static final EnumComponentType COMPONENT_TYPE = EnumComponentType.ATTRIBUTES;

	public ComponentAttributes GetComponent(AEntity entity) {
		return (ComponentAttributes)SystemEntity.GetInstance().GetComponent(entity, SystemAttributes.COMPONENT_TYPE);
	}
	
	public BoundedValue GetAttribute(AEntity entity, EnumAttributeType attr) {
		return (BoundedValue)this.GetComponent(entity).Attributes.get(attr);
	}
	

	public double GetHealth(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.HEALTH).GetCurrent();
	}
	public SystemAttributes SetHealth(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.HEALTH).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddHealth(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.HEALTH).AddCurrent(amount);
		
		return this;
	}
	

	public double GetMana(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.MANA).GetCurrent();
	}
	public SystemAttributes SetMana(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.MANA).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddMana(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.MANA).AddCurrent(amount);
		
		return this;
	}
	

	public double GetStrength(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.STRENGTH).GetCurrent();
	}
	public SystemAttributes SetStrength(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.STRENGTH).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddStrength(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.STRENGTH).AddCurrent(amount);
		
		return this;
	}
	

	public double GetToughness(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.TOUGHNESS).GetCurrent();
	}
	public SystemAttributes SetToughness(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.TOUGHNESS).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddToughness(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.TOUGHNESS).AddCurrent(amount);
		
		return this;
	}
	

	public double GetPower(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.POWER).GetCurrent();
	}
	public SystemAttributes SetPower(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.POWER).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddPower(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.POWER).AddCurrent(amount);
		
		return this;
	}
	

	public double GetResistance(AEntity entity) {
		return this.GetAttribute(entity, EnumAttributeType.RESISTANCE).GetCurrent();
	}
	public SystemAttributes SetResistance(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.RESISTANCE).SetCurrent(amount);
		
		return this;
	}
	public SystemAttributes AddResistance(AEntity entity, double amount) {
		this.GetAttribute(entity, EnumAttributeType.RESISTANCE).AddCurrent(amount);
		
		return this;
	}
	
	public static SystemAttributes GetInstance() {
		return SystemAttributes.INSTANCE;
	}
}