/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;

public interface ITMDSIKeyPanelController {
    public void addTMKeyPanelListener(TMDSIKeyPanelListener var1);

    public void removeTMKeyPanelListener();

    public void setTextInputActive(int var1, boolean var2);
}

