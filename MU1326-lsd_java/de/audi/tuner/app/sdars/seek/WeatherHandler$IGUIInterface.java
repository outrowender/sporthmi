/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

interface WeatherHandler$IGUIInterface {
    default public void updateWeatherSeekList(SeekEntry[] seekEntryArray) {
    }

    default public void updateWeatherMarketList(TrafficWxEntry[] trafficWxEntryArray) {
    }
}

