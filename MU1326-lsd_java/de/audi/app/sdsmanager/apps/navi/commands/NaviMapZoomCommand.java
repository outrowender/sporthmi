/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.def.NullMapService;
import de.audi.atip.log.LogChannel;

public class NaviMapZoomCommand
extends AbstractSystemCallCommand {
    private static final int NAVI_MAP_ZOOM_IN;
    private static final int NAVI_MAP_ZOOM_OUT;
    private MapService mapService;
    private final int zoomDirection;

    public NaviMapZoomCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, MapService mapService) {
        super(logChannel, string, sDSHandlerService);
        this.mapService = new NullMapService(this.logger);
        this.mapService = mapService;
        this.zoomDirection = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] zoomDirection=%2", (Object)this.getName(), (long)this.zoomDirection);
        int n = 3000;
        switch (this.zoomDirection) {
            case 0: {
                this.logger.log(-2137614336, "[%1#execute] Zooming into map!", (Object)this.getName());
                this.mapService.setIncrementalZoom(-1);
                break;
            }
            case 1: {
                this.logger.log(-2137614336, "[%1#execute] Zooming out from map!", (Object)this.getName());
                this.mapService.setIncrementalZoom(1);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#execute] Unknown zoomDirection %2!", (Object)this.getName(), (long)this.zoomDirection);
                n = 3001;
            }
        }
        this.sendResult(n);
    }
}

