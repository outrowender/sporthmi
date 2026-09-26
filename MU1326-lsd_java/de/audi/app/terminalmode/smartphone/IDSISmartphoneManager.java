/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;

public interface IDSISmartphoneManager {
    public static final long NO_MESSAGE_ID;
    public static final int BUTTON_PTT_LONG;
    public static final int BUTTON_SKIP_FORWARD;
    public static final int BUTTON_SKIP_BACKWARD;
    public static final int BUTTON_SEEK_FORWARD;
    public static final int BUTTON_SEEK_BACKWARD;
    public static final int BUTTON_PLAY;
    public static final int BUTTON_PAUSE;
    public static final int BUTTONSTATE_PRESSED;
    public static final int BUTTONSTATE_RELEASED;

    default public void startService(TMState tMState) {
    }

    default public void responseUpdateMode(TMState tMState, long l) {
    }

    default public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
    }

    default public void requestConstraintsChange(TMState tMState, Resource resource, boolean bl) {
    }

    default public void requestNightMode(boolean bl) {
    }

    default public ISpeechRequestHandler getSpeechRequestHandler() {
    }

    default public IPlayerModificationListener getPlayerModificationListener() {
    }

    default public SmartphoneManager$SmartphoneType getSmartphoneType() {
    }

    default public IPhoneCallController getPhoneCallController() {
    }

    default public IDSISmartphoneManager$ISmartphoneProperties getSmartphoneProperties() {
    }
}

