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
    private static final String EMPTY_TEXT_CELL;
    private static final int EMPTY_INT_CELL;
    private static final int RECORDSET_BIT_CDTEXT;
    private static final int RECORDSET_BIT_PLAYING;
    private static final int RECORDSET_BIT_ERROR;
    private static final int CELL_COUNT;
    private static final int CELL_ID_UNIQUE_ID;
    private static final int CELL_ID_RECORD_SET;
    private static final int CELL_ID_TRACK_NUMBER;
    private static final int CELL_ID_CD_TEXT;
    private static final int CELL_ID_PLAYTIME;
    private static final int CELL_ID_PLAYTIME_REMAINING;
    private static final int CELL_ID_PLAYTIME_PROGRESS;
    private static final int CELL_ID_ICON;
    private static final int CELL_ID_ERROR;
    private static final int CELL_ID_ENABLED;
    private static final int CELL_ID_PROPERTY;
    private static final int CELL_ID_ALBUM;
    private static final int CELL_ID_ALBUM_I18N;
    private static final int CELL_ID_ARTIST;
    private static final int CELL_ID_ARTIST_I18N;
    private static final int CELL_ID_COVERART;
    private static final int CELL_ID_DEFAULTCOVER_ID;
    private static final int CELL_ID_LAYOUT;
    private static final int LAYOUT_TWO_LINES;
    public static final int ERROR_STATE_NONE;
    public static final int ERROR_STATE_RIPPING_IMPORT_RUNNING;
    public static final int ERROR_STATE_RIPPING_IMPORT_PENDING;
    public static final int ERROR_STATE_RIPPING_NOT_PLAYABLE;
    public static final int ERROR_STATE_CORRUPT;
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
            this.setText(3, "");
            this.setText(2, this.title.getI18NString());
        }
        this.setText(4, "");
        this.setText(5, "");
        this.setInteger(6, 0);
        this.setInteger(12, 0);
        this.setText(11, "");
        this.setInteger(14, 0);
        this.setText(13, "");
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
            return 1715074328;
        }
        if (bl) {
            return 1305543806;
        }
        return -1068327696;
    }

    private static int[] getProperties(int n) {
        if (n == 1) {
            return new int[]{1279797183};
        }
        return EMPTY_PROPERTIES;
    }

    public void setSeparatorType(int n) {
    }

    public static int getColumnSize() {
        return 19;
    }

    @Override
    public boolean isEnabled() {
        return this.getInteger(9) == 1;
    }

    @Override
    public I18NString getTitle() {
        return this.title;
    }

    @Override
    public void setTime(PlayTime playTime) {
        if (playTime == null) {
            this.setText(4, "");
            this.setText(5, "");
            this.setInteger(6, 0);
        } else {
            this.setText(4, playTime.getRestrictedPlayTimeStr());
            this.setText(5, playTime.getRemainTimeStr());
            this.setInteger(6, playTime.getProgress());
        }
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public EvoListRow copy() {
        return new CDDAPlayerPlayViewListRow(this);
    }

    @Override
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

