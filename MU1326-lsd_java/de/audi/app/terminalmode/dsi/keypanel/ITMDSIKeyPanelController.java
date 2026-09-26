/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;

public interface ITMDSIKeyPanelController {
    default public void addTMKeyPanelListener(TMDSIKeyPanelListener tMDSIKeyPanelListener) {
    }

    default public void removeTMKeyPanelListener() {
    }

    default public void setTextInputActive(int n, boolean bl) {
    }
}

