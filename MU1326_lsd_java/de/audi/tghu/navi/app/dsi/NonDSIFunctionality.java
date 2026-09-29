/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.timer.TimerListener;

public interface NonDSIFunctionality
extends TimerListener {
    default public void updateRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
    }

    default public void updateClockAdjusted(boolean bl) {
    }
}

