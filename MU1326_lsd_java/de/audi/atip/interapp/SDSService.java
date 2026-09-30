/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.AbstractSDSService;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface SDSService
extends AbstractSDSService {
    public static final byte SDS_ABORTER_NONE = -1;
    public static final byte SDS_ABORTER_VOICE_COMMAND = 0;
    public static final byte SDS_ABORTER_APS_OPS_RVC = 1;
    public static final byte SDS_ABORTER_KBD = 2;
    public static final byte SDS_ABORTER_WIDGET = 3;
    public static final byte SDS_ABORTER_ADB = 4;
    public static final byte SDS_ABORTER_MEDIA = 5;
    public static final byte SDS_ABORTER_NAVI = 6;
    public static final byte SDS_ABORTER_PHONE = 7;
    public static final byte SDS_ABORTER_TUNER = 8;
    public static final byte SDS_ABORTER_VOLUME_SETTING = 9;
    public static final byte SDS_ABORTER_ONLINE = 10;
    public static final byte SDS_ABORTER_POPUP = 11;
    public static final byte SDS_ABORTER_PTT_DOUBLE = 12;
    public static final byte SDS_ABORTER_PTT_LONG = 13;

    public void playPrioPrompt(String var1);

    public void itemSelected(int var1, int var2);

    public void itemSelected(int var1, int var2, int var3);

    public void keyTyped(int var1, int var2);

    public void folderUpSelected();

    public void notifySpellerUserInteraction(int var1);

    public void abortSDSSession(boolean var1, byte var2);

    public void returnKeyPressed();

    public boolean startDDSPress();

    public void cancelDDSPress();

    public void endDDSPress();

    public void turnDDSWheel();

    public void movedDDSJoystick(JoystickEvent var1);

    public void registerStatusListener(ISDSServiceStatusListener var1);

    public void unregisterStatusListener(ISDSServiceStatusListener var1);

    public void cancelTimers();

    public void startVolumeSettingSession();

    public void stopVolumeSettingSession();

    public boolean isVolumeSettingSessionActive();

    public void textChanged(int var1, String var2, char var3);

    public boolean isExternalSDSActive();

    public void screenConnected(int var1, int var2, boolean var3);

    public void screenConnectedWithSDSData(int var1, int var2, ScreenConnectedSDSData var3);

    public void sendResponse(int var1, int var2);

    public void updateExternalSDSActive();

    public static class ScreenConnectedSDSData {
        private int smallStageType;
        private static final Map SMALL_STAGE_TYPE_TO_STR = ScreenConnectedSDSData.createSmallStageTypeToStrMap();

        private static Map createSmallStageTypeToStrMap() {
            HashMap hashMap = new HashMap();
            hashMap.put(new Integer(0), "Abbreviating");
            hashMap.put(new Integer(1), "Omission");
            hashMap.put(new Integer(2), "Replacing");
            hashMap.put(new Integer(3), "Screenshot");
            hashMap.put(new Integer(4), "Canceling");
            hashMap.put(new Integer(6), "No Change");
            hashMap.put(new Integer(7), "Wrap");
            return Collections.unmodifiableMap(hashMap);
        }

        public int getSmallStageType() {
            return this.smallStageType;
        }

        public void setSmallStageType(int n) {
            this.smallStageType = n;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("{ ");
            buffer.append("smallStageType: ").append(SMALL_STAGE_TYPE_TO_STR.get(new Integer(this.smallStageType))).append(" (").append(this.smallStageType).append(")");
            buffer.append(" }");
            return buffer.toString();
        }
    }
}

