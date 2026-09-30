/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.media.MediaCoverartEntry;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class MediaSDSUtils {
    private static final byte DEVICE_BT = 1;
    private static final byte DEVICE_JUKEBOX = 2;
    private static final byte DEVICE_CD = 3;
    private static final byte DEVICE_CDC = 4;
    private static final byte DEVICE_DVD = 5;
    private static final byte DEVICE_DVDC = 6;
    public static final byte DEVICE_IPOD = 7;
    private static final byte DEVICE_ONLINE = 8;
    private static final byte DEVICE_SD = 9;
    public static final byte DEVICE_USB = 10;
    private static final byte DEVICE_WLAN = 11;
    private static final byte DEVICE_EXTERN_AUDIO = 12;
    private static final byte DEVICE_EXTERN_AV = 13;
    public static final byte FOLDER_TYPE_SONGS = 0;
    public static final byte FOLDER_TYPE_ARTISTS = 1;
    public static final byte FOLDER_TYPE_ALBUMS = 2;
    public static final byte FOLDER_TYPE_GENRES = 3;
    public static final byte FOLDER_TYPE_MOVIES = 4;
    public static final byte FOLDER_TYPE_PLAYLISTS = 5;
    public static final byte FOLDER_TYPE_COMPOSERS = 12;
    public static final byte FOLDER_TYPE_PODCASTS = 13;
    public static final byte FOLDER_TYPE_AUDIO_BOOKS = 14;
    public static final byte FOLDER_TYPE_PLAY_MORE_LIKE_THIS = 17;
    public static final byte FOLDER_TYPE_FAVORITE = 18;
    public static final byte LISTMODE_NONE = -1;
    public static final byte LISTMODE_DYN_DEVICE = 0;
    public static final byte LISTMODE_ALBUM = 1;
    public static final byte LISTMODE_ARTIST = 2;
    public static final byte LISTMODE_TITLE = 3;
    public static final byte LISTMODE_PLAY_MUSIC = 4;
    public static final byte LISTMODE_ARTIST_ONESHOT = 5;
    public static final byte LISTMODE_TITLE_ONESHOT = 6;
    public static final byte LISTMODE_ALBUM_ONESHOT = 7;
    public static final byte LISTMODE_GENRE = 8;
    public static final byte PICKLIST_TITLE_DYN_DEVICE = 0;
    public static final byte PICKLIST_TITLE_ALBUM = 1;
    public static final byte PICKLIST_TITLE_ARTIST = 2;
    public static final byte PICKLIST_TITLE_TITLE = 3;
    public static final byte PICKLIST_TITLE_PLAY_MUSIC = 4;
    public static final byte PICKLIST_TITLE_GENRE = 5;
    public static final byte ILLEGAL_TYPE_CODE = -10;
    public static final byte MEDIA_SOURCE_NBEST = 0;
    public static final byte MEDIA_SOURCE_PICKLIST = 1;
    public static final byte MEDIA_SOURCE_PLAYMUSIC = 2;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_DYNAMIC = 0;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_JUKEBOX = 1;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_AMI = 2;
    public static final byte PLAY_MUSIC_SELECTED_SOURCE_TYPE_AUX = 3;
    public static final byte MEDIA_G2P_ONESHOT = 0;
    public static byte[][] oneshotListModeToDataLevel = new byte[][]{{5, 0}, {7, 1}, {6, 2}};
    private static final int[][] DEVICES_TO_SOURCES = new int[][]{{1, 11}, {2, 6}, {3, 1}, {4, 2}, {5, 3}, {6, 4}, {7, 10}, {8, 13}, {9, 5}, {10, 10}, {11, 12}, {12, 9}, {13, 8}};
    private static final int[][] ACTIVATE_SOURCE_TO_EVENTS = new int[][]{{0, 20000}, {1, 20008}, {2, 20001}, {16, 20000}, {9, 20001}, {4, 20003}, {3, 20003}, {14, 20003}, {5, 20009}, {6, 20008}, {10, 20005}, {12, 20002}, {13, 20005}, {8, 20002}, {11, 20005}, {17, 20005}, {18, 20003}, {19, 20003}};
    private static final byte[][] LISTMODE_TO_PICKLIST_TITLE = new byte[][]{{0, 0}, {1, 1}, {7, 1}, {2, 2}, {5, 2}, {4, 4}, {3, 3}, {6, 3}, {8, 5}};
    private static final byte[][] LISTMODE_TO_MEDIA_MODE = new byte[][]{{0, 0}, {4, 0}, {1, 1}, {7, 1}, {2, 2}, {5, 2}, {4, 0}, {3, 3}, {6, 3}, {8, 4}};

    public static boolean isOneshotListmode(int n) {
        return n == 6 || n == 5 || n == 7;
    }

    public static int getSourceIDForDevice(int n) {
        return SDSUtils.translate(n, DEVICES_TO_SOURCES);
    }

    public static int getActivationResponseEvent(int n, LogChannel logChannel) {
        int n2 = SDSUtils.translate(n, ACTIVATE_SOURCE_TO_EVENTS);
        logChannel.log(10000000, "MediaSDSUtils#getActivationResponseEvent: response=%1, event=%2!", (long)n, (long)n2);
        if (n2 == Integer.MIN_VALUE) {
            logChannel.log(100000, "MediaSDSUtils#getActivationResponseEvent: Unhandled response %1, sending ERROR!", (long)n);
            n2 = 20001;
        }
        return n2;
    }

    public static IMediaSDSService.MediaSDSListEntry[] toMediaDeviceArray(IPicklistElement[] iPicklistElementArray, byte by, MediaCoverartEntry[] mediaCoverartEntryArray) {
        if (iPicklistElementArray == null) {
            return new IMediaSDSService.MediaSDSListEntry[0];
        }
        int n = iPicklistElementArray.length;
        IMediaSDSService.MediaSDSListEntry[] mediaSDSListEntryArray = new IMediaSDSService.MediaSDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            IMediaSDSService.MediaSDSListEntry mediaSDSListEntry;
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
                IMediaSDSService.MediaSDSListEntry mediaSDSListEntry2;
                int n2 = SDSUtils.getHighNibble(l);
                int n3 = SDSUtils.getLowNibble(l);
                mediaSDSListEntryArray[i2] = mediaSDSListEntry2 = new IMediaSDSService.MediaSDSListEntry(iPicklistSlot.getText(), string, l, iPicklistElement.getGraphGroupSize(), n3, n2, resourceLocator);
                continue;
            }
            mediaSDSListEntryArray[i2] = mediaSDSListEntry = new IMediaSDSService.MediaSDSListEntry(iPicklistSlot.getText(), string, l, iPicklistElement.getGraphGroupSize(), resourceLocator);
        }
        return mediaSDSListEntryArray;
    }

    public static IMediaSDSService.MediaSDSListEntry[] toMediaDeviceArray(IPicklistElement[] iPicklistElementArray, byte by) {
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
}

