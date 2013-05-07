package sp1.applications.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Dominik Plisek
 */
public interface SecurityControllerWrapperAsync {

	void listRights(String secret, AsyncCallback<Map<String, String>> callback);

	void login(String username, String password, AsyncCallback<String> callback);

}
