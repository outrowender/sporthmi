/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavSegmentID;

public class TrStoreTrace
extends NavCommand {
    private final String name;
    public static final String NAV_SEGMENT_ID;

    public TrStoreTrace(String string) {
        this.name = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "TrStoreTrace#execute( name: %1 )", (Object)this.name);
        this.getDSINavigation().trStoreTrace(this.name);
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        this.logger.log(-2137614336, "TrStoreTrace#trStoreTraceResult( trStoreTraceResultCode:%2, errorCode: %3, segmentID: %1 )", (Object)navSegmentID, (long)n, (long)n2);
        if (n != 0) {
            this.getCommandList().commandAborted(n2);
        }
        this.getCommandList().put("NavSegmentID", navSegmentID);
        this.getCommandList().commandFinished();
    }
}

