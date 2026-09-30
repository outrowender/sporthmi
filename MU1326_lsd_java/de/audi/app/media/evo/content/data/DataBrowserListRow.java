/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.AbstractMediaBrowserListRow;
import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class DataBrowserListRow
extends AbstractMediaBrowserListRow {
    private static final int[] EMPTY_PROPERTIES = new int[0];
    private static final String EMPTY_TEXT = "";
    private static final int EMPTY_INTEGER = 0;
    private static final int COLUMNS = 17;
    private static final int COL_UNIQUE_ID = 0;
    private static final int COL_RECORDSET = 1;
    private static final int COL_SYMBOL = 2;
    private static final int COL_FILENAME = 3;
    private static final int COL_TITLE = 4;
    private static final int COL_TITLE_I18N_KEY = 5;
    private static final int COL_ALBUM = 6;
    private static final int COL_ALBUM_I18N_KEY = 7;
    private static final int COL_ARTIST = 8;
    private static final int COL_ARTIST_I18N_KEY = 9;
    private static final int COL_ERROR_TYPE = 10;
    private static final int COL_ENABLED = 11;
    private static final int COL_PROPERTY = 12;
    private static final int COL_COVER = 13;
    private static final int COL_LAYOUT = 14;
    private static final byte COL_DEFAULTCOVER_ID = 15;
    private static final int COL_ONLINE = 16;
    private static final int LAYOUT_ONE_LINE = 1;
    private static final int LAYOUT_TWO_LINES = 2;
    private static final int LAYOUT_DEFAULT = 3;
    private static final int RECORDSET_BIT_VALUE_FOLDER = 1;
    private static final int RECORDSET_BIT_VALUE_ERROR = 8;
    private final MediaListEntry folderMediaListEntry;
    private final MediaListEntry[] folderstack;
    private final I18NString title;
    private final MediaListEntry fileMediaListEntry;
    private static final IntMap I18NSYMBOLMAP = new IntMap(15);
    private static final IntMap CONTENTSYMBOLMAP;

    public DataBrowserListRow(MediaListEntry mediaListEntry, int n, MediaListEntry[] mediaListEntryArray, int n2) {
        super(mediaListEntry.getEntryID(), n, mediaListEntry.getContentType(), 17);
        int n3;
        this.title = n2 != 1 ? mediaListEntry.getTitle() : mediaListEntry.getFilename();
        this.folderMediaListEntry = mediaListEntry.isFolder() ? mediaListEntry : null;
        this.fileMediaListEntry = !mediaListEntry.isFolder() ? mediaListEntry : null;
        this.folderstack = mediaListEntryArray;
        this.setLong(0, mediaListEntry.getEntryID());
        this.setText(3, mediaListEntry.getFilename().getI18NString());
        this.setText(4, mediaListEntry.getTitle().getI18NString());
        this.setInteger(5, mediaListEntry.getTitle().getI18NKey());
        this.setText(6, EMPTY_TEXT);
        this.setInteger(7, 0);
        this.setText(8, EMPTY_TEXT);
        this.setInteger(9, 0);
        if (n2 == 2 || n2 == 3) {
            if (mediaListEntry.getAlbum() != null) {
                this.setText(6, mediaListEntry.getAlbum().getI18NString());
                this.setInteger(7, mediaListEntry.getAlbum().getI18NKey());
            }
            if (mediaListEntry.getArtist() != null) {
                this.setText(8, mediaListEntry.getArtist().getI18NString());
                this.setInteger(9, mediaListEntry.getArtist().getI18NKey());
            }
            if ((mediaListEntry.getAlbum() == null || mediaListEntry.getAlbum().isEmpty()) && (mediaListEntry.getArtist() == null || mediaListEntry.getArtist().isEmpty())) {
                this.setInteger(14, 1);
            } else {
                this.setInteger(14, 2);
            }
        } else {
            this.setInteger(14, 3);
        }
        this.setHMIResourceLocator(13, new HMIResourceLocator(mediaListEntry.getCovertArt() == null ? -1 : mediaListEntry.getCovertArt().getId(), mediaListEntry.getCovertArt() == null ? ResourceLocatorModelApp.UNDEFINED_URI : mediaListEntry.getCovertArt().getUrl()));
        this.setInteger(15, (int)mediaListEntry.getAlbumID());
        int n4 = mediaListEntry.isProtected() ? 1 : (mediaListEntry.isCorrupt() ? 2 : (mediaListEntry.isDeadLink() ? (mediaListEntry.isOnline() ? 5 : 3) : 0));
        this.setInteger(10, n4);
        this.setInteger(11, n4 != 0 ? 0 : 1);
        int n5 = mediaListEntry.isOnline() ? 1 : 0;
        this.setInteger(16, n5);
        int n6 = 0;
        n6 |= mediaListEntry.isFolder() ? 1 : 0;
        n6 |= n4 != 0 ? 8 : 0;
        this.setInteger(1, n6 |= n2 << 1);
        this.setInteger(2, DataBrowserListRow.getSymbolID(mediaListEntry, n4, n2 == 1));
        if ((!mediaListEntry.isFolder() || 0 == mediaListEntry.getContentType()) && null != mediaListEntryArray && mediaListEntryArray.length > 0 && mediaListEntryArray[mediaListEntryArray.length - 1].isPlaylist()) {
            n3 = 379373513;
        } else if (n4 != 0) {
            switch (n4) {
                case 2: {
                    n3 = 418724198;
                    break;
                }
                case 3: {
                    n3 = -211503700;
                    break;
                }
                case 1: {
                    n3 = -454086987;
                    break;
                }
                default: {
                    n3 = 514471534;
                    break;
                }
            }
        } else {
            n3 = !mediaListEntry.isFolder() ? (mediaListEntry.isAudioFile() ? -258190656 : 890526283) : (n2 == 1 ? (mediaListEntry.isPlaylist() ? (10 == mediaListEntry.getContentType() ? 858668755 : 1729654983) : -1440372016) : (mediaListEntry.isPlaylist() ? (10 == mediaListEntry.getContentType() || mediaListEntry.getTitle().getI18NKey() == 48 ? 858668755 : 1729654983) : 1065699435));
        }
        this.setPropertyCell(12, new PropertyListCell(n3, EMPTY_PROPERTIES));
    }

    public DataBrowserListRow(DataBrowserListRow dataBrowserListRow) {
        super(dataBrowserListRow);
        this.folderMediaListEntry = dataBrowserListRow.getFolderMediaEntry();
        this.fileMediaListEntry = dataBrowserListRow.getFileMediaEntry();
        this.title = dataBrowserListRow.getTitle();
        this.folderstack = dataBrowserListRow.getFolderStack();
    }

    static int getSymbolID(MediaListEntry mediaListEntry, int n, boolean bl) {
        if (!mediaListEntry.isFolder()) {
            if (n == 5) {
                return 2;
            }
            if (mediaListEntry.isAudioFile()) {
                return 0 + n;
            }
            if (mediaListEntry.isVideoFile()) {
                return 4 + n;
            }
            if (mediaListEntry.isPlaylist()) {
                return bl ? 8 : 50;
            }
            return 9;
        }
        if (mediaListEntry.isPlaylist()) {
            if (!bl) {
                return mediaListEntry.getTitle().getI18NKey() == 49 ? 51 : 50;
            }
            try {
                return I18NSYMBOLMAP.get(mediaListEntry.getTitle().getI18NKey());
            }
            catch (NoMapElementException noMapElementException) {
                return 30;
            }
        }
        try {
            return CONTENTSYMBOLMAP.get(mediaListEntry.getContentType());
        }
        catch (NoMapElementException noMapElementException) {
            return 10;
        }
    }

    public static int getColumnSize() {
        return 17;
    }

    public int getSymbol() {
        return this.getInteger(2);
    }

    private int getRecordSet() {
        return this.getInteger(1);
    }

    public boolean isEnabled() {
        return this.getInteger(10) == 0;
    }

    public I18NString getTitle() {
        return this.title;
    }

    public String getAlbum() {
        return I18NString.getOriginalString(this.getText(6), this.getInteger(7));
    }

    public String getArtist() {
        return I18NString.getOriginalString(this.getText(8), this.getInteger(9));
    }

    public HMIResourceLocator getCoverart() {
        return (HMIResourceLocator)this.getCell(13);
    }

    public boolean isPlayListContent() {
        return this.folderMediaListEntry != null && this.folderMediaListEntry.isPlaylist();
    }

    public boolean isFolder() {
        return (this.getRecordSet() & 1) == 1;
    }

    public MediaListEntry getFolderMediaEntry() {
        return this.folderMediaListEntry;
    }

    public MediaListEntry getFileMediaEntry() {
        return this.fileMediaListEntry;
    }

    public MediaListEntry[] getFolderStack() {
        return this.folderstack;
    }

    public boolean isVideoFile() {
        return this.getEntryContentType() == 2;
    }

    public boolean isFile() {
        return !this.isFolder();
    }

    public EvoListRow copy() {
        return new DataBrowserListRow(this);
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append("[");
        buffer.append("'").append(this.getUniqueID());
        buffer.append("','").append(this.getEntryID());
        buffer.append("','").append(this.getSymbol());
        buffer.append("','").append(this.getTitle());
        buffer.append("','").append(Integer.toBinaryString(this.getRecordSet()));
        buffer.append("','").append(this.getAlbum());
        buffer.append("','").append(this.getArtist());
        buffer.append("','").append(((PropertyListCell)this.getCell(12)).getCategory());
        buffer.append("']");
        return buffer.toString();
    }

    static {
        I18NSYMBOLMAP.put(26, 39);
        I18NSYMBOLMAP.put(25, 38);
        I18NSYMBOLMAP.put(27, 40);
        I18NSYMBOLMAP.put(19, 32);
        I18NSYMBOLMAP.put(20, 33);
        I18NSYMBOLMAP.put(21, 34);
        I18NSYMBOLMAP.put(22, 35);
        I18NSYMBOLMAP.put(23, 36);
        I18NSYMBOLMAP.put(24, 37);
        I18NSYMBOLMAP.put(28, 41);
        CONTENTSYMBOLMAP = new IntMap(15);
        CONTENTSYMBOLMAP.put(18, 25);
        CONTENTSYMBOLMAP.put(17, 20);
        CONTENTSYMBOLMAP.put(16, 18);
        CONTENTSYMBOLMAP.put(11, 27);
        CONTENTSYMBOLMAP.put(8, 23);
        CONTENTSYMBOLMAP.put(14, 15);
        CONTENTSYMBOLMAP.put(13, 13);
        CONTENTSYMBOLMAP.put(15, 17);
    }
}

