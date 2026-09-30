/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.SDARSListRow;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;

public class SDARSListRowEvo
extends SDARSListRow {
    private static final int INDEX_DEFAULT_IMAGE_ID = 19;
    private static final int NUM_COLS = 20;
    private static final int ITUNES_ICON_RESET = Utilities.isTaggingSupported() ? 1 : 0;
    private static final int ITUNES_ICON_ENABLED = Utilities.isTaggingSupported() ? 2 : 0;
    private final RadioRowProperties props;

    public SDARSListRowEvo(StationInfoExt stationInfoExt, boolean bl, boolean bl2) {
        super(20, stationInfoExt, bl, bl2);
        this.setText(1, stationInfoExt.shortLabel);
        this.setText(2, bl2 ? "NoSignal" : stationInfoExt.getShortCategory());
        this.setInteger(19, 7);
        this.props = new RadioRowProperties();
        this.props.setCategory(-524345816);
        this.setPropertyCell(16, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(14, ITUNES_ICON_RESET);
    }

    private SDARSListRowEvo(SDARSListRowEvo sDARSListRowEvo) {
        super(sDARSListRowEvo);
        this.props = sDARSListRowEvo.props;
    }

    public EvoListRow copy() {
        return new SDARSListRowEvo(this);
    }

    public void setStationActive(boolean bl) {
        this.props.setActive(bl);
        this.setPropertyCell(16, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    public void setProgramData(SdarsRadioText sdarsRadioText, int n) {
        super.setProgramData(sdarsRadioText, n);
        this.props.setTaggingInfosAvailable(sdarsRadioText.artistOrTitleInformationAvailable() && this.props.isActive());
        this.setPropertyCell(16, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        boolean bl = sdarsRadioText.getTaggingStatus() == 2 && this.props.isActive();
        this.setInteger(14, bl ? ITUNES_ICON_ENABLED : ITUNES_ICON_RESET);
        this.setInteger(13, 2);
    }

    void reset() {
        this.resetPdt();
        this.props.setTaggingInfosAvailable(false);
        this.props.setSongSeekPossible(0);
        this.props.setArtistSeekPossible(0);
        this.props.setTeam1SeekPossible(0);
        this.props.setTeam2SeekPossible(0);
        this.setPropertyCell(16, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(14, ITUNES_ICON_RESET);
        this.setInteger(13, 1);
    }

    public void setSeekPossibility(AddToSeeksPossibilityEnum addToSeeksPossibilityEnum, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4) {
        super.setSeekPossibility(addToSeeksPossibilityEnum, addToSeeksPossibilityEnum2, addToSeeksPossibilityEnum3, addToSeeksPossibilityEnum4);
        this.props.setArtistSeekPossible(addToSeeksPossibilityEnum.showOption ? 1 : 0);
        this.props.setSongSeekPossible(addToSeeksPossibilityEnum2.showOption ? 1 : 0);
        this.setPropertyCell(16, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }
}

