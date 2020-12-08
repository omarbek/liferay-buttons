package panel.application.list;

import panel.constants.PanelPanelCategoryKeys;
import panel.constants.PanelPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author omar
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class PanelPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PanelPortletKeys.PANEL;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PanelPortletKeys.PANEL + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}