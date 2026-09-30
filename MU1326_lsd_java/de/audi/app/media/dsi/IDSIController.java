/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IDSIControllerStateListener;

public interface IDSIController {
    public void init();

    public void deinit();

    public int getInstanceID();

    public void startDSI();

    public boolean isStarted();

    public void setStateListener(IDSIControllerStateListener var1);
}

