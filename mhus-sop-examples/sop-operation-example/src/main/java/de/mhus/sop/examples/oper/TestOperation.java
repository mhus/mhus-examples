package de.mhus.sop.examples.oper;

import java.util.Date;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.adb.query.Db;
import de.mhus.lib.core.MApi;
import de.mhus.lib.core.definition.DefRoot;
import de.mhus.lib.core.strategy.AbstractOperation;
import de.mhus.lib.core.strategy.Operation;
import de.mhus.lib.core.strategy.OperationDescription;
import de.mhus.lib.core.strategy.OperationResult;
import de.mhus.lib.core.strategy.Successful;
import de.mhus.lib.core.strategy.TaskContext;
import de.mhus.lib.form.definition.FmText;

@Component
public class TestOperation extends AbstractOperation implements Operation {

	@Override
	protected OperationResult doExecute2(TaskContext context) throws Exception {
		log().i("Execute",context.getParameters());
		return new Successful(this);
	}

	@Override
	protected OperationDescription createDescription() {
		return new OperationDescription(this,"Test", new DefRoot(
				new FmText("firstname", "First name", "Insert first name"),
				new FmText("familyname", "Family name", "Insert family name")
				));
	}

}
