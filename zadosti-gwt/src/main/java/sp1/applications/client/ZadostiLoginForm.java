package sp1.applications.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

/**
 * @author Dominik Plisek
 */
public class ZadostiLoginForm extends DynamicForm implements SubmitValuesHandler {
	
	private SecurityControllerWrapperAsync controller = GWT.create(SecurityControllerWrapper.class);
	
	public ZadostiLoginForm() {
		setFields(new TextItem("userName", "Jméno"), 
				new PasswordItem("password", "Heslo"),
				new SubmitItem("submit", "Přihlásit"));
		addSubmitValuesHandler(this);
	}

	@Override
	public void onSubmitValues(SubmitValuesEvent event) {
		controller.login((String) getValue("userName"), (String) getValue("password"), new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				SC.warn("Nebylo možné Vás přihlásit.");
			}

			@Override
			public void onSuccess(String secret) {
				if (secret == null) {
					onFailure(null);
					return;
				}
				switchToMainTabSet(secret);
			}
			
		});
	}

	private void switchToMainTabSet(String secret) {
		hide();
		drawMainTabSet();
		MainTabSet.getInstance().setSecret(secret);
		MainTabSet.getInstance().addTab(new GMZadostTableTab());
	}

	private void drawMainTabSet() {
		MainTabSet.getInstance().setWidth100();
		MainTabSet.getInstance().setHeight100();
		MainTabSet.getInstance().draw();
	}

}
