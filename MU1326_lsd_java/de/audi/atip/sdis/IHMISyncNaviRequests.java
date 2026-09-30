/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sdis;

import de.audi.atip.sdis.IHMISyncRequests;

public interface IHMISyncNaviRequests
extends IHMISyncRequests {
    public void requestLastDestinationList();

    public void requestStartRouteGuidance(double var1, double var3);
}

