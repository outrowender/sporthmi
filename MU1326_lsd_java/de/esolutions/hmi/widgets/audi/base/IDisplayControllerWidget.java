/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;

public interface IDisplayControllerWidget {
    public void prepareAndSwitchToTargetContext();

    public void setOpacityOnBackgroundLayers(float var1, boolean var2);

    public int getTargetContextID();

    public void setTerminal(HMITerminalImpl var1);
}

