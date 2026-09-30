/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSODPNaviService;

public interface SDSODPNaviServiceListener {
    public void responseSelectPOIByUID(byte var1, SDSODPNaviService.POIEntry[] var2);

    public void responseSelectPOIByListIndex(byte var1);

    public void responseStartRouteGuidance(byte var1, long var2);

    public void responseStopRouteGuidance(byte var1);

    public void responseSetPOISearchArea(byte var1);
}

