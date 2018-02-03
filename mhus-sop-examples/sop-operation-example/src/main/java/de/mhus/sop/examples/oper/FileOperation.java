package de.mhus.sop.examples.oper;

import java.io.File;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.definition.DefRoot;
import de.mhus.lib.core.strategy.AbstractOperation;
import de.mhus.lib.core.strategy.NotSuccessful;
import de.mhus.lib.core.strategy.Operation;
import de.mhus.lib.core.strategy.OperationDescription;
import de.mhus.lib.core.strategy.OperationResult;
import de.mhus.lib.core.strategy.Successful;
import de.mhus.lib.core.strategy.TaskContext;
import de.mhus.lib.core.util.Version;
import de.mhus.lib.form.definition.FmText;

@Component(properties="tags=acl=*")
public class FileOperation extends AbstractOperation implements Operation {

	@Override
	protected OperationResult doExecute2(TaskContext context) throws Exception {
		log().i("Execute",context.getParameters());
		String fileName = context.getParameters().getString("file");
		File f = new File("etc/" + fileName);
		if (f.exists())
			return new Successful(this,fileName, f);
		else
			return new NotSuccessful(this,"file not found", -1);
	}

	@Override
	protected OperationDescription createDescription() {
		return new OperationDescription(this,new Version("1.0.1"),"Test", new DefRoot(
				new FmText("file", "File name", "file name in karaf etc")
				)).putParameter(OperationDescription.TAGS, "acl=*");
	}

}
