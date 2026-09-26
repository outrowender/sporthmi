/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;

public interface ITooltipFormatter$TooltipFormatterEnvironment {
    default public LogChannel getLogChannel() {
    }

    default public NavLocation getNavLocation(byte[] byArray) {
    }

    default public boolean hasIcon(NavLocation navLocation) {
    }

    default public float getZoomLevel() {
    }
}

