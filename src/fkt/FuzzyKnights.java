package fkt;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import fkt.component.ComponentState;
import fkt.entity.EntityCat;
import fkt.enums.EnumState;
import fkt.exceptions.InvalidStateDurationException;
import fkt.system.SystemEntity;
import fkt.system.SystemName;
import fkt.system.SystemState;
import fkt.utility.Helper;

public class FuzzyKnights {
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		EntityCat entity = new EntityCat();

		SystemState.GetInstance().SetState(entity, EnumState.WEAK, 200);
		TimeUnit.SECONDS.sleep(1);
		SystemState.GetInstance().RemoveAllExpiredStates(entity);
		
		Helper.cout(entity);
	}
}