package fkt.common.component;

import java.util.concurrent.ConcurrentHashMap;

import fkt.common.component.structs.Resource;
import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumResourceType;

public class ComponentResources extends AComponent {
	public ConcurrentHashMap<EnumResourceType, Resource> Resources = new ConcurrentHashMap<EnumResourceType, Resource>();
	
	public ComponentResources(EnumResourceType resourceType, int current, int max) {
		super(EnumComponentType.RESOURCES);

		this.Resources.put(resourceType, new Resource(resourceType, current, max));
	}
	public ComponentResources(int current, int max) {
		this(EnumResourceType.HP, current, max);
	}
	public ComponentResources() {
		this(EnumResourceType.HP, 1, 1);
	}

	/**
	 * Pass an object with the following syntax:
	 * 
	 * new Object[][] {
	 * 	{ <EnumResourceType> ResourceType, <int> Current, <int> Max },
	 *  ...
	 * }
	 * 
	 * @param Object[][] resources
	 */
	public ComponentResources(Object[][] resources){
		super(EnumComponentType.RESOURCES);
		
		for(Object[] resource : resources) {			
			this.Resources.put(
				(EnumResourceType)resource[0],
				new Resource((EnumResourceType)resource[0], (int)resource[1], (int)resource[2])
			);
		}
	}
	public ComponentResources(ConcurrentHashMap<EnumResourceType, Resource> resources) {
		super(EnumComponentType.RESOURCES);
		
		this.Resources = resources;
	}
}