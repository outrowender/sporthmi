/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.app;

import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.car.common.comp.ICarComponent;
import de.audi.app.car.common.dump.IDumpRegistry;
import de.audi.app.car.common.lang.ILanguageUpdateDispatcher;
import de.audi.app.car.common.md.IMessageDispatcher;
import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.power.IPowerEventDispatcher;
import de.audi.app.car.common.screenstate.IPopupStateDispatcher;
import de.audi.app.car.common.sdis.ISDISConnector;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.osgi.framework.BundleContext;

public interface ICarApplication {
    public static final int MODULE_ID_CAR = 6;
    public static final int MODULE_ID_SETTINGS = 11;
    public static final int MODULE_ID_EARLY_FUNC = 21;
    public static final String MODULE_NAME_CAR = "AppCar";
    public static final String MODULE_NAME_SETTINGS = "AppSettings";
    public static final String MODULE_NAME_EARLY_FUNC = "AppEarlyFunc";
    public static final int CLIMATE_SYSTEM_VARIANT_NONE = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER = 1;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;

    public void init();

    public void deinit();

    public void startDSIServiceForComponent(String var1, int var2);

    public int getId();

    public String getApplicationName();

    public LogChannel getLogChannel();

    public LogChannel getMerLogChannel();

    public BundleContext getBundleContext();

    public IActionProxyDispatcher getActionProxyDispatcher();

    public IMessageDispatcher getMessageDispatcher();

    public DispatcherBase getJobDispatcher();

    public IFrameworkAccess getFrameworkAccess();

    public IMenuEntryRegistry getMenuEntryRegistry();

    public IPopupStateDispatcher getScreenStateDispatcher();

    public IPowerEventDispatcher getPowerEventDispatcher();

    public ILanguageUpdateDispatcher getLanguageUpdateDispatcher();

    public CarFuncAdap getCarMenuCoding();

    public ICarComponent getComponent(int var1);

    public ISDISConnector getSDISConnector();

    public IDumpRegistry getDumpRegistry();

    public int getClimateSystemVariant();
}

