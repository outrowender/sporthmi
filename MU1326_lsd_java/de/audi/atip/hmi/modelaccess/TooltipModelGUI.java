/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;

public interface TooltipModelGUI
extends ListModelGUI {
    default public void requestTooltipData(HMIModelGUI hMIModelGUI, int n, boolean bl, int n2) {
    }

    default public void tooltipVisible(HMIModelGUI hMIModelGUI, int n) {
    }

    default public void tooltipHidden(HMIModelGUI hMIModelGUI, boolean bl, int n) {
    }
}

