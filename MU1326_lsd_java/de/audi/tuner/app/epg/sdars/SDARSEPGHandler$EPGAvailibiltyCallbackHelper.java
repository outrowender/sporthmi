/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.epg.sdars.IEPGAvailibiltyCallback;
import de.audi.tuner.app.sdars.StationInfoExt;

class SDARSEPGHandler$EPGAvailibiltyCallbackHelper {
    private IEPGAvailibiltyCallback callback = IEPGAvailibiltyCallback.DUMMY;
    private StationInfoExt interestingStation = new StationInfoExt();
    private boolean lastReportedValue;

    public SDARSEPGHandler$EPGAvailibiltyCallbackHelper() {
        this(IEPGAvailibiltyCallback.DUMMY, new StationInfoExt(), false);
        this.interestingStation.sID = -1;
    }

    public SDARSEPGHandler$EPGAvailibiltyCallbackHelper(IEPGAvailibiltyCallback iEPGAvailibiltyCallback, StationInfoExt stationInfoExt, boolean bl) {
        this.callback = iEPGAvailibiltyCallback;
        this.interestingStation = stationInfoExt;
        this.lastReportedValue = bl;
    }

    public boolean isInterestedInEPGAvailibityChangesFor(StationInfoExt stationInfoExt) {
        return this.interestingStation.sID == stationInfoExt.sID;
    }

    public void notifyEPGAvailibity(boolean bl) {
        if (this.lastReportedValue != bl) {
            this.lastReportedValue = bl;
            this.callback.epgAvailibiltyChanged(this.interestingStation, bl);
        }
    }
}

