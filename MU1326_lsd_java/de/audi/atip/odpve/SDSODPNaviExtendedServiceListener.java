/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odpve;

import de.audi.atip.odp.SDSODPNaviServiceListener;
import de.audi.atip.odpve.SDSODPNaviExtendedService;

public interface SDSODPNaviExtendedServiceListener
extends SDSODPNaviServiceListener {
    public void responseGetPoiResultDetails(int var1, SDSODPNaviExtendedService.POIEntryDetails var2);
}

