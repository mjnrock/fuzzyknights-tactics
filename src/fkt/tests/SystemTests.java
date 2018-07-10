package fkt.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import fkt.FuzzyKnights;
import fkt.common.entity.AEntity;
import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumState;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.system.SystemState;

public class SystemTests {
	FuzzyKnights FK;
	AEntity Entity;
	
	@Before
    public void setUp() throws Exception {
		FK = FuzzyKnights.GetInstance();
		Entity = new EntityCat();
	}

    @Test
    public void SystemStateManagement() throws InvalidStateDurationException, InterruptedException {

		//	SystemState > SetState adds to the Entity's State
		SystemState.GetInstance().SetState(Entity, EnumState.CASTING, 2000);
		Assertions.assertTrue(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));
		
		//	SystemState > RemoveAllExpiredStates does NOT removes the (yet non-expired) State
		TimeUnit.SECONDS.sleep(1);
		SystemState.GetInstance().RemoveAllExpiredStates(Entity);
		Assertions.assertTrue(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));
		
		//	SystemState > RemoveAllExpiredStates does remove the Expired State
		TimeUnit.SECONDS.sleep(1);
		SystemState.GetInstance().RemoveAllExpiredStates(Entity);
		Assertions.assertFalse(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));
	}
}