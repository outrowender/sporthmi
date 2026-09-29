/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.util.change.ChangeEvent;
import de.audi.tuner.util.change.ChangeHandler;
import de.audi.tuner.util.change.ChangeListener;
import java.util.Arrays;
import org.dsi.ifc.sdars.StationDescription;

public class SDARSStationDescriptions {
    private final LogChannel lc;
    private final StationDescription[] stationDescriptions = new StationDescription[384];
    private final ChangeHandler changeHandler = new ChangeHandler();
    private final ChangeEvent changeEvent;

    public SDARSStationDescriptions(TunerBasics tunerBasics) {
        this.lc = tunerBasics.getLogger().sdarsDSI;
        this.changeEvent = new ChangeEvent(this);
    }

    public void addChangeListener(ChangeListener changeListener) {
        this.changeHandler.addChangeListener(changeListener);
    }

    public void updateStationDescriptions(StationDescription[] stationDescriptionArray) {
        int n = stationDescriptionArray.length;
        Arrays.fill(this.stationDescriptions, null);
        for (int i2 = 0; i2 < n; ++i2) {
            StationDescription stationDescription = stationDescriptionArray[i2];
            if (stationDescription == null) continue;
            if (stationDescription.longStationDescription == null) {
                stationDescription.longStationDescription = "";
            }
            if (stationDescription.shortStationDescription == null) {
                stationDescription.shortStationDescription = "";
            }
            if (stationDescription.longStationDescription.length() == 0) {
                stationDescription.longStationDescription = stationDescription.shortStationDescription;
            }
            this.stationDescriptions[stationDescription.sID] = stationDescription;
        }
        this.changeHandler.signalChange(this.changeEvent);
    }

    public StationDescription getStationDescriptionForSID(int n) {
        if (SDARSStationDescriptions.isSIDValid(n)) {
            return this.stationDescriptions[n];
        }
        this.lc.log(10000, "[SDARSStationDescriptions] invalid sID %1", (long)n);
        return null;
    }

    public static boolean isSIDValid(int n) {
        return n >= 0 && n < 384;
    }

    public String getLongDescription(int n) {
        StationDescription stationDescription = this.getStationDescriptionForSID(n);
        return stationDescription == null ? "" : stationDescription.getLongStationDescription();
    }
}

