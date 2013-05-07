package sp1.applications.client;

import java.util.Date;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

/**
 * @author Dominik Plisek
 */
public class GMZadostTableFilter extends DynamicForm implements SubmitValuesHandler {

	private GMZadostTable table;

	public GMZadostTableFilter(GMZadostTable table) {
		this.table = table;
		setNumCols(4);
		setColWidths(200, "*", 200, "*");
		setFields(new TextItem("jednaciCislo"),
				new TextItem("jednaciCisloZadatele"),
				new DateItem("datumDoruceniOd"),
				new DateItem("datumDoruceniDo"),
				new SubmitItem("submit", "Filtrovat"));
		for (FormItem item : getFields()) {
			item.setWidth("*");
		}
		addSubmitValuesHandler(this);
	}

	@Override
	public void onSubmitValues(SubmitValuesEvent event) {
		table.filter((String) getValue("jednaciCislo"),
				(String) getValue("jednaciCisloZadatele"),
				(Date) getValue("datumDoruceniOd"),
				(Date) getValue("datumDoruceniDo"));
	}

}
