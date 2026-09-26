/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.preferredstations;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Brand;

public interface IPreferredStations {
    default public void onStart(int n, int n2, NavCommand navCommand) {
    }

    default public void brandsUpdated(int n, int n2, Brand[] brandArray) {
    }

    default public void toggleBrandPreferrence(int n) {
    }

    default public void onExit() {
    }
}

