/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;

public interface ICarplayDSIController {
    public static final int UI_LAST;
    public static final int UI_HOME;
    public static final int BUTTONSTATE_PRESSED;
    public static final int BUTTONSTATE_RELEASED;

    default public void startService(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray) {
    }

    default public void stopService() {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postDSICarplayButtonEvent(int n, int n2) {
    }

    default public void responseUpdateMode(IDSIResource[] iDSIResourceArray, IDSIAppState[] iDSIAppStateArray) {
    }

    default public void requestModeChange(IDSIAppState[] iDSIAppStateArray, IDSIResource[] iDSIResourceArray, String string) {
    }

    default public void responseBTDeactivation() {
    }

    default public void requestUI(int n) {
    }

    default public void responseUpdateMainAudioType(int n) {
    }

    default public void requestSIRIAction(SiriAction siriAction) {
    }

    default public void requestNightMode(boolean bl) {
    }
}

