/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler$IMapSelectionListener;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.tmc.TmcMessage;

public interface MapSelectionHandler {
    default public void addListener(MapSelectionHandler$IMapSelectionListener mapSelectionHandler$IMapSelectionListener) {
    }

    default public void requestInfoForPosition(boolean bl, boolean bl2) {
    }

    default public void requestInfoForScreenPosition(int n, Point point) {
    }

    default public void requestPreviewMapItemInformation(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    default public MapPin getSelectedPin() {
    }

    default public MapItemSelectionInfo getSelectedValue() {
    }

    default public void clear() {
    }

    default public void cancelSelection() {
    }

    default public int getActiveInfoListIndex() {
    }

    default public void updateInfoForPosition(PosInfo[] posInfoArray, boolean bl) {
    }

    default public void updateOnlineResultFlagDetails(int n) {
    }

    default public void updateTmcMessage(TmcMessage tmcMessage) {
    }

    default public MapItemSelectionInfo getStoredSelectedValue(int n) {
    }
}

