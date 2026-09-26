/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odpve;

import de.audi.atip.odp.SDSODPNaviServiceListener;
import de.audi.atip.odpve.SDSODPNaviExtendedService$POIEntryDetails;

public interface SDSODPNaviExtendedServiceListener
extends SDSODPNaviServiceListener {
    default public void responseGetPoiResultDetails(int n, SDSODPNaviExtendedService.POIEntryDetails pOIEntryDetails) {
    }
}

