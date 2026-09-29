/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.sdars.AbstractSdarsEpgListRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import org.dsi.ifc.sdars.EPGProgramInfo;

public abstract class AbstractProgramSdarsEpgListRow
extends AbstractSdarsEpgListRow {
    public final EPGProgramInfo programInfo;

    public AbstractProgramSdarsEpgListRow(int n, int n2, StationInfoExt stationInfoExt, EPGProgramInfo ePGProgramInfo, int n3, long l) {
        super(RadioObjectIds.toSdarsEPGProg(stationInfoExt.sID, n3), n2, n, stationInfoExt);
        this.programInfo = ePGProgramInfo;
    }

    protected AbstractProgramSdarsEpgListRow(AbstractProgramSdarsEpgListRow abstractProgramSdarsEpgListRow) {
        super(abstractProgramSdarsEpgListRow);
        this.programInfo = abstractProgramSdarsEpgListRow.programInfo;
    }

    public int getProgramID() {
        return this.programInfo.programID;
    }

    public String getLongProgramName() {
        return Utilities.getFirstNotEmpty(this.programInfo.longProgramName, this.programInfo.shortProgramName);
    }

    public String getChannelName() {
        return this.station.fullLabel;
    }

    public abstract String getFormatedPerid() {
    }

    public abstract void updateTimesWithTimezoneOffset(long l) {
    }
}

