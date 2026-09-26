/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SDSODPNaviService$POIEntry;

public interface SDSODPNaviServiceListener {
    default public void responseSelectPOIByUID(byte by, SDSODPNaviService.POIEntry[] pOIEntryArray) {
    }

    default public void responseSelectPOIByListIndex(byte by) {
    }

    default public void responseStartRouteGuidance(byte by, long l) {
    }

    default public void responseStopRouteGuidance(byte by) {
    }

    default public void responseSetPOISearchArea(byte by) {
    }
}

