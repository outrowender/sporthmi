/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.sdars.IStationInfo;
import de.audi.tuner.app.sdars.StationInfoExt;
import org.dsi.ifc.sdars.EPGShortInfo;

public class EPGShortInfoExt
extends EPGShortInfo
implements IStationInfo {
    public final StationInfoExt station;

    public EPGShortInfoExt(StationInfoExt stationInfoExt, EPGShortInfo ePGShortInfo) {
        super(stationInfoExt.sID, ePGShortInfo.epgProgramInfo);
        this.station = stationInfoExt;
    }

    public StationInfoExt getStation() {
        return this.station;
    }
}

