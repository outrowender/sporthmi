/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.interapp.AMFMStationInfo;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AbstractStationConsistencyCheck;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.radio.Station;

class StationConsistencyCheckJp
extends AbstractStationConsistencyCheck {
    private SimpleIntObjectMap frequencyNameMapping = new SimpleIntObjectMap();
    private final Object mutex = new Object();

    StationConsistencyCheckJp(TunerBasics tunerBasics) {
        super(tunerBasics);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Station[] checkList(Station[] stationArray) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                String string = this.getJpStationName(stationArray[i2].frequency);
                if (string == null) continue;
                stationArray[i2].name = string;
            }
        }
        return stationArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AMFMStation[] checkList(AMFMStation[] aMFMStationArray) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < aMFMStationArray.length; ++i2) {
                String string = this.getJpStationName(aMFMStationArray[i2].frequency);
                if (string == null) continue;
                aMFMStationArray[i2].name = string;
                aMFMStationArray[i2].rds = true;
            }
        }
        return aMFMStationArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public AMFMStation checkStation(AMFMStation aMFMStation) {
        String string;
        Object object = this.mutex;
        synchronized (object) {
            string = this.getJpStationName(aMFMStation.frequency);
        }
        if (string != null) {
            aMFMStation.name = string;
            aMFMStation.rds = true;
        }
        return aMFMStation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setJpAMFMStationInfo(AMFMStationInfo[] aMFMStationInfoArray) {
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap();
        for (int i2 = 0; i2 < aMFMStationInfoArray.length; ++i2) {
            if (aMFMStationInfoArray[i2].stationName == null || aMFMStationInfoArray[i2].stationName.equals("")) continue;
            this.logger.dd.log(100000000, "AMFMStationInfo: %1 - %2", (Object)aMFMStationInfoArray[i2].stationName, (long)aMFMStationInfoArray[i2].frequency);
            simpleIntObjectMap.add(aMFMStationInfoArray[i2].frequency, aMFMStationInfoArray[i2].stationName);
        }
        Object object = this.mutex;
        synchronized (object) {
            this.frequencyNameMapping = simpleIntObjectMap;
        }
    }

    private String getJpStationName(long l) {
        return (String)this.frequencyNameMapping.get((int)l);
    }
}

