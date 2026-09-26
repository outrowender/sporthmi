/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.logger;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.MediaInfo;
import org.dsi.ifc.media.PlaybackMode;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public class LogUtil {
    static final int[] DSIMEDIAFLAGBITS = new int[]{4096, 0x800000, 16, 32, 1024, 1, 1024, 2048, 256, 512, 8, 512, 64, 128, 8192, 16384, 4096, 128, 1, 16384, 2};
    static final String[] DSIMEDIAFLAGBITSTRS = new String[]{"COPY_PROTECTED", "FIRMWARE_NOT_SUPPORTED", "IMPORT_RUNNING", "INVALID_REGIOCODE", "NO_CONTENT", "NO_PLAYABLE_FILES", "PASS_COVERART", "PASS_EXT_META_DATA", "PASS_FILESYSTEM", "PASS_META_DATA", "PASS_ALL", "PLAYBACK", "PML_BLOCKED", "PML_RESTRICTED", "READ_ONLY", "READY_FOR_RECORDER", "DELETION_RUNNING", "READY_FOR_COVERFLOW", "CORRUPTED_PARTITION", "LAST_PLAYSELECTION_VALID", "CHARGING"};
    static final int[] DSIDEVICEFLAGBITS = new int[]{1, 4, 2, 64, 16, 8, 32};
    static final String[] DSIDEVICEFLAGBITSTRS = new String[]{"COOPERATIVE", "ERROR", "EXCLUSIVE", "OVERCURRENT", "OVERTEMP", "UNAVAILABLE", "UNDERTEMP"};
    static final String[] SOURCETYPESTR = new String[]{"CD", "CDC", "DVD", "DVDC", "FILEPLAYER", "SDCARD", "HDD", "TV", "AVIN", "AMI", "USB", "BLUETOOTH", "WLAN", "ONLINE"};
    private static final HashMap mediaTypeStringMap = new HashMap(25);
    private static final HashMap slotErrorStringMap;

    private static String listEntryToString(ListEntry listEntry) {
        Buffer buffer = new Buffer(200);
        buffer.append("[ListEntry: '").append(listEntry.entryID);
        buffer.append("','").append(listEntry.contentType);
        buffer.append("','").append(listEntry.flags);
        buffer.append("','").append(listEntry.filename);
        buffer.append("','").append(listEntry.title).append("'");
        if (listEntry.getExtInfo() != null) {
            buffer.append("[");
            buffer.append("'").append(listEntry.getExtInfo().getTitleID());
            buffer.append("','").append(listEntry.getExtInfo().getAlbum());
            buffer.append("','").append(listEntry.getExtInfo().getAlbumID());
            buffer.append("','").append(listEntry.getExtInfo().getArtist());
            buffer.append("','").append(listEntry.getExtInfo().getArtistID());
            buffer.append("','").append(listEntry.getExtInfo().getCoverArtResource()).append("']");
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static void logEntryList(String string, LogChannel logChannel, ListEntry[] listEntryArray) {
        if (!logChannel.isDebug()) {
            return;
        }
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            ListEntry listEntry = listEntryArray[i2];
            Buffer buffer = new Buffer(200);
            buffer.append(string);
            buffer.append(" [");
            buffer.append(i2);
            buffer.append("] ").append(LogUtil.listEntryToString(listEntry));
            logChannel.log(-2137614336, "%1", (Object)buffer);
        }
        if (listEntryArray.length == 0) {
            logChannel.log(-2137614336, "%1 No entries in list.", (Object)string);
        }
    }

    public static String listEntryToStr(ListEntry[] listEntryArray) {
        if (null == listEntryArray) {
            return "null";
        }
        Buffer buffer = new Buffer(200);
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            ListEntry listEntry = listEntryArray[i2];
            buffer.append(LogUtil.listEntryToString(listEntry));
        }
        return buffer.toString();
    }

    public static String listEntryToStr(MediaListEntry[] mediaListEntryArray) {
        if (null == mediaListEntryArray) {
            return "null";
        }
        Buffer buffer = new Buffer(200);
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            buffer.append(mediaListEntry);
        }
        return buffer.toString();
    }

    public static void logSearchList(LogChannel logChannel, SearchListEntry[] searchListEntryArray) {
        if (logChannel.getCurrentLogThreshold() != 14808325) {
            return;
        }
        for (int i2 = 0; i2 < searchListEntryArray.length; ++i2) {
            SearchListEntry searchListEntry = searchListEntryArray[i2];
            Buffer buffer = new Buffer(200);
            buffer.append("SearchListEntry[").append(i2).append(", ");
            buffer.append("searchid='").append(searchListEntry.getSearchID()).append("', ");
            buffer.append("description='").append(searchListEntry.getDescription()).append("', ");
            buffer.append("tagType='").append(searchListEntry.getTagType()).append("']");
            logChannel.log(14808325, "%1", (Object)buffer);
        }
    }

    public static void logSearchExtList(LogChannel logChannel, SearchListEntryExt[] searchListEntryExtArray) {
        if (logChannel.getCurrentLogThreshold() != 14808325) {
            return;
        }
        for (int i2 = 0; i2 < searchListEntryExtArray.length; ++i2) {
            SearchListEntryExt searchListEntryExt = searchListEntryExtArray[i2];
            Buffer buffer = new Buffer(200);
            buffer.append("SearchListEntryExt[");
            buffer.append("SearchID='").append(searchListEntryExt.getSearchID()).append("', ");
            buffer.append("EntryID='").append(searchListEntryExt.getEntryID()).append("', ");
            buffer.append("ArtistID='").append(searchListEntryExt.getArtistID()).append("', ");
            buffer.append("Artist='").append(searchListEntryExt.getArtist()).append("', ");
            buffer.append("AlbumID='").append(searchListEntryExt.getAlbumID()).append("', ");
            buffer.append("Album='").append(searchListEntryExt.getAlbum()).append("'");
            buffer.append("]");
            logChannel.log(14808325, "%1", (Object)buffer);
        }
    }

    public static String deviceInfoToStr(DeviceInfo deviceInfo) {
        String string;
        Buffer buffer = new Buffer();
        int n = deviceInfo.getDeviceType();
        switch (n) {
            case 8: {
                string = "AUX";
                break;
            }
            case 10: {
                string = "BT";
                break;
            }
            case 5: {
                string = "CDC";
                break;
            }
            case 4: {
                string = "CD";
                break;
            }
            case 6: {
                string = "DVDC";
                break;
            }
            case 3: {
                string = "DVD";
                break;
            }
            case 12: {
                string = "FILEPLAYER";
                break;
            }
            case 0: {
                string = "JUKEBOX";
                break;
            }
            case 1: {
                string = "SD";
                break;
            }
            case 2: {
                string = "USB";
                break;
            }
            case 9: {
                string = "WLAN";
                break;
            }
            case 99: {
                string = "ONLINEPLAYER";
                break;
            }
            case 13: {
                string = "BDINT";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        buffer.append("deviceID='").append(deviceInfo.deviceID);
        buffer.append("',type='").append(string);
        buffer.append("',slots='").append(deviceInfo.numSlots);
        buffer.append("',flags='").append(LogUtil.getBitString(deviceInfo.getFlags(), DSIDEVICEFLAGBITS, DSIDEVICEFLAGBITSTRS));
        buffer.append("'");
        return buffer.toString();
    }

    static String resolveMediaType(int n) {
        Object object = mediaTypeStringMap.get(Integers.valueOf(n));
        if (object == null) {
            return String.valueOf(n);
        }
        return (String)object;
    }

    public static String mediaInfoToStr(MediaInfo mediaInfo) {
        String string = LogUtil.resolveMediaType(mediaInfo.mediaType);
        Buffer buffer = new Buffer(200);
        buffer.append("deviceID='").append(mediaInfo.deviceID);
        buffer.append("',mediaID='").append(mediaInfo.mediaID);
        buffer.append("',name='").append(mediaInfo.name);
        buffer.append("',type='").append(string);
        buffer.append("',flags='").append(LogUtil.getBitString(mediaInfo.flags, DSIMEDIAFLAGBITS, DSIMEDIAFLAGBITSTRS));
        buffer.append("',uID='").append(mediaInfo.uniqueMediaID);
        buffer.append("',mountPoint='").append(mediaInfo.mountPoint);
        buffer.append("',[").append(mediaInfo.getMediaCaps());
        buffer.append("]");
        return buffer.toString();
    }

    public static String getListEntryContentTypeStr(int n) {
        switch (n) {
            case 1: {
                return "AUDIO";
            }
            case 3: {
                return "IMAGE";
            }
            case 2: {
                return "VIDEO";
            }
        }
        return String.valueOf(n);
    }

    public static String getPlaybackStateStr(int n) {
        switch (n) {
            case 12: {
                return "MENU SELECT";
            }
            case 2: {
                return "NOT READY TO PLAY";
            }
            case 5: {
                return "PAUSED";
            }
            case 3: {
                return "PLAYING";
            }
            case 10: {
                return "PLAYING MENU";
            }
            case 1: {
                return "READY TO PLAY";
            }
            case 9: {
                return "FASTBW";
            }
            case 8: {
                return "FASTFW";
            }
            case 7: {
                return "SLOWBW";
            }
            case 6: {
                return "SLOWFW";
            }
            case 4: {
                return "STOPPED";
            }
            case 11: {
                return "STOPPED WITH ERROR";
            }
            case 0: {
                return "INVALID";
            }
        }
        return String.valueOf(n);
    }

    public static final String getNameOfPlaybackScope(int n) {
        switch (n) {
            case 2: {
                return "DEVICE";
            }
            case 1: {
                return "FILE";
            }
            case 3: {
                return "MEDIUM";
            }
            case 6: {
                return "SELECTION";
            }
        }
        return new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
    }

    public static void logPlaybackModeList(LogChannel logChannel, String string, PlaybackMode[] playbackModeArray) {
        if (!logChannel.isInfo()) {
            return;
        }
        for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
            PlaybackMode playbackMode = playbackModeArray[i2];
            Buffer buffer = new Buffer();
            boolean bl = (playbackMode.getModeFlag() & 2) == 2;
            boolean bl2 = (playbackMode.getModeFlag() & 1) == 1;
            buffer.append("modeID='").append(playbackMode.getModeID()).append("',scope='").append(LogUtil.getNameOfPlaybackScope(playbackMode.getScope())).append("',mix='").append(bl).append("',repeat='").append(bl2).append("'");
            logChannel.log(1078071040, "%1 %2", (Object)string, (Object)buffer);
        }
    }

    private static String getBitString(int n, int[] nArray, String[] stringArray) {
        Buffer buffer = new Buffer(50);
        try {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if ((n & nArray[i2]) != nArray[i2]) continue;
                if (buffer.length() > 0) {
                    buffer.append(",");
                }
                buffer.append(stringArray[i2]);
            }
        }
        catch (Exception exception) {
            buffer.append("INVALID CONVERSION");
        }
        return buffer.toString();
    }

    public static String getSourceTypeStr(int n) {
        try {
            return SOURCETYPESTR[n];
        }
        catch (Exception exception) {
            return new StringBuffer().append("UNKNOWN (").append(n).append(")").toString();
        }
    }

    public static String getContentTypeStr(int n) {
        switch (n) {
            case 5: {
                return "AUX AUDIO";
            }
            case 6: {
                return "AUX VIDEO";
            }
            case 4: {
                return "AV";
            }
            case 0: {
                return "CDDA";
            }
            case 1: {
                return "DATA";
            }
            case 2: {
                return "DVDV";
            }
            case 3: {
                return "TV";
            }
            case 7: {
                return "FILEPLAYER";
            }
            case 8: {
                return "ONLINE";
            }
        }
        return "UNDEFINED";
    }

    public static final String getISourceSlotErrorStr(int n) {
        Object object = slotErrorStringMap.get(Integers.valueOf(n));
        if (object == null) {
            return new StringBuffer().append("UNKNOWN (").append(n).append(")").toString();
        }
        return (String)object;
    }

    public static String getBrowserCategoryString(int n) {
        switch (n) {
            case 1: {
                return "CATEGORY_PHYSICAL";
            }
            case 2: {
                return "CATEGORY_TITLES";
            }
            case 3: {
                return "CATEGORY_ALBUMS";
            }
            case 4: {
                return "CATEGORY_ARTISTS";
            }
            case 5: {
                return "CATEGORY_GENRES";
            }
            case 6: {
                return "CATEGORY_PLAYLISTS";
            }
            case 7: {
                return "CATEGORY_VIDEOS";
            }
            case 8: {
                return "CATEGORY_PODCASTS";
            }
            case 9: {
                return "CATEGORY_AUDIOBOOKS";
            }
            case 10: {
                return "CATEGORY_COMPOSERS";
            }
            case 11: {
                return "CATEGORY_FAVORITES";
            }
            case 12: {
                return "CATEGORY_RADIO";
            }
        }
        return new StringBuffer().append("CATEGORY_UNDEFINED").append(n).toString();
    }

    static {
        mediaTypeStringMap.put(Integers.valueOf(13), "RELOAD");
        mediaTypeStringMap.put(Integers.valueOf(1), "CDAUDIO");
        mediaTypeStringMap.put(Integers.valueOf(5), "CDROM");
        mediaTypeStringMap.put(Integers.valueOf(2), "DVDAUDIO");
        mediaTypeStringMap.put(Integers.valueOf(6), "DVDROM");
        mediaTypeStringMap.put(Integers.valueOf(3), "DVDVIDEO");
        mediaTypeStringMap.put(Integers.valueOf(10), "EMPTY");
        mediaTypeStringMap.put(Integers.valueOf(18), "FILEPLAYER");
        mediaTypeStringMap.put(Integers.valueOf(7), "FILESYSTEM");
        mediaTypeStringMap.put(Integers.valueOf(12), "LOADING");
        mediaTypeStringMap.put(Integers.valueOf(19), "NAVDB");
        mediaTypeStringMap.put(Integers.valueOf(8), "RAW");
        mediaTypeStringMap.put(Integers.valueOf(9), "RCP");
        mediaTypeStringMap.put(Integers.valueOf(0), "UNKNOWN");
        mediaTypeStringMap.put(Integers.valueOf(11), "UNREADABLE");
        mediaTypeStringMap.put(Integers.valueOf(15), "UNSUPPORTED");
        mediaTypeStringMap.put(Integers.valueOf(17), "UPDATE");
        mediaTypeStringMap.put(Integers.valueOf(21), "BLUERAY");
        mediaTypeStringMap.put(Integers.valueOf(20), "IPOD");
        mediaTypeStringMap.put(Integers.valueOf(99), "ONLINEPLAYER");
        slotErrorStringMap = new HashMap(35);
        slotErrorStringMap.put(Integers.valueOf(10), "ERR_BT_AUDIOPLAYER_DEACTIVATED");
        slotErrorStringMap.put(Integers.valueOf(11), "ERR_BT_AUDIOPLAYER_NOT_CONNECTED");
        slotErrorStringMap.put(Integers.valueOf(12), "ERR_BT_DEACTIVATED");
        slotErrorStringMap.put(Integers.valueOf(13), "ERR_BT_DEACTIVATED_CLAMP_S_OFF");
        slotErrorStringMap.put(Integers.valueOf(14), "ERR_BT_RECONNECTING");
        slotErrorStringMap.put(Integers.valueOf(3), "ERR_CHILDLOCK");
        slotErrorStringMap.put(Integers.valueOf(6), "ERR_DELETION_RUNNING");
        slotErrorStringMap.put(Integers.valueOf(15), "ERR_DEVICE_UNAVAILABLE");
        slotErrorStringMap.put(Integers.valueOf(19), "ERR_EMPTY");
        slotErrorStringMap.put(Integers.valueOf(4), "ERR_IMPORT_RUNNING");
        slotErrorStringMap.put(Integers.valueOf(5), "ERR_NO_PLAYABLE_FILES");
        slotErrorStringMap.put(Integers.valueOf(0), "ERR_NONE");
        slotErrorStringMap.put(Integers.valueOf(7), "ERR_OVERCURRENT");
        slotErrorStringMap.put(Integers.valueOf(8), "ERR_TEMPERATURE_TOO_HIGH");
        slotErrorStringMap.put(Integers.valueOf(9), "ERR_TEMPERATURE_TOO_LOW");
        slotErrorStringMap.put(Integers.valueOf(16), "ERR_UNREADABLE");
        slotErrorStringMap.put(Integers.valueOf(20), "ERR_WLAN_DEACTIVATED_CLAMP_S_OFF");
        slotErrorStringMap.put(Integers.valueOf(21), "ERR_WLAN_DEACTIVATED");
        slotErrorStringMap.put(Integers.valueOf(29), "ERR_WLAN_NO_DEVICE");
        slotErrorStringMap.put(Integers.valueOf(30), "ERR_WLAN_NO_APP");
        slotErrorStringMap.put(Integers.valueOf(1), "ERR_WRONG_REGION_CODE_NO_CHANGES_LEFT");
        slotErrorStringMap.put(Integers.valueOf(2), "ERR_WRONG_REGION_CODE_CHANGES_LEFT");
        slotErrorStringMap.put(Integers.valueOf(18), "ERR_UNSUPPORTED_WRONG_FIRMWARE");
        slotErrorStringMap.put(Integers.valueOf(17), "ERR_UNSUPPORTED");
        slotErrorStringMap.put(Integers.valueOf(22), "ERR_JUKEBOX_NOT_FILLED");
        slotErrorStringMap.put(Integers.valueOf(23), "ERR_CORRUPTED_PARTITION");
        slotErrorStringMap.put(Integers.valueOf(25), "ERR_ONLINE_DEACTIVATED_CLAMP_S_OFF");
        slotErrorStringMap.put(Integers.valueOf(27), "ERR_ONLINE_DEACTIVATED_WLAN_NO_CONN");
        slotErrorStringMap.put(Integers.valueOf(26), "ERR_ONLINE_DEACTIVATED_WLAN_OFF");
        slotErrorStringMap.put(Integers.valueOf(28), "ERR_ONLINE_NO_APP");
    }
}

