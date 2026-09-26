/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import org.dsi.ifc.generalvehiclestates.TankInfo;

public interface IUpdateTankInfoObserver {
    default public void updateTankInfo(TankInfo tankInfo) {
    }
}

