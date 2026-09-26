/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSdsHandler;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;

public class UpdateSdsServiceCommand
extends AbstractOnlineDestinationCommand {
    SDSListEntry[] contacts;

    public UpdateSdsServiceCommand(SDSListEntry[] sDSListEntryArray) {
        this.contacts = sDSListEntryArray;
    }

    public UpdateSdsServiceCommand() {
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "UpdateSdsServiceCommand#execute()");
        IOnlineSDSMyAudiServiceListener iOnlineSDSMyAudiServiceListener = this.getSdsServiceListener();
        if (iOnlineSDSMyAudiServiceListener == null) {
            this.logger.log(10000, "UpdateSdsServiceCommand#execute() no DSI!");
            return;
        }
        if (this.contacts == null) {
            this.contacts = OnlineDestinationSdsHandler.convertPortalToSdsEntries(this.application.getModelHandler().getPortalEntryList());
        }
        this.logger.log(1078071040, "UpdateSdsServiceCommand#execute() sending Contancs: %1", (long)this.contacts.length);
        iOnlineSDSMyAudiServiceListener.updateMyAudiContacts(this.contacts);
        this.getCommandList().commandFinished();
    }
}

