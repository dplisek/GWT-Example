package sp1.applications.client;

import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author Dominik Plisek
 */
public class GMZadostTableLayout extends VLayout {
	
	private GMZadostTable table;
	private GMZadostTableFilter filterForm;
	
	public GMZadostTableLayout() {
		createTable();
		createFilterForm();
		addMember(filterForm);
		addMember(table);
	}

	private void createTable() {
		table = new GMZadostTable();
		table.setWidth100();
		table.setHeight("*");
	}

	private void createFilterForm() {
		filterForm = new GMZadostTableFilter(table);
		filterForm.setWidth100();
		filterForm.setAutoHeight();
	}

}
