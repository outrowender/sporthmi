/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.favorites;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.memory.AmFmMemoryRow;

public class AmFmFavRowEvo
extends AmFmMemoryRow {
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    private static final int INDEX_PRESET_POS;
    private static final int INDEX_EXTENSION_HD;
    private static final int INDEX_ALBUM_COMPOSER;
    private static final int INDEX_ALBUM_COMPOSER_ICON;
    private static final int INDEX_ARTIST_ICON;
    private static final int INDEX_TITLE_ICON;
    private static final int INDEX_ITUNES_ICON;
    public static final int NUM_COLS;
    private static final int ITUNES_ICON_RESET;
    private static final int ITUNES_ICON_ENABLED;
    private final RadioRowProperties props;

    public AmFmFavRowEvo(AMFMStation aMFMStation, int n, int n2) {
        super(23, aMFMStation);
        this.props = new RadioRowProperties();
        this.props.setCategory(AmFmFavRowEvo.determineCategoryFor(aMFMStation));
        this.props.setNameFreezed(aMFMStation.isPsFreezed());
        this.props.setScrollingPS(aMFMStation.isScrollingPS());
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setHMIResourceLocator(10, aMFMStation.getImage(n2));
        this.setInteger(15, aMFMStation.waveband == 1 ? 1 : 4);
        this.setPresetIndex(n - 1);
        this.setText(17, aMFMStation.getHdExtension());
    }

    private AmFmFavRowEvo(AmFmFavRowEvo amFmFavRowEvo) {
        super(amFmFavRowEvo);
        this.props = amFmFavRowEvo.props;
    }

    @Override
    public EvoListRow copy() {
        return new AmFmFavRowEvo(this);
    }

    @Override
    public void setStationActive(boolean bl) {
        this.props.setActive(bl);
        if (!bl) {
            this.props.setTaggingInfosAvailable(false);
            this.resetProgramData();
        }
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    @Override
    public void setPSFreeze(boolean bl, String string) {
        super.setPSFreeze(bl, string);
        this.props.setNameFreezed(bl);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
    }

    @Override
    public void resetProgramData() {
        super.resetProgramData();
        this.props.setCategory(AmFmFavRowEvo.determineCategoryFor(this.station));
        this.props.setTaggingInfosAvailable(false);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setText(18, "");
        this.setInteger(19, 0);
        this.setInteger(20, 0);
        this.setInteger(21, 0);
        this.setInteger(22, ITUNES_ICON_RESET);
    }

    @Override
    public void setProgramData(TunerObjectContainer tunerObjectContainer, int n) {
        super.setProgramData(tunerObjectContainer, n);
        String string = tunerObjectContainer.getAMFMService().getAlbum();
        this.setText(18, string);
        ArtistAndTitlePair artistAndTitlePair = tunerObjectContainer.getArtistAndTitlePair();
        this.setInteger(19, string.length() == 0 ? 0 : 1);
        this.setInteger(20, artistAndTitlePair.artistString.length() == 0 ? 0 : 1);
        this.setInteger(21, artistAndTitlePair.titleString.length() == 0 ? 0 : 1);
        this.props.setCategory(AmFmFavRowEvo.determineCategoryFor(tunerObjectContainer.getAMFMService()));
        HdStationInfoExt hdStationInfoExt = tunerObjectContainer.getAMFMService().getHdInfo();
        this.props.setTaggingInfosAvailable(hdStationInfoExt.artistAndTitleInformationAvailable());
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        boolean bl = hdStationInfoExt.getTaggingStatus() == 2;
        this.setInteger(22, bl ? ITUNES_ICON_ENABLED : ITUNES_ICON_RESET);
    }

    @Override
    public void setPresetIndex(int n) {
        int n2 = Utilities.adjustPresetPosForNar(n + 1);
        this.setInteger(16, n2);
    }

    @Override
    protected void tmpOverwrite(TunerObjectContainer tunerObjectContainer) {
        super.tmpOverwrite(tunerObjectContainer);
        this.setText(17, tunerObjectContainer.getAMFMService().getHdExtension());
    }

    @Override
    protected void resetOverwrite() {
        super.resetOverwrite();
        this.setText(17, this.station.getHdExtension());
    }

    private static int determineCategoryFor(AMFMStation aMFMStation) {
        if (aMFMStation.waveband == 1) {
            return aMFMStation.isHd() ? 921087017 : 1330850098;
        }
        return aMFMStation.isHd() ? -376755059 : 220659906;
    }

    static {
        ITUNES_ICON_RESET = Utilities.isNARBuild() && Utilities.isTaggingSupported() ? 1 : 0;
        ITUNES_ICON_ENABLED = Utilities.isNARBuild() && Utilities.isTaggingSupported() ? 2 : 0;
    }
}

