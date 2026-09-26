/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class GetLastCityHistoryEntryCommand
extends NavCommand {
    private LICityHistoryEntry lastCity;

    public GetLastCityHistoryEntryCommand(LICityHistoryEntry lICityHistoryEntry) {
        this.lastCity = lICityHistoryEntry;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "GetLastCityHistoryEntryCommand#execute calling liGetLastCityHistoryEntry(lastCity.getId() = %1)", this.lastCity.getId());
        this.getDSINavigation().liGetLastCityHistoryEntry(this.lastCity.getId());
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logger.log(-2137614336, "GetLastCityHistoryEntryCommand#liGetLastCityHistoryEntryResult(%1, %2)", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Boolean.toString(bl));
        if (navLocation != null) {
            this.getCommandList().put("NavLocation from History", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

