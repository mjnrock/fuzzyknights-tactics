package fkt.common.system;

import fkt.common.component.AComponent;
import fkt.common.entity.AEntity;

public interface IComponentSystem {	
	public AComponent GetComponent(AEntity entity);
}