/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.esolutions.fw.util.commons.Buffer;

public class FmListRow
extends AbstractAmFmRow {
    public static final int NUM_OF_COLS;
    protected static final int INDEX_IMAGE;
    private static final int INDEX_RECORD_SET;
    private static final int INDEX_NAME_FREQ;
    private static final int INDEX_NAME_RDS;
    private static final int INDEX_PTY;
    protected static final int INDEX_HD_NAME;
    protected static final int INDEX_HD_EXTENSION;
    private static final int INDEX_HD_ICON;
    public static final int INDEX_IS_FAVORITE;
    private static final int INDEX_PSFREEZE_STATUS;
    private static final int INDEX_SEPARATOR_LINE;
    protected final RecordSets recordSets;

    public FmListRow(int n, AMFMStation aMFMStation, RecordSets recordSets) {
        super(n, aMFMStation);
        this.recordSets = recordSets;
        this.setInteger(1, recordSets.getFMRecordSet(aMFMStation));
        this.setHMIResourceLocator(0, this.station.getImage(0));
        this.setText(2, aMFMStation.getFrequencyString());
        this.setText(3, aMFMStation.getName());
        this.setHdStatus(aMFMStation.getAudioStatus());
        this.setInteger(4, aMFMStation.getPtyCode());
        this.setInteger(9, aMFMStation.isPsFreezed() ? 1 : 0);
        this.setInteger(10, 0);
        this.setInteger(8, aMFMStation.getPresetPos());
    }

    protected FmListRow(FmListRow fmListRow) {
        super(fmListRow);
        this.recordSets = fmListRow.recordSets;
    }

    @Override
    public EvoListRow copy() {
        return new FmListRow(this);
    }

    @Override
    public String getFastScrollTxt() {
        Buffer buffer = new Buffer("");
        if (Utilities.isNARBuild()) {
            buffer.append(this.getText(2));
            buffer.append(" ");
            buffer.append(this.getText(3));
        } else if (this.station.rds) {
            buffer.append(this.getText(3));
        } else {
            buffer.append(this.getText(2));
        }
        return buffer.toString();
    }

    public void setSeparatorLine(boolean bl) {
        int n = bl ? 2 : 1;
        int n2 = this.getInteger(10);
        if (n2 == 2 && n == 1 || n2 == 1 && n == 2) {
            this.setInteger(10, 3);
        } else {
            this.setInteger(10, n);
        }
    }

    @Override
    public int getSeparatorLine() {
        return this.getInteger(10);
    }

    @Override
    public void setSeparatorLine(int n) {
        this.setInteger(10, n);
    }

    public void setPtyCode(int n) {
        this.setInteger(4, n);
        this.station.ptyCode = n;
    }

    @Override
    public final void setHdStatus(int n) {
        if (this.station.hd) {
            switch (n) {
                case 2: {
                    this.setInteger(7, 2);
                    break;
                }
                case 3: {
                    this.setInteger(7, 3);
                    break;
                }
                default: {
                    this.setInteger(7, 1);
                    break;
                }
            }
        } else {
            this.setInteger(7, 0);
        }
    }

    @Override
    public void resetHdStatus() {
        this.station.setAudioStatus(0);
        this.setInteger(7, this.station.hd ? 1 : 0);
    }

    @Override
    void psUnfreeze() {
        this.station.unfreezePs();
        this.setInteger(9, 0);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append("{FM} ");
        buffer.append(super.toString());
        return buffer.toString();
    }

    @Override
    public void setStationActive(boolean bl) {
    }
}

