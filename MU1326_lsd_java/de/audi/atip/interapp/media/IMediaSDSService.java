/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.media;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public interface IMediaSDSService
extends AbstractSDSApplicationService {
    public static final byte BROWSE_TYPE_STRUCTURE = 1;
    public static final byte BROWSE_TYPE_ARTIST = 2;
    public static final byte BROWSE_TYPE_ALBUM = 3;
    public static final byte BROWSE_TYPE_TITLE = 4;
    public static final byte BROWSE_TYPE_PLAYLIST = 5;
    public static final byte BROWSE_TYPE_VIDEO = 6;
    public static final byte BROWSE_TYPE_IPOD_AUDIOBOOKS = 7;
    public static final byte BROWSE_TYPE_IPOD_COMPOSERS = 8;
    public static final byte BROWSE_TYPE_IPOD_PODCASTS = 9;
    public static final byte BROWSE_TYPE_GENRE = 10;
    public static final int BROWSE_TYPE_FAVORITE = 11;
    public static final byte PL_FILLING_OK = 1;
    public static final byte PL_FILLING_ERROR = 2;
    public static final byte LISTMODE_DYN_DEVICE = 0;
    public static final byte LISTMODE_ALBUM = 1;
    public static final byte LISTMODE_ARTIST = 2;
    public static final byte LISTMODE_TITLE = 3;
    public static final byte LISTMODE_GENRE = 4;
    public static final int PARTITION_INDEX_INVALID = -1;

    public void activateSource(int var1, int var2);

    public void activateSource(int var1, int var2, int var3);

    public void activateSource(int var1);

    public void setTrackNumber(int var1);

    public void folderUp();

    public void playMoreLikeThis();

    public void mix(boolean var1);

    public void repeatTrack(boolean var1);

    public void startBrowsing(int var1);

    public void playAllTracks();

    public void g2pPlayTitle(long var1);

    public void g2pPlayTitleOfAlbum(long var1, long var3);

    public void g2pPlayTitleOfArtist(long var1, long var3);

    public void g2pPlayAlbum(long var1);

    public void g2pPlayAlbumOfArtist(long var1, long var3);

    public void g2pPlayArtist(long var1);

    public void g2pPlayGenre(long var1);

    public void g2pRequestCoverarts(long[] var1, int var2);

    public byte fillPickList(SDSListEntry[] var1);

    public byte fillPickList(MediaSDSListEntry[] var1, byte var2);

    public void showPickList();

    public void hidePickList();

    public static class MediaSDSListEntry
    extends SDSListEntry {
        private final int sourceID;
        private final int slot;
        private final ResourceLocator cover;
        private final String nameSecondRow;

        public MediaSDSListEntry(String string, long l, int n) {
            this(string, l, n, null);
        }

        public MediaSDSListEntry(String string, long l, int n, int n2, int n3) {
            this(string, null, l, n, n2, n3, null);
        }

        public MediaSDSListEntry(String string, String string2, long l, int n, ResourceLocator resourceLocator) {
            this(string, string2, l, n, -1, -1, resourceLocator);
        }

        public MediaSDSListEntry(String string, long l, int n, ResourceLocator resourceLocator) {
            this(string, null, l, n, -1, -1, resourceLocator);
        }

        public MediaSDSListEntry(String string, String string2, long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
            super(string, l, n);
            this.nameSecondRow = string2;
            this.sourceID = n2;
            this.slot = n3;
            this.cover = resourceLocator;
        }

        public int getSourceID() {
            return this.sourceID;
        }

        public int getSlot() {
            return this.slot;
        }

        public ResourceLocator getCover() {
            return this.cover;
        }

        public String getNameSecondRow() {
            return this.nameSecondRow;
        }

        public String toString() {
            return new Buffer().append(super.toString()).append("{").append(this.nameSecondRow == null ? "null" : this.nameSecondRow).append('}').toString();
        }
    }
}

