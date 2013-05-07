package sp1.applications.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;

/**
 * @author Dominik Plisek
 */
public abstract class RightsAwareAsyncCallback<T> implements
		AsyncCallback<T> {

	@Override
	public void onFailure(Throwable caught) {
		SC.warn("Not logged in.");
	}

}
