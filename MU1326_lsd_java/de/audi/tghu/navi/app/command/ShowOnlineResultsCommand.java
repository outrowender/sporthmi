/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class ShowOnlineResultsCommand
extends NavCommand {
    private OnlinePOIResultList resultList;

    public ShowOnlineResultsCommand(OnlinePOIResultList onlinePOIResultList) {
        this.resultList = onlinePOIResultList;
    }

    public void execute() {
        this.logger.log(10000000, "ShowOnlineResultsCommand#execute() - length: %1", (long)this.resultList.length());
        this.navigation.getMapInterface().setOnlineResultFlags(this.resultList);
        if (this.resultList != null && this.resultList.length() == 1) {
            PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = this.resultList.getPOIElementAt(0);
            NavLocation navLocation = Util.getLocationFromGeoPos(poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
            this.navigation.getMapInterface().enterOnlineResultMap(navLocation);
        } else {
            this.navigation.getMapInterface().enterOnlineResultMap();
        }
        this.getCommandList().commandFinished();
    }
}

