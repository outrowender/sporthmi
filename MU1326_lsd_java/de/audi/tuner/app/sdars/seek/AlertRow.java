/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.SeekAlertIconTypeEnum;
import de.audi.tuner.ifc.AbstractRadioListRow;
import org.dsi.ifc.sdars.SeekEntry;

public class AlertRow
extends AbstractRadioListRow {
    public static final int INDEX_RECORDSET;
    private static final int INDEX_TEXT1;
    private static final int INDEX_TEXT2;
    private static final int INDEX_TEXT3;
    private static final int INDEX_ICON;
    protected static final int INDEX_CHANNEL_NUMBER;
    protected static final int INDEX_CHANNEL_NAME;
    private static final int INDEX_CHANNEL_CATEGORY;
    protected static final int INDEX_PROPERTIES;
    protected static final int COLUMN_COUNT;
    private static final int RECORDSET_DEFAULT;
    private static final String DEFAULT_TEXT2;
    private final StationInfoExt stationInfo;
    private final SeekEntry seekEntry;

    public AlertRow(StationInfoExt stationInfoExt, SeekEntry seekEntry, String string, String string2) {
        this(9, stationInfoExt, seekEntry, string, string2);
    }

    protected AlertRow(int n, StationInfoExt stationInfoExt, SeekEntry seekEntry, String string, String string2) {
        super(stationInfoExt.sID, n);
        this.stationInfo = stationInfoExt;
        this.seekEntry = seekEntry;
        this.setInteger(0, 0);
        this.setText(1, string);
        this.setText(2, "-");
        this.setText(3, string2);
        this.setInteger(4, SeekAlertIconTypeEnum.forSeekEntry((SeekEntry)seekEntry).ordinal);
        this.setText(5, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.setText(6, stationInfoExt.fullLabel);
        this.setText(7, stationInfoExt.getFullCategory());
    }

    protected AlertRow(AlertRow alertRow) {
        super(alertRow);
        this.stationInfo = alertRow.stationInfo;
        this.seekEntry = alertRow.seekEntry;
    }

    @Override
    public EvoListRow copy() {
        return new AlertRow(this);
    }

    public final void setNoSignal(boolean bl) {
        this.setText(7, bl ? "NoSignal" : this.stationInfo.getFullCategory());
    }

    public void updateTexts(String string, String string2) {
        if (string.length() != 0) {
            this.setText(1, string);
        }
        if (string2.length() != 0) {
            this.setText(3, string2);
        }
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return new TunerObjectContainer(this.stationInfo);
    }

    public SeekEntry getSeekEntry() {
        return this.seekEntry;
    }

    public StationInfoExt getStationInfo() {
        return this.stationInfo;
    }
}

