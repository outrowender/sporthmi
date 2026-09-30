/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.favorites;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.SDARSMemoryRow;
import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.seek.AddToSeeksPossibilityEnum;

public class SDARSFavRowEvo
extends SDARSMemoryRow {
    private static final int INDEX_PROPERTIES = 14;
    private static final int INDEX_DEFAULT_IMAGE_ID = 15;
    private static final int INDEX_PRESET_POS = 16;
    private static final int INDEX_ALBUM_COMPOSER = 18;
    private static final int INDEX_ALBUM_COMPOSER_ICON = 19;
    private static final int INDEX_ARTIST_ICON = 20;
    private static final int INDEX_TITLE_ICON = 21;
    private static final int INDEX_ITUNES_ICON = 22;
    public static final int NUM_COLS = 23;
    private final RadioRowProperties props;
    private static final int ITUNES_ICON_RESET = Utilities.isTaggingSupported() ? 1 : 0;
    private static final int ITUNES_ICON_ENABLED = Utilities.isTaggingSupported() ? 2 : 0;

    public SDARSFavRowEvo(StationInfoExt stationInfoExt, int n) {
        super(23, stationInfoExt);
        this.props = new RadioRowProperties();
        this.props.setCategory(-524345816);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(15, 2);
        this.setPresetIndex(n - 1);
        this.setInteger(22, ITUNES_ICON_RESET);
    }

    private SDARSFavRowEvo(SDARSFavRowEvo sDARSFavRowEvo) {
        super(sDARSFavRowEvo);
        this.props = sDARSFavRowEvo.props;
    }

    public EvoListRow copy() {
        return new SDARSFavRowEvo(this);
    }

    public void setStationActive(boolean bl) {
        super.setStationActive(bl);
        this.props.setActive(bl);
        if (!bl) {
            this.props.setTaggingInfosAvailable(false);
            this.props.setSongSeekPossible(0);
            this.props.setArtistSeekPossible(0);
            this.props.setTeam1SeekPossible(0);
            this.props.setTeam2SeekPossible(0);
            this.resetProgramData();
        }
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    public void resetProgramData() {
        super.resetProgramData();
        this.setText(18, "");
        this.setInteger(19, 0);
        this.setInteger(20, 0);
        this.setInteger(21, 0);
        this.setInteger(22, ITUNES_ICON_RESET);
        this.setInteger(11, 1);
    }

    public void setProgramData(SdarsRadioText sdarsRadioText, int n) {
        super.setProgramData(sdarsRadioText, n);
        this.setText(18, sdarsRadioText.composer);
        this.setInteger(19, sdarsRadioText.composer.length() == 0 ? 0 : 1);
        this.setInteger(20, sdarsRadioText.shortArtistName.length() == 0 ? 0 : 1);
        this.setInteger(21, sdarsRadioText.shortProgramTitle.length() == 0 ? 0 : 1);
        this.props.setTaggingInfosAvailable(sdarsRadioText.artistOrTitleInformationAvailable() && this.props.isActive());
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        boolean bl = sdarsRadioText.getTaggingStatus() == 2 && this.props.isActive();
        this.setInteger(22, bl ? ITUNES_ICON_ENABLED : ITUNES_ICON_RESET);
        this.setInteger(11, 2);
    }

    public void setSeekPossibility(AddToSeeksPossibilityEnum addToSeeksPossibilityEnum, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum2, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum3, AddToSeeksPossibilityEnum addToSeeksPossibilityEnum4) {
        super.setSeekPossibility(addToSeeksPossibilityEnum, addToSeeksPossibilityEnum2, addToSeeksPossibilityEnum3, addToSeeksPossibilityEnum4);
        this.props.setArtistSeekPossible(addToSeeksPossibilityEnum.showOption ? 1 : 0);
        this.props.setSongSeekPossible(addToSeeksPossibilityEnum2.showOption ? 1 : 0);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    public void setPresetIndex(int n) {
        int n2 = Utilities.adjustPresetPosForNar(n + 1);
        this.setInteger(16, n2);
    }
}

