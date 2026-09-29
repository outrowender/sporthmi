/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.aih;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public abstract class AddressInputHandler {
    public abstract CommandList handleCompleteLocation(NavLocation navLocation, LogChannel logChannel) {
    }

    protected void logRouteInformations(LogChannel logChannel, String string, NavLocation navLocation) {
        String string2 = LocationFormatter.formatLocationShort(navLocation);
        logChannel.log(-2137614336, "%1 - Location: %2", (Object)string, (Object)string2);
    }

    protected void clearBackupLocation(LogChannel logChannel) {
        logChannel.log(-2137614336, "AddressInputHandler#clearBackupLocation()");
    }

    public String toString() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        n = n >= 0 ? ++n : 0;
        return string.substring(n);
    }
}

