/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.IWirelessChargingApplication;
import de.audi.app.wirelesscharging.core.IWirelessChargingComponent;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;

public abstract class AbstractWirelessChargingComponent
implements IWirelessChargingComponent {
    private final IWirelessChargingApplication application;
    protected final LogChannel log;

    public AbstractWirelessChargingComponent(IWirelessChargingApplication iWirelessChargingApplication, String string) {
        this.application = iWirelessChargingApplication;
        this.log = iWirelessChargingApplication.getFrameworkAccess().getLogChannel(string);
    }

    public void init() {
        this.initSubComponents();
    }

    public void deinit() {
        this.deinitSubComponents();
    }

    protected IWirelessChargingComponent[] getSubComponents() {
        return new IWirelessChargingComponent[0];
    }

    private void initSubComponents() {
        IWirelessChargingComponent[] iWirelessChargingComponentArray = this.getSubComponents();
        for (int i2 = 0; i2 < iWirelessChargingComponentArray.length; ++i2) {
            iWirelessChargingComponentArray[i2].init();
        }
    }

    private void deinitSubComponents() {
        IWirelessChargingComponent[] iWirelessChargingComponentArray = this.getSubComponents();
        if (iWirelessChargingComponentArray != null) {
            for (int i2 = 0; i2 < iWirelessChargingComponentArray.length; ++i2) {
                iWirelessChargingComponentArray[i2].deinit();
            }
        }
    }

    protected IWirelessChargingApplication getApplication() {
        return this.application;
    }

    protected LogChannel getLogger(String string) {
        return this.application.getFrameworkAccess().getLogChannel(string);
    }

    protected IFrameworkAccess getFrameworkAccess() {
        return this.application.getFrameworkAccess();
    }

    protected IHMIServiceApp getHmiServiceApp() {
        return this.getFrameworkAccess().getHmiServiceApp();
    }

    public MenuModelApp getMenuModel(int n) {
        return this.getHmiServiceApp().getMenuModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.getHmiServiceApp().getChoiceModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.getHmiServiceApp().getLabelModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.getHmiServiceApp().getRangeModel(n);
    }

    public ListModelApp getListModel(int n) {
        return this.getHmiServiceApp().getListModel(n);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return this.getHmiServiceApp().getBaseListModel(n);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.getHmiServiceApp().getButtonModel(n);
    }

    public OptionModelApp getOptionModel(int n) {
        return this.getHmiServiceApp().getOptionModel(n);
    }

    public MetricsModelApp getMetricsModel(int n) {
        return this.getHmiServiceApp().getMetricsModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.getHmiServiceApp().getSpellerModel(n);
    }

    public MatchspellerModelApp getMatchSpellerModel(int n) {
        return this.getHmiServiceApp().getMatchSpellerModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.getHmiServiceApp().getResourceLocatorModel(n);
    }

    public TiledListModelApp getTiledListModel(int n) {
        return this.getHmiServiceApp().getTiledListModel(n);
    }

    public AbstractMetrics getMetric(int n) {
        return this.getMetricsModel(n).getMetric();
    }

    public DateMetric getDateMetric(int n) {
        return (DateMetric)this.getHmiServiceApp().getMetricsModel(n).getMetric();
    }
}

