package sp1.applications.client;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

import sp1.applications.shared.entity.GMZadost;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.SubmitItem;

/**
 * @author Dominik Plisek
 */
public class GMZadostForm extends DynamicForm implements SubmitValuesHandler {
	
	private GMZadostControllerWrapperAsync controller = GWT.create(GMZadostControllerWrapper.class);

	public GMZadostForm(GMZadost zadost) {
		setDataSource(GMZadostDataSource.getInstance());
		setUseAllDataSourceFields(true);
		setFields(new SubmitItem("submit", "Uložit"));
		editRecord(new GMZadostRecord(zadost));
		addSubmitValuesHandler(this);
	}

	@Override
	public void onSubmitValues(SubmitValuesEvent event) {
		String secret = MainTabSet.getInstance().getSecret();
		controller.update(secret, createGMZadostFromMap(event.getValuesAsMap()), new RightsAwareAsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				SC.say("Uloženo.");
			}
			
		});
	}

	private GMZadost createGMZadostFromMap(Map map) {
		GMZadost zadost = new GMZadost();
		zadost.setDatumDoruceni(new Date(((java.util.Date) map.get("datumDoruceni")).getTime()));
		zadost.setDatumOdeslani(new Date(((java.util.Date) map.get("datumOdeslani")).getTime()));
		zadost.setJednaciCislo((String) map.get("jednaciCislo"));
		zadost.setJednaciCisloZadatele((String) map.get("jednaciCisloZadatele"));
		zadost.setKeDni(new Date(((java.util.Date) map.get("keDni")).getTime()));
		zadost.setLhuta(Integer.parseInt(String.valueOf(map.get("lhuta"))));
		zadost.setPoznamka((String) map.get("poznamka"));
		zadost.setVyrizujeOsoba((String) map.get("vyrizujeOsoba"));
		zadost.setZadostId(Integer.parseInt(String.valueOf(map.get("zadostId"))));
		zadost.setZmenaStavu(new Timestamp(((java.util.Date) map.get("zmenaStavu")).getTime()));
		return zadost;
	}

}
