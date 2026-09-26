/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.app.car.sdis.CarMainASIProvider;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.dsi2asi.GenericDsiAsiHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import org.dsi.ifc.global.CarViewOption;
import org.osgi.framework.BundleContext;

public interface ISDISFramework {
    public static final int ASI_BC_SERVICE;
    public static final int ASI_CLIMATE_SERVICE;
    public static final int ASI_DRIVING_SERVICE;
    public static final int ASI_CAR_SERVICE;

    default public LogChannel getLogChannel(String string) {
    }

    default public IFrameworkAccess getHMIFramework() {
    }

    default public BundleContext getBundleContext() {
    }

    default public void registerService(String string, Object object) {
    }

    default public void registerDSI(String string, String string2, IDSIObserver iDSIObserver) {
    }

    default public void deRegisterDSI(String string) {
    }

    default public void deRegisterService(String string) {
    }

    default public CarMainASIProvider getASIDataUpdater() {
    }

    default public int updateVisibility(CarViewOption carViewOption, short s) {
    }

    default public int getVisibilityMainState(CarViewOption[] carViewOptionArray) {
    }

    default public CarFuncAdap getCarAdaption() {
    }

    default public GenericDsiAsiHandler getDsiAsiHandler() {
    }
}

