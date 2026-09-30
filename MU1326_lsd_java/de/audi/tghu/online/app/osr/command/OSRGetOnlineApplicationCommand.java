/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRServiceState;

public class OSRGetOnlineApplicationCommand
extends AbstractOSRCommand {
    private final String applicationId;
    private final IOnlineServiceListener callback;

    public OSRGetOnlineApplicationCommand(String string) {
        this.applicationId = string;
        this.callback = null;
    }

    public OSRGetOnlineApplicationCommand(String string, IOnlineServiceListener iOnlineServiceListener) {
        this.applicationId = string;
        this.callback = iOnlineServiceListener;
    }

    public void execute() {
        this.logger.log(10000000, "ORSGetOnlineApplicationCommand#execute: applicationId=%1", (Object)this.applicationId);
        if (this.getDSI() != null) {
            this.getDSI().getOnlineApplication(this.applicationId);
        } else {
            this.logger.log(10000, "ORSGetOnlineApplicationCommand#execute: no DSI available");
            this.getCommandList().commandFinished();
        }
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logger.log(10000000, "ORSGetOnlineApplicationCommand#getOnlineApplicationResponse: applicationId=%1", (Object)oSRApplication.getId());
        if (this.callback != null) {
            this.callback.getOnlineApplicationResponse(oSRApplication);
        }
        super.getOnlineApplicationResponse(oSRApplication);
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

