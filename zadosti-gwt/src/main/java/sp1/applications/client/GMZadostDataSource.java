package sp1.applications.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;


/**
 * @author Dominik Plisek
 */
public class GMZadostDataSource extends DataSource {

	public GMZadostDataSource() {
		super("gmZadost");
		setClientOnly(true);
		setFields(createZadostId(),
				createDatumDoruceni(),
				createDatumOdeslani(),
				createZmenaStavu(),
				createKeDni(),
				createLhuta(),
				createVyrizujeOsoba(),
				createJednaciCislo(),
				createPoznamka(),
				createJednaciCisloZadatele());
	}

	private DataSourceField createZadostId() {
		DataSourceIntegerField zadostId = new DataSourceIntegerField("zadostId");
		zadostId.setPrimaryKey(true);
		return zadostId;
	}

	private DataSourceField createDatumDoruceni() {
		return new DataSourceDateField("datumDoruceni");
	}

	private DataSourceField createDatumOdeslani() {
		return new DataSourceDateField("datumOdeslani");
	}

	private DataSourceField createZmenaStavu() {
		return new DataSourceDateTimeField("zmenaStavu");
	}

	private DataSourceField createKeDni() {
		return new DataSourceDateField("keDni");
	}

	private DataSourceField createLhuta() {
		return new DataSourceIntegerField("lhuta");
	}

	private DataSourceField createVyrizujeOsoba() {
		return new DataSourceTextField("vyrizujeOsoba");
	}

	private DataSourceField createJednaciCislo() {
		return new DataSourceTextField("jednaciCislo");
	}

	private DataSourceField createPoznamka() {
		return new DataSourceTextField("poznamka");
	}

	private DataSourceField createJednaciCisloZadatele() {
		return new DataSourceTextField("jednaciCisloZadatele");
	}

}
