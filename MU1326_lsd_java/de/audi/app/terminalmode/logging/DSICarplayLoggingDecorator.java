/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.logging.DSIBaseLoggingDecorator;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public class DSICarplayLoggingDecorator
extends DSIBaseLoggingDecorator
implements DSICarplay {
    private final DSICarplay wrappee;

    public DSICarplayLoggingDecorator(DSICarplay dSICarplay, LogChannel logChannel, int n) {
        super(dSICarplay, logChannel, n, "DSICarplay");
        this.wrappee = dSICarplay;
    }

    public void startService(ServiceConfiguration serviceConfiguration) {
        this.lc.log(this.level, "-> [DSICarplay.startService] %1", (Object)serviceConfiguration);
        this.wrappee.startService(serviceConfiguration);
    }

    public void postButtonEvent(int n, int n2) {
        this.lc.log(this.level, "-> [DSICarplay.postButtonEvent] button %3(%1), %2", (Object)new Integer(n), (Object)this.buttonStateToString(n2), (Object)this.buttonToString(n));
        this.wrappee.postButtonEvent(n, n2);
    }

    private String buttonStateToString(int n) {
        switch (n) {
            case 0: {
                return "BUTTONSTATE_PRESSED";
            }
            case 1: {
                return "BUTTONSTATE_RELEASED";
            }
        }
        return "UNKNOWN";
    }

    private String buttonToString(int n) {
        switch (n) {
            case 0: {
                return "BUTTON_UNKNOWN";
            }
            case 1: {
                return "BUTTON_SELECT";
            }
            case 2: {
                return "BUTTON_HOME";
            }
            case 3: {
                return "BUTTON_BACK";
            }
            case 4: {
                return "BUTTON_VOICE";
            }
            case 5: {
                return "BUTTON_LEFT";
            }
            case 6: {
                return "BUTTON_RIGHT";
            }
            case 7: {
                return "BUTTON_UP";
            }
            case 8: {
                return "BUTTON_DOWN";
            }
            case 9: {
                return "BUTTON_SKIP_FORWARD";
            }
            case 10: {
                return "BUTTON_SKIP_BACKWARD";
            }
            case 11: {
                return "BUTTON_SEEK_FORWARD";
            }
            case 12: {
                return "BUTTON_SEEK_BACKWARD";
            }
            case 13: {
                return "BUTTON_ACCEPT_CALL";
            }
            case 14: {
                return "BUTTON_END_CALL";
            }
            case 20: {
                return "BUTTON_FLASH_CALL";
            }
            case 15: {
                return "BUTTON_PLAY_PAUSE";
            }
            case 16: {
                return "BUTTON_PRIMARY";
            }
            case 17: {
                return "BUTTON_SECONDARY";
            }
            case 18: {
                return "BUTTON_PAUSE";
            }
            case 19: {
                return "BUTTON_PLAY";
            }
        }
        return "UNKNOWN";
    }

    public void postRotaryEvent(int n) {
        this.lc.log(this.level, "-> [DSICarplay.postRotaryEvent] ticks %1", (long)n);
        this.wrappee.postRotaryEvent(n);
    }

    public void requestNightMode(boolean bl) {
        this.lc.log(this.level, "-> [DSICarplay.requestNightMode] %1", bl);
        this.wrappee.requestNightMode(bl);
    }

    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        this.lc.log(this.level, "-> [DSICarplay.postTouchEvent] touchSource %1, numberOfFingers %2, touchEvents %3 ", (Object)new Integer(n), (Object)new Integer(n2), (Object)Arrays2.toString(touchEventArray));
        this.wrappee.postTouchEvent(n, n2, touchEventArray);
    }

    public void postCharacterEvent(int n, String[] stringArray) {
        this.lc.log(this.level, "-> [DSICarplay.postCharacterEvent] postCharacterEvent %1, detectedCharacters %2", (Object)new Integer(n), (Object)stringArray);
        this.wrappee.postCharacterEvent(n, stringArray);
    }

    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        this.lc.log(this.level, "-> [DSICarplay.requestModeChange] reason=%1, resources=%2, appStates=%3", (Object)string, (Object)resourceRequestArray, (Object)appStateRequestArray);
        this.wrappee.requestModeChange(resourceRequestArray, appStateRequestArray, string);
    }

    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.lc.log(this.level, "-> [DSICarplay.responseUpdateMode] resources %1, appStates %2", (Object)resourceArray, (Object)appStateArray);
        this.wrappee.responseUpdateMode(resourceArray, appStateArray);
    }

    public void responseBTDeactivation() {
        this.lc.log(this.level, "-> [DSICarplay.responseBTDeactivation]");
        this.wrappee.responseBTDeactivation();
    }

    public void requestUI(int n) {
        this.lc.log(this.level, "-> [DSICarplay.requestUI] %1", (long)n);
        this.wrappee.requestUI(n);
    }

    public void requestUI2(String string) {
        this.lc.log(this.level, "-> [DSICarplay.requestUI2] %1", (Object)string);
        this.wrappee.requestUI2(string);
    }

    public void requestSIRIAction(int n) {
        this.lc.log(this.level, "-> [DSICarplay.requestSIRIAction] %1(%2)", (Object)this.siriActionToString(n), (long)n);
        this.wrappee.requestSIRIAction(n);
    }

    private String siriActionToString(int n) {
        switch (n) {
            case 0: {
                return "SIRIACTION_PREWARM";
            }
            case 1: {
                return "SIRIACTION_START";
            }
            case 2: {
                return "SIRIACTION_STOP";
            }
        }
        return "UNKNOWN";
    }

    public void responseUpdateMainAudioType(int n) {
        this.lc.log(this.level, "-> [DSICarplay.responseUpdateMainAudioType] %1", (long)n);
        this.wrappee.responseUpdateMainAudioType(n);
    }
}

