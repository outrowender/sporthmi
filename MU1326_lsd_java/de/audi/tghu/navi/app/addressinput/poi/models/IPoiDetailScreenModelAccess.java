/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import org.dsi.ifc.global.NavLocation;

public interface IPoiDetailScreenModelAccess
extends IPoiScreenOnStart {
    public void onUpdateLocation(NavLocation var1);
}

