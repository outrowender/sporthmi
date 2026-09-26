/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.persistence.IMediaPersistence;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSlot;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.MediaListSourceStateDiffer;
import de.audi.app.media.source.state.providers.MediaListSourceStateProvider$1;
import de.audi.app.media.source.state.providers.MediaListSourceStateProvider$2;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class MediaListSourceStateProvider
implements IMediaDeviceListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IDiagnosisManager diagnosisManager;
    private final MediaListSourceStateDiffer sourceStateUpdater;
    private final IMediaPersistence mediaPersistence;
    private volatile List[] deviceList = new ArrayList[14];
    private volatile MediaInfo[] currentMediaList;
    private boolean wasDeviceErrors = false;
    private boolean initialDeviceListReceived;
    private boolean simulatedMediaListUpdateRequired;

    public MediaListSourceStateProvider(LogChannel logChannel, ISourceStateUpdater iSourceStateUpdater, IMediaPersistence iMediaPersistence, IDiagnosisManager iDiagnosisManager) {
        this.logger = logChannel;
        this.diagnosisManager = iDiagnosisManager;
        this.mediaPersistence = iMediaPersistence;
        this.sourceStateUpdater = new MediaListSourceStateDiffer(logChannel, iSourceStateUpdater);
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaListSourceStateProvider");
        this.diagnosisManager.addDataProvider(-1, new MediaListSourceStateProvider$1(this));
        this.diagnosisManager.addDataProvider(-1, new MediaListSourceStateProvider$2(this));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaListSourceStateProvider");
        this.currentMediaList = null;
        for (int i2 = 0; i2 < 14; ++i2) {
            if (this.deviceList[i2] == null) continue;
            this.deviceList[i2].clear();
            this.deviceList[i2] = null;
        }
    }

    @Override
    public void updateDeviceList(DeviceInfo[] deviceInfoArray) {
        int n;
        Object object;
        this.logger.log(1078071040, "[%1.updateDeviceList]", (Object)"MediaListSourceStateProvider");
        this.initialDeviceListReceived = true;
        ArrayList[] arrayListArray = new ArrayList[14];
        boolean bl = false;
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            object = deviceInfoArray[i2];
            n = MediaListSourceStateProvider.getSourceTypeOfDeviceType(((DeviceInfo)object).getDeviceType());
            if (arrayListArray[n] == null) {
                arrayListArray[n] = new ArrayList(2);
            }
            arrayListArray[n].add(object);
            bl = bl | MediaListSourceStateProvider.isFlag(((DeviceInfo)object).getFlags(), 4) | MediaListSourceStateProvider.isFlag(((DeviceInfo)object).getFlags(), 64) | MediaListSourceStateProvider.isFlag(((DeviceInfo)object).getFlags(), 16) | MediaListSourceStateProvider.isFlag(((DeviceInfo)object).getFlags(), 8) | MediaListSourceStateProvider.isFlag(((DeviceInfo)object).getFlags(), 32);
        }
        this.deviceList = arrayListArray;
        HashMap hashMap = new HashMap();
        object = new HashMap();
        for (n = 0; n < arrayListArray.length; ++n) {
            ArrayList arrayList = arrayListArray[n];
            Boolean bl2 = arrayList == null || arrayList.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
            hashMap.put(Integers.valueOf(n), bl2);
            int n2 = 0;
            if (bl2.booleanValue()) {
                for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                    n2 += ((DeviceInfo)arrayList.get((int)i3)).numSlots;
                }
            }
            object.put(Integers.valueOf(n), Integers.valueOf(n2));
        }
        this.sourceStateUpdater.updateSourceAvailability(hashMap);
        this.sourceStateUpdater.updateNumberOfSlots((Map)object);
        if (this.currentMediaList != null && (bl || this.wasDeviceErrors || this.simulatedMediaListUpdateRequired)) {
            this.simulatedMediaListUpdateRequired = false;
            if (bl) {
                this.logger.log(-2137614336, "[%1.updateDeviceList] Device errors detected. Update internal slot infos.", (Object)"MediaListSourceStateProvider");
            } else {
                this.logger.log(-2137614336, "[%1.updateDeviceList] Available device errors cleared. Update internal slot infos.", (Object)"MediaListSourceStateProvider");
            }
            this.updateMediaList(this.currentMediaList);
        }
        this.wasDeviceErrors = bl;
    }

    private static int getSourceTypeOfDeviceType(int n) {
        switch (n) {
            case 4: {
                return 0;
            }
            case 5: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 6: {
                return 3;
            }
            case 0: {
                return 6;
            }
            case 1: {
                return 5;
            }
            case 2: {
                return 10;
            }
            case 8: {
                return 9;
            }
            case 10: {
                return 11;
            }
            case 9: {
                return 12;
            }
            case 13: {
                return 2;
            }
            case 12: {
                return 4;
            }
            case 14: 
            case 99: {
                return 13;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Not supported device type ").append(n).append(".").toString());
    }

    private DeviceInfo getDeviceInfo(int n, long l) {
        List list = this.deviceList[n];
        if (list == null) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            DeviceInfo deviceInfo = (DeviceInfo)list.get(i2);
            if (deviceInfo.getDeviceID() != l) continue;
            return deviceInfo;
        }
        return null;
    }

    private int getSourceTypeOfDeviceID(long l) {
        for (int i2 = 0; i2 < 14; ++i2) {
            List list = this.deviceList[i2];
            if (list == null) continue;
            for (int i3 = 0; i3 < list.size(); ++i3) {
                DeviceInfo deviceInfo = (DeviceInfo)list.get(i3);
                if (deviceInfo.getDeviceID() != l) continue;
                return i2;
            }
        }
        return -1;
    }

    private static boolean isFlag(int n, int n2) {
        return (n & n2) == n2;
    }

    @Override
    public void updateMediaList(MediaInfo[] mediaInfoArray) {
        this.logger.log(1078071040, "[%1.updateMediaList]", (Object)"MediaListSourceStateProvider");
        HashMap hashMap = new HashMap(14);
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            MediaSlot mediaSlot;
            int n;
            MediaCapabilities mediaCapabilities;
            MediaInfo mediaInfo = mediaInfoArray[i2];
            long l = mediaInfo.getDeviceID();
            int n2 = this.getSourceTypeOfDeviceID(l);
            if (n2 < 0) {
                this.logger.log(1078071040, "[%1.updateMediaList] No source for deviceID '%2'.", (Object)"MediaListSourceStateProvider", l);
                continue;
            }
            int n3 = this.getDeviceIndex(n2, l);
            ArrayList arrayList = (ArrayList)hashMap.get(Integers.valueOf(n2));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Integers.valueOf(n2), arrayList);
            }
            long l2 = mediaInfo.getMediaID();
            int n4 = mediaInfo.getFlags();
            boolean bl = MediaListSourceStateProvider.isFlag(n4, 1024);
            boolean bl2 = !MediaListSourceStateProvider.isFlag(n4, 1);
            boolean bl3 = MediaListSourceStateProvider.isFlag(n4, 64);
            boolean bl4 = MediaListSourceStateProvider.isFlag(n4, 32);
            boolean bl5 = MediaListSourceStateProvider.isFlag(n4, 256);
            boolean bl6 = MediaListSourceStateProvider.isFlag(n4, 512);
            boolean bl7 = MediaListSourceStateProvider.isFlag(n4, 2048);
            boolean bl8 = MediaListSourceStateProvider.isFlag(n4, 1024);
            boolean bl9 = MediaListSourceStateProvider.isFlag(n4, 8);
            boolean bl10 = MediaListSourceStateProvider.isFlag(n4, 16);
            boolean bl11 = MediaListSourceStateProvider.isFlag(n4, 4096);
            boolean bl12 = MediaListSourceStateProvider.isFlag(n4, 8192);
            boolean bl13 = MediaListSourceStateProvider.isFlag(n4, 0x800000);
            boolean bl14 = MediaListSourceStateProvider.isFlag(n4, 1);
            boolean bl15 = MediaListSourceStateProvider.isFlag(n4, 16384);
            boolean bl16 = MediaListSourceStateProvider.isFlag(n4, 128);
            boolean bl17 = MediaListSourceStateProvider.isFlag(n4, 2);
            boolean bl18 = MediaListSourceStateProvider.isFlag(n4, 4);
            MediaFlags mediaFlags = new MediaFlags(bl9, bl5, bl6, bl7, bl8, bl10, bl12, bl16, bl15, bl18);
            if (mediaInfo.getMediaCaps() != null) {
                boolean bl19 = mediaInfo.getMediaCaps().isPlayerCoverArt();
                boolean bl20 = mediaInfo.getMediaCaps().isBrowserCoverArt();
                mediaCapabilities = new MediaCapabilities(bl19, bl20, mediaInfo.getMediaCaps().isVideoSupport(), mediaInfo.getMediaCaps().isPlaybackModes(), mediaInfo.getMediaCaps().isSearchEntries(), mediaInfo.getMediaCaps().isContentBrowser(), mediaInfo.getMediaCaps().isRawBrowser(), mediaInfo.getMediaCaps().isImportData());
            } else {
                mediaCapabilities = MediaCapabilities.EMPTY_CAPABILITIES;
            }
            String string = mediaInfo.getName();
            if (string != null && ((string = string.trim()).startsWith("medium.") || string.length() == 0 || string.startsWith("filterCriteria.unknownAlbum"))) {
                string = null;
            }
            String string2 = mediaInfo.getMountPoint();
            DeviceInfo deviceInfo = this.getDeviceInfo(n2, l);
            if (deviceInfo != null) {
                n = MediaListSourceStateProvider.isFlag(deviceInfo.getFlags(), 64) ? 7 : (MediaListSourceStateProvider.isFlag(deviceInfo.getFlags(), 16) ? 8 : (MediaListSourceStateProvider.isFlag(deviceInfo.getFlags(), 32) ? 9 : (MediaListSourceStateProvider.isFlag(deviceInfo.getFlags(), 8) ? 15 : (bl17 ? 24 : 0))));
            } else {
                this.logger.log(-1601830656, "[%1.updateMediaList] No device info for source '%2' and deviceID '%3'.", (Object)"MediaListSourceStateProvider", (long)n2, l);
                n = 0;
            }
            int n5 = arrayList.size();
            switch (mediaInfo.getMediaType()) {
                case 10: {
                    mediaSlot = new MediaSlot(0, n5, 0, l, l2, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 19 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 12: {
                    mediaSlot = new MediaSlot(1, n5, 0, l, l2, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 0 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 13: {
                    mediaSlot = new MediaSlot(2, n5, 0, l, l2, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 0 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 15: {
                    int n6 = n == 0 ? (bl13 ? 18 : 17) : n;
                    mediaSlot = new MediaSlot(3, n5, 0, l, l2, string, string2, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n6, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 0: {
                    if (n2 == 10) {
                        mediaSlot = new MediaSlot(0, n5, 0, l, l2, null, null, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 19 : n, n3, mediaInfo.getUniqueMediaID());
                        break;
                    }
                    mediaSlot = new MediaSlot(3, n5, 0, l, l2, string, string2, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 16 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 11: {
                    mediaSlot = new MediaSlot(3, n5, 0, l, l2, string, string2, MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n == 0 ? 16 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 1: {
                    mediaSlot = new MediaSlot(3, n5, 1, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(1, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 2: {
                    mediaSlot = new MediaSlot(3, n5, 5, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(5, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 3: {
                    mediaSlot = new MediaSlot(3, n5, 6, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(6, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 8: {
                    if (deviceInfo == null) {
                        mediaSlot = new MediaSlot(3, n5, 0, l, l2, null, null, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(0, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                        break;
                    }
                    if (deviceInfo.deviceType == 8) {
                        mediaSlot = new MediaSlot(3, n5, 14, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(14, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                        break;
                    }
                    if (deviceInfo.deviceType == 10) {
                        mediaSlot = new MediaSlot(3, n5, 19, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(19, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                        break;
                    }
                    mediaSlot = new MediaSlot(3, n5, 0, l, l2, null, null, mediaFlags, mediaCapabilities, n == 0 ? 16 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 5: {
                    mediaSlot = new MediaSlot(3, n5, 2, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(2, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 6: {
                    mediaSlot = new MediaSlot(3, n5, 7, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(7, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 9: {
                    int n7;
                    switch (n2) {
                        case 12: {
                            n7 = 23;
                            break;
                        }
                        default: {
                            n7 = 13;
                        }
                    }
                    mediaSlot = new MediaSlot(3, n5, n7, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(n7, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 7: {
                    int n7;
                    switch (n2) {
                        case 6: {
                            n7 = 11;
                            break;
                        }
                        case 5: {
                            n7 = 9;
                            break;
                        }
                        case 10: {
                            n7 = 10;
                            break;
                        }
                        case 0: 
                        case 1: {
                            n7 = 2;
                            break;
                        }
                        case 2: 
                        case 3: {
                            n7 = 7;
                            break;
                        }
                        case 12: {
                            n7 = 23;
                            break;
                        }
                        default: {
                            n7 = 12;
                        }
                    }
                    mediaSlot = new MediaSlot(3, n5, n7, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(n7, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 19: {
                    mediaSlot = new MediaSlot(3, n5, 21, l, l2, "", string2, mediaFlags, mediaCapabilities, n == 0 ? 5 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 17: {
                    mediaSlot = new MediaSlot(3, n5, 22, l, l2, "", string2, mediaFlags, mediaCapabilities, n == 0 ? 5 : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 18: {
                    mediaSlot = new MediaSlot(3, n5, 20, l, l2, string, string2, mediaFlags, mediaCapabilities, n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 21: {
                    mediaSlot = new MediaSlot(3, n5, 20, l, l2, string, string2, mediaFlags, mediaCapabilities, n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 20: {
                    mediaSlot = new MediaSlot(3, n5, 24, l, l2, string, string2, mediaFlags, mediaCapabilities, n == 0 ? this.getLoadedSlotErrors(24, bl, bl2, bl5, bl4, bl3, bl11, bl10, bl14) : n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                case 14: 
                case 99: {
                    mediaSlot = new MediaSlot(3, n5, 25, l, l2, string, string2, mediaFlags, mediaCapabilities, n, n3, mediaInfo.getUniqueMediaID());
                    break;
                }
                default: {
                    this.logger.log(-1601830656, "[%1.updateMediaList] Unsupported media type '%2'. Mark slot as empty. ", (Object)"MediaListSourceStateProvider", (long)mediaInfo.getMediaType());
                    mediaSlot = new MediaSlot(0, n5, 0, l, l2, string, string2, mediaFlags, mediaCapabilities, n, n3, mediaInfo.getUniqueMediaID());
                }
            }
            arrayList.add(mediaSlot);
        }
        this.currentMediaList = mediaInfoArray;
        if (!this.initialDeviceListReceived) {
            this.simulatedMediaListUpdateRequired = true;
        }
        this.sourceStateUpdater.updateSourceSlots(hashMap);
    }

    private int getLoadedSlotErrors(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        if (bl8) {
            return 23;
        }
        if (bl) {
            if (n == 11) {
                return 22;
            }
            return 5;
        }
        if (bl6) {
            return 6;
        }
        if (bl4) {
            if (this.mediaPersistence.getGlobalIntProperty("GLOBAL_KEY_DVDV_REGIONCODE_CHANGES_LEFT") > 0) {
                return 2;
            }
            return 1;
        }
        if (bl5) {
            return 3;
        }
        if (!bl2 && bl3) {
            return 5;
        }
        if ((n == 2 || n == 7) && bl7) {
            return 4;
        }
        return 0;
    }

    private int getDeviceIndex(int n, long l) {
        List list = this.deviceList[n];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            DeviceInfo deviceInfo = (DeviceInfo)list.get(i2);
            if (deviceInfo.getDeviceID() != l) continue;
            return i2;
        }
        return 0;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("MediaListSourceStateProvider").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ List[] access$000(MediaListSourceStateProvider mediaListSourceStateProvider) {
        return mediaListSourceStateProvider.deviceList;
    }

    static /* synthetic */ MediaInfo[] access$100(MediaListSourceStateProvider mediaListSourceStateProvider) {
        return mediaListSourceStateProvider.currentMediaList;
    }
}

