package fkt;

import java.util.concurrent.TimeUnit;

import fkt.entity.EntityCat;
import fkt.enums.EnumState;
import fkt.exceptions.InvalidStateDurationException;
import fkt.system.SystemState;
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