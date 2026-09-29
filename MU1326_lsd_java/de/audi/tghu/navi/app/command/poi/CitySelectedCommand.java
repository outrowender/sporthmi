/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public abstract class CitySelectedCommand
extends NavCommand {
    protected NavLocation selectedCity = null;

    public NavLocation getSelectedCity() {
        return this.selectedCity;
    }

    public void setSelectedCity(NavLocation navLocation) {
        this.selectedCity = navLocation;
    }
}

