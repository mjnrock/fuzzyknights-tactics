package fkt.common.component;

import java.util.concurrent.ConcurrentHashMap;

import fkt.common.enums.EnumComponentType;
import fkt.utility.Attribute;
import fkt.common.enums.EnumAttributeType;

public class ComponentAttributes extends AComponent {
	public ConcurrentHashMap<EnumAttributeType, Attribute> Attributes = new ConcurrentHashMap<EnumAttributeType, Attribute>();
	
	public ComponentAttributes(EnumAttributeType attributeType, int current, int min, int max) {
		super(EnumComponentType.ATTRIBUTES);

		this.Attributes.put(attributeType, new Attribute(attributeType, current, min, max));
	}
	public ComponentAttributes(EnumAttributeType attributeType, int current) {
		super(EnumComponentType.ATTRIBUTES);

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
		super(EnumComponentType.ATTRIBUTES);
		
		for(Object[] attribute : attributes) {
			if(attribute.length == 2) {
				this.Attributes.put(
					(EnumAttributeType)attribute[0],
					new Attribute(
						(EnumAttributeType)attribute[0],
						Double.valueOf(attribute[1].toString()),
						0,
						Double.valueOf(attribute[1].toString())
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
	public ComponentAttributes(ConcurrentHashMap<EnumAttributeType, Attribute> attributes) {
		super(EnumComponentType.ATTRIBUTES);
		
		this.Attributes = attributes;
	}
}