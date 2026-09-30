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
    public void resolvePicNavLocation(int var1, int var2, ResourceLocator var3);

    public void show(MapItemSelectionInfo var1);

    public MapItemSelectionAction checkToShow(MapItemSelectionInfo var1, Point var2, boolean var3, boolean var4);

    public void show(MapItemSelectionInfo var1, Point var2);

    public void showToolTip(String var1, int var2, int var3, PosInfo var4, String var5, boolean var6, boolean var7, ResourceLocator var8);

    public ToolTipTimer getTooltipTimer();
}

