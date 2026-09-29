/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncRequests;

public interface IHMISyncNaviRequests
extends IHMISyncRequests {
    default public void requestLastDestinationList() {
    }

    default public void requestStartRouteGuidance(double d2, double d3) {
    }
}

