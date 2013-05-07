package sp1.applications.client;

import java.util.Date;
import java.util.List;

import sp1.applications.shared.entity.GMZadost;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * @author Dominik Plisek
 */
public class GMZadostTable extends ListGrid {
	
	private GMZadostControllerWrapperAsync controller = GWT.create(GMZadostControllerWrapper.class);
	
	public GMZadostTable() {
		setDataSource(new GMZadostDataSource());
		setUseAllDataSourceFields(true);
	}

	public void filter(String jednaciCislo, String jednaciCisloZadatele, Date datumDoruceniOd, Date datumDoruceniDo) {
		controller.filter(jednaciCislo, jednaciCisloZadatele, datumDoruceniOd, datumDoruceniDo,
				new RightsAwareAsyncCallback<List<GMZadost>>() {

					@Override
					public void onSuccess(List<GMZadost> result) {
						setData(result);
					}
			
		});
	}

	private void setData(List<GMZadost> result) {
		RecordList recordList = new RecordList();
		for (GMZadost zadost : result) {
			ListGridRecord record = new ListGridRecord();
			record.setAttribute("zadostId", zadost.getZadostId());
			record.setAttribute("datumDoruceni", zadost.getDatumDoruceni());
			record.setAttribute("datumOdeslani", zadost.getDatumOdeslani());
			record.setAttribute("zmenaStavu", zadost.getZmenaStavu());
			record.setAttribute("keDni", zadost.getKeDni());
			record.setAttribute("lhuta", zadost.getLhuta());
			record.setAttribute("vyrizujeOsoba", zadost.getVyrizujeOsoba());
			record.setAttribute("jednaciCislo", zadost.getJednaciCislo());
			record.setAttribute("poznamka", zadost.getPoznamka());
			record.setAttribute("jednaciCisloZadatele", zadost.getJednaciCisloZadatele());
			recordList.add(record);
		}
		setData(recordList);
	}

}
