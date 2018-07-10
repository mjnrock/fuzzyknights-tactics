package fkt.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import fkt.FuzzyKnights;
import fkt.common.entity.AEntity;
import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumState;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.system.SystemState;

public class SystemStateTests {
	FuzzyKnights FK;
	AEntity Entity;
	
	@Before
    public void Init() throws Exception {
		FK = FuzzyKnights.GetInstance();
		Entity = new EntityCat();
	}	
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();	

    @Test
    public void InvalidStateDuration() throws InvalidStateDurationException {
		//	SystemState > SetState does not allow bad duration entries
    	expectedEx.expect(InvalidStateDurationException.class);
		SystemState.GetInstance().SetState(Entity, EnumState.CASTING, 0);
		SystemState.GetInstance().SetState(Entity, EnumState.CASTING, -16511);
	}
    
    @Test
    public void StateExpirations() throws InvalidStateDurationException, InterruptedException {
		//	SystemState > SetState adds to the Entity's State
		SystemState.GetInstance().SetState(Entity, EnumState.CASTING, 2000);
		Assertions.assertTrue(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));


		//	SystemState > IsPersistent = FALSE
		Assertions.assertFalse(SystemState.GetInstance().IsPersistent(Entity, EnumState.CASTING));

		
		//	SystemState > IsExpired = FALSE
		Assertions.assertFalse(SystemState.GetInstance().IsExpired(Entity, EnumState.CASTING));
		
		
		//	SystemState > RemoveAllExpiredStates does NOT removes the (yet non-expired) State
		TimeUnit.SECONDS.sleep(1);
		SystemState.GetInstance().RemoveAllExpiredStates(Entity);
		Assertions.assertTrue(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));

		
		//	SystemState > GetExpiration returns proper (long) numbers
		long expiresAt = SystemState.GetInstance().GetExpiration(Entity, EnumState.CASTING);
		Assertions.assertTrue(
			(expiresAt > 0)
			&& (expiresAt <= Long.MAX_VALUE)
		);
		
		
		//	SystemState > IsExpired = FALSE
		TimeUnit.SECONDS.sleep(1);
		Assertions.assertTrue(SystemState.GetInstance().IsExpired(Entity, EnumState.CASTING));
		//	SystemState > RemoveAllExpiredStates does remove the Expired State
		SystemState.GetInstance().RemoveAllExpiredStates(Entity);
		Assertions.assertFalse(SystemState.GetInstance().GetStates(Entity).containsKey(EnumState.CASTING));

		
		//	SystemState > IsPersistent = TRUE
		Assertions.assertTrue(SystemState.GetInstance().IsPersistent(Entity, EnumState.NORMAL));
	}
}