/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.utils.generics.GList;
import de.audi.tv.app.cas.CasIDs;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class TVUtil {
    public static final short KEYPANEL_LIST_SEPARATOR = 255;
    public static final short KEYSTATUS_RELEASE = 0;
    public static final short KEYSTATUS_PRESS = 1;
    public static final short KEYPAN_JS_IDLE = -1;
    public static final short KEYPAN_YELLOW = 1;
    public static final short KEYPAN_GREEN = 2;
    public static final short KEYPAN_RED = 3;
    public static final short KEYPAN_BLUE = 4;
    public static final short KEYPAN_BACK = 5;
    public static final short KEYPAN_ENTER = 6;
    public static final short KEYPAN_HOME = 7;
    public static final short KEYPAN_NEXT = 8;
    public static final short KEYPAN_PREVIOUS = 9;
    public static final short KEYPAN_SETUP = 10;
    public static final short KEYPAN_MENU = 11;
    public static final short KEYPAN_JOYST_NORTH = 12;
    public static final short KEYPAN_JOYST_SOUTH = 13;
    public static final short KEYPAN_JOYST_WEST = 14;
    public static final short KEYPAN_JOYST_EAST = 15;
    public static final short KEYPAN_JOYST_NORTHEAST = 16;
    public static final short KEYPAN_JOYST_NORTHWEST = 17;
    public static final short KEYPAN_JOYST_SOUTHEAST = 18;
    public static final short KEYPAN_JOYST_SOUTHWEST = 19;
    public static final short KEYPAN_NUM_1 = 20;
    public static final short KEYPAN_NUM_2 = 21;
    public static final short KEYPAN_NUM_3 = 22;
    public static final short KEYPAN_NUM_4 = 23;
    public static final short KEYPAN_NUM_5 = 24;
    public static final short KEYPAN_NUM_6 = 25;
    public static final short KEYPAN_NUM_7 = 26;
    public static final short KEYPAN_NUM_8 = 27;
    public static final short KEYPAN_NUM_9 = 28;
    public static final short KEYPAN_NUM_0 = 29;
    public static final short KEYPAN_NUM = 30;
    public static final short KEYPAN_START = 31;
    public static final short KEYPAN_STOP = 32;
    public static final short KEYPAN_MIX_ON = 33;
    public static final short KEYPAN_MIX_OFF = 34;
    public static final short KEYPAN_D = 35;
    public static final short KEYPAN_SCREEN = 36;
    public static final short KEYPAN_MODE = 37;
    public static final short KEYPAN_ZOOM_ON = 38;
    public static final short KEYPAN_ZOOM_OFF = 39;
    public static final short KEYPAN_PAGEFLIP_UP = 40;
    public static final short KEYPAN_PAGEFLIP_DOWN = 41;
    public static final short KEYPAN_PAGEFLIP_WEST = 42;
    public static final short KEYPAN_PAGEFLIP_EAST = 43;
    public static final short KEYPAN_RESET = 44;
    public static final short KEYPAN_DELETE = 45;
    public static final short KEYPAN_YES = 46;
    public static final short KEYPAN_NO = 47;
    public static final short KEYPAN_ZOOM_PLUS = 48;
    public static final short KEYPAN_ZOOM_MINUS = 49;
    public static final short[] KEYPANEL_NUMBER_CODES = new short[]{29, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    public static final int SOURCE_TV_ESM = 4;
    public static final int SOURCE_AV_ESM = 5;
    public static final int SOURCE_ESM = 6;
    public static final int SOURCE_HMI_UNKOWN = -1;
    public static final int SOURCE_HMI_TV = 0;
    public static final int SOURCE_HMI_AV = 1;
    public static final int CHANNEL_SORTING_ALPHABETICAL = 0;
    public static final int CHANNEL_SORTING_PRESORTED = 1;
    public static final int CHANNEL_SORTING_LEGAL = 2;
    public static final ResourceLocator EMPTY_RL = new ResourceLocator();
    private static IFrameworkAccess framework;
    private static int region;
    public static final int ICON_GOOD_SIGNAL = 0;
    static final int ICON_NO_AUDIO_SERVICE = 1;
    static final int ICON_MUTE_NO_SIGNAL = 2;
    static final int ICON_MUTE_LOW_SIGNAL = 3;
    static final int ICON_CAS_CARD_MISSING = 5;
    public static final int ICON_CAS_CARD_ERROR = 6;
    public static final int ICON_CAS_LOCKED = 8;

    public static void init(IFrameworkAccess iFrameworkAccess) {
        framework = iFrameworkAccess;
        region = framework.getSysConst(442);
    }

    public static boolean equalsFullPID(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null || serviceInfo2 == null) {
            return false;
        }
        return serviceInfo.namePID == serviceInfo2.namePID && serviceInfo.servicePID == serviceInfo2.servicePID && serviceInfo.sType == serviceInfo2.sType;
    }

    public static boolean equalsNamePID(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null || serviceInfo2 == null) {
            return false;
        }
        return serviceInfo.namePID == serviceInfo2.namePID;
    }

    public static int getChannelType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                if (region == 2) {
                    return 12;
                }
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
        }
        return 0;
    }

    public static boolean isChannelTypeAlwaysShowOSD(int n) {
        switch (n) {
            case 3: 
            case 4: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    public static boolean isDatabroadcastTerminalMode(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return true;
            }
        }
        return false;
    }

    public static boolean isVideoService(ServiceInfo serviceInfo) {
        switch (serviceInfo.sType) {
            case 3: 
            case 4: 
            case 6: 
            case 10: {
                return false;
            }
        }
        return true;
    }

    public static boolean doesTerminalModeShowFastMovingPictures(int n) {
        switch (n) {
            case 13: 
            case 14: {
                return false;
            }
        }
        return true;
    }

    public static boolean doesTerminalModeShowTvPictures(int n) {
        return n != 13;
    }

    public static boolean isVisualAudioService(ServiceInfo serviceInfo) {
        return serviceInfo != null && serviceInfo.sType == 6;
    }

    public static boolean isPayTV(ServiceInfo serviceInfo) {
        return serviceInfo.sType == 5;
    }

    public static int singleByteBCDToDual(int n) {
        return ((n & 0xF0) >> 4) * 10 + (n & 0xF);
    }

    public static int getCasStatus(int n) {
        int n2 = CasIDs.getIconID(n);
        int n3 = -1;
        switch (n2) {
            case 2: {
                n3 = 6;
                break;
            }
            case 3: {
                n3 = 5;
                break;
            }
            case 4: {
                n3 = 8;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        return n3;
    }

    public static int getMuteStatus(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static ProgramInfo getClonedProgramInfo(ProgramInfo programInfo) {
        ServiceInfo serviceInfo = new ServiceInfo(programInfo.serviceInfo.namePID, programInfo.serviceInfo.servicePID, programInfo.serviceInfo.name, programInfo.serviceInfo.sType, programInfo.serviceInfo.getContentGroup());
        return new ProgramInfo(serviceInfo, new String(programInfo.channelName), programInfo.normArea, programInfo.videoFormat, programInfo.availableAudioChannels, programInfo.selectedAudioChannel, programInfo.epgFlag, programInfo.teletextFlag, programInfo.variantDatabroadcastFlag, programInfo.databroadcastFlag1, programInfo.databroadcastFlag2, programInfo.bwsFlag, programInfo.slsFlag, programInfo.txtFlag, programInfo.casFlag, programInfo.visAudioFlag, programInfo.announcement, programInfo.caDescriptor, programInfo.casStatus, programInfo.parentalRating, programInfo.nowStartTime, programInfo.nowEndTime, programInfo.nowProgramInfo, programInfo.nextStartTime, programInfo.nextEndTime, programInfo.nextProgramInfo, programInfo.subtitleFlag);
    }

    public static boolean doesTunerRequireHmiEsmHandling(StartUpConfig startUpConfig) {
        return false;
    }

    public static int getInternalSourceRepresentation(int n) {
        switch (n) {
            case 0: 
            case 4: {
                return 0;
            }
            case 1: 
            case 5: {
                return 1;
            }
        }
        return -1;
    }

    public static int getTvTunerSourceRepresentation(int n, boolean bl) {
        if (bl) {
            if (n == 0) {
                return 4;
            }
            if (n == 1) {
                return 5;
            }
            throw new IllegalArgumentException("Given source can not be mapped to TV tuner source!");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        throw new IllegalArgumentException("Given source can not be mapped to TV tuner source!");
    }

    public static boolean getBoolAvailabilityForDsiServiceFlag(int n) {
        return n == 2;
    }

    public static boolean isCmmbService(ServiceInfo serviceInfo) {
        return serviceInfo.getSType() == 9 || serviceInfo.getSType() == 10;
    }

    public static <T> T lastOfOrNull(GList<T> gList) {
        if (gList.isEmpty()) {
            return null;
        }
        return gList.get(gList.size() - 1);
    }

    private TVUtil() {
        throw new IllegalAccessError("TVUtil contains only static methods!");
    }
}

