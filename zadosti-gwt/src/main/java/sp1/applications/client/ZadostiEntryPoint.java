package sp1.applications.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * @author Dominik Plisek
 */
public class ZadostiEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		ZadostiLoginForm loginForm = new ZadostiLoginForm();
		loginForm.draw();
	}

}
