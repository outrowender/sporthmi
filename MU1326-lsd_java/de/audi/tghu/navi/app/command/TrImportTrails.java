/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavSegmentID;

public class TrImportTrails
extends NavCommand {
    private final String fileName;
    public static final String NAV_SEGMENT_IDS;

    public TrImportTrails(String string) {
        this.fileName = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "TrImportTrails#execute( fileName: %1 )", (Object)this.fileName);
        this.getDSINavigation().trImportTrails(this.fileName);
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        this.logger.log(-2137614336, "TrImportTrails#trImportTrailsResult( %1, %2 )", (Object)navSegmentIDArray, (long)n);
        if (n != 0) {
            this.getCommandList().commandAborted(n);
        }
        this.getCommandList().put("NavSegmentIDs", navSegmentIDArray);
        this.getCommandList().commandFinished();
    }
}

