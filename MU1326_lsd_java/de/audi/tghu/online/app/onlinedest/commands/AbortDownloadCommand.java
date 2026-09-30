/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import org.dsi.ifc.online.DSIDestinationImport;

public class AbortDownloadCommand
extends AbstractOnlineDestinationCommand {
    public void execute() {
        this.logger.log(1000000, "AbortDownloadCommand#execute: try execute()");
        DSIDestinationImport dSIDestinationImport = this.getDSI();
        if (dSIDestinationImport == null) {
            this.logger.log(10000, "AbortDownloadCommand#execute: no DSI!");
            return;
        }
        dSIDestinationImport.stopAction();
    }

    public void stopActionResult(int n) {
        this.getCommandList().commandFinished();
    }
}

