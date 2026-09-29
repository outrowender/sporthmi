/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.amfm.stationlist;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.amfm.stationlist.FmListRow;
import de.audi.tuner.app.amfm.stationlist.RecordSets;
import de.audi.tuner.app.misc.RadioHMIResourceLocator;

public class FmListRowEvo
extends FmListRow {
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_ARTIST;
    private static final int INDEX_TITLE;
    private static final int INDEX_ARTIST_ICON;
    private static final int INDEX_TITLE_ICON;
    private static final int INDEX_RADIOTEXT_ICON;
    private static final int INDEX_DASH;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    private static final int INDEX_ALBUM;
    private static final int INDEX_ALBUM_ICON;
    private static final int INDEX_ITUNES_ICON;
    public static final int NUM_COLS;
    private final RadioRowProperties props;

    public FmListRowEvo(AMFMStation aMFMStation, RecordSets recordSets, int n) {
        super(23, aMFMStation, recordSets);
        this.props = new RadioRowProperties();
        this.props.setNameFreezed(aMFMStation.isPsFreezed());
        this.props.setNoRadioText(!aMFMStation.isRds() && !aMFMStation.isHd());
        this.props.setCategory(aMFMStation.isHd() ? 921087017 : 1330850098);
        this.props.setScrollingPS(aMFMStation.isScrollingPS());
        this.setPropertyCell(11, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(19, 1);
        this.setText(5, aMFMStation.getHDNameAndExt().trim());
        this.setText(6, "");
        this.setHMIResourceLocator(0, aMFMStation.getImage(0));
        this.setInteger(18, 0);
    }

    private FmListRowEvo(FmListRowEvo fmListRowEvo) {
        super(fmListRowEvo);
        this.props = fmListRowEvo.props;
    }

    @Override
    public EvoListRow copy() {
        return new FmListRowEvo(this);
    }

    @Override
    public void setStationActive(boolean bl) {
        this.props.setActive(bl);
        this.setPropertyCell(11, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        if (!bl) {
            this.resetProgramData();
            this.resetHdStatus();
        }
    }

    @Override
    public final void setProgramData(AMFMStation aMFMStation, int n, TunerStatus tunerStatus) {
        this.setInteger(16, Utilities.isJapan() ? 0 : (aMFMStation.getTag(64).length() > 0 ? 2 : 1));
        ArtistAndTitlePair artistAndTitlePair = aMFMStation.getArtistAndTitlePair();
        String string = aMFMStation.getAlbum();
        this.setText(12, artistAndTitlePair.artistString);
        this.setInteger(14, artistAndTitlePair.artistString.length() == 0 ? 0 : 1);
        this.setText(13, artistAndTitlePair.titleString);
        this.setInteger(15, artistAndTitlePair.titleString.length() == 0 ? 0 : 1);
        int n2 = Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString);
        this.setInteger(18, n2);
        this.setText(20, string);
        this.setInteger(21, string.length() == 0 ? 0 : 1);
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(aMFMStation.getImage(n));
        hMIResourceLocator.setMinDisplayDuration(5000);
        this.setHMIResourceLocator(0, hMIResourceLocator);
        HdStationInfoExt hdStationInfoExt = aMFMStation.getHdInfo();
        this.props.setTaggingInfosAvailable(hdStationInfoExt.artistAndTitleInformationAvailable());
        this.setPropertyCell(11, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        int n3 = 0;
        if (tunerStatus.isFmHdModeOn()) {
            boolean bl = hdStationInfoExt.getTaggingStatus() == 2;
            n3 = bl ? ITUNES_ICON_ENABLED : ITUNES_ICON_RESET;
        }
        this.setInteger(22, n3);
    }

    private void resetProgramData() {
        this.setText(12, "");
        this.setText(13, "");
        this.setText(20, "");
        this.setInteger(14, 0);
        this.setInteger(15, 0);
        this.setInteger(21, 0);
        this.setInteger(16, Utilities.isJapan() ? 0 : 1);
        this.setInteger(18, 0);
        RadioHMIResourceLocator radioHMIResourceLocator = this.station.getImage(0);
        this.setHMIResourceLocator(0, radioHMIResourceLocator);
        this.setInteger(22, ITUNES_ICON_RESET);
        this.props.setTaggingInfosAvailable(false);
        this.station.resetProgramData();
    }
}

