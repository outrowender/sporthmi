/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import org.dsi.ifc.global.NavLocation;

public interface IVehicleModelAccess {
    public void updateStreet(String var1);

    public void updateCountryNCity(String var1, String var2, String var3);

    public void updateZip(String var1);

    public void updateSatInfo(String var1, String var2, int var3, int var4, int var5, int var6);

    public void updateHeight(int var1);

    public void buildRows();

    public void updateRoadSign(NavLocation var1);
}

