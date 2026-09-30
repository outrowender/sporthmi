/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IDSIControllerStateListener;

public interface IDSIController {
    public void init();

    public void deinit();

    public int getInstanceID();

    public void startDSI();

    public void stopDSI();

    public boolean isStarted();

    public void setStateListener(IDSIControllerStateListener var1);
}

