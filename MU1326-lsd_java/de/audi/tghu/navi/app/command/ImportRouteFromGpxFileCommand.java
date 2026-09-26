/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.gpximport.GpxHandler;
import org.dsi.ifc.global.NavLocation;

public class ImportRouteFromGpxFileCommand
extends NavCommand {
    private final String filePath;
    private final GpxHandler gpxHandler;

    public ImportRouteFromGpxFileCommand(String string, GpxHandler gpxHandler) {
        this.filePath = string;
        this.gpxHandler = gpxHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "ImportRouteFromGpxFileCommand#execute() - filePath = %1", (Object)this.filePath);
        this.getDSINavigation().importRouteFromGpxFile(this.filePath);
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        this.gpxHandler.setImportedLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

