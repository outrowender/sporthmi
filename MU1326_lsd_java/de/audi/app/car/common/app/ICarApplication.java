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
    public static final int MODULE_ID_CAR;
    public static final int MODULE_ID_SETTINGS;
    public static final int MODULE_ID_EARLY_FUNC;
    public static final String MODULE_NAME_CAR;
    public static final String MODULE_NAME_SETTINGS;
    public static final String MODULE_NAME_EARLY_FUNC;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void startDSIServiceForComponent(String string, int n) {
    }

    default public int getId() {
    }

    default public String getApplicationName() {
    }

    default public LogChannel getLogChannel() {
    }

    default public LogChannel getMerLogChannel() {
    }

    default public BundleContext getBundleContext() {
    }

    default public IActionProxyDispatcher getActionProxyDispatcher() {
    }

    default public IMessageDispatcher getMessageDispatcher() {
    }

    default public DispatcherBase getJobDispatcher() {
    }

    default public IFrameworkAccess getFrameworkAccess() {
    }

    default public IMenuEntryRegistry getMenuEntryRegistry() {
    }

    default public IPopupStateDispatcher getScreenStateDispatcher() {
    }

    default public IPowerEventDispatcher getPowerEventDispatcher() {
    }

    default public ILanguageUpdateDispatcher getLanguageUpdateDispatcher() {
    }

    default public CarFuncAdap getCarMenuCoding() {
    }

    default public ICarComponent getComponent(int n) {
    }

    default public ISDISConnector getSDISConnector() {
    }

    default public IDumpRegistry getDumpRegistry() {
    }

    default public int getClimateSystemVariant() {
    }
}

