/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import org.dsi.ifc.global.NavLocation;

public interface IPoiSearchAreaModelAccess {
    default public void onStart(NavLocation navLocation) {
    }

    default public void onUpdateSearchArea(PoiSearchArea poiSearchArea) {
    }

    default public void onUpdateSearchArea(PoiSearchArea poiSearchArea, boolean bl, int n) {
    }

    default public void onUpdateHistoryList() {
    }

    default public void onElementSelected(NavLocation navLocation) {
    }
}

