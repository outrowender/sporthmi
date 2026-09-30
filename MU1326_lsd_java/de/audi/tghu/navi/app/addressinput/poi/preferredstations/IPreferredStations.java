/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.preferredstations;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Brand;

public interface IPreferredStations {
    public void onStart(int var1, int var2, NavCommand var3);

    public void brandsUpdated(int var1, int var2, Brand[] var3);

    public void toggleBrandPreferrence(int var1);

    public void onExit();
}

