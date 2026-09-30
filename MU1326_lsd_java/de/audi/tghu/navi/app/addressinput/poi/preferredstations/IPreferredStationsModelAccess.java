/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.preferredstations;

import org.dsi.ifc.navigation.Brand;

public interface IPreferredStationsModelAccess {
    public void preferrBrand(long var1, boolean var3);

    public void brandsUpdated(Brand[] var1);
}

