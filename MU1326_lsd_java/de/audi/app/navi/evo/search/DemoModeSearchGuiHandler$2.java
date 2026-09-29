/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetPosition;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

final class DemoModeSearchGuiHandler$2
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ LogChannel val$lc;

    DemoModeSearchGuiHandler$2(String string, NavLocation navLocation, LogChannel logChannel) {
        this.val$location = navLocation;
        this.val$lc = logChannel;
        super(string);
    }

    @Override
    public void execute() {
        if (this.val$location != null) {
            if (this.val$location.isPositionValid()) {
                this.val$lc.log(-2137614336, "DemoModeSearchGuiHandler#searchResultSelected # location valid = %1", (Object)LocationFormatter.formatLocationShort(this.val$location));
                this.navigation.getDemoModeManager().demoLocationWasSet(this.val$location);
                this.getCommandList().commandFinishedWithPostCommand(new RGSetPosition(this.val$location));
            } else {
                this.val$lc.log(-2137614336, "DemoModeSearchGuiHandler#searchResultSelected # location invalid= %1", (Object)LocationFormatter.formatLocationShort(this.val$location));
            }
        } else {
            this.val$lc.log(-2137614336, "DemoModeSearchGuiHandler#searchResultSelected # no result or no location");
            this.getCommandList().commandFinished();
        }
    }
}

