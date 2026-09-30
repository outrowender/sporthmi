/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.details;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.details.listbuilders.AddressDetailsRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;

public class GuiModelAccessDetailsLocationAddress
extends GuiModelAccessDetailsEvo
implements GuiModelAccessDetailsNavi {
    private final NavigationEnv env;
    private final AddressDetailsRowBuilder detailsRowBuilder;

    public GuiModelAccessDetailsLocationAddress(NavigationEnv navigationEnv, IDestinationHandler iDestinationHandler) {
        super(navigationEnv, navigationEnv.getLogChannel(), iDestinationHandler);
        this.env = navigationEnv;
        this.detailsRowBuilder = new AddressDetailsRowBuilder();
    }

    public void onUpdateLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "[Details] GuiModelAccessDetailsLocationAddress#onUpdateLocation - location=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        super.onUpdateLocation(navLocation);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
        BaseListModelApp baseListModelApp = this.addressList.getEmptyCopy();
        int n = 0;
        EvoListRow evoListRow = this.detailsRowBuilder.buildListRow(locationFormattingResponse.getFirstLineAsText(), n);
        baseListModelApp.setRow(n++, evoListRow);
        EvoListRow evoListRow2 = this.detailsRowBuilder.buildListRow(locationFormattingResponse.getSecondLineAsText(), n);
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

