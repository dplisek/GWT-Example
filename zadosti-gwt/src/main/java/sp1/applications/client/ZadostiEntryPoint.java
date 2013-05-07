package sp1.applications.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * @author Dominik Plisek
 */
public class ZadostiEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		drawMainTabSet();
		MainTabSet.getInstance().addTab(new GMZadostTableTab());
	}

	private void drawMainTabSet() {
		MainTabSet.getInstance().setWidth100();
		MainTabSet.getInstance().setHeight100();
		MainTabSet.getInstance().draw();
	}

}
