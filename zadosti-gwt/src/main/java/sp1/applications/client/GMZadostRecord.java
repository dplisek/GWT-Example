package sp1.applications.client;

import sp1.applications.shared.entity.GMZadost;

import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * @author Dominik Plisek
 */
public class GMZadostRecord extends ListGridRecord {
	
	private final GMZadost zadost;

	public GMZadostRecord(GMZadost zadost) {
		this.zadost = zadost;
		setAttribute("zadostId", zadost.getZadostId());
		setAttribute("datumDoruceni", zadost.getDatumDoruceni());
		setAttribute("datumOdeslani", zadost.getDatumOdeslani());
		setAttribute("zmenaStavu", zadost.getZmenaStavu());
		setAttribute("keDni", zadost.getKeDni());
		setAttribute("lhuta", zadost.getLhuta());
		setAttribute("vyrizujeOsoba", zadost.getVyrizujeOsoba());
		setAttribute("jednaciCislo", zadost.getJednaciCislo());
		setAttribute("poznamka", zadost.getPoznamka());
		setAttribute("jednaciCisloZadatele", zadost.getJednaciCisloZadatele());
	}

	public GMZadost getZadost() {
		return zadost;
	}

}
