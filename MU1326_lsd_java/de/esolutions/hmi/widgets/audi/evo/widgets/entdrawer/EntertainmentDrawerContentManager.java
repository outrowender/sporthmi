/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.entdrawer;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.esolutions.hmi.widgets.audi.base.IDrawerManager;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class EntertainmentDrawerContentManager
implements WidgetConstants {
    private static final int ID_REBASE = 1000;
    private static final int RET_IDX_CONTENT = 0;
    private static final int RET_IDX_PRIO_POS = 1;
    private static final int NO_RET_IDX = 2;
    public static final int CONTENT_IDX_RADIO = 0;
    public static final int CONTENT_IDX_TA = 1;
    public static final int CONTENT_IDX_SDS = 2;
    public static final int CONTENT_IDX_NAVI = 3;
    public static final int CONTENT_IDX_PHONE = 4;
    public static final int CONTENT_IDX_APS = 5;
    public static final int CONTENT_IDX_MEDIA = 6;
    public static final int CONTENT_IDX_TV = 7;
    public static final int CONTENT_IDX_SDS_ADB = 8;
    public static final int CONTENT_IDX_SDS_MEDIA = 9;
    public static final int CONTENT_IDX_SDS_MESSAGING = 10;
    public static final int CONTENT_IDX_SDS_NAVI_ASIA_CNTW = 11;
    public static final int CONTENT_IDX_SDS_NAVI = 12;
    public static final int CONTENT_IDX_SDS_NAVI_POI_ONLINE = 13;
    public static final int CONTENT_IDX_SDS_PHONE = 14;
    public static final int CONTENT_IDX_SDS_RHMI = 15;
    public static final int CONTENT_IDX_SDS_TUNER = 16;
    public static final int CONTENT_IDX_SDS_NAVI_ASIA_JP = 17;
    public static final int CONTENT_IDX_SDS_NAVI_ASIA_KR = 18;
    public static final int CONTENT_IDX_SDIS = 19;
    public static final int CONTENT_IDX_TERMINAL_MODE = 20;
    public static final int CONTENT_IDX_TERMINAL_MODE_PHONE = 21;
    public static final int CONTENT_ID_TUNER = 1001;
    public static final int CONTENT_ID_TA = 2001;
    public static final int CONTENT_ID_SDS = 3001;
    public static final int CONTENT_ID_NAVI = 4001;
    public static final int CONTENT_ID_PHONE_NO_CALL = 5001;
    public static final int CONTENT_ID_PHONE_ACTIVE_CALL = 5002;
    public static final int CONTENT_ID_PHONE_INCOMING_CALL = 5003;
    public static final int CONTENT_ID_APS = 6001;
    public static final int CONTENT_ID_APS_REDUCED = 6002;
    public static final int CONTENT_ID_MEDIA = 7001;
    public static final int CONTENT_ID_TV = 8001;
    public static final int CONTENT_ID_SDS_ADB = 9001;
    public static final int CONTENT_ID_SDS_MEDIA = 10001;
    public static final int CONTENT_ID_SDS_MESSAGING = 11001;
    public static final int CONTENT_ID_SDS_NAVI_ASIA_CNTW = 12001;
    public static final int CONTENT_ID_SDS_NAVI = 13001;
    public static final int CONTENT_ID_SDS_NAVI_POI_ONLINE = 14001;
    public static final int CONTENT_ID_SDS_PHONE = 15001;
    public static final int CONTENT_ID_SDS_RHMI = 16001;
    public static final int CONTENT_ID_SDS_TUNER = 17001;
    public static final int CONTENT_ID_SDS_NAVI_ASIA_JP = 18001;
    public static final int CONTENT_ID_SDS_NAVI_ASIA_KR = 19001;
    public static final int CONTENT_ID_SDIS = 20001;
    public static final int CONTENT_ID_TERMINAL_MODE = 21001;
    public static final int CONTENT_ID_TERMINAL_MODE_PHONE = 22001;
    public static final int CONTENT_ID_DEFAULT_AUDIO_SOURCE = 9999;
    private static final int[] PRIO_2_CONTENT_LUT = new int[]{5, 21, 4, 2, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 3, 1, 19, 6, 0, 7, 20, -1};
    public static final AudioDrawerContext.Source[] AUDIO_CONTENT_TO_SOURCES_LUT = new AudioDrawerContext.Source[]{AudioDrawerContext.SOURCE_RADIO, AudioDrawerContext.SOURCE_TA, AudioDrawerContext.SOURCE_SDS_MAIN, AudioDrawerContext.SOURCE_NAVI, AudioDrawerContext.SOURCE_PHONE, AudioDrawerContext.SOURCE_MEDIA, AudioDrawerContext.SOURCE_APS, AudioDrawerContext.SOURCE_TV, AudioDrawerContext.SOURCE_SDS_ADB, AudioDrawerContext.SOURCE_SDS_MEDIA, AudioDrawerContext.SOURCE_SDS_MESSAGING, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_CNTW, AudioDrawerContext.SOURCE_SDS_NAVI, AudioDrawerContext.SOURCE_SDS_NAVI_POI_ONLINE, AudioDrawerContext.SOURCE_SDS_PHONE, AudioDrawerContext.SOURCE_SDS_RHMI, AudioDrawerContext.SOURCE_SDS_TUNER, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_JP, AudioDrawerContext.SOURCE_SDS_NAVI_ASIA_KR, AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_TERMINAL_MODE, AudioDrawerContext.SOURCE_TERMINAL_MODE_PHONE, AudioDrawerContext.SOURCE_NONE};
    private static int prevValue = -1;

    private static int computeContentID(int[] nArray, int[] nArray2) {
        int n = -1;
        if (nArray != null && nArray.length > 0 && nArray2 != null && nArray2.length == 2 && nArray2[1] < nArray.length) {
            int n2 = nArray2[0] + 1;
            int n3 = nArray[nArray2[1]];
            n = n2 * 1000 + n3;
        }
        return n;
    }

    private static int getContentIDForAppReq(int[] nArray, IDrawerManager iDrawerManager) {
        int[] nArray2 = null;
        int n = -1;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 0) continue;
            n2 = i2;
            break;
        }
        nArray2 = new int[]{PRIO_2_CONTENT_LUT[n2], n2};
        n = EntertainmentDrawerContentManager.computeContentID(nArray, nArray2);
        return n;
    }

    private static int filterOutNaviConnection(int n, int[] nArray) {
        prevValue = nArray[15] != 0 && n == -1 ? prevValue : n;
        return prevValue;
    }

    public static int getContentIDForAppReq(TiledListModelGUI tiledListModelGUI, IDrawerManager iDrawerManager) {
        GuiListRow guiListRow;
        int n = -1;
        if (tiledListModelGUI != null && tiledListModelGUI.getLength() > 0 && iDrawerManager != null && (guiListRow = tiledListModelGUI.getGuiRow(0)) != null && guiListRow.getColumnCount() >= 22) {
            int[] nArray = new int[22];
            boolean bl = true;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                try {
                    nArray[i2] = guiListRow.getInteger(i2);
                    continue;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    bl = false;
                    break;
                }
            }
            n = bl ? EntertainmentDrawerContentManager.getContentIDForAppReq(nArray, iDrawerManager) : n;
            n = EntertainmentDrawerContentManager.filterOutNaviConnection(n, nArray);
        }
        return n;
    }

    public static int getContentIDForAppReq(ListModelGUI listModelGUI, IDrawerManager iDrawerManager) {
        int n = -1;
        if (listModelGUI != null && listModelGUI.getLength() > 0 && iDrawerManager != null && listModelGUI.getMaxColumns() >= 22) {
            int[] nArray = new int[22];
            boolean bl = true;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                try {
                    nArray[i2] = ((IntegerListCell)listModelGUI.getCell(0, i2)).getValue();
                    continue;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    bl = false;
                    break;
                }
            }
            n = bl ? EntertainmentDrawerContentManager.getContentIDForAppReq(nArray, iDrawerManager) : n;
            n = EntertainmentDrawerContentManager.filterOutNaviConnection(n, nArray);
        }
        return n;
    }

    public static boolean isDefaultAudioSource(int n) {
        return n == 9999;
    }

    public static boolean isMediaAudioSource(int n) {
        return n == 7001;
    }

    public static boolean isAPSAudioSource(int n) {
        return n == 6001 || n == 6002;
    }

    public static boolean isTunerAudioSource(int n) {
        return n == 1001;
    }

    public static boolean isTVAudioSource(int n) {
        return n == 8001;
    }

    public static boolean isSDISAudioSource(int n) {
        return n == 20001;
    }

    public static boolean isPhoneAudioSource(int n) {
        switch (n) {
            case 5001: 
            case 5002: 
            case 5003: {
                return true;
            }
        }
        return false;
    }

    public static boolean isSDSAudioSource(int n) {
        switch (n) {
            case 3001: 
            case 9001: 
            case 10001: 
            case 11001: 
            case 12001: 
            case 13001: 
            case 14001: 
            case 15001: 
            case 16001: 
            case 17001: 
            case 18001: 
            case 19001: {
                return true;
            }
        }
        return false;
    }
}

