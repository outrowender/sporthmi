/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface TooltipModelGUI
extends ListModelGUI {
    public void requestTooltipData(HMIModelGUI var1, int var2, boolean var3, int var4);

    public void tooltipVisible(HMIModelGUI var1, int var2);

    public void tooltipHidden(HMIModelGUI var1, boolean var2, int var3);
}

