/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.atip.interapp.media.IMediaSDSService$MediaSDSListEntry;
import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class MediaSDSUtils {
    private static final byte DEVICE_BT;
    private static final byte DEVICE_JUKEBOX;
    private static final byte DEVICE_CD;
    private static final byte DEVICE_CDC;
    private static final byte DEVICE_DVD;
    private static final byte DEVICE_DVDC;
    public static final byte DEVICE_IPOD;
    private static final byte DEVICE_ONLINE;
    private static final byte DEVICE_SD;
    public static final byte DEVICE_USB;
    private static final byte DEVICE_WLAN;
    private static final byte DEVICE_EXTERN_AUDIO;
    private static final byte DEVICE_EXTERN_AV;
    public static final byte FOLDER_TYPE_SONGS;
    public static final byte FOLDER_TYPE_ARTISTS;
    public static final byte FOLDER_TYPE_ALBUMS;
    public static final byte FOLDER_TYPE_GENRES;
    public static final byte FOLDER_TYPE_MOVIES;
    public static final byte FOLDER_TYPE_PLAYLISTS;
    public static final byte FOLDER_TYPE_COMPOSERS;
    public static final byte FOLDER_TYPE_PODCASTS;
    public static final byte FOLDER_TYPE_AUDIO_BOOKS;
    public static final byte FOLDER_TYPE_PLAY_MORE_LIKE_THIS;
    public static final byte FOLDER_TYPE_FAVORITE;
    public static final byte LISTMODE_NONE;
    public static final byte LISTMODE_DYN_DEVICE;
    public static final byte LISTMODE_ALBUM;
    public static final byte LISTMODE_ARTIST;
    public static final byte LISTMODE_TITLE;
    public static final byte LISTMODE_PLAY_MUSIC;
    public static final byte LISTMODE_ARTIST_ONESHOT;
    public static final byte LISTMODE_TITLE_ONESHOT;
    public static final byte LISTMODE_ALBUM_ONESHOT;
    public static final byte LISTMODE_GENRE;
    public static final byte PICKLIST_TITLE_DYN_DEVICE;
    public static final byte PICKLIST_TITLE_ALBUM;
    public static final byte PICKLIST_TITLE_ARTIST;
    public static final byte PICKLIST_TITLE_TITLE;
    public static final byte PICKLIST_TITLE_PLAY_MUSIC;
    public static final byte PICKLIST_TITLE_GENRE;
    public static final byte ILLEGAL_TYPE_CODE;
    public static final byte MEDIA_SOURCE_NBEST;
    public static final byte MEDIA_SOURCE_PICKLIST;
    public static final byte MEDIA_SOURCE_PLAYMUSIC;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_DYNAMIC;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_JUKEBOX;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_AMI;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_AUX;
    public static final byte MEDIA_G2P_ONESHOT;
    public static byte[][] oneshotListModeToDataLevel;
    private static final int[][] DEVICES_TO_SOURCES;
    private static final int[][] ACTIVATE_SOURCE_TO_EVENTS;
    private static final byte[][] LISTMODE_TO_PICKLIST_TITLE;
    private static final byte[][] LISTMODE_TO_MEDIA_MODE;

    public static boolean isOneshotListmode(int n) {
        return n == 6 || n == 5 || n == 7;
    }

    public static int getSourceIDForDevice(int n) {
        return SDSUtils.translate(n, DEVICES_TO_SOURCES);
    }

    public static int getActivationResponseEvent(int n, LogChannel logChannel) {
        int n2 = SDSUtils.translate(n, ACTIVATE_SOURCE_TO_EVENTS);
        logChannel.log(-2137614336, "MediaSDSUtils#getActivationResponseEvent: response=%1, event=%2!", (long)n, (long)n2);
        if (n2 == 128) {
            logChannel.log(-1601830656, "MediaSDSUtils#getActivationResponseEvent: Unhandled response %1, sending ERROR!", (long)n);
            n2 = 20001;
        }
        return n2;
    }

    public static IMediaSDSService$MediaSDSListEntry[] toMediaDeviceArray(IPicklistElement[] iPicklistElementArray, byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
        if (iPicklistElementArray == null) {
            return new IMediaSDSService$MediaSDSListEntry[0];
        }
        int n = iPicklistElementArray.length;
        IMediaSDSService$MediaSDSListEntry[] iMediaSDSService$MediaSDSListEntryArray = new IMediaSDSService$MediaSDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            IMediaSDSService$MediaSDSListEntry iMediaSDSService$MediaSDSListEntry;
            IPicklistSlot iPicklistSlot;
            IPicklistSlot[] iPicklistSlotArray;
            IPicklistElement iPicklistElement = iPicklistElementArray[i2];
            if (iPicklistElement == null || (iPicklistSlotArray = iPicklistElement.getSlots()) == null || iPicklistSlotArray.length == 0 || (iPicklistSlot = iPicklistSlotArray[0]) == null) continue;
            long l = iPicklistSlot.getObjID();
            ResourceLocator resourceLocator = MediaSDSUtils.getCoverart(mediaCoverartEntryArray, l);
            String string = null;
            if (iPicklistSlotArray.length > 1 && iPicklistSlotArray[1] != null) {
                string = iPicklistSlotArray[1].getText();
            }
            if (MediaSDSUtils.getMediaModeForListMode(by) == 0) {
                IMediaSDSService$MediaSDSListEntry iMediaSDSService$MediaSDSListEntry2;
                int n2 = SDSUtils.getHighNibble(l);
                int n3 = SDSUtils.getLowNibble(l);
                iMediaSDSService$MediaSDSListEntryArray[i2] = iMediaSDSService$MediaSDSListEntry2 = new IMediaSDSService$MediaSDSListEntry(iPicklistSlot.getText(), string, l, iPicklistElement.getGraphGroupSize(), n3, n2, resourceLocator);
                continue;
            }
            iMediaSDSService$MediaSDSListEntryArray[i2] = iMediaSDSService$MediaSDSListEntry = new IMediaSDSService$MediaSDSListEntry(iPicklistSlot.getText(), string, l, iPicklistElement.getGraphGroupSize(), resourceLocator);
        }
        return iMediaSDSService$MediaSDSListEntryArray;
    }

    public static IMediaSDSService$MediaSDSListEntry[] toMediaDeviceArray(IPicklistElement[] iPicklistElementArray, byte by) {
        return MediaSDSUtils.toMediaDeviceArray(iPicklistElementArray, by, null);
    }

    private static ResourceLocator getCoverart(MediaCoverartEntry[] mediaCoverartEntryArray, long l) {
        if (mediaCoverartEntryArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < mediaCoverartEntryArray.length; ++i2) {
            if (mediaCoverartEntryArray[i2].getEntryId() != l) continue;
            return mediaCoverartEntryArray[i2].getCoverart();
        }
        return null;
    }

    public static boolean isMediaDeviceMode(byte by) {
        return by == 3 || by == 4 || by == 5 || by == 6 || by == 9;
    }

    public static int getPicklistTitleForListMode(byte by) {
        return SDSUtils.translate(by, LISTMODE_TO_PICKLIST_TITLE);
    }

    public static byte getMediaModeForListMode(byte by) {
        return SDSUtils.translate(by, LISTMODE_TO_MEDIA_MODE);
    }

    static {
        oneshotListModeToDataLevel = new byte[][]{{5, 0}, {7, 1}, {6, 2}};
        DEVICES_TO_SOURCES = new int[][]{{1, 11}, {2, 6}, {3, 1}, {4, 2}, {5, 3}, {6, 4}, {7, 10}, {8, 13}, {9, 5}, {10, 10}, {11, 12}, {12, 9}, {13, 8}};
        ACTIVATE_SOURCE_TO_EVENTS = new int[][]{{0, 20000}, {1, 20008}, {2, 20001}, {16, 20000}, {9, 20001}, {4, 20003}, {3, 20003}, {14, 20003}, {5, 20009}, {6, 20008}, {10, 20005}, {12, 20002}, {13, 20005}, {8, 20002}, {11, 20005}, {17, 20005}, {18, 20003}, {19, 20003}};
        LISTMODE_TO_PICKLIST_TITLE = new byte[][]{{0, 0}, {1, 1}, {7, 1}, {2, 2}, {5, 2}, {4, 4}, {3, 3}, {6, 3}, {8, 5}};
        LISTMODE_TO_MEDIA_MODE = new byte[][]{{0, 0}, {4, 0}, {1, 1}, {7, 1}, {2, 2}, {5, 2}, {4, 0}, {3, 3}, {6, 3}, {8, 4}};
    }
}

