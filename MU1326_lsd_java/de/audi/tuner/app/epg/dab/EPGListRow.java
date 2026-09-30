/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.IContainsDabStation;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;

public class EPGListRow
extends EvoListRow
implements IContainsDabStation {
    protected static final int INDEX_RS = 0;
    protected static final int INDEX_SERVICE_NAME = 1;
    protected static final int INDEX_START_TIME = 2;
    protected static final int INDEX_PROGRAM_INFO = 3;
    public static final int NUM_COLUMNS = 4;
    protected static final int LLD_STATIONNAME = 0;
    static final int LLD_NOW_NEXT_INFO = 1;
    protected final EPGShortInfoExt shortInfo;

    protected EPGListRow(EPGShortInfoExt ePGShortInfoExt, long l, int n) {
        super(l, n);
        this.shortInfo = ePGShortInfoExt;
        this.setText(1, "");
        this.setText(3, "");
        this.setText(2, "");
    }

    protected EPGListRow(EPGListRow ePGListRow) {
        super(ePGListRow);
        this.shortInfo = ePGListRow.shortInfo;
    }

    public String getStationName() {
        return this.shortInfo.getDabStation().getFullName();
    }

    public DabStation getDabStation() {
        return this.shortInfo.getDabStation();
    }

    protected final void fillTimeColumn(int n, long l) {
        this.setText(n, Utilities.getFormatedTime(l));
    }

    public EPGShortInfoExt getShortInfo() {
        return this.shortInfo;
    }
}

