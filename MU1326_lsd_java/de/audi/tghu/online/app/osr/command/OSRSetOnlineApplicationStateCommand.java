/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRServiceState;

public class OSRSetOnlineApplicationStateCommand
extends AbstractOSRCommand {
    private final String applicationId;
    private final int state;
    private final IOnlineServiceListener callback;

    public OSRSetOnlineApplicationStateCommand(String string, int n, IOnlineServiceListener iOnlineServiceListener) {
        this.applicationId = string;
        this.state = n;
        this.callback = iOnlineServiceListener;
    }

    public OSRSetOnlineApplicationStateCommand(String string, int n) {
        this.applicationId = string;
        this.state = n;
        this.callback = null;
    }

    public void execute() {
        this.logger.log(10000000, "ORSSetOnlineApplicationStateCommand#execute() applicationId: %1 state: %2", (Object)this.applicationId, (long)this.state);
        this.getDSI().setOnlineApplicationState(this.applicationId, this.state);
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        if (oSRApplication == null) {
            this.logger.log(100000, "ORSSetOnlineApplicationStateCommand#getOnlineApplicationResponse() applicationId: %1 - app is null");
            this.getCommandList().commandAborted("getOnlineApplicationResponse failed");
            return;
        }
        this.logger.log(10000000, "ORSSetOnlineApplicationStateCommand#getOnlineApplicationResponse() applicationId: %1", (Object)oSRApplication.getId());
        if (this.callback != null) {
            this.callback.getOnlineApplicationResponse(oSRApplication);
        } else {
            super.getOnlineApplicationResponse(oSRApplication);
        }
        this.getCommandList().commandFinished();
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

