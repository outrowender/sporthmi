/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.esolutions.fw.util.commons.Buffer;

public class AmListRow
extends AbstractAmFmRow {
    public static final int NUM_OF_COLS = 8;
    protected static final int INDEX_IMAGE = 0;
    protected static final int INDEX_RECORD_SET = 1;
    protected static final int INDEX_FREQUENCY_NAME = 2;
    protected static final int INDEX_NAME = 3;
    public static final int INDEX_IS_FAVORITE = 4;
    private static final int INDEX_NAME_HD = 5;
    private static final int INDEX_HD_ICON = 6;
    private static final int INDEX_PSFREEZE_STATUS = 7;

    public AmListRow(int n, AMFMStation aMFMStation, RecordSets recordSets) {
        super(n, aMFMStation);
        this.setInteger(1, recordSets.getAMRecordSet(aMFMStation));
        this.setHMIResourceLocator(0, this.station.getImage(0));
        this.setText(3, aMFMStation.getName());
        this.setText(2, aMFMStation.getFrequencyString());
        this.setText(5, aMFMStation.isHd() ? aMFMStation.shortNameHD : "");
        this.setHdStatus(aMFMStation.getAudioStatus());
        this.setInteger(4, aMFMStation.getPresetPos());
        this.setInteger(7, aMFMStation.isPsFreezed() ? 1 : 0);
    }

    protected AmListRow(AmListRow amListRow) {
        super(amListRow);
    }

    public EvoListRow copy() {
        return new AmListRow(this);
    }

    public void setHdStatus(int n) {
        if (this.station.hd) {
            switch (n) {
                case 2: {
                    this.setInteger(6, 2);
                    break;
                }
                default: {
                    this.setInteger(6, 1);
                    break;
                }
            }
        } else {
            this.setInteger(6, 0);
        }
    }

    public void resetHdStatus() {
        this.setInteger(6, this.station.hd ? 1 : 0);
    }

    public String getFastScrollTxt() {
        return this.getText(2);
    }

    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append("{AM} ");
        buffer.append(super.toString());
        return buffer.toString();
    }

    public void setStationActive(boolean bl) {
    }

    public void reset() {
    }

    void psUnfreeze() {
        this.station.unfreezePs();
        this.setInteger(7, this.station.isPsFreezed() ? 1 : 0);
    }
}

