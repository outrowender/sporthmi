/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class StationNameHistory {
    private SimpleIntObjectMap nameHistory = new SimpleIntObjectMap(1);
    private boolean fixed;
    private int activeFrequency;

    public synchronized void setStationDisplayModeFixed(boolean bl) {
        this.fixed = bl;
    }

    public synchronized AMFMStation[] updateStationList(AMFMStation[] aMFMStationArray) {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(aMFMStationArray.length + 1);
        for (int i2 = 0; i2 < aMFMStationArray.length; ++i2) {
            AMFMStation aMFMStation = aMFMStationArray[i2];
            if (!aMFMStation.isRds()) continue;
            String string = (String)this.nameHistory.get((int)aMFMStation.frequency);
            if (string != null && this.fixed) {
                aMFMStation.name = string;
            }
            simpleIntObjectMap.add((int)aMFMStation.frequency, aMFMStation.name);
        }
        String string = (String)this.nameHistory.get(this.activeFrequency);
        if (string != null) {
            simpleIntObjectMap.add(this.activeFrequency, string);
        }
        this.nameHistory = simpleIntObjectMap;
        return aMFMStationArray;
    }

    public synchronized AMFMStation updateActiveStation(AMFMStation aMFMStation) {
        if (aMFMStation.isRds()) {
            String string = (String)this.nameHistory.get((int)aMFMStation.frequency);
            if (string != null && this.fixed) {
                aMFMStation.name = string;
            }
            this.nameHistory.add((int)aMFMStation.frequency, aMFMStation.name);
            this.activeFrequency = (int)aMFMStation.frequency;
        }
        return aMFMStation;
    }
}

