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
    public static final int ASI_BC_SERVICE = 0;
    public static final int ASI_CLIMATE_SERVICE = 1;
    public static final int ASI_DRIVING_SERVICE = 2;
    public static final int ASI_CAR_SERVICE = 3;

    public LogChannel getLogChannel(String var1);

    public IFrameworkAccess getHMIFramework();

    public BundleContext getBundleContext();

    public void registerService(String var1, Object var2);

    public void registerDSI(String var1, String var2, IDSIObserver var3);

    public void deRegisterDSI(String var1);

    public void deRegisterService(String var1);

    public CarMainASIProvider getASIDataUpdater();

    public int updateVisibility(CarViewOption var1, short var2);

    public int getVisibilityMainState(CarViewOption[] var1);

    public CarFuncAdap getCarAdaption();

    public GenericDsiAsiHandler getDsiAsiHandler();
}

