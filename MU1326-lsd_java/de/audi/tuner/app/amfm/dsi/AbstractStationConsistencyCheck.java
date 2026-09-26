/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.interapp.AMFMStationInfo;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.amfm.AMFMStation;
import org.dsi.ifc.radio.Station;

abstract class AbstractStationConsistencyCheck {
    protected final Logger logger;
    protected final TunerStatus status;

    AbstractStationConsistencyCheck(TunerBasics tunerBasics) {
        this.logger = tunerBasics.getLogger();
        this.status = tunerBasics.getStatus();
    }

    public abstract AMFMStation[] checkList(AMFMStation[] aMFMStationArray) {
    }

    public Station[] checkList(Station[] stationArray) {
        return stationArray;
    }

    public abstract AMFMStation checkStation(AMFMStation aMFMStation) {
    }

    public void setJpAMFMStationInfo(AMFMStationInfo[] aMFMStationInfoArray) {
    }
}

