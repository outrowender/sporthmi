/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.HMIResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;

public class RadioDBEntry {
    public final HMIResourceLocator stationLogo;
    public final RadioStationData stationData;
    public final boolean isUnique;

    public RadioDBEntry(HMIResourceLocator hMIResourceLocator, RadioStationData radioStationData, boolean bl) {
        this.stationLogo = hMIResourceLocator;
        this.stationData = radioStationData;
        this.isUnique = bl;
    }
}

