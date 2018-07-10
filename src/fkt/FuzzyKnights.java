package fkt;

import java.util.concurrent.TimeUnit;

import fkt.common.component.structs.BoundedValue;
import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumAttributeType;
import fkt.common.enums.EnumState;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.system.SystemState;
import fkt.utility.Helper;

public class FuzzyKnights {
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		EntityCat entity = new EntityCat();

		SystemState.GetInstance().SetState(entity, EnumState.CASTING, 200);
		TimeUnit.SECONDS.sleep(1);
		SystemState.GetInstance().RemoveAllExpiredStates(entity);
		
		Helper.cout(entity);
	}
}