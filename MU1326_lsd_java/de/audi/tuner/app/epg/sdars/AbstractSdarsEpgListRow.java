/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.StationInfoExt;

public abstract class AbstractSdarsEpgListRow
extends EvoListRow {
    public static final int INDEX_RECORDSET;
    public static final int COL_COUNT;
    public static final int RECORDSET_STATION;
    public static final int RECORDSET_PROGRAM;
    public static final int ACTION_NONE;
    public static final int ACTION_PROGRAM_LIST;
    public static final int ACTION_PROGRAM_DETAILS;
    public static final int ACTION_TUNE;
    public final StationInfoExt station;

    public AbstractSdarsEpgListRow(long l, int n, int n2, StationInfoExt stationInfoExt) {
        super(l, n);
        this.station = stationInfoExt;
        this.setInteger(0, n2);
    }

    protected AbstractSdarsEpgListRow(AbstractSdarsEpgListRow abstractSdarsEpgListRow) {
        super(abstractSdarsEpgListRow);
        this.station = abstractSdarsEpgListRow.station;
    }

    public StationInfoExt getStation() {
        return this.station;
    }

    public int getSID() {
        return this.station.sID;
    }

    public abstract boolean representsStation() {
    }

    public abstract boolean representsProgram() {
    }

    public boolean correspondsTo(StationInfoExt stationInfoExt) {
        return this.station.sID == stationInfoExt.sID;
    }

    public abstract int getActionForSelection(int n) {
    }
}

