/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.map.gui.ToolTipTimer;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public interface IMapTooltip {
    default public void resolvePicNavLocation(int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void show(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    default public MapItemSelectionAction checkToShow(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl, boolean bl2) {
    }

    default public void show(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    default public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
    }

    default public ToolTipTimer getTooltipTimer() {
    }
}

