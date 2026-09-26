/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSourceAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CombiBAPUtils {
    private static final IntMap FOLDERTYPEMAP = new IntMap(40);
    private static final IntMap FILETYPEMAP;
    private static final HashMap INFOSTATESTRINGMAP;
    public static final int SINGLE_SD_CARD_BAP_SLOT_INDEX;

    public static CombiBAPAudioSource getBAPSource(ISource iSource, ISourceSlot iSourceSlot) {
        int n;
        int n2;
        int n3 = CombiBAPUtils.getBAPSourceType(iSource, iSourceSlot);
        int n4 = CombiBAPUtils.getBAPMediaType(iSource, iSourceSlot);
        CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes = CombiBAPUtils.getBAPSouceAttribute(iSourceSlot);
        if (iSource.getType() == 10) {
            n2 = iSourceSlot.getDeviceIndex();
            n = MediaUtils.calculatePartitionIndex(iSourceSlot);
        } else {
            n2 = iSourceSlot.getIndex();
            n = 0;
        }
        if (iSource.getType() == 13 && iSourceSlot.isEmpty()) {
            return null;
        }
        return new CombiBAPAudioSource(n3, n2, n, n4, iSourceSlot.getName() == null ? "" : iSourceSlot.getName(), combiBAPAudioSourceAttributes);
    }

    public static int getBapSourceIndex(ISourceSlot iSourceSlot) {
        if (iSourceSlot.getSource().getType() == 10) {
            return iSourceSlot.getDeviceIndex();
        }
        if (iSourceSlot.getSource().getType() == 5 && iSourceSlot.getSource().getNumberOfSlots() == 1) {
            return -1;
        }
        return iSourceSlot.getIndex();
    }

    public static int getBAPSourceType(ISource iSource) {
        switch (iSource.getType()) {
            case 9: {
                return 13;
            }
            case 8: {
                return 9;
            }
            case 11: {
                return 22;
            }
            case 1: {
                return 7;
            }
            case 0: {
                return 6;
            }
            case 3: {
                return 18;
            }
            case 2: {
                return 8;
            }
            case 6: {
                return 20;
            }
            case 5: {
                return 11;
            }
            case 7: {
                return 9;
            }
            case 10: {
                return 19;
            }
            case 12: {
                return 27;
            }
            case 13: {
                return 34;
            }
            case 4: {
                return 255;
            }
        }
        return 0;
    }

    public static int getBAPSourceType(ISource iSource, ISourceSlot iSourceSlot) {
        switch (iSource.getType()) {
            case 10: {
                if (iSourceSlot.getMediaType() == 24) {
                    return 15;
                }
                return 19;
            }
            case 11: {
                if (iSourceSlot.getMediaType() == 19) {
                    return 21;
                }
                return 22;
            }
        }
        return CombiBAPUtils.getBAPSourceType(iSource);
    }

    public static int getMediaSourceTypeOfCombiSourceType(int n) {
        switch (n) {
            case 13: {
                return 9;
            }
            case 29: 
            case 30: {
                return -1;
            }
            case 21: 
            case 22: {
                return 11;
            }
            case 6: {
                return 0;
            }
            case 7: {
                return 1;
            }
            case 8: {
                return 2;
            }
            case 18: {
                return 3;
            }
            case 10: 
            case 20: {
                return 6;
            }
            case 11: {
                return 5;
            }
            case 9: {
                return 7;
            }
            case 15: 
            case 19: {
                return 10;
            }
            case 27: 
            case 28: {
                return 12;
            }
            case 34: {
                return 13;
            }
        }
        return -1;
    }

    private static int getBAPMediaType(ISource iSource, ISourceSlot iSourceSlot) {
        if (iSourceSlot.isEmpty()) {
            return 0;
        }
        if (iSourceSlot.isLoading() || iSourceSlot.isReloading()) {
            return 255;
        }
        switch (iSourceSlot.getContentType()) {
            case 1: {
                switch (iSource.getType()) {
                    case 10: {
                        if (iSourceSlot.getMediaType() == 24) {
                            return 12;
                        }
                        return 7;
                    }
                    case 2: 
                    case 3: {
                        return 6;
                    }
                    case 0: 
                    case 1: {
                        return 5;
                    }
                    case 11: {
                        return 9;
                    }
                }
                return 7;
            }
            case 0: {
                return 1;
            }
            case 8: {
                return 10;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 11;
            }
            case 4: 
            case 5: {
                return 8;
            }
        }
        return 0;
    }

    public static int getBAPInfoState(ActiveSourceState activeSourceState) {
        int n;
        block0 : switch (activeSourceState.getState()) {
            case 1: {
                n = 0;
                break;
            }
            case 4: {
                switch (activeSourceState.getSlot().getSource().getType()) {
                    case 5: {
                        n = 4;
                        break block0;
                    }
                    case 2: 
                    case 3: {
                        n = 3;
                        break block0;
                    }
                    case 0: 
                    case 1: {
                        n = 2;
                        break block0;
                    }
                    case 12: {
                        n = 49;
                        break block0;
                    }
                    case 9: 
                    case 10: {
                        n = 39;
                        break block0;
                    }
                }
                n = 6;
                break;
            }
            case 5: {
                n = 8;
                break;
            }
            case 6: {
                n = 11;
                break;
            }
            case 7: {
                n = 64;
                break;
            }
            case 2: 
            case 3: {
                n = 9;
                break;
            }
            case 25: {
                if (activeSourceState.getSlot().getSource().getType() == 3) {
                    n = 9;
                    break;
                }
                n = 1;
                break;
            }
            case 8: {
                n = 34;
                break;
            }
            case 24: {
                n = 60;
                break;
            }
            case 9: {
                n = 35;
                break;
            }
            case 10: {
                n = 36;
                break;
            }
            case 11: {
                n = 41;
                break;
            }
            case 12: {
                n = 42;
                break;
            }
            case 14: {
                n = 61;
                break;
            }
            case 15: {
                n = 43;
                break;
            }
            case 13: {
                n = 62;
                break;
            }
            case 16: {
                n = 46;
                break;
            }
            case 17: {
                n = 59;
                break;
            }
            case 18: {
                n = 47;
                break;
            }
            case 19: {
                n = 53;
                break;
            }
            case 22: {
                n = 51;
                break;
            }
            case 23: {
                n = 50;
                break;
            }
            case 32: {
                n = 49;
                break;
            }
            case 20: {
                n = 65;
                break;
            }
            case 21: {
                n = 66;
                break;
            }
            case 28: {
                n = 50;
                break;
            }
            case 29: {
                n = 51;
                break;
            }
            case 30: {
                n = 49;
                break;
            }
            case 31: 
            case 33: {
                n = 49;
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    private static CombiBAPAudioSourceAttributes getBAPSouceAttribute(ISourceSlot iSourceSlot) {
        CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes = new CombiBAPAudioSourceAttributes();
        if (iSourceSlot.isLoading() || iSourceSlot.isReloading()) {
            combiBAPAudioSourceAttributes.setMediaIsBeingLoaded(true);
            return combiBAPAudioSourceAttributes;
        }
        if (iSourceSlot.getError() != 0) {
            switch (iSourceSlot.getError()) {
                case 16: {
                    combiBAPAudioSourceAttributes.setMediaIsNotReadable(true);
                    break;
                }
                case 5: {
                    combiBAPAudioSourceAttributes.setMediaIsNotPlayable(true);
                    break;
                }
                case 14: {
                    combiBAPAudioSourceAttributes.reset();
                    combiBAPAudioSourceAttributes.setMediaIsBeingLoaded(true);
                    break;
                }
                case 1: 
                case 2: 
                case 11: 
                case 17: 
                case 18: 
                case 23: 
                case 24: {
                    combiBAPAudioSourceAttributes.setMediaAudioSourceError(true);
                    break;
                }
                case 20: 
                case 21: {
                    combiBAPAudioSourceAttributes.setBuiltInButNotReady(true);
                    break;
                }
                case 27: 
                case 29: {
                    if (iSourceSlot.getSource().getType() != 12 && iSourceSlot.getSource().getType() != 13) break;
                    combiBAPAudioSourceAttributes.setMediaAudioSourceError(true);
                    break;
                }
                case 19: 
                case 30: {
                    if (iSourceSlot.getSource().getType() == 12) {
                        combiBAPAudioSourceAttributes.setMediaAudioSourceError(true);
                        break;
                    }
                }
                default: {
                    combiBAPAudioSourceAttributes.setBuiltInButNotReady(true);
                }
            }
        }
        return combiBAPAudioSourceAttributes;
    }

    public static int getBAPFolderTypeOfMediaEntry(MediaListEntry mediaListEntry) {
        if (mediaListEntry.isPlaylist()) {
            return 4;
        }
        try {
            return FOLDERTYPEMAP.get(mediaListEntry.getTitle().getI18NKey());
        }
        catch (NoMapElementException noMapElementException) {
            return 1;
        }
    }

    public static int getFileStateOfMediaEntry(MediaListEntry mediaListEntry) {
        if (mediaListEntry.isFolder()) {
            if (mediaListEntry.hasEntries()) {
                return 0;
            }
            return 1;
        }
        if (mediaListEntry.isDeadLink()) {
            return 8;
        }
        if (mediaListEntry.isCorrupt()) {
            return 4;
        }
        if (mediaListEntry.isProtected()) {
            return 2;
        }
        if (mediaListEntry.isImportRunning()) {
            return 16;
        }
        if (mediaListEntry.isImportPending()) {
            return 32;
        }
        if (mediaListEntry.isNoPlaybackDuringImport()) {
            return 64;
        }
        return 0;
    }

    public static int getBAPFileTypeOfMediaEntry(MediaListEntry mediaListEntry) {
        try {
            return FILETYPEMAP.get(mediaListEntry.getTitle().getI18NKey());
        }
        catch (NoMapElementException noMapElementException) {
            if (mediaListEntry.isAudioFile()) {
                return 6;
            }
            if (mediaListEntry.isFolder()) {
                if (mediaListEntry.isPlaylist()) {
                    return 4;
                }
                return 1;
            }
            if (mediaListEntry.isPlaylist()) {
                return 3;
            }
            if (mediaListEntry.isVideoFile()) {
                return 7;
            }
            return 0;
        }
    }

    public static boolean containsInvalidCharacter(String string) {
        try {
            char c2 = string.charAt(0);
            return c2 >= '\u3000' || c2 > '\u08ff' && c2 < '\u0c00';
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static int getAbsolutePosition(long l, long l2, MediaListEntry[] mediaListEntryArray, int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            if (mediaListEntryArray[i2].getEntryID() != l || (long)mediaListEntryArray[i2].getContentType() != l2) continue;
            n2 = i2;
            break;
        }
        if (n2 == -1) {
            return 0;
        }
        return n2 + n + 1;
    }

    public static boolean isSourceEmpty(ISource iSource) {
        List list = iSource.getSlots();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
            if (iSourceSlot.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public static boolean isBluetoothBAPSourceType(int n) {
        return n == 21 || n == 22;
    }

    static String getInfoStateString(int n) {
        Object object = INFOSTATESTRINGMAP.get(Integers.valueOf(n));
        if (object == null) {
            return "STATES_ERROR_UNSPECIFIED";
        }
        return (String)object;
    }

    static {
        FOLDERTYPEMAP.put(5, 33);
        FOLDERTYPEMAP.put(2, 21);
        FOLDERTYPEMAP.put(18, 42);
        FOLDERTYPEMAP.put(16, 41);
        FOLDERTYPEMAP.put(11, 25);
        FOLDERTYPEMAP.put(26, 52);
        FOLDERTYPEMAP.put(25, 51);
        FOLDERTYPEMAP.put(27, 53);
        FOLDERTYPEMAP.put(19, 45);
        FOLDERTYPEMAP.put(20, 46);
        FOLDERTYPEMAP.put(21, 47);
        FOLDERTYPEMAP.put(22, 48);
        FOLDERTYPEMAP.put(23, 49);
        FOLDERTYPEMAP.put(24, 50);
        FOLDERTYPEMAP.put(28, 54);
        FOLDERTYPEMAP.put(8, 17);
        FOLDERTYPEMAP.put(1, 4);
        FOLDERTYPEMAP.put(17, 44);
        FOLDERTYPEMAP.put(32, 13);
        FOLDERTYPEMAP.put(33, 37);
        FOLDERTYPEMAP.put(6, 34);
        FOLDERTYPEMAP.put(7, 35);
        FOLDERTYPEMAP.put(3, 22);
        FOLDERTYPEMAP.put(4, 23);
        FOLDERTYPEMAP.put(9, 18);
        FOLDERTYPEMAP.put(10, 19);
        FOLDERTYPEMAP.put(50, 26);
        FOLDERTYPEMAP.put(51, 27);
        FOLDERTYPEMAP.put(30, 22);
        FOLDERTYPEMAP.put(35, 4);
        FOLDERTYPEMAP.put(36, 44);
        FOLDERTYPEMAP.put(13, 13);
        FOLDERTYPEMAP.put(15, 15);
        FILETYPEMAP = new IntMap(50);
        FILETYPEMAP.put(1, 4);
        FILETYPEMAP.put(35, 4);
        FILETYPEMAP.put(44, 12);
        FILETYPEMAP.put(12, 12);
        FILETYPEMAP.put(13, 13);
        FILETYPEMAP.put(15, 13);
        FILETYPEMAP.put(32, 13);
        FILETYPEMAP.put(37, 13);
        FILETYPEMAP.put(31, 13);
        FILETYPEMAP.put(34, 13);
        FILETYPEMAP.put(5, 33);
        FILETYPEMAP.put(2, 21);
        FILETYPEMAP.put(18, 42);
        FILETYPEMAP.put(16, 41);
        FILETYPEMAP.put(11, 25);
        FILETYPEMAP.put(26, 52);
        FILETYPEMAP.put(25, 51);
        FILETYPEMAP.put(27, 53);
        FILETYPEMAP.put(19, 45);
        FILETYPEMAP.put(20, 46);
        FILETYPEMAP.put(21, 47);
        FILETYPEMAP.put(22, 48);
        FILETYPEMAP.put(23, 49);
        FILETYPEMAP.put(24, 50);
        FILETYPEMAP.put(28, 54);
        FILETYPEMAP.put(8, 17);
        FILETYPEMAP.put(17, 44);
        FILETYPEMAP.put(33, 37);
        FILETYPEMAP.put(6, 34);
        FILETYPEMAP.put(7, 35);
        FILETYPEMAP.put(3, 22);
        FILETYPEMAP.put(4, 23);
        FILETYPEMAP.put(9, 18);
        FILETYPEMAP.put(10, 19);
        FILETYPEMAP.put(50, 26);
        FILETYPEMAP.put(51, 27);
        FILETYPEMAP.put(30, 22);
        FILETYPEMAP.put(36, 44);
        INFOSTATESTRINGMAP = new HashMap(40);
        INFOSTATESTRINGMAP.put(Integers.valueOf(0), "STATES_NO_ERROR");
        INFOSTATESTRINGMAP.put(Integers.valueOf(67), "STATES_HANDBOOK_VIDEO_ACTIVE");
        INFOSTATESTRINGMAP.put(Integers.valueOf(70), "STATES_FILES_BEING_USED_AS_RINGTONE_DF_4_1");
        INFOSTATESTRINGMAP.put(Integers.valueOf(9), "STATES_MEDIA_IS_BEING_LOADED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(4), "STATES_NO_SD");
        INFOSTATESTRINGMAP.put(Integers.valueOf(3), "STATES_NO_DVD");
        INFOSTATESTRINGMAP.put(Integers.valueOf(2), "STATES_NO_CD");
        INFOSTATESTRINGMAP.put(Integers.valueOf(49), "STATES_NO_WLAN_PLAYER_IN_SYSTEM");
        INFOSTATESTRINGMAP.put(Integers.valueOf(39), "STATES_NO_DEVICE_CONECTED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(6), "STATES_NO_MEDIA");
        INFOSTATESTRINGMAP.put(Integers.valueOf(8), "STATES_MEDIA_NOT_READABLE");
        INFOSTATESTRINGMAP.put(Integers.valueOf(11), "STATES_TEMPERATURE_TOO_HIGH");
        INFOSTATESTRINGMAP.put(Integers.valueOf(64), "STATES_TEMPERATURE_TOO_LOW");
        INFOSTATESTRINGMAP.put(Integers.valueOf(34), "STATES_NO_PLAYABLE_FILES");
        INFOSTATESTRINGMAP.put(Integers.valueOf(60), "STATES_JUKEBOX_IS_STILL_EMPTY");
        INFOSTATESTRINGMAP.put(Integers.valueOf(35), "STATES_WRONG_REGION_CODE_SOME_CHANGES_LEFT");
        INFOSTATESTRINGMAP.put(Integers.valueOf(36), "STATES_WRONG_REGION_CODE_NO_CHANGES_LEFT");
        INFOSTATESTRINGMAP.put(Integers.valueOf(41), "STATES_BLUETOOTH_DEACTIVATED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(42), "STATES_BLUETOOTH_OFF_DUE_TO_CLAMP_S_OFF");
        INFOSTATESTRINGMAP.put(Integers.valueOf(61), "STATES_BT_AUDIO_PLAYER_DEACTIVATED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(43), "STATES_NO_BT_AUDIO_PLAYER_CONNECTED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(62), "STATES_BT_AUTOMATIC_RECONNECT");
        INFOSTATESTRINGMAP.put(Integers.valueOf(46), "STATES_IMPORT_RUNNING");
        INFOSTATESTRINGMAP.put(Integers.valueOf(59), "STATES_JUBEBOX_IS_BEEING_DELETED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(47), "STATES_CHILDLOCK_ERROR");
        INFOSTATESTRINGMAP.put(Integers.valueOf(53), "STATES_OVERCURRENT");
        INFOSTATESTRINGMAP.put(Integers.valueOf(51), "STATES_WLAN_DEACTIVATED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(65), "STATES_EXTERNAL_DEVICE_NOT_SUPPORTED");
        INFOSTATESTRINGMAP.put(Integers.valueOf(66), "STATES_EXTERNAL_DEVICE_FIRMWARE_ERROR");
        INFOSTATESTRINGMAP.put(Integers.valueOf(50), "STATES_WLAN_S_CONTACT_MISSING");
    }
}

