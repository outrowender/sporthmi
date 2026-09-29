/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;

public class SetAdbImportStatusCommand
extends AbstractOnlineDestinationCommand {
    @Override
    public void execute() {
        this.logger.log(1078071040, "StoreAddressListInNavigation#execute()");
        NaviMyAudiImport naviMyAudiImport = this.getNaviMyAudiService();
        if (naviMyAudiImport == null) {
            this.logger.log(10000, "StoreAddressListInNavigation#execute(): no NaviMyAudiImport Service tracked!!");
            this.getCommandList().commandFinished();
            return;
        }
        this.getCommandList().commandFinished();
    }
}

