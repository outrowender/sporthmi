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
import de.audi.tuner.app.amfm.stationlist.AmListRow;
import de.audi.tuner.app.amfm.stationlist.RecordSets;

public class AmListRowEvo
extends AmListRow {
    private static final int INDEX_PROPERTIES = 8;
    private static final int INDEX_DEFAULT_IMAGE_ID = 9;
    private static final int INDEX_ARTIST = 10;
    private static final int INDEX_TITLE = 11;
    private static final int INDEX_ALBUM = 12;
    private static final int INDEX_DASH = 13;
    private static final int INDEX_ARTIST_ICON = 14;
    private static final int INDEX_TITLE_ICON = 15;
    private static final int INDEX_ALBUM_ICON = 16;
    private static final int INDEX_ITUNES_ICON = 17;
    private static final int INDEX_RADIOTEXT_ICON = 18;
    public static final int NUM_COLS = 19;
    private final RadioRowProperties props;

    public AmListRowEvo(AMFMStation aMFMStation, RecordSets recordSets, int n) {
        super(19, aMFMStation, recordSets);
        this.props = new RadioRowProperties();
        this.props.setNameFreezed(aMFMStation.isPsFreezed());
        this.props.setNoRadioText(!aMFMStation.isHd());
        this.props.setCategory(aMFMStation.isHd() ? -1926460439 : -1040177395);
        this.props.setScrollingPS(aMFMStation.isScrollingPS());
        this.setPropertyCell(8, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(9, 4);
        this.setHMIResourceLocator(0, aMFMStation.getImage(0));
        this.setInteger(13, 0);
    }

    private AmListRowEvo(AmListRowEvo amListRowEvo) {
        super(amListRowEvo);
        this.props = amListRowEvo.props;
    }

    public EvoListRow copy() {
        return new AmListRowEvo(this);
    }

    public void setStationActive(boolean bl) {
        this.props.setActive(bl);
        this.setPropertyCell(8, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        if (!bl) {
            this.resetProgramData();
            this.resetHdStatus();
        }
    }

    public final void setProgramData(AMFMStation aMFMStation, int n, TunerStatus tunerStatus) {
        Object object;
        ArtistAndTitlePair artistAndTitlePair = aMFMStation.getArtistAndTitlePair();
        String string = aMFMStation.getAlbum();
        this.setText(10, artistAndTitlePair.artistString);
        this.setText(11, artistAndTitlePair.titleString);
        this.setText(12, string);
        this.setInteger(14, artistAndTitlePair.artistString.length() == 0 ? 0 : 1);
        this.setInteger(15, artistAndTitlePair.titleString.length() == 0 ? 0 : 1);
        this.setInteger(16, string.length() == 0 ? 0 : 1);
        int n2 = Utilities.getDashCode(artistAndTitlePair.artistString, artistAndTitlePair.titleString);
        this.setInteger(13, n2);
        HMIResourceLocator hMIResourceLocator = new HMIResourceLocator(aMFMStation.getImage(n));
        hMIResourceLocator.setMinDisplayDuration(5000);
        this.setHMIResourceLocator(0, hMIResourceLocator);
        int n3 = 0;
        if (aMFMStation.isHd()) {
            n3 = 1;
            object = aMFMStation.getTag(64);
            if (!Utilities.isEmpty((String)object)) {
                n3 = 2;
            }
        }
        this.setInteger(18, n3);
        object = aMFMStation.getHdInfo();
        this.props.setTaggingInfosAvailable(((HdStationInfoExt)object).artistAndTitleInformationAvailable());
        this.setPropertyCell(8, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        int n4 = 0;
        if (tunerStatus.isAmHdModeOn()) {
            boolean bl = ((HdStationInfoExt)object).getTaggingStatus() == 2;
            n4 = bl ? ITUNES_ICON_ENABLED : ITUNES_ICON_RESET;
        }
        this.setInteger(17, n4);
    }

    private void resetProgramData() {
        this.setText(10, "");
        this.setText(11, "");
        this.setText(12, "");
        this.setInteger(14, 0);
        this.setInteger(15, 0);
        this.setInteger(16, 0);
        this.setInteger(13, 0);
        this.setInteger(17, ITUNES_ICON_RESET);
        this.setInteger(18, 0);
        this.setHMIResourceLocator(0, this.station.getImage(0));
        this.props.setTaggingInfosAvailable(false);
        this.station.resetProgramData();
    }
}

