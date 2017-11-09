package de.mhus.lib.examples.vault;

import java.io.IOException;
import java.util.UUID;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.vault.DefaultEntry;
import de.mhus.lib.core.vault.MVault;
import de.mhus.lib.core.vault.MutableVaultSource;
import de.mhus.lib.core.vault.VaultSource;

@Component(provide=VaultSource.class)
public class ExampleVaultSource extends MutableVaultSource {

	final static String key256 =
			"-----BEGIN RSA PRIVATE KEY-----\n"+
			"MIGtAgEAAiEAxVq56rE81vq5AdHUW1A080fbJ9VMswMEQhq6eNZMeckCAwEAAQIh\n"+
			"AJPB8I5Zcm6WOuu02OQg8fKdgJTYP9r7BMLre6vaoJ5dAhEA85mCJpzJUAcM9t91\n"+
			"5QkVzwIRAM9mkZCsW9GtzhHmRiVIdOcCEQCm5WSjWcYfW0VJmt4mNmxHAhEAs9cA\n"+
			"yi5qv/qyAZtnn9SgaQIRAJNnH1i7zc7VZ4Zk0udBLLY=\n"+
			"-----END RSA PRIVATE KEY-----";

	final static String abendlied = "Über allen Gipfeln\n"
			+ "Ist Ruh,\n"
			+ "In allen Wipfeln\n"
			+ "Spürest du\n"
			+ "Kaum einen Hauch;\n"
			+ "Die Vögelein schweigen im Walde.\n"
			+ "Warte nur, balde\n"
			+ "Ruhest du auch.";
	
	public ExampleVaultSource() {
		name = "ExampleVaultSource";
		try {
			doLoad();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doLoad() throws IOException {
		entries.clear();
		addEntry(new DefaultEntry(UUID.fromString("c647a51e-1ca2-4c01-9b6d-27465b8b6c7a"),MVault.TYPE_RSA_PRIVATE_KEY,"Sample RSA 256 Private Key",key256));
		addEntry(new DefaultEntry(UUID.fromString("2ed0a3fc-7335-48cc-8517-06163be825f8"),MVault.TYPE_TEXT,"Sample Goethe Secret",abendlied));
	}

	@Override
	public void doSave() throws IOException {
		
	}

}
