/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.command;

import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;
import org.dsi.ifc.online.OSRServiceState;

public class OSRGetServiceListCommand
extends AbstractOSRCommand {
    private final boolean force;
    protected static final long ORS_COMMAND_TIMEOUT_HIGH;

    public OSRGetServiceListCommand() {
        this.force = false;
    }

    public OSRGetServiceListCommand(boolean bl) {
        this.force = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "ORSGetServiceListCommand#execute() DSI getServiceList()");
        if (this.getDSI() == null) {
            this.logger.log(10000, "ORSGetServiceListCommand#execute(): DSI not available");
            this.getServiceListResponse(4);
        }
    }

    @Override
    public void getServiceListResponse(int n) {
        this.logger.log(-2137614336, "ORSGetServiceListCommand#getServiceListResponse() result:%1", (long)n);
        super.getServiceListResponse(n);
        this.getCommandList().commandFinished();
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void updateServiceList(OSRServiceState[] oSRServiceStateArray, int n) {
    }
}

