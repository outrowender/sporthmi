/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$RequestModeChangeCallback;
import de.audi.app.terminalmode.statemachine.TMState;

public interface IAndroidAuto2RequestHandler {
    default public void responseUpdateMode(TMState tMState, long l) {
    }

    default public void requestModeChange(TMState tMState, String string, IDSISmartphoneManager$RequestModeChangeCallback iDSISmartphoneManager$RequestModeChangeCallback) {
    }
}

