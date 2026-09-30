/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class DataPlayerPlayViewListRow
extends AbstractMediaPlayViewListRow {
    private static final String LOGCLASS = "DataPlayerPlayViewListRow";
    private static final int[] EMPTY_PROPERTIES = new int[0];
    private static final String EMPTY_TEXT_CELL = null;
    private static final int EMPTY_INT_CELL = 0;
    private static final int NOT_SUPPORT_INT_CELL = -1;
    private static final byte RECORDSET_BIT_VIDEO_TYPE = 1;
    private static final byte RECORDSET_BIT_PLAYING = 2;
    private static final byte RECORDSET_BIT_ERROR = 4;
    private static final byte RECORDSET_BIT_CHAPTER_SUPPORT = 8;
    private static final byte CELL_COUNT = 21;
    private static final byte CELL_ID_UNIQUE_ID = 0;
    private static final byte CELL_ID_RECORD_SET = 1;
    private static final byte CELL_ID_ICON = 2;
    private static final byte CELL_ID_TITEL = 3;
    private static final byte CELL_ID_TITLE_I18N = 4;
    private static final byte CELL_ID_ARTIST = 5;
    private static final byte CELL_ID_ARTIST_I18N = 6;
    private static final byte CELL_ID_ALBUM = 7;
    private static final byte CELL_ID_ALBUM_I18N = 8;
    private static final byte CELL_ID_PLAYTIME = 9;
    private static final byte CELL_ID_PLAYTIME_REMAINING = 10;
    private static final byte CELL_ID_PLAYTIME_PROGRESS = 11;
    private static final byte CELL_ID_ERROR_STATE = 12;
    private static final byte CELL_ID_COVERART = 13;
    private static final byte CELL_ID_PROPERTY = 14;
    private static final byte CELL_ID_TOTAL_CHAPTER = 15;
    private static final byte CELL_ID_ACTIV_CHAPTER = 16;
    private static final byte CELL_ID_ENABLED = 17;
    private static final byte CELL_ID_LAYOUT = 18;
    private static final byte CELL_ID_DEFAULTCOVER_ID = 19;
    private static final byte CELL_ID_ONLINE = 20;
    private static final int LAYOUT_ONE_LINE = 1;
    private static final int LAYOUT_TWO_LINES = 2;
    public static final int ERROR_STATE_NONE = 0;
    public static final int ERROR_STATE_PROTECTED = 1;
    public static final int ERROR_STATE_CORRUPT = 2;
    public static final int ERROR_STATE_DEADLINK = 3;
    public static final int ERROR_STATE_ONLINE_ENTRY_NO_CONNECTION = 4;
    public static final int ONLINE_STATE_NONE = 0;
    public static final int ONLINE_STATE_CLOUD = 1;
    private static final int ICONTYPE_OFFSET_AUDIO = 0;
    private static final int ICONTYPE_OFFSET_VIDEO = 4;
    private final int entryContentType;
    private volatile ResourceLocator coverart;
    private final MediaListEntry entry;
    private volatile boolean supportsPlayTime;
    private final LogChannel logger;

    public DataPlayerPlayViewListRow(MediaListEntry mediaListEntry, boolean bl, LogChannel logChannel) {
        super(mediaListEntry.getEntryID(), 21);
        this.entryContentType = mediaListEntry.getContentType();
        this.coverart = mediaListEntry.getCovertArt();
        this.entry = mediaListEntry;
        this.supportsPlayTime = bl;
        this.logger = logChannel;
        this.setLong(0, mediaListEntry.getEntryID());
        this.setText(3, mediaListEntry.getTitle().getI18NString());
        this.setInteger(4, mediaListEntry.getTitle().getI18NKey());
        if (mediaListEntry.isAudioFile() && mediaListEntry.getArtist() != null) {
            this.setText(5, mediaListEntry.getArtist().getI18NString());
            this.setInteger(6, mediaListEntry.getArtist().getI18NKey());
        } else {
            this.setText(5, EMPTY_TEXT_CELL);
            this.setInteger(6, 0);
        }
        if (mediaListEntry.isAudioFile() && mediaListEntry.getAlbum() != null) {
            this.setText(7, mediaListEntry.getAlbum().getI18NString());
            this.setInteger(8, mediaListEntry.getAlbum().getI18NKey());
        } else {
            this.setText(7, EMPTY_TEXT_CELL);
            this.setInteger(8, 0);
        }
        if ((mediaListEntry.getAlbum() == null || mediaListEntry.getAlbum().isEmpty()) && (mediaListEntry.getArtist() == null || mediaListEntry.getArtist().isEmpty())) {
            this.setInteger(18, 1);
        } else {
            this.setInteger(18, 2);
        }
        this.setInteger(19, (int)MediaUtils.removeEntryIdFlags(mediaListEntry.getAlbumID()));
        int n = mediaListEntry.isProtected() ? 1 : (mediaListEntry.isCorrupt() ? 2 : (mediaListEntry.isDeadLink() ? (mediaListEntry.isOnline() ? 4 : 3) : 0));
        this.setInteger(12, n);
        this.setInteger(17, n == 0 ? 1 : 0);
        int n2 = mediaListEntry.isOnline() ? 1 : 0;
        this.setInteger(20, n2);
        this.setText(9, EMPTY_TEXT_CELL);
        this.setText(10, EMPTY_TEXT_CELL);
        this.setInteger(11, this.supportsPlayTime ? 0 : -1);
        this.setText(15, EMPTY_TEXT_CELL);
        this.setText(16, EMPTY_TEXT_CELL);
        if (n == 4) {
            this.setInteger(2, 2);
        } else {
            this.setInteger(2, mediaListEntry.isAudioFile() ? 0 + n : 4 + n);
        }
        this.setHMIResourceLocator(13, new HMIResourceLocator(mediaListEntry.getCovertArt() == null ? -1 : mediaListEntry.getCovertArt().getId(), mediaListEntry.getCovertArt() == null ? ResourceLocatorModelApp.UNDEFINED_URI : mediaListEntry.getCovertArt().getUrl()));
        int n3 = 0;
        n3 |= mediaListEntry.isVideoFile() ? 1 : 0;
        this.setInteger(1, n3 |= n != 0 ? 4 : 0);
        this.setPropertyCell(14, new PropertyListCell(DataPlayerPlayViewListRow.getCategory(mediaListEntry.isAudioFile(), n, false), EMPTY_PROPERTIES));
    }

    public DataPlayerPlayViewListRow(DataPlayerPlayViewListRow dataPlayerPlayViewListRow) {
        super(dataPlayerPlayViewListRow);
        this.coverart = dataPlayerPlayViewListRow.getCoverArt();
        this.entryContentType = dataPlayerPlayViewListRow.getEntryContentType();
        this.entry = dataPlayerPlayViewListRow.getEntry();
        this.supportsPlayTime = dataPlayerPlayViewListRow.supportsPlayTime;
        this.logger = dataPlayerPlayViewListRow.logger;
    }

    private static int getCategory(boolean bl, int n, boolean bl2) {
        switch (n) {
            case 2: {
                return 418724198;
            }
            case 3: {
                return -211503700;
            }
            case 1: {
                return -454086987;
            }
        }
        if (bl2) {
            return bl ? 2114244941 : -1596414918;
        }
        return bl ? -258190656 : 890526283;
    }

    public void setTime(PlayTime playTime) {
        if (playTime == null) {
            this.setText(9, EMPTY_TEXT_CELL);
            this.setText(10, EMPTY_TEXT_CELL);
            this.setInteger(11, 0);
        } else {
            this.setText(9, playTime.getRestrictedPlayTimeStr());
            this.setText(10, playTime.getRemainTimeStr());
            this.setInteger(11, playTime.getProgress());
        }
    }

    public void setPlaying(boolean bl) {
        int n = this.getInteger(1);
        if (bl) {
            this.setInteger(1, n | 2);
            this.setPropertyCell(14, new PropertyListCell(DataPlayerPlayViewListRow.getCategory(this.isAudio(), this.getErrorState(), true), EMPTY_PROPERTIES));
            this.setInteger(18, 2);
        } else {
            this.setInteger(1, n & 0xFFFFFFFD);
            this.setPropertyCell(14, new PropertyListCell(DataPlayerPlayViewListRow.getCategory(this.isAudio(), this.getErrorState(), false), EMPTY_PROPERTIES));
            this.setText(16, EMPTY_TEXT_CELL);
            this.setText(15, EMPTY_TEXT_CELL);
        }
    }

    public void setDetailInfos(MediaDetailInfo mediaDetailInfo) {
        if (this.getEntryID() != mediaDetailInfo.getPlayingTrack().getEntryID()) {
            return;
        }
        if (null != mediaDetailInfo.getAlbum()) {
            this.setText(7, mediaDetailInfo.getAlbum().getI18NString());
            this.setInteger(8, mediaDetailInfo.getAlbum().getI18NKey());
        }
        if (null != mediaDetailInfo.getArtist()) {
            this.setText(5, mediaDetailInfo.getArtist().getI18NString());
            this.setInteger(6, mediaDetailInfo.getArtist().getI18NKey());
        }
        if (null != mediaDetailInfo.getTitle() && !mediaDetailInfo.getTitle().isEmpty()) {
            this.setText(3, mediaDetailInfo.getTitle().getI18NString());
            this.setInteger(4, mediaDetailInfo.getTitle().getI18NKey());
        }
        this.setText(15, String.valueOf(mediaDetailInfo.getNumChapters()));
        this.setText(16, String.valueOf(mediaDetailInfo.getActiveChapter() + 1));
        if (mediaDetailInfo.getNumChapters() > 0) {
            this.setInteger(1, this.getInteger(1) | 8);
        }
        if ((mediaDetailInfo.getAlbum() == null || mediaDetailInfo.getAlbum().isEmpty()) && (mediaDetailInfo.getArtist() == null || mediaDetailInfo.getArtist().isEmpty())) {
            this.setInteger(18, 1);
        } else {
            this.setInteger(18, 2);
        }
    }

    public void setCoverArt(ResourceLocator resourceLocator) {
        this.logger.log(1000000, "[%1.setCoverArt] cover: '%2'.", (Object)LOGCLASS, (Object)resourceLocator);
        this.coverart = resourceLocator;
        if (resourceLocator == null) {
            this.setHMIResourceLocator(13, new HMIResourceLocator(-1, HMIResourceLocator.UNDEFINED_URI));
        } else {
            this.setHMIResourceLocator(13, new HMIResourceLocator(resourceLocator.getId(), resourceLocator.getUrl()));
        }
    }

    public void updatePlaytimeCapabilitiy(boolean bl) {
        this.supportsPlayTime = bl;
        this.setInteger(11, this.supportsPlayTime ? 0 : -1);
    }

    public MediaListEntry getEntry() {
        return this.entry;
    }

    public I18NString getTitle() {
        return this.entry.getTitle();
    }

    public String getAlbum() {
        return I18NString.getOriginalString(this.getText(7), this.getInteger(8));
    }

    public String getArtist() {
        return I18NString.getOriginalString(this.getText(5), this.getInteger(6));
    }

    public static int getColumnSize() {
        return 21;
    }

    int getErrorState() {
        return this.getInteger(12);
    }

    public boolean isEnabled() {
        return (this.getInteger(1) & 4) != 4;
    }

    public boolean isVideo() {
        return this.entryContentType == 2;
    }

    public boolean isAudio() {
        return this.entryContentType == 1;
    }

    public ResourceLocator getCoverArt() {
        return this.coverart;
    }

    public boolean isPlaying() {
        return (this.getInteger(1) & 2) == 2;
    }

    protected int getEntryContentType() {
        return this.entryContentType;
    }

    public EvoListRow copy() {
        return new DataPlayerPlayViewListRow(this);
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("['");
        buffer.append(this.getUniqueID());
        buffer.append("','");
        buffer.append(this.getEntryID());
        buffer.append("','");
        buffer.append(this.getText(3));
        buffer.append("','");
        buffer.append(this.getInteger(4));
        buffer.append("','");
        buffer.append(this.getText(5));
        buffer.append("','");
        buffer.append(this.getInteger(6));
        buffer.append("','");
        buffer.append(this.getInteger(11));
        buffer.append("','");
        buffer.append(this.getText(9));
        buffer.append("','");
        buffer.append(this.getCell(14));
        buffer.append("','");
        buffer.append(this.getCell(16));
        buffer.append("','");
        buffer.append(this.getCell(15));
        buffer.append("','");
        buffer.append(this.getCell(12));
        buffer.append("','");
        buffer.append(this.getCell(17));
        buffer.append("','");
        buffer.append(this.getCell(18));
        buffer.append("','").append(this.getInteger(1)).append("','").append(this.getCell(13));
        buffer.append("','").append(this.getInteger(2)).append("']");
        return buffer.toString();
    }
}

