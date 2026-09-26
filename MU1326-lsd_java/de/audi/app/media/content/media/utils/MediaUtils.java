/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.utils;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaBrowserListRow;
import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import java.util.Iterator;
import java.util.List;

public class MediaUtils {
    public static final String EMPTY_STRING;
    public static final int ENABLED;
    public static final int DISABLED;
    public static final int HMI_MEDIATYPE_UNDEFINED;
    public static final int HMI_MEDIATYPE_CDAUDIO;
    public static final int HMI_MEDIATYPE_CDROM;
    public static final int HMI_MEDIATYPE_DVDAUDIO;
    public static final int HMI_MEDIATYPE_DVDVIDEO;
    public static final int HMI_MEDIATYPE_DVDROM;
    public static final int HMI_MEDIATYPE_SDCARD;
    public static final int HMI_MEDIATYPE_USB;
    public static final int HMI_MEDIATYPE_HDD;
    public static final int HMI_MEDIATYPE_FILESYSTEM;
    public static final int HMI_MEDIATYPE_REMOTEPLAYER;
    public static final int HMI_MEDIATYPE_AUX_AUDIOSTREAM;
    public static final int HMI_MEDIATYPE_AUX_VIDEOSTREAM;
    public static final int HMI_MEDIATYPE_TV;
    public static final int HMI_MEDIATYPE_AV;
    public static final int HMI_MEDIATYPE_BT_AUDIOSTREAM;
    public static final int HMI_MEDIATYPE_WLAN;
    public static final int HMI_MEDIATYPE_NAVIGATION_DATABASE;
    public static final int HMI_MEDIATYPE_SYSTEM_UPDATE;
    public static final int HMI_MEDIATYPE_IPOD;
    public static final int HMI_MEDIATYPE_ONLINE;
    public static final int HMI_SOURCEICON_UNDEFINED;
    public static final int HMI_SOURCEICON_CDDRIVE;
    public static final int HMI_SOURCEICON_CDCHANGER;
    public static final int HMI_SOURCEICON_CDCHANGER_1;
    public static final int HMI_SOURCEICON_CDCHANGER_2;
    public static final int HMI_SOURCEICON_CDCHANGER_3;
    public static final int HMI_SOURCEICON_CDCHANGER_4;
    public static final int HMI_SOURCEICON_CDCHANGER_5;
    public static final int HMI_SOURCEICON_CDCHANGER_6;
    public static final int HMI_SOURCEICON_DVDDRIVE;
    public static final int HMI_SOURCEICON_DVDCHANGER;
    public static final int HMI_SOURCEICON_DVDCHANGER_1;
    public static final int HMI_SOURCEICON_DVDCHANGER_2;
    public static final int HMI_SOURCEICON_DVDCHANGER_3;
    public static final int HMI_SOURCEICON_DVDCHANGER_4;
    public static final int HMI_SOURCEICON_DVDCHANGER_5;
    public static final int HMI_SOURCEICON_DVDCHANGER_6;
    public static final int HMI_SOURCEICON_SDCARD;
    public static final int HMI_SOURCEICON_SDCARD_1;
    public static final int HMI_SOURCEICON_SDCARD_2;
    public static final int HMI_SOURCEICON_HDD;
    public static final int HMI_SOURCEICON_USB;
    public static final int HMI_SOURCEICON_USB_1;
    public static final int HMI_SOURCEICON_USB_11;
    public static final int HMI_SOURCEICON_USB_12;
    public static final int HMI_SOURCEICON_USB_13;
    public static final int HMI_SOURCEICON_USB_14;
    public static final int HMI_SOURCEICON_USB_2;
    public static final int HMI_SOURCEICON_USB_21;
    public static final int HMI_SOURCEICON_USB_22;
    public static final int HMI_SOURCEICON_USB_23;
    public static final int HMI_SOURCEICON_USB_24;
    public static final int HMI_SOURCEICON_IPOD;
    public static final int HMI_SOURCEICON_IPOD_1;
    public static final int HMI_SOURCEICON_IPOD_2;
    public static final int HMI_SOURCEICON_BT;
    public static final int HMI_SOURCEICON_RCP;
    public static final int HMI_SOURCEICON_WLAN;
    public static final int HMI_SOURCEICON_AUX_AUDIO;
    public static final int HMI_SOURCEICON_AUX_VIDEO;
    public static final int HMI_SOURCEICON_TVTUNER;
    public static final int HMI_SOURCEICON_AVIN;
    public static final int HMI_SOURCEICON_FILEPLAYER;
    public static final int HMI_SOURCEICON_ONLINEPLAYER;
    private static final IntMap MEDIATYPEMAP;
    private static final IntMap HMISOURCEICONMAP;
    public static final byte UPDATE_NOT_RELEVANT;
    public static final byte UPDATE_NOBROWSER_TO_RAWBROWSER;
    public static final byte UPDATE_NOBROWSER_TO_CONTENTBROWSER;
    public static final byte UPDATE_RAWBROWSER_TO_CONTENTBROWSER;
    public static final int HMI_ONLINE_ENTRY_POINT_UNDEFINED;

    public static boolean isSameFolder(MediaListEntry[] mediaListEntryArray, MediaListEntry[] mediaListEntryArray2) {
        if (mediaListEntryArray == mediaListEntryArray2) {
            return true;
        }
        if (mediaListEntryArray2 == null || mediaListEntryArray == null) {
            return false;
        }
        if (mediaListEntryArray.length != mediaListEntryArray2.length) {
            return false;
        }
        for (int i2 = mediaListEntryArray.length - 1; i2 >= 0; --i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            MediaListEntry mediaListEntry2 = mediaListEntryArray2[i2];
            if (MediaUtils.removeEntryIdFlags(mediaListEntry.getEntryID()) != MediaUtils.removeEntryIdFlags(mediaListEntry2.getEntryID())) {
                return false;
            }
            if (mediaListEntry.getContentType() == mediaListEntry2.getContentType()) continue;
            return false;
        }
        return true;
    }

    public static MediaListEntry[] getParentFolderStack(MediaListEntry[] mediaListEntryArray, int n) {
        if (mediaListEntryArray.length < n) {
            throw new IllegalArgumentException();
        }
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length - n];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray2.length);
        return mediaListEntryArray2;
    }

    public static MediaListEntry[] appendToFolderStack(MediaListEntry[] mediaListEntryArray, MediaListEntry mediaListEntry) {
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length + 1];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray.length);
        mediaListEntryArray2[mediaListEntryArray2.length - 1] = mediaListEntry;
        return mediaListEntryArray2;
    }

    public static int getHMIMediaType(int n) {
        try {
            return MEDIATYPEMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return 0;
        }
    }

    public static boolean isDefaultSyncSource(int n) {
        return n == 6 || n == 5 || n == 10;
    }

    public static boolean isSlotEnabledInHMISourceList(ISourceSlot iSourceSlot) {
        boolean bl;
        boolean bl2 = bl = iSourceSlot.getSource().isActivateable(iSourceSlot) || iSourceSlot.isLoading() || iSourceSlot.isReloading();
        if (!bl) {
            switch (iSourceSlot.getSource().getType()) {
                case 2: 
                case 3: {
                    return iSourceSlot.getError() == 3;
                }
                case 11: {
                    return iSourceSlot.getError() == 12 || iSourceSlot.getError() == 10 || iSourceSlot.getError() == 11 || iSourceSlot.getError() == 14;
                }
                case 12: {
                    boolean bl3 = iSourceSlot.getError() == 21 || iSourceSlot.getError() == 29 || iSourceSlot.getError() == 30 || iSourceSlot.getState() == 0;
                    return bl3;
                }
                case 13: {
                    return iSourceSlot.getError() == 26 || iSourceSlot.getError() == 27 || iSourceSlot.getError() == 28;
                }
            }
        }
        return bl;
    }

    public static boolean isSourceEnabled(int n) {
        switch (n) {
            case 12: {
                return true;
            }
        }
        return false;
    }

    public static boolean isPlaylistFolder(MediaListEntry[] mediaListEntryArray) {
        for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            if (!mediaListEntryArray[i2].isPlaylist()) continue;
            return true;
        }
        return false;
    }

    public static final int getHMISourceIcon(ISourceSlot iSourceSlot) {
        int n = iSourceSlot.getSource().getType() == 10 ? (iSourceSlot.getMediaType() == 24 ? MediaUtils.getIPodHMIIcon(iSourceSlot.getDeviceIndex()) : MediaUtils.getUSBHMIIcon(iSourceSlot)) : MediaUtils.getHMISourceIcon(iSourceSlot.getSource().getType(), iSourceSlot.getIndex(), iSourceSlot.getDeviceIndex(), iSourceSlot.getMediaType());
        return n;
    }

    private static int resolveSDIcon(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 18;
                break;
            }
            case 1: {
                n2 = 19;
                break;
            }
            default: {
                n2 = 17;
            }
        }
        return n2;
    }

    private static int resolveDVDChangerIcon(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 11;
                break;
            }
            case 1: {
                n2 = 12;
                break;
            }
            case 2: {
                n2 = 13;
                break;
            }
            case 3: {
                n2 = 14;
                break;
            }
            case 4: {
                n2 = 15;
                break;
            }
            case 5: {
                n2 = 16;
                break;
            }
            default: {
                n2 = 10;
            }
        }
        return n2;
    }

    private static int resolveCDChangerIcon(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            case 3: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            case 5: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 2;
            }
        }
        return n2;
    }

    private static int resolveAUXIcon(int n) {
        int n2;
        switch (n) {
            case 14: {
                n2 = 38;
                break;
            }
            case 13: {
                n2 = 36;
                break;
            }
            default: {
                n2 = 38;
            }
        }
        return n2;
    }

    private static int resolveUSBIcon(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 22;
                break;
            }
            case 1: {
                n2 = 27;
                break;
            }
            default: {
                n2 = 21;
            }
        }
        return n2;
    }

    public static final int getHMISourceIcon(int n, int n2, int n3, int n4) {
        int n5;
        switch (n) {
            case 5: {
                n5 = MediaUtils.resolveSDIcon(n2);
                break;
            }
            case 3: {
                n5 = MediaUtils.resolveDVDChangerIcon(n2);
                break;
            }
            case 1: {
                n5 = MediaUtils.resolveCDChangerIcon(n2);
                break;
            }
            case 9: {
                n5 = MediaUtils.resolveAUXIcon(n4);
                break;
            }
            case 10: {
                if (n4 == 24) {
                    n5 = MediaUtils.getIPodHMIIcon(n3);
                    break;
                }
                n5 = MediaUtils.resolveUSBIcon(n3);
                break;
            }
            default: {
                try {
                    n5 = HMISOURCEICONMAP.get(n);
                    break;
                }
                catch (NoMapElementException noMapElementException) {
                    return 0;
                }
            }
        }
        return n5;
    }

    public static int getUSBHMIIcon(ISourceSlot iSourceSlot) {
        int n;
        if (iSourceSlot.getSource().isEmpty()) {
            n = 21;
        } else {
            int n2 = MediaUtils.calculatePartitionIndex(iSourceSlot);
            block0 : switch (iSourceSlot.getDeviceIndex()) {
                case 0: {
                    switch (n2) {
                        case 0: {
                            n = 22;
                            break block0;
                        }
                        case 1: {
                            n = 23;
                            break block0;
                        }
                        case 2: {
                            n = 24;
                            break block0;
                        }
                    }
                    n = 22;
                    break;
                }
                case 1: {
                    switch (n2) {
                        case 0: {
                            n = 27;
                            break block0;
                        }
                        case 1: {
                            n = 28;
                            break block0;
                        }
                        case 2: {
                            n = 29;
                            break block0;
                        }
                    }
                    n = 27;
                    break;
                }
                default: {
                    n = 21;
                }
            }
        }
        return n;
    }

    public static int calculatePartitionIndex(ISourceSlot iSourceSlot) {
        if (iSourceSlot.getSource().getType() != 10) {
            return 0;
        }
        List list = iSourceSlot.getSource().getSlots();
        int n = 0;
        int n2 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ISourceSlot iSourceSlot2 = (ISourceSlot)iterator.next();
            if (iSourceSlot2.getDeviceIndex() != iSourceSlot.getDeviceIndex()) continue;
            if (!iSourceSlot2.isEmpty()) {
                ++n;
            }
            if (iSourceSlot2.getIndex() != iSourceSlot.getIndex()) continue;
            n2 = n;
        }
        if (n > 1 && !iSourceSlot.isEmpty()) {
            return n2;
        }
        return 0;
    }

    public static int getIPodHMIIcon(int n) {
        switch (n) {
            case 0: {
                return 33;
            }
            case 1: {
                return 34;
            }
        }
        return 32;
    }

    public static final boolean isFileContentType(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    public static final boolean isFolderContentType(int n) {
        switch (n) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: {
                return true;
            }
        }
        return false;
    }

    public static String getTerminalIDToStr(int n) {
        switch (n) {
            case 0: {
                return "MAIN";
            }
            case 3: {
                return "RLEFT";
            }
            case 4: {
                return "RRIGHT";
            }
            case -1: {
                return "ALL";
            }
        }
        return new StringBuffer().append("UNKNOWN(").append(n).append(")").toString();
    }

    public static final String getPlayViewClientIDToStr(int n) {
        switch (n) {
            case 3: {
                return "COMBI";
            }
            case 4: {
                return "COMBI_FS";
            }
            case 1: {
                return "MAIN";
            }
            case 2: {
                return "MAIN_FS";
            }
            case 5: {
                return "SDIS";
            }
        }
        return String.valueOf(n);
    }

    public static final boolean isInternalSource(int n) {
        return n == 4;
    }

    public static final int[] integerListToIntArray(List list) {
        int[] nArray = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            nArray[i2] = (Integer)list.get(i2);
        }
        return nArray;
    }

    public static AbstractMediaBrowserListRow findEntryID(List list, long l, int n) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractMediaBrowserListRow abstractMediaBrowserListRow = (AbstractMediaBrowserListRow)iterator.next();
            if (null == abstractMediaBrowserListRow || abstractMediaBrowserListRow.getEntryID() != l || abstractMediaBrowserListRow.getEntryContentType() != n) continue;
            return abstractMediaBrowserListRow;
        }
        return null;
    }

    public static byte getUpgradeTypeBrowser(MediaCapabilities mediaCapabilities, MediaCapabilities mediaCapabilities2) {
        if ((null == mediaCapabilities || !mediaCapabilities.isRawBrowsing()) && mediaCapabilities2.isContentBrowsing()) {
            return 2;
        }
        if ((null == mediaCapabilities || !mediaCapabilities.isRawBrowsing()) && mediaCapabilities2.isRawBrowsing()) {
            return 1;
        }
        if (null != mediaCapabilities && mediaCapabilities.isRawBrowsing() && !mediaCapabilities.isContentBrowsing() && mediaCapabilities2.isContentBrowsing()) {
            return 3;
        }
        return 0;
    }

    public static long removeEntryIdFlags(long l) {
        return l & 0x1FFFFFFFFFFFFFFFL;
    }

    public static String removeFileExtension(String string) {
        if (null == string) {
            return "";
        }
        int n = string.lastIndexOf(46);
        return n > 0 ? string.substring(0, n) : string;
    }

    public static MediaListEntry getLastEntryInStack(MediaListEntry[] mediaListEntryArray) {
        return null != mediaListEntryArray && mediaListEntryArray.length > 0 ? mediaListEntryArray[mediaListEntryArray.length - 1] : null;
    }

    public static void showPopup(int n, IMediaTerminal iMediaTerminal) {
        iMediaTerminal.getFramework().getHmiServiceApp().showPartialPopup(0, n);
    }

    static {
        MEDIATYPEMAP = new IntMap(25);
        MEDIATYPEMAP.put(14, 11);
        MEDIATYPEMAP.put(17, 14);
        MEDIATYPEMAP.put(15, 12);
        MEDIATYPEMAP.put(19, 15);
        MEDIATYPEMAP.put(2, 2);
        MEDIATYPEMAP.put(1, 1);
        MEDIATYPEMAP.put(7, 5);
        MEDIATYPEMAP.put(5, 3);
        MEDIATYPEMAP.put(6, 4);
        MEDIATYPEMAP.put(12, 9);
        MEDIATYPEMAP.put(11, 8);
        MEDIATYPEMAP.put(13, 10);
        MEDIATYPEMAP.put(9, 6);
        MEDIATYPEMAP.put(10, 7);
        MEDIATYPEMAP.put(16, 13);
        MEDIATYPEMAP.put(23, 16);
        MEDIATYPEMAP.put(21, 17);
        MEDIATYPEMAP.put(22, 18);
        MEDIATYPEMAP.put(24, 19);
        MEDIATYPEMAP.put(25, 20);
        HMISOURCEICONMAP = new IntMap(15);
        HMISOURCEICONMAP.put(7, 40);
        HMISOURCEICONMAP.put(8, 41);
        HMISOURCEICONMAP.put(6, 20);
        HMISOURCEICONMAP.put(2, 9);
        HMISOURCEICONMAP.put(0, 1);
        HMISOURCEICONMAP.put(11, 35);
        HMISOURCEICONMAP.put(12, 37);
        HMISOURCEICONMAP.put(13, 43);
        HMISOURCEICONMAP.put(4, 42);
    }
}

