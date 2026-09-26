/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavSegmentID;

public class TrExportTrails
extends NavCommand {
    private final NavSegmentID[] traceIDs;
    private final String fileName;

    public TrExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        this.traceIDs = navSegmentIDArray;
        this.fileName = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "TrExportTrails#execute( traceIDs: %1 )", (Object)this.traceIDs);
        this.getDSINavigation().trExportTrails(this.traceIDs, this.fileName);
    }

    @Override
    public void trExportTrailsResult(int n) {
        this.logger.log(-2137614336, "TrExportTrails#trExportTrailsResult( trDataResult: %1 )", (long)n);
        if (n != 0) {
            this.getCommandList().commandAborted(n);
        }
        this.getCommandList().commandFinished();
    }
}

