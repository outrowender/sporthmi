/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.carplay.SiriAction;

public interface ICarplayDSIController {
    public static final int UI_LAST = 0;
    public static final int UI_HOME = 1;
    public static final int BUTTONSTATE_PRESSED = 1;
    public static final int BUTTONSTATE_RELEASED = 2;

    public void startService(IDSIAppState[] var1, IDSIResource[] var2);

    public void stopService();

    public void postButtonEvent(int var1, int var2);

    public void postDSICarplayButtonEvent(int var1, int var2);

    public void responseUpdateMode(IDSIResource[] var1, IDSIAppState[] var2);

    public void requestModeChange(IDSIAppState[] var1, IDSIResource[] var2, String var3);

    public void responseBTDeactivation();

    public void requestUI(int var1);

    public void responseUpdateMainAudioType(int var1);

    public void requestSIRIAction(SiriAction var1);

    public void requestNightMode(boolean var1);
}

