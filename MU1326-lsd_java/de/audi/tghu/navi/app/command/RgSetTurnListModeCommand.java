/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

public class RgSetTurnListModeCommand
extends NavCommand {
    @Override
    public void execute() {
        int n = Util.getRouteInfoConfigMode(this.env.getFramework());
        if (1 == n) {
            this.getDSINavigation().rgSetTurnListMode(3);
            this.logger.log(-2137614336, "RgSetTurnListModeCommand#execute(), rgSetTurnListMode(DSINavigation.TURNLISTMODE_COMPLETEWITHWARNINGS)");
        } else if (2 == n) {
            this.getDSINavigation().rgSetTurnListMode(4);
            this.logger.log(-2137614336, "RgSetTurnListModeCommand#execute(), rgSetTurnListMode(DSINavigation.TURNLISTMODE_COMPACT2)");
        }
        this.getCommandList().commandFinished();
    }
}

