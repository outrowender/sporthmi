/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.TMState;

public interface IAndroidAuto2RequestHandler {
    public void responseUpdateMode(TMState var1, long var2);

    public void requestModeChange(TMState var1, String var2, IDSISmartphoneManager.RequestModeChangeCallback var3);
}

