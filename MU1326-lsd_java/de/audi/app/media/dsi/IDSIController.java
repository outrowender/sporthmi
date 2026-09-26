/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IDSIControllerStateListener;

public interface IDSIController {
    default public void init() {
    }

    default public void deinit() {
    }

    default public int getInstanceID() {
    }

    default public void startDSI() {
    }

    default public boolean isStarted() {
    }

    default public void setStateListener(IDSIControllerStateListener iDSIControllerStateListener) {
    }
}

