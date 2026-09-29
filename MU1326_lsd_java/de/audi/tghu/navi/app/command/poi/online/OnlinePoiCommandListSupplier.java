/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListSupplier;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandList;
import de.audi.tghu.navi.app.util.Util;

public class OnlinePoiCommandListSupplier
implements ICommandListSupplier {
    private LogChannel logChannel;
    private NavigationEnv env;

    public OnlinePoiCommandListSupplier(LogChannel logChannel, NavigationEnv navigationEnv) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        logChannel.log(1078071040, "OnlinePoiCommandListSupplier#OnlinePoiCommandListSupplier()");
    }

    @Override
    public boolean isApplicationOperable() {
        return true;
    }

    @Override
    public boolean isDSIsAvailable(CommandList commandList) {
        this.logChannel.log(1078071040, "OnlinePoiCommandListSupplier#isDSIsAvailable()");
        if (commandList instanceof OnlinePoiCommandList) {
            OnlinePoiCommandList onlinePoiCommandList = (OnlinePoiCommandList)commandList;
            return onlinePoiCommandList.getOnlineSearch() != null;
        }
        return false;
    }

    @Override
    public String getApplicationName(CommandList commandList) {
        return "OnlinePoi";
    }

    @Override
    public void handleException(Exception exception) {
        this.logChannel.log(1078071040, "OnlinePoiCommandListSupplier#handleException()");
        Util.handleDSIException(exception, this.env);
    }

    @Override
    public void showDebugPopup(CommandList commandList, String string, String string2) {
    }
}

