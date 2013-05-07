package sp1.applications.server.wrappers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sp1.applications.client.GMZadostControllerWrapper;
import sp1.applications.server.rest.GMZadostController;
import sp1.applications.shared.common.BadRequestException;
import sp1.applications.shared.common.ForbiddenException;
import sp1.applications.shared.entity.GMZadost;

/**
 * @author Dominik Plisek
 */
@SuppressWarnings("serial")
public class GMZadostControllerWrapperImpl extends
		AutoinjectingRemoteServiceServlet implements GMZadostControllerWrapper {
	
	@Autowired
	private GMZadostController controller;

	@Override
	public List<GMZadost> filter(String jednaciCislo,
			String jednaciCisloZadatele, Date datumDoruceniOd,
			Date datumDoruceniDo) throws ForbiddenException, BadRequestException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return controller.filter("FULL", jednaciCislo, jednaciCisloZadatele, dateFormat.format(datumDoruceniOd),
				dateFormat.format(datumDoruceniDo));
	}
	
	@Override
	public boolean create(String secret, GMZadost entity) throws ForbiddenException, BadRequestException {
		controller.create(secret, entity);
		return true;
	}
	
	@Override
	public boolean update(String secret, GMZadost entity) throws ForbiddenException, BadRequestException {
		controller.update(secret, entity);
		return true;
	}
	
}
