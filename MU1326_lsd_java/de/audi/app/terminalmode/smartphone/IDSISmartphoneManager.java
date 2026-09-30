/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IPhoneCallController;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.smartphone.ISpeechRequestHandler;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.utils.reactive.properties.Property;

public interface IDSISmartphoneManager {
    public static final long NO_MESSAGE_ID = -1L;
    public static final int BUTTON_PTT_LONG = 1;
    public static final int BUTTON_SKIP_FORWARD = 2;
    public static final int BUTTON_SKIP_BACKWARD = 3;
    public static final int BUTTON_SEEK_FORWARD = 4;
    public static final int BUTTON_SEEK_BACKWARD = 5;
    public static final int BUTTON_PLAY = 6;
    public static final int BUTTON_PAUSE = 7;
    public static final int BUTTONSTATE_PRESSED = 1;
    public static final int BUTTONSTATE_RELEASED = 2;

    public void startService(TMState var1);

    public void responseUpdateMode(TMState var1, long var2);

    public void requestModeChange(TMState var1, String var2, RequestModeChangeCallback var3);

    public void requestConstraintsChange(TMState var1, Resource var2, boolean var3);

    public void requestNightMode(boolean var1);

    public ISpeechRequestHandler getSpeechRequestHandler();

    public IPlayerModificationListener getPlayerModificationListener();

    public SmartphoneManager.SmartphoneType getSmartphoneType();

    public IPhoneCallController getPhoneCallController();

    public ISmartphoneProperties getSmartphoneProperties();

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface ISmartphoneProperties {
        public Property<Boolean> getPropertyMUPhonecallActive();

        public Property<Boolean> getPropertyMUHFPPhonecallActive();

        public Property<BTState> getPropertyBluetooth();

        public Property<Boolean> getPropertyMURVCActive();

        public Property<SPIServiceState> getPropertySPIServiceState();
    }

    public static interface RequestModeChangeCallback {
        public void modeChanged();
    }
}

