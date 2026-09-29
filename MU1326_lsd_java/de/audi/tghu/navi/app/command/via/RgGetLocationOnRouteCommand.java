/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class RgGetLocationOnRouteCommand
extends NavCommand {
    private long lDistance = 0L;

    public RgGetLocationOnRouteCommand(long l) {
        super("RgGetLocationOnRouteCommand");
        this.lDistance = l;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RgGetLocationOnRouteCommand#execute() - calling rgGetLocationOnRoute( %1 ) ", this.lDistance);
        this.getDSINavigation().rgGetLocationOnRoute(this.lDistance);
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation) {
        this.logger.log(-2137614336, "RgGetLocationOnRouteCommand#rgGetLocationOnRouteResult() - %1 ", (Object)navLocation);
        this.getCommandList().commandFinished();
    }
}

