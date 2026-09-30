/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface MapSelectionHandler {
    public void addListener(IMapSelectionListener var1);

    public void requestInfoForPosition(boolean var1, boolean var2);

    public void requestInfoForScreenPosition(int var1, Point var2);

    public void requestPreviewMapItemInformation(NavLocationWgs84 var1, boolean var2);

    public MapPin getSelectedPin();

    public MapItemSelectionInfo getSelectedValue();

    public void clear();

    public void cancelSelection();

    public int getActiveInfoListIndex();

    public void updateInfoForPosition(PosInfo[] var1, boolean var2);

    public void updateOnlineResultFlagDetails(int var1);

    public void updateTmcMessage(TmcMessage var1);

    public MapItemSelectionInfo getStoredSelectedValue(int var1);

    public static interface IMapSelectionListener {
        public void onSelectionChanged(MapItemSelectionInfo var1);
    }
}

