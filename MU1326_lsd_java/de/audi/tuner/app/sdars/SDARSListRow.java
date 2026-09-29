/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;
import de.audi.tuner.app.sdars.ISDARSRow;
import de.audi.tuner.app.sdars.IStationInfo;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.RadioText;

public class SDARSListRow
extends AbstractRadioListRow
implements ISDARSRow,
IStationInfo {
    private static final int RS_WHITE;
    private static final int RS_GREY;
    protected static final int INDEX_ST_CHNUM;
    protected static final int INDEX_ST_NAME;
    protected static final int INDEX_ST_CATID;
    private static final int INDEX_RS;
    private static final int INDEX_ST_IS_FAVORITE;
    private static final int INDEX_ST_SEEK_ALERT;
    private static final int INDEX_ARTIST_ICON;
    private static final int INDEX_ARTIST;
    private static final int INDEX_TITLE_ICON;
    private static final int INDEX_TITLE;
    protected static final int INDEX_ST_CATID_LONG;
    private static final int INDEX_ST_NAME_LONG;
    private static final int INDEX_DASH;
    protected static final int INDEX_RADIOTEXT_ICON;
    protected static final int INDEX_ITUNES_ICON;
    private static final int INDEX_IMAGE;
    protected static final int INDEX_PROPERTIES;
    private static final int INDEX_COMPOSER_ICON;
    private static final int INDEX_COMPOSER;
    public static final int NUM_OF_COLS;
    private final StationInfoExt station;
    private boolean tmpAdded;
    private RadioText pdt;

    public SDARSListRow(int n, StationInfoExt stationInfoExt, boolean bl, boolean bl2) {
        super(RadioObjectIds.getSDARSObjectId(stationInfoExt.sID), n);
        this.station = stationInfoExt;
        this.tmpAdded = bl;
        this.setText(0, Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
        this.setText(10, bl2 ? "NoSignal" : stationInfoExt.getFullCategory());
        this.setInteger(3, stationInfoExt.subscription == 2 ? 0 : 1);
        this.setInteger(4, stationInfoExt.getPresetPos());
        this.setInteger(5, 0);
        this.setInteger(6, 0);
        this.setText(7, "");
        this.setInteger(8, 0);
        this.setText(9, "");
        this.setText(11, stationInfoExt.fullLabel);
        this.setInteger(12, 0);
        this.setInteger(13, 0);
        this.setInteger(14, 0);
        this.setHMIResourceLocator(15, stationInfoExt.getStationArt());
    }

    protected SDARSListRow(SDARSListRow sDARSListRow) {
        super(sDARSListRow);
        this.station = sDARSListRow.station;
        this.tmpAdded = sDARSListRow.tmpAdded;
        this.pdt = sDARSListRow.pdt;
    }

    @Override
    public EvoListRow copy() {
        return new SDARSListRow(this);
    }

    @Override
    public StationInfoExt getStation() {
        return this.station;
    }

    public void setNoSignal(boolean bl) {
        this.setText(2, bl ? "NoSignal" : this.station.getShortCategory());
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return new TunerObjectContainer(this.station);
    }

    @Override
    public void resetPdt() {
        this.setText(7, "");
        this.setText(9, "");
        this.setText(18, "");
        this.setInteger(6, 0);
        this.setInteger(8, 0);
        this.setInteger(17, 0);
        this.setInteger(12, 0);
        this.setHMIResourceLocator(15, this.station.getStationArt());
        this.pdt = null;
    }

    public void setStationActive(boolean bl) {
    }

    public boolean isTmpAdded() {
        return this.tmpAdded;
    }

    public String getCategory(boolean bl) {
        return bl ? this.station.getFullCategory() : this.station.getShortCategory();
    }

    @Override
    public void setProgramData(SdarsRadioText sdarsRadioText, int n) {
        this.pdt = sdarsRadioText;
        this.setText(7, sdarsRadioText.shortArtistName);
        this.setInteger(6, sdarsRadioText.shortArtistName.length() == 0 ? 0 : 1);
        this.setText(9, sdarsRadioText.shortProgramTitle);
        this.setInteger(8, sdarsRadioText.shortProgramTitle.length() == 0 ? 0 : 1);
        this.setInteger(12, 2);
        this.setText(18, sdarsRadioText.composer);
        this.setInteger(17, sdarsRadioText.composer.length() == 0 ? 0 : 1);
        RadioHMIResourceLocator radioHMIResourceLocator = Utilities.getPreferredImage(n, null, sdarsRadioText.getCoverArt(), this.station.getStationArt());
        this.setHMIResourceLocator(15, radioHMIResourceLocator);
    }

    public RadioText getPdt() {
        return this.pdt;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(300);
        buffer.append(this.station.toString());
        buffer.append(super.toString());
        return buffer.toString();
    }

    @Override
    public void setSeekPossibility(AddToSeeksPossibilityEnum addToSeeksPossibilityEnum, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4) {
    }
}

