package sp1.applications.client;

import java.util.Date;
import java.util.List;

import sp1.applications.shared.entity.GMZadost;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;

/**
 * @author Dominik Plisek
 */
public class GMZadostTable extends ListGrid implements RecordDoubleClickHandler {
	
	private GMZadostControllerWrapperAsync controller = GWT.create(GMZadostControllerWrapper.class);
	
	public GMZadostTable() {
		setDataSource(GMZadostDataSource.getInstance());
		setUseAllDataSourceFields(true);
		addRecordDoubleClickHandler(this);
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
			recordList.add(new GMZadostRecord(zadost));
		}
		setData(recordList);
	}

	@Override
	public void onRecordDoubleClick(RecordDoubleClickEvent event) {
		MainTabSet.getInstance().addTab(new GMZadostTab(((GMZadostRecord) event.getRecord()).getZadost()));
	}

}
