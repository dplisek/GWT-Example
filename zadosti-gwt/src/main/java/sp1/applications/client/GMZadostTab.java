package sp1.applications.client;

import sp1.applications.shared.entity.GMZadost;

import com.smartgwt.client.widgets.tab.Tab;

/**
 * @author Dominik Plisek
 */
public class GMZadostTab extends Tab {

	public GMZadostTab(GMZadost zadost) {
		setTitle("" + zadost.getZadostId());
		setCanClose(true);
		setPane(new GMZadostForm(zadost));
	}

}
