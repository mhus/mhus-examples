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
import de.mhus.lib.core.util.Version;
import de.mhus.osgi.sop.api.adb.AdbApi;
import de.mhus.osgi.sop.api.model.SopRegister;

@Component
public class RegistryOperation extends AbstractOperation implements Operation {

	@Override
	protected OperationResult doExecute2(TaskContext context) throws Exception {
		log().i("Execute",context.getParameters());
		
		MApi.lookup(AdbApi.class).getManager().inject(new SopRegister("ping", new Date().toString(), "" , new Date().toString(), null)).save();
		
		for (SopRegister obj : MApi.lookup(AdbApi.class).getManager().getByQualification(Db.query(SopRegister.class).eq(SopRegister::getName, "ping")))
			System.out.println(obj);
		
		return new Successful(this);
	}

	@Override
	protected OperationDescription createDescription() {
		return new OperationDescription(this,new Version("1.0.1"),"Test", new DefRoot(
		
				)).putParameter(OperationDescription.TAGS, "acl=*");
	}

}
