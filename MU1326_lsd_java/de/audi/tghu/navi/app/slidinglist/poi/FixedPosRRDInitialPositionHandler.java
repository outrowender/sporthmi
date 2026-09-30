/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import de.audi.tghu.navi.app.slidinglist.poi.RRDInitialPositionHandler;
import org.dsi.ifc.navigation.PosPosition;

public class FixedPosRRDInitialPositionHandler
implements RRDInitialPositionHandler {
    private PosPosition initialPosition;

    public FixedPosRRDInitialPositionHandler(PosPosition posPosition) {
        this.initialPosition = posPosition;
    }

    public PosPosition getInitialPosition() {
        return this.initialPosition;
    }
}

