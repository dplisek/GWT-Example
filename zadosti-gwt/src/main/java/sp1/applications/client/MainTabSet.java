package sp1.applications.client;

import com.smartgwt.client.widgets.tab.TabSet;

/**
 * @author Dominik Plisek
 */
public class MainTabSet extends TabSet {
	
	private static final MainTabSet INSTANCE = new MainTabSet();
	
	public static MainTabSet getInstance() {
		return INSTANCE;
	}

	private MainTabSet() {
		
	}

}
