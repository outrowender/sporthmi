/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class OnlineSearchUpdateMapCommand
extends NavCommand {
    private LogChannel logChannel;
    private OnlinePOIResultList resultList;
    private PoiOnlineSearchArea searchArea;
    private int index;
    private IPreviewMap previewMap;

    public OnlineSearchUpdateMapCommand(LogChannel logChannel, OnlinePOIResultList onlinePOIResultList, PoiOnlineSearchArea poiOnlineSearchArea, int n, IPreviewMap iPreviewMap) {
        super("update-previewMap-command");
        this.logChannel = logChannel;
        this.resultList = onlinePOIResultList;
        this.searchArea = poiOnlineSearchArea;
        this.index = n;
        this.previewMap = iPreviewMap;
    }

    public void execute() {
        this.logChannel.log(1000000, this.CLASS_NAME + "CMD_updatePreviewMap: updating index %1", (long)this.index);
        NavLocation navLocation = this.resultList.getTransformedLocationAt(this.index);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
        String string = locationFormattingResponse.getFirstLineAsText();
        String string2 = locationFormattingResponse.getSecondLineAsText();
        GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
        guiTooltipInformationContainer.toolTipTwoLinesLine1st = string;
        guiTooltipInformationContainer.toolTipTwoLinesLine2nd = string2;
        guiTooltipInformationContainer.toolTipOneLineLine1st = string;
        if (navLocation != null) {
            int n = this.searchArea.getSearchContext();
            if (n == 0) {
                this.logChannel.log(10000000, this.CLASS_NAME + "CMD_updatePreviewMap: current car position is at the center of preview map name: %1 address: %2", (Object)string, (Object)string2);
                this.previewMap.setPreviewPoiOnlineAroundCCP(navLocation, 3, null, guiTooltipInformationContainer);
            } else {
                NavLocation navLocation2;
                this.logChannel.log(10000000, this.CLASS_NAME + "CMD_updatePreviewMap: center of city, destination or stopover is at the center of the map name: %1 address: %2", (Object)string, (Object)string2);
                NavLocation navLocation3 = navLocation2 = this.searchArea == null ? null : this.searchArea.getNavLocation();
                if (navLocation2 == null) {
                    this.previewMap.setPreviewPoiOnlineAroundCCP(navLocation, 3, null, guiTooltipInformationContainer);
                    return;
                }
                NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(navLocation2.getLongitude(), navLocation2.getLatitude());
                if (n == 1 || n == 2) {
                    this.previewMap.setPreviewPoiOnlineAroundDestination(navLocation, navLocationWgs84, 3, null, guiTooltipInformationContainer);
                } else {
                    this.previewMap.setPreviewPoiOnlineAroundReferencePoint(navLocation, navLocationWgs84, 3, null, guiTooltipInformationContainer);
                }
            }
        } else {
            this.logChannel.log(100000, this.CLASS_NAME + "CMD_updatePreviewMap: no detailed location for index %1", (long)this.index);
        }
        this.getCommandList().commandFinished();
    }
}

