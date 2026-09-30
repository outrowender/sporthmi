/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import org.dsi.ifc.global.NavLocation;

public interface IPoiSearchAreaModelAccess {
    public void onStart(NavLocation var1);

    public void onUpdateSearchArea(PoiSearchArea var1);

    public void onUpdateSearchArea(PoiSearchArea var1, boolean var2, int var3);

    public void onUpdateHistoryList();

    public void onElementSelected(NavLocation var1);
}

