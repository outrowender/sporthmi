/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;

public interface IDisplayControllerWidget {
    default public void prepareAndSwitchToTargetContext() {
    }

    default public void setOpacityOnBackgroundLayers(float f2, boolean bl) {
    }

    default public int getTargetContextID() {
    }

    default public void setTerminal(HMITerminalImpl hMITerminalImpl) {
    }
}

