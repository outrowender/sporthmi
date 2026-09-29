/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class DeleteSatelliteCacheCommand
extends NavCommand {
    @Override
    public void execute() {
        this.logger.log(-2137614336, "DeleteSatelliteCacheCommand#execute() - calling deleteSatelliteCache()");
        this.getDSINavigation().deleteSatelliteCache();
        this.getCommandList().commandFinished();
    }
}

