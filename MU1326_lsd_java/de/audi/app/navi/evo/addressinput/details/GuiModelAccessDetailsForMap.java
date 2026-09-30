/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.details;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsLocationAddress;
import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public class GuiModelAccessDetailsForMap
implements GuiModelAccessDetailsNavi {
    private final NavigationEnv env;
    private final IDestinationHandler detailsHandler;
    private final IconHandler iconHandler;

    public GuiModelAccessDetailsForMap(NavigationEnv navigationEnv, IconHandler iconHandler, IDestinationHandler iDestinationHandler) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.detailsHandler = iDestinationHandler;
    }

    public void onUpdateLocation(NavLocation navLocation) {
        this.env.getLogChannel().log(10000000, "GuiModelAccessDetailsForMap#onUpdateLocation - location=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        GuiModelAccessDetailsEvo guiModelAccessDetailsEvo = !Util.isEmpty(LocationFormatter.formatPOIName(navLocation)) ? new GuiModelAccessDetailsLocationPoi(this.env, this.iconHandler, this.detailsHandler) : new GuiModelAccessDetailsLocationAddress(this.env, this.detailsHandler);
        guiModelAccessDetailsEvo.onUpdateLocation(navLocation);
    }

    public void onUpdateLocation(OperatorCallResult operatorCallResult) {
    }

    public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }

    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
        return null;
    }
}

