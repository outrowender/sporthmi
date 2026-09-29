/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import org.dsi.ifc.global.NavLocation;

public interface IVehicleModelAccess {
    default public void updateStreet(String string) {
    }

    default public void updateCountryNCity(String string, String string2, String string3) {
    }

    default public void updateZip(String string) {
    }

    default public void updateSatInfo(String string, String string2, int n, int n2, int n3, int n4) {
    }

    default public void updateHeight(int n) {
    }

    default public void buildRows() {
    }

    default public void updateRoadSign(NavLocation navLocation) {
    }
}

