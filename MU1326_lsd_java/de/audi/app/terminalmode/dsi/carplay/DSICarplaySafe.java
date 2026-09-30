/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.carplay.SiriAction;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplaySafe {
    public void startService(ServiceConfiguration var1);

    public void postButtonEvent(int var1, int var2);

    public void postTouchEvent(int var1, int var2, TouchEvent[] var3);

    public void postRotaryEvent(int var1);

    public void postCharacterEvent(int var1, String[] var2);

    public void requestModeChange(ResourceRequest[] var1, AppStateRequest[] var2, String var3);

    public void responseUpdateMode(Resource[] var1, AppState[] var2);

    public void responseBTDeactivation();

    public void requestUI(int var1);

    public void requestUI2(String var1);

    public void requestNightMode(boolean var1);

    public void requestSIRIAction(SiriAction var1);

    public void responseUpdateMainAudioType(int var1);
}

