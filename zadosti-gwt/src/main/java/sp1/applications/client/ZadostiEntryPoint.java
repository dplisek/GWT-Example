package sp1.applications.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * @author Dominik Plisek
 */
public class ZadostiEntryPoint implements EntryPoint {

	private MainTabSet mainTabSet;

	public void onModuleLoad() {
		drawMainTabSet();
		mainTabSet.addTab(new GMZadostTableTab());
	}

	private void drawMainTabSet() {
		mainTabSet = new MainTabSet();
		mainTabSet.setWidth100();
		mainTabSet.setHeight100();
		mainTabSet.draw();
	}

}
