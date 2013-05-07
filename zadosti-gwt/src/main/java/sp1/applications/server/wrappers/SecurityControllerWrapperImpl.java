package sp1.applications.server.wrappers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sp1.applications.client.SecurityControllerWrapper;
import sp1.applications.server.rest.SecurityController;
import sp1.applications.shared.common.ForbiddenException;

/**
 * @author Dominik Plisek
 */
@SuppressWarnings("serial")
public class SecurityControllerWrapperImpl extends
		AutoinjectingRemoteServiceServlet implements SecurityControllerWrapper {
	
	@Autowired
	private SecurityController controller;

	@Override
	public String login(String username, String password) {
	    return controller.login(username, password);
	}

	@Override
	public Map<String, String> listRights(String secret) throws ForbiddenException {
	    return controller.listRights(secret);
	}
	
	

}
