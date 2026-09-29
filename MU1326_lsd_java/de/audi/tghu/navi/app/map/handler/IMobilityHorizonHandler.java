/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener;

public interface IMobilityHorizonHandler
extends DSIMobilityHorizonListener {
    default public void setDSIMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
    }
}

