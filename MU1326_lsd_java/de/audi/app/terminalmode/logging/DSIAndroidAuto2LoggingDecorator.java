/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.logging.DSIBaseLoggingDecorator;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;

public class DSIAndroidAuto2LoggingDecorator
extends DSIBaseLoggingDecorator
implements DSIAndroidAuto2 {
    private final DSIAndroidAuto2 wrappee;

    public DSIAndroidAuto2LoggingDecorator(DSIAndroidAuto2 dSIAndroidAuto2, LogChannel logChannel, int n) {
        super(dSIAndroidAuto2, logChannel, n, "DSIAndroidAuto");
        this.wrappee = dSIAndroidAuto2;
    }

    public void audioFocusNotification(int n, boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.audioFocusNotification] %1, %2", (Object)DSIAndroidAuto2LoggingDecorator.audioFocusNotificationToString(n), (Object)this.isUnsolicitedtoString(bl));
        this.wrappee.audioFocusNotification(n, bl);
    }

    private static String audioFocusNotificationToString(int n) {
        switch (n) {
            case 1: {
                return "AUDIOFOCUSSTATE_GAIN";
            }
            case 6: {
                return "AUDIOFOCUSSTATE_GAIN_MEDIA_ONLY";
            }
            case 2: {
                return "AUDIOFOCUSSTATE_GAIN_TRANSIENT";
            }
            case 7: {
                return "AUDIOFOCUSSTATE_GAIN_TRANSIENT_GUIDANCE_ONLY";
            }
            case 3: {
                return "AUDIOFOCUSSTATE_LOSS";
            }
            case 5: {
                return "AUDIOFOCUSSTATE_LOSS_TRANSIENT";
            }
            case 4: {
                return "AUDIOFOCUSSTATE_LOSS_TRANSIENT_CAN_DUCK";
            }
        }
        return String.valueOf(n);
    }

    public void bluetoothAuthenticationData(String string) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.bluetoothAuthenticationData] %1", (Object)string);
        this.wrappee.bluetoothAuthenticationData(string);
    }

    public void bluetoothPairingResponse(boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.bluetoothPairingResponse] %1", (Object)(bl ? "already paired" : "not paired"));
        this.wrappee.bluetoothPairingResponse(bl);
    }

    public void microphoneNotification(int n, boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.microphoneNotification] micModeStatus %1, %2", (Object)new Integer(n), (Object)this.isUnsolicitedtoString(bl));
        this.wrappee.microphoneNotification(n, bl);
    }

    public void navFocusNotification(int n, boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.navFocusNotification] navFocusType %1, %2", (Object)new Integer(n), (Object)this.isUnsolicitedtoString(bl));
        this.wrappee.navFocusNotification(n, bl);
    }

    public void postButtonEvent(int n, int n2) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.postButtonEvent] button %1, buttonState %2", (Object)DSIAndroidAuto2LoggingDecorator.buttonToString(n), (long)n2);
        this.wrappee.postButtonEvent(n, n2);
    }

    private static String buttonToString(int n) {
        switch (n) {
            case 7: {
                return "BUTTON_0BUTTON_0";
            }
            case 8: {
                return "BUTTON_1BUTTON_1";
            }
            case 9: {
                return "BUTTON_2";
            }
            case 10: {
                return "BUTTON_3";
            }
            case 11: {
                return "BUTTON_4";
            }
            case 12: {
                return "BUTTON_5";
            }
            case 13: {
                return "BUTTON_6";
            }
            case 14: {
                return "BUTTON_7";
            }
            case 15: {
                return "BUTTON_8";
            }
            case 16: {
                return "BUTTON_9";
            }
            case 4: {
                return "BUTTON_BACK";
            }
            case 110: {
                return "BUTTON_BUTTON_MODE";
            }
            case 109: {
                return "BUTTON_BUTTON_SELECT";
            }
            case 108: {
                return "BUTTON_BUTTON_START";
            }
            case 5: {
                return "BUTTON_CALL";
            }
            case 23: {
                return "BUTTON_DPAD_CENTER";
            }
            case 20: {
                return "BUTTON_DPAD_DOWN";
            }
            case 21: {
                return "BUTTON_DPAD_LEFT";
            }
            case 22: {
                return "BUTTON_DPAD_RIGHT";
            }
            case 19: {
                return "BUTTON_DPAD_UP";
            }
            case 6: {
                return "BUTTON_ENDCALL";
            }
            case 80: {
                return "BUTTON_FOCUS";
            }
            case 3: {
                return "BUTTON_HOME";
            }
            case 65537: {
                return "BUTTON_MEDIA";
            }
            case 222: {
                return "BUTTON_MEDIA_AUDIO_TRACK";
            }
            case 128: {
                return "BUTTON_MEDIA_CLOSE";
            }
            case 129: {
                return "BUTTON_MEDIA_EJECT";
            }
            case 90: {
                return "BUTTON_MEDIA_FAST_FORWARD";
            }
            case 87: {
                return "BUTTON_MEDIA_NEXT";
            }
            case 127: {
                return "BUTTON_MEDIA_PAUSE";
            }
            case 126: {
                return "BUTTON_MEDIA_PLAY";
            }
            case 85: {
                return "BUTTON_MEDIA_PLAY_PAUSE";
            }
            case 88: {
                return "BUTTON_MEDIA_PREVIOUS";
            }
            case 130: {
                return "BUTTON_MEDIA_RECORD";
            }
            case 89: {
                return "BUTTON_MEDIA_REWIND";
            }
            case 86: {
                return "BUTTON_MEDIA_STOP";
            }
            case 82: {
                return "BUTTON_MENU";
            }
            case 91: {
                return "BUTTON_MUTE";
            }
            case 65538: {
                return "BUTTON_NAVIGATION";
            }
            case 83: {
                return "BUTTON_NOTIFICATION";
            }
            case 81: {
                return "BUTTON_PLUS";
            }
            case 18: {
                return "BUTTON_POUND";
            }
            case 65539: {
                return "BUTTON_RADIO";
            }
            case 65536: {
                return "BUTTON_ROTARY_CONTROLLER";
            }
            case 84: {
                return "BUTTON_SEARCH";
            }
            case 65535: {
                return "BUTTON_SENTINEL";
            }
            case 1: {
                return "BUTTON_SOFT_LEFT";
            }
            case 2: {
                return "BUTTON_SOFT_RIGHT";
            }
            case 17: {
                return "BUTTON_STAR";
            }
            case 65540: {
                return "BUTTON_TEL";
            }
            case 0: {
                return "BUTTON_UNKNOWN";
            }
            case 25: {
                return "BUTTON_VOLUME_DOWN";
            }
            case 164: {
                return "BUTTON_VOLUME_MUTE";
            }
            case 24: {
                return "BUTTON_VOLUME_UP";
            }
        }
        return String.valueOf(n);
    }

    public void postRotaryEvent(int n) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.postRotaryEvent] ticks %1", (long)n);
        this.wrappee.postRotaryEvent(n);
    }

    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.postTouchEvent] touchSource %1, %2, action %3, actionIndex %4", (Object)new Integer(n), (Object)Arrays2.toString(touchEventArray), (Object)new Integer(n2), (Object)Integer.toString(n3));
        this.wrappee.postTouchEvent(n, touchEventArray, n2, n3);
    }

    public void setNightMode(boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.setNightMode] %1", bl);
        this.wrappee.setNightMode(bl);
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.startService] %1", (Object)serviceConfiguration);
        this.wrappee.startService(serviceConfiguration);
    }

    public void videoFocusNotification(int n, boolean bl) {
        this.lc.log(this.level, "-> [DSIAndroidAuto2.videoFocusNotification] videoFocusMode %1, %2", (Object)new Integer(n), (Object)this.isUnsolicitedtoString(bl));
        this.wrappee.videoFocusNotification(n, bl);
    }

    private String isUnsolicitedtoString(boolean bl) {
        return bl ? "unsolicited" : "solicited";
    }
}

