package sp1.applications.client;

import java.util.Date;
import java.util.List;

import sp1.applications.shared.common.BadRequestException;
import sp1.applications.shared.common.ForbiddenException;
import sp1.applications.shared.entity.GMZadost;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Dominik Plisek
 */
@RemoteServiceRelativePath("wrappers/gmZadost")
public interface GMZadostControllerWrapper extends RemoteService {

	List<GMZadost> filter(String jednaciCislo, String jednaciCisloZadatele,
			Date datumDoruceniOd, Date datumDoruceniDo) throws ForbiddenException, BadRequestException;

	boolean update(String secret, GMZadost entity) throws ForbiddenException,
			BadRequestException;

	boolean create(String secret, GMZadost entity) throws ForbiddenException,
			BadRequestException;
	
}
