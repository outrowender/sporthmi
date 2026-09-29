/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import org.dsi.ifc.global.CarViewOption;

public final class VehicleStatesHelper {
    private static CarViewOption vinViewOption = null;
    private static CarViewOption keyDataViewOption = null;
    private static int vinMenuEntryState = 0;
    private static int keyDataMenuEntryState = 0;

    private VehicleStatesHelper() {
    }

    public static void updateVinAndKeyDataVisibilityFromVin(CarViewOption carViewOption, int n, ICarApplication iCarApplication) {
        vinViewOption = carViewOption;
        vinMenuEntryState = n;
        VehicleStatesHelper.updateVinAndKeyDataVisibility(iCarApplication);
    }

    public static void updateVinAndKeyDataVisibilityFromKeyData(CarViewOption carViewOption, int n, ICarApplication iCarApplication) {
        keyDataViewOption = carViewOption;
        keyDataMenuEntryState = n;
        VehicleStatesHelper.updateVinAndKeyDataVisibility(iCarApplication);
    }

    private static synchronized void updateVinAndKeyDataVisibility(ICarApplication iCarApplication) {
        int n = 0;
        if (vinViewOption != null && vinViewOption.getReason() == 11 && keyDataViewOption != null && keyDataViewOption.getReason() == 11) {
            n = 1;
            vinMenuEntryState = 0;
            keyDataMenuEntryState = 0;
        }
        iCarApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(992938240).setValue(n);
        iCarApplication.getMenuEntryRegistry().updateMenuEntryVisibility(182, vinMenuEntryState);
        iCarApplication.getMenuEntryRegistry().updateMenuEntryVisibility(181, keyDataMenuEntryState);
    }
}

