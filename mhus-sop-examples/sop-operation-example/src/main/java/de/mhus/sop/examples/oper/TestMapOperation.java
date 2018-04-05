package de.mhus.sop.examples.oper;

import java.util.Date;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.MDate;
import de.mhus.lib.core.MSystem;
import de.mhus.lib.core.definition.DefRoot;
import de.mhus.lib.core.strategy.AbstractOperation;
import de.mhus.lib.core.strategy.Operation;
import de.mhus.lib.core.strategy.OperationDescription;
import de.mhus.lib.core.strategy.OperationResult;
import de.mhus.lib.core.strategy.Successful;
import de.mhus.lib.core.strategy.TaskContext;

@Component
public class TestMapOperation extends AbstractOperation implements Operation {

	@Override
	protected OperationResult doExecute2(TaskContext context) throws Exception {
		log().i("Execute",context.getParameters());
		return new Successful(this, "ok", "time", MDate.toIso8601(new Date()), "timestamp", ""+System.currentTimeMillis(), "host",MSystem.getHostname(), "free", MSystem.freeMemoryAsString());
	}

	@Override
	protected OperationDescription createDescription() {
		return new OperationDescription(this,"Test", new DefRoot(
		
				));
	}

}
