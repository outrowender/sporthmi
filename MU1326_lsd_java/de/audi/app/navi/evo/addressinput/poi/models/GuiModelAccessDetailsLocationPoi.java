/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.details.listbuilders.AddressDetailsRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public class GuiModelAccessDetailsLocationPoi
extends GuiModelAccessDetailsEvo {
    private final AddressDetailsRowBuilder poiDetailsRowBuilder;
    private final NavigationEnv env;
    private final IconHandler iconHandler;

    public GuiModelAccessDetailsLocationPoi(NavigationEnv navigationEnv, IconHandler iconHandler, IDestinationHandler iDestinationHandler) {
        super(navigationEnv, navigationEnv.getLogChannel(), iDestinationHandler);
        this.iconHandler = iconHandler;
        this.poiDetailsRowBuilder = new AddressDetailsRowBuilder();
        this.env = navigationEnv;
    }

    public void onUpdateLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "[PoiInputModel] %2#onUpdateLocation - navlocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
        super.onUpdateLocation(navLocation);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
        int n = LocationFormatter.getIconResourceID(this.iconHandler, navLocation);
        BaseListModelApp baseListModelApp = this.addressList.getEmptyCopy();
        int n2 = 0;
        EvoListRow evoListRow = this.poiDetailsRowBuilder.buildListRowWithIcon(locationFormattingResponse.getFirstLineAsText(), n, n2);
        baseListModelApp.setRow(n2++, evoListRow);
        EvoListRow evoListRow2 = this.poiDetailsRowBuilder.buildListRow(locationFormattingResponse.getSecondLineAsText(), n2);
        baseListModelApp.setRow(n2++, evoListRow2);
        baseListModelApp.setLength(n2);
        this.addressList.update(baseListModelApp);
    }

    public void onUpdateLocation(OperatorCallResult operatorCallResult) {
        this.logChannel.log(10000000, "[PoiInputModel] %2#onUpdateLocation - operatorCallResult=%1", (Object)operatorCallResult, (Object)this.CLASS_NAME);
        super.onUpdateLocation(operatorCallResult);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(operatorCallResult, this.env);
        BaseListModelApp baseListModelApp = this.addressList.getEmptyCopy();
        int n = 0;
        EvoListRow evoListRow = this.poiDetailsRowBuilder.buildListRowWithIcon(locationFormattingResponse.getFirstLineAsText(), -1, n);
        baseListModelApp.setRow(n++, evoListRow);
        EvoListRow evoListRow2 = this.poiDetailsRowBuilder.buildListRow(locationFormattingResponse.getSecondLineAsText(), n);
        baseListModelApp.setRow(n++, evoListRow2);
        baseListModelApp.setLength(n);
        this.addressList.update(baseListModelApp);
    }

    public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }

    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
        return null;
    }
}

