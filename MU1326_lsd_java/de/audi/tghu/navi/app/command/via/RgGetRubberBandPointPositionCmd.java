/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocationWgs84;

public class RgGetRubberBandPointPositionCmd
extends NavCommand {
    public RgGetRubberBandPointPositionCmd() {
        super("RgGetRubberBandPointPositionCmd");
    }

    public void execute() {
        this.logger.log(10000000, "RgGetRubberBandPointPositionCmd#execute() - call rgGetRubberBandPointPosition()");
        this.getDSINavigation().rgGetRubberBandPointPosition();
    }

    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }
}

