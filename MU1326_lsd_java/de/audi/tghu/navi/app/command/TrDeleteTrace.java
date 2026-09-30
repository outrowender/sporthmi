/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavSegmentID;

public class TrDeleteTrace
extends NavCommand {
    private final NavSegmentID navSegmentId;

    public TrDeleteTrace(NavSegmentID navSegmentID) {
        this.navSegmentId = navSegmentID;
    }

    public void execute() {
        this.logger.log(10000000, "TrDeleteTrace#execute( navSegmentId: %1 )", (Object)this.navSegmentId);
        this.getDSINavigation().trDeleteTrace(this.navSegmentId);
    }

    public void trDeleteTraceResult(int n, int n2) {
        this.logger.log(10000000, "TrDeleteTrace#trDeleteTraceResult( trDeleteTraceResultCode: %1, errorCode: %2 )", (long)n, (long)n2);
        if (n != 0) {
            this.getCommandList().commandAborted(n2);
        }
        this.getCommandList().commandFinished();
    }
}

