/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.sdars.AbstractSdarsEpgListRow;
import de.audi.tuner.app.sdars.StationInfoExt;

public class StationSdarsEpgListRow
extends AbstractSdarsEpgListRow {
    private static final int INDEX_CHANNEL_NUMBER = 1;
    private static final int INDEX_CHANNEL_NAME = 2;
    public static final int STATION_COL_COUNT = 3;

    public StationSdarsEpgListRow(StationInfoExt stationInfoExt) {
        this(stationInfoExt, 3);
    }

    protected StationSdarsEpgListRow(StationInfoExt stationInfoExt, int n) {
        this(stationInfoExt, n, false);
    }

    protected StationSdarsEpgListRow(StationInfoExt stationInfoExt, int n, boolean bl) {
        super(stationInfoExt.sID, n, 0, stationInfoExt);
        this.setText(1, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.setText(2, bl ? stationInfoExt.fullLabel : stationInfoExt.shortLabel);
    }

    public StationSdarsEpgListRow(StationSdarsEpgListRow stationSdarsEpgListRow) {
        super(stationSdarsEpgListRow);
    }

    public EvoListRow copy() {
        return new StationSdarsEpgListRow(this);
    }

    public boolean representsStation() {
        return true;
    }

    public boolean representsProgram() {
        return false;
    }

    public int getActionForSelection(int n) {
        return 3;
    }
}

