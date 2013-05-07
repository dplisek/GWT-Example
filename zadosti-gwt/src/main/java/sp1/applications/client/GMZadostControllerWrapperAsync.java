package sp1.applications.client;

import java.util.Date;
import java.util.List;

import sp1.applications.shared.entity.GMZadost;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Dominik Plisek
 */
public interface GMZadostControllerWrapperAsync {

	void filter(String jednaciCislo, String jednaciCisloZadatele,
			Date datumDoruceniOd, Date datumDoruceniDo, AsyncCallback<List<GMZadost>> callback);

}
