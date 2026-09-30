/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractAmFmRow
extends AbstractRadioListRow {
    static final int INDEX_ROW_ID_UNUSED = 0;
    protected static final int ICON_NONE = 0;
    protected static final int ICON_HD_GREY = 1;
    protected static final int ICON_HD_WHITE = 2;
    protected static final int ICON_LOW_RECEPTION = 3;
    protected static final int ITUNES_ICON_RESET = Utilities.isNARBuild() && Utilities.isTaggingSupported() ? 1 : 0;
    protected static final int ITUNES_ICON_ENABLED = Utilities.isNARBuild() && Utilities.isTaggingSupported() ? 2 : 0;
    protected final AMFMStation station;

    protected AbstractAmFmRow(int n, AMFMStation aMFMStation) {
        super(aMFMStation.getUniqueId(), n);
        this.station = aMFMStation;
    }

    protected AbstractAmFmRow(AbstractAmFmRow abstractAmFmRow) {
        super(abstractAmFmRow);
        this.station = abstractAmFmRow.station;
    }

    public boolean isTmpAdded() {
        return this.station.isTmpAdded();
    }

    public AMFMStation getStation() {
        return this.station;
    }

    public int getPresetIndex() {
        return 42;
    }

    public abstract String getFastScrollTxt();

    public abstract void setHdStatus(int var1);

    public abstract void resetHdStatus();

    public abstract void setStationActive(boolean var1);

    abstract void psUnfreeze();

    public TunerObjectContainer getTOContainer() {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(new AMFMStation(this.station));
        tunerObjectContainer.setPresetPos(this.station.getPresetPos());
        return tunerObjectContainer;
    }

    public int getFrequency() {
        return (int)this.station.frequency;
    }

    public int getPi() {
        return this.station.pi;
    }

    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append(this.station);
        buffer.append(' ');
        buffer.append(super.toString());
        return buffer.toString();
    }

    public int getSeparatorLine() {
        return 0;
    }

    public void setSeparatorLine(int n) {
    }

    public void setProgramData(AMFMStation aMFMStation, int n, TunerStatus tunerStatus) {
    }
}

