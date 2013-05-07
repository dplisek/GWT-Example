package sp1.applications.client;

import com.smartgwt.client.widgets.tab.Tab;

/**
 * @author Dominik Plisek
 */
public class GMZadostTableTab extends Tab {
	
	private GMZadostTableLayout tableLayout;

	public GMZadostTableTab() {
		setTitle("Žádosti");
		setTableLayoutAsPane();
	}

	private void setTableLayoutAsPane() {
		tableLayout = new GMZadostTableLayout();
		tableLayout.setWidth100();
		tableLayout.setHeight100();
		setPane(tableLayout);
	}
	
}
