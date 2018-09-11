package fkt.common.component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.enums.EnumComponentType;
import fkt.utility.Attribute;
import fkt.utility.AttributeModifier;
import fkt.common.enums.EnumAttributeType;

public class ComponentAttributes extends AComponent {
	public ConcurrentHashMap<EnumAttributeType, Attribute> Attributes = new ConcurrentHashMap<EnumAttributeType, Attribute>();
	public ConcurrentHashMap<EnumAttributeType, List<AttributeModifier>> Modifiers = new ConcurrentHashMap<EnumAttributeType, List<AttributeModifier>>();

	public ComponentAttributes() {
		super(EnumComponentType.ATTRIBUTES);
		
		for(EnumAttributeType type : EnumAttributeType.values()) {
			this.Attributes.put(type, new Attribute(type, 0, 0, 0));
			this.Modifiers.put(type, new ArrayList<AttributeModifier>());
		}
	}
	public ComponentAttributes(ConcurrentHashMap<EnumAttributeType, Attribute> attributes) {
		super(EnumComponentType.ATTRIBUTES);
		
		this.Attributes = attributes;
	}
	
	public ComponentAttributes(EnumAttributeType attributeType, int current, int min, int max) {
		this();

		this.Attributes.put(attributeType, new Attribute(attributeType, current, min, max));
	}
	public ComponentAttributes(EnumAttributeType attributeType, int current) {
		this();

		this.Attributes.put(attributeType, new Attribute(attributeType, current, 0, current));
	}

	/**
	 * Pass an object with the following syntax:
	 * 
	 * new Object[][] {
	 * 	{ <EnumAttributeType> AttributeType, <int> Current, <int> Max },
	 *  ...
	 * }
	 * 
	 * @param Object[][] attributes
	 */
	public ComponentAttributes(Object[][] attributes){
		this();
		
		for(Object[] attribute : attributes) {
			if(attribute.length == 2) {
				this.Attributes.put(
					(EnumAttributeType)attribute[0],
					new Attribute(
						(EnumAttributeType)attribute[0],
						Double.valueOf(attribute[1].toString())
					)
				);
			} else if(attribute.length == 3) { 
				this.Attributes.put(
					(EnumAttributeType)attribute[0],
					new Attribute(
						(EnumAttributeType)attribute[0],
						Double.valueOf(attribute[1].toString()),
						Double.valueOf(attribute[2].toString())
					)
				);
			} else if(attribute.length == 4) { 
				this.Attributes.put(
						(EnumAttributeType)attribute[0],
						new Attribute(
							(EnumAttributeType)attribute[0],
							Double.valueOf(attribute[1].toString()),
							Double.valueOf(attribute[2].toString()),
							Double.valueOf(attribute[3].toString())
						)
					);
				}
		}
	}
}