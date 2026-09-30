/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class CDDAPlayerPlayViewListRow
extends AbstractMediaPlayViewListRow {
    private static final int[] EMPTY_PROPERTIES = new int[0];
    private static final String EMPTY_TEXT_CELL = "";
    private static final int EMPTY_INT_CELL = 0;
    private static final int RECORDSET_BIT_CDTEXT = 1;
    private static final int RECORDSET_BIT_PLAYING = 2;
    private static final int RECORDSET_BIT_ERROR = 4;
    private static final int CELL_COUNT = 19;
    private static final int CELL_ID_UNIQUE_ID = 0;
    private static final int CELL_ID_RECORD_SET = 1;
    private static final int CELL_ID_TRACK_NUMBER = 2;
    private static final int CELL_ID_CD_TEXT = 3;
    private static final int CELL_ID_PLAYTIME = 4;
    private static final int CELL_ID_PLAYTIME_REMAINING = 5;
    private static final int CELL_ID_PLAYTIME_PROGRESS = 6;
    private static final int CELL_ID_ICON = 7;
    private static final int CELL_ID_ERROR = 8;
    private static final int CELL_ID_ENABLED = 9;
    private static final int CELL_ID_PROPERTY = 10;
    private static final int CELL_ID_ALBUM = 11;
    private static final int CELL_ID_ALBUM_I18N = 12;
    private static final int CELL_ID_ARTIST = 13;
    private static final int CELL_ID_ARTIST_I18N = 14;
    private static final int CELL_ID_COVERART = 15;
    private static final int CELL_ID_DEFAULTCOVER_ID = 16;
    private static final int CELL_ID_LAYOUT = 18;
    private static final int LAYOUT_TWO_LINES = 2;
    public static final int ERROR_STATE_NONE = 0;
    public static final int ERROR_STATE_RIPPING_IMPORT_RUNNING = 1;
    public static final int ERROR_STATE_RIPPING_IMPORT_PENDING = 2;
    public static final int ERROR_STATE_RIPPING_NOT_PLAYABLE = 3;
    public static final int ERROR_STATE_CORRUPT = 4;
    private final I18NString title;

    public CDDAPlayerPlayViewListRow(MediaListEntry mediaListEntry) {
        super(mediaListEntry.getEntryID(), 19);
        this.title = mediaListEntry.getTitle();
        this.setLong(0, mediaListEntry.getEntryID());
        int n = mediaListEntry.isNoPlaybackDuringImport() ? 3 : (mediaListEntry.isImportPending() ? 2 : (mediaListEntry.isCorrupt() ? 4 : (mediaListEntry.isImportRunning() ? 1 : 0)));
        this.setInteger(8, n);
        this.setInteger(9, n == 0 ? 1 : 0);
        boolean bl = true;
        bl = !this.title.isInternationalized();
        int n2 = 0;
        n2 |= n != 0 ? 4 : 0;
        this.setInteger(1, n2 |= bl ? 1 : 0);
        if (bl) {
            this.setText(3, this.title.getI18NString());
            this.setText(2, CDDAPlayerPlayViewListRow.extractTrackNumberFromFileName(mediaListEntry.getFilename().getOriginalString()));
        } else {
            this.setText(3, EMPTY_TEXT_CELL);
            this.setText(2, this.title.getI18NString());
        }
        this.setText(4, EMPTY_TEXT_CELL);
        this.setText(5, EMPTY_TEXT_CELL);
        this.setInteger(6, 0);
        this.setInteger(12, 0);
        this.setText(11, EMPTY_TEXT_CELL);
        this.setInteger(14, 0);
        this.setText(13, EMPTY_TEXT_CELL);
        this.setInteger(7, n);
        this.setHMIResourceLocator(15, new HMIResourceLocator(mediaListEntry.getCovertArt() == null ? -1 : mediaListEntry.getCovertArt().getId(), mediaListEntry.getCovertArt() == null ? ResourceLocatorModelApp.UNDEFINED_URI : mediaListEntry.getCovertArt().getUrl()));
        this.setInteger(16, (int)mediaListEntry.getAlbumID());
        this.setPropertyCell(10, new PropertyListCell(CDDAPlayerPlayViewListRow.getCategory(n, false), CDDAPlayerPlayViewListRow.getProperties(n)));
        this.setInteger(18, 2);
    }

    public CDDAPlayerPlayViewListRow(CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow) {
        super(cDDAPlayerPlayViewListRow);
        this.title = cDDAPlayerPlayViewListRow.getTitle();
    }

    private static int getCategory(int n, boolean bl) {
        if (n == 4 || n == 3) {
            return 418724198;
        }
        if (bl) {
            return 2114244941;
        }
        return -258190656;
    }

    private static int[] getProperties(int n) {
        if (n == 1) {
            return new int[]{-1087944628};
        }
        return EMPTY_PROPERTIES;
    }

    public void setSeparatorType(int n) {
    }

    public static int getColumnSize() {
        return 19;
    }

    public boolean isEnabled() {
        return this.getInteger(9) == 1;
    }

    public I18NString getTitle() {
        return this.title;
    }

    public void setTime(PlayTime playTime) {
        if (playTime == null) {
            this.setText(4, EMPTY_TEXT_CELL);
            this.setText(5, EMPTY_TEXT_CELL);
            this.setInteger(6, 0);
        } else {
            this.setText(4, playTime.getRestrictedPlayTimeStr());
            this.setText(5, playTime.getRemainTimeStr());
            this.setInteger(6, playTime.getProgress());
        }
    }

    public void setPlaying(boolean bl) {
        int n = this.getInteger(1);
        if (bl) {
            this.setInteger(1, (n &= 0xFFFFFFFB) | 2);
            this.setPropertyCell(10, new PropertyListCell(CDDAPlayerPlayViewListRow.getCategory(this.getErrorState(), true), EMPTY_PROPERTIES));
            this.setInteger(9, 1);
        } else {
            this.setInteger(1, n & 0xFFFFFFFD);
            this.setPropertyCell(10, new PropertyListCell(CDDAPlayerPlayViewListRow.getCategory(this.getErrorState(), false), EMPTY_PROPERTIES));
        }
    }

    public void setDetailInfos(MediaDetailInfo mediaDetailInfo) {
        if (this.getEntryID() != mediaDetailInfo.getPlayingTrack().getEntryID()) {
            return;
        }
        if (null != mediaDetailInfo.getAlbum()) {
            this.setText(11, mediaDetailInfo.getAlbum().getI18NString());
            this.setInteger(12, mediaDetailInfo.getAlbum().getI18NKey());
        }
        if (null != mediaDetailInfo.getArtist()) {
            this.setText(13, mediaDetailInfo.getArtist().getI18NString());
            this.setInteger(14, mediaDetailInfo.getArtist().getI18NKey());
        }
    }

    public void setCoverArt(ResourceLocator resourceLocator) {
        if (-1 == ((HMIResourceLocator)this.getCell(15)).getResourceID()) {
            this.setHMIResourceLocator(15, new HMIResourceLocator(resourceLocator == null ? -1 : resourceLocator.getId(), resourceLocator == null ? ResourceLocatorModelApp.UNDEFINED_URI : resourceLocator.getUrl()));
        }
    }

    private int getErrorState() {
        return this.getInteger(8);
    }

    private static String extractTrackNumberFromFileName(String string) {
        int n = string.indexOf(".cda");
        if (n > -1) {
            return string.substring(5, n);
        }
        return "0";
    }

    public EvoListRow copy() {
        return new CDDAPlayerPlayViewListRow(this);
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[eID='");
        buffer.append(this.getEntryID());
        buffer.append("',tnr='");
        buffer.append(this.getText(2));
        buffer.append("',rs='");
        buffer.append(this.getInteger(1));
        buffer.append("' album='");
        buffer.append(this.getText(11));
        buffer.append("' '");
        buffer.append(this.getInteger(12));
        buffer.append("' artist='");
        buffer.append(this.getText(13));
        buffer.append("' '");
        buffer.append(this.getInteger(14));
        buffer.append("' '");
        buffer.append(this.getInteger(9) == 1 ? "enabled" : "disabled");
        buffer.append("']");
        return buffer.toString();
    }
}

