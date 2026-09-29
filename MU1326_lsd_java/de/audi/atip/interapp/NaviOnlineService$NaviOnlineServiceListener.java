/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.global.NavLocation;

public interface NaviOnlineService$NaviOnlineServiceListener {
    default public void indicateSelectedMapFlag(int n) {
    }

    default public void indicateRouteGuidanceFinished(NavLocation navLocation, String string) {
    }
}

