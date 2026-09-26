/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaI18NString;
import org.dsi.ifc.media.ListEntry;

public final class MediaUtilsSDIS {
    private static final MediaI18NString EMTPY_I18N_STRING = new MediaI18NString(0, "");

    public static MediaListEntry[] convertASIEntries2MediaEntries(MediaEntry[] mediaEntryArray) {
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[mediaEntryArray.length];
        for (int i2 = 0; i2 < mediaEntryArray.length; ++i2) {
            mediaListEntryArray[i2] = MediaUtilsSDIS.convertMediaEntry2MediaListEntry(mediaEntryArray[i2]);
        }
        return mediaListEntryArray;
    }

    public static MediaListEntry convertMediaEntry2MediaListEntry(MediaEntry mediaEntry) {
        return new MediaListEntry(mediaEntry.getId(), MediaUtilsSDIS.getDSIContentType(mediaEntry.getType()), mediaEntry.getTitle().getName(), mediaEntry.getTitle().getName());
    }

    public static MediaEntry[] convert2ASIMediaEntries(MediaListEntry[] mediaListEntryArray) {
        MediaEntry[] mediaEntryArray = new MediaEntry[mediaListEntryArray.length];
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            mediaEntryArray[i2] = MediaUtilsSDIS.getMediaEntryOfListEntry(mediaListEntry);
        }
        return mediaEntryArray;
    }

    public static MediaSourceSlot get2DSISourceSlot(de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot mediaSourceSlot, ISourceController iSourceController) {
        ISource iSource = iSourceController.getSource(MediaUtilsSDIS.getSourceTypeOfSDISSource(mediaSourceSlot.getSource()));
        if (null == iSource) {
            return null;
        }
        return (MediaSourceSlot)iSource.getSlot(mediaSourceSlot.getSlotIdx());
    }

    public static int getSourceTypeOfSDISSource(int n) {
        switch (n) {
            case 3: {
                return 6;
            }
            case 2: {
                return 5;
            }
            case 1: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 4: {
                return 10;
            }
        }
        throw new IllegalArgumentException();
    }

    private static MediaEntry getMediaEntryOfListEntry(MediaListEntry mediaListEntry) {
        return new MediaEntry(mediaListEntry.getEntryID(), MediaUtilsSDIS.getMediaEntryType(mediaListEntry), MediaUtilsSDIS.getMediaI18NString(mediaListEntry.getTitle().isEmpty() ? mediaListEntry.getFilename() : mediaListEntry.getTitle()), MediaUtilsSDIS.getMediaI18NString(mediaListEntry.getArtist()), (int)mediaListEntry.getArtistID(), MediaUtilsSDIS.getMediaI18NString(mediaListEntry.getAlbum()), (int)mediaListEntry.getAlbumID(), 0L, mediaListEntry.getCovertArt() != null ? mediaListEntry.getCovertArt().getUrl() : "");
    }

    private static MediaI18NString getMediaI18NString(I18NString i18NString) {
        if (i18NString == null) {
            return EMTPY_I18N_STRING;
        }
        return new MediaI18NString((byte)i18NString.getI18NKey(), i18NString.getI18NString());
    }

    private static byte getMediaEntryType(MediaListEntry mediaListEntry) {
        if ((4 & mediaListEntry.getEntryFlags()) == 4 || (8 & mediaListEntry.getEntryFlags()) == 8 || (2 & mediaListEntry.getEntryFlags()) == 2) {
            if (mediaListEntry.isOnline()) {
                if (mediaListEntry.isVideoFile()) {
                    return 14;
                }
                return 12;
            }
            if (mediaListEntry.isVideoFile()) {
                return 10;
            }
            return 0;
        }
        if (mediaListEntry.isOnline()) {
            if (mediaListEntry.isVideoFile()) {
                return 13;
            }
            return 11;
        }
        if (mediaListEntry.isAudioFile()) {
            return 1;
        }
        if (mediaListEntry.isVideoFile()) {
            return 2;
        }
        if (mediaListEntry.isPlaylist()) {
            if (mediaListEntry.isFolder()) {
                if (mediaListEntry.getContentType() == 10) {
                    return 9;
                }
                return 5;
            }
            return 3;
        }
        if (mediaListEntry.isFolder()) {
            switch (mediaListEntry.getContentType()) {
                case 7: {
                    return 17;
                }
                case 13: {
                    return 7;
                }
                case 14: {
                    return 6;
                }
                case 16: {
                    return 8;
                }
                case 15: {
                    return 18;
                }
                case 17: {
                    return 19;
                }
                case 11: {
                    return 20;
                }
                case 18: {
                    return 21;
                }
            }
            return 4;
        }
        return 0;
    }

    public static byte getMediaEntryType(int n, int n2) {
        ListEntry listEntry = new ListEntry(0L, "", "", n, 0, n2, null);
        MediaListEntry mediaListEntry = new MediaListEntry(listEntry);
        return MediaUtilsSDIS.getMediaEntryType(mediaListEntry);
    }

    private static byte getDSIContentType(int n) {
        switch (n) {
            case 17: {
                return 7;
            }
            case 1: 
            case 11: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 5;
            }
            case 6: {
                return 14;
            }
            case 7: {
                return 13;
            }
            case 8: {
                return 16;
            }
            case 9: {
                return 10;
            }
            case 5: {
                return 6;
            }
            case 18: {
                return 15;
            }
            case 19: {
                return 17;
            }
            case 20: {
                return 11;
            }
            case 21: {
                return 18;
            }
            case 4: {
                return 4;
            }
        }
        return 0;
    }
}

