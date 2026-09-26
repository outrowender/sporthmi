/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings;

import de.audi.app.settings.etc.ETCHandler;
import de.audi.app.settings.licensebrowser.ILicenseBrowser;
import de.audi.app.settings.licensebrowser.LicenseBrowserIntegration;
import de.audi.app.settings.licensebrowser.LicenseBrowserStdIntegration;
import de.audi.app.settings.reset.FactoryResetHandler;
import de.audi.app.settings.time.TimeHandler;
import de.audi.app.settings.timeunitslang.UnitHandler;
import de.audi.app.settings.timeunitslang.dsi.DSICarComfortManager;
import de.audi.app.settings.timeunitslang.dsi.DSICarTimeUnitsLanguageManager;
import de.audi.app.settings.timeunitslang.dsi.NavigationListener;
import de.audi.app.settings.utils.VariantMapper;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.storage.IStorageAccess;
import org.osgi.framework.BundleContext;

public class SettingsEnv {
    public static final int VISIBLE;
    public static final int INVISIBLE;
    public static final int DISABLED;
    public static final int DISABLED_WITH_REASON;
    private final VariantMapper variantMapper = new VariantMapper();
    private IFrameworkAccess fw;
    private ILicenseBrowser licenseBrowser;
    private FactoryResetHandler factoryResetHandler;
    private DSICarTimeUnitsLanguageManager dsiManager;
    private DSICarComfortManager dsiCarComfortManager;
    private NavigationListener naviListener;
    private BundleContext context;
    private UnitHandler unitHandler;
    private TimeHandler timeHandler;
    private ETCHandler etcHandler;
    private float[] timeZoneOffsets;

    public BundleContext getContext() {
        return this.context;
    }

    public VariantMapper getVariantMapper() {
        return this.variantMapper;
    }

    public void init(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.fw = iFrameworkAccess;
        this.context = bundleContext;
        this.licenseBrowser = this.fw.getSysConst(523) == 1 ? new LicenseBrowserIntegration(this) : new LicenseBrowserStdIntegration(this);
        this.factoryResetHandler = new FactoryResetHandler(this);
        this.timeHandler = new TimeHandler(this);
        this.unitHandler = new UnitHandler(this, this.timeHandler);
        this.dsiManager = new DSICarTimeUnitsLanguageManager(this);
        this.dsiCarComfortManager = new DSICarComfortManager(this);
        this.naviListener = new NavigationListener(this);
        this.fw.getAppStateMgr().registerComponentStateListener(this.factoryResetHandler);
        if (this.isETCAvailable()) {
            this.etcHandler = new ETCHandler(this);
        }
    }

    public void deinit() {
        if (this.etcHandler != null) {
            this.etcHandler.cleanup();
            this.etcHandler = null;
        }
        this.fw.getAppStateMgr().unregisterComponentStateListener(this.factoryResetHandler);
    }

    public IFrameworkAccess getFw() {
        return this.fw;
    }

    public boolean isSDISAvailable() {
        return this.getFw().isSDISEnabled();
    }

    public ILicenseBrowser getLicenseBrowser() {
        return this.licenseBrowser;
    }

    public UnitHandler getUnitHandler() {
        return this.unitHandler;
    }

    public TimeHandler getTimeHandler() {
        return this.timeHandler;
    }

    public ETCHandler getEtcHandler() {
        return this.etcHandler;
    }

    public DSICarTimeUnitsLanguageManager getDSIManager() {
        return this.dsiManager;
    }

    public DSICarComfortManager getDSICarComfortManager() {
        return this.dsiCarComfortManager;
    }

    public NavigationListener getNavigationListener() {
        return this.naviListener;
    }

    public FactoryResetHandler getFactoryResetHandler() {
        return this.factoryResetHandler;
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.fw.getHmiServiceApp().getButtonModel(n);
    }

    public SpellerModelApp getSpeller(int n) {
        return this.fw.getHmiServiceApp().getSpellerModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.fw.getHmiServiceApp().getRangeModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.fw.getHmiServiceApp().getChoiceModel(n);
    }

    public MetricsModelApp getMetricsModel(int n) {
        return this.fw.getHmiServiceApp().getMetricsModel(n);
    }

    public ListModelApp getListModel(int n) {
        return this.fw.getHmiServiceApp().getListModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.fw.getHmiServiceApp().getLabelModel(n);
    }

    public DateMetric getDateMetric(int n) {
        return (DateMetric)this.fw.getHmiServiceApp().getMetricsModel(n).getMetric();
    }

    public Temperature getTemperatureMetric(int n) {
        return (Temperature)this.fw.getHmiServiceApp().getMetricsModel(n).getMetric();
    }

    public boolean isETCAvailable() {
        return this.fw.getSysConst(4325) == 1;
    }

    public int getETCCardRemiderTimeout() {
        int n = this.fw.getSysConst(4372);
        if (n <= 0) {
            n = 1625948160;
        }
        return n;
    }

    public IStorageAccess getStorageMgr() {
        return this.fw.getStorageMgr();
    }

    public void setTimeZoneOffsets(float[] fArray) {
        this.timeZoneOffsets = fArray;
    }

    public float[] getTimeZoneOffsets() {
        return this.timeZoneOffsets;
    }
}

