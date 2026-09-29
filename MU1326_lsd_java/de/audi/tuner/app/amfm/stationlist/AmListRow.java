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
    public static final int NUM_OF_COLS;
    protected static final int INDEX_IMAGE;
    protected static final int INDEX_RECORD_SET;
    protected static final int INDEX_FREQUENCY_NAME;
    protected static final int INDEX_NAME;
    public static final int INDEX_IS_FAVORITE;
    private static final int INDEX_NAME_HD;
    private static final int INDEX_HD_ICON;
    private static final int INDEX_PSFREEZE_STATUS;

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

    @Override
    public EvoListRow copy() {
        return new AmListRow(this);
    }

    @Override
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

    @Override
    public void resetHdStatus() {
        this.setInteger(6, this.station.hd ? 1 : 0);
    }

    @Override
    public String getFastScrollTxt() {
        return this.getText(2);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append("{AM} ");
        buffer.append(super.toString());
        return buffer.toString();
    }

    @Override
    public void setStationActive(boolean bl) {
    }

    public void reset() {
    }

    @Override
    void psUnfreeze() {
        this.station.unfreezePs();
        this.setInteger(7, this.station.isPsFreezed() ? 1 : 0);
    }
}

