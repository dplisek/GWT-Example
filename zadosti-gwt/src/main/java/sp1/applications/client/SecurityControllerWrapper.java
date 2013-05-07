package sp1.applications.client;

import java.util.Map;

import sp1.applications.shared.common.ForbiddenException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Dominik Plisek
 */
@RemoteServiceRelativePath("wrappers/security")
public interface SecurityControllerWrapper extends RemoteService {

	String login(String username, String password);

	Map<String, String> listRights(String secret) throws ForbiddenException;

}
