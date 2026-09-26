/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.tghu.navi.app.car.IUpdateDisplayDayNightObserver;
import de.audi.tghu.navi.app.car.IUpdateESPDataObserver;
import de.audi.tghu.navi.app.car.IUpdateTankInfoObserver;
import de.audi.tghu.navi.app.car.IUpdateVehicleStandstillObserver;

public interface IVehicleStatesObserver
extends IUpdateTankInfoObserver,
IUpdateDisplayDayNightObserver,
IUpdateVehicleStandstillObserver,
IUpdateESPDataObserver {
}

