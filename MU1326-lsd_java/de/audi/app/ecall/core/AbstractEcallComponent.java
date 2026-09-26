/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
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

public abstract class AbstractEcallComponent
implements IEcallComponent {
    private final IEcallApplication application;
    protected final LogChannel log;

    public AbstractEcallComponent(IEcallApplication iEcallApplication, String string) {
        this.application = iEcallApplication;
        this.log = iEcallApplication.getFrameworkAccess().getLogChannel(string);
    }

    @Override
    public void init() {
        this.initSubComponents();
    }

    @Override
    public void deinit() {
        this.deinitSubComponents();
    }

    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[0];
    }

    private void initSubComponents() {
        IEcallComponent[] iEcallComponentArray = this.getSubComponents();
        for (int i2 = 0; i2 < iEcallComponentArray.length; ++i2) {
            iEcallComponentArray[i2].init();
        }
    }

    private void deinitSubComponents() {
        IEcallComponent[] iEcallComponentArray = this.getSubComponents();
        if (iEcallComponentArray != null) {
            for (int i2 = 0; i2 < iEcallComponentArray.length; ++i2) {
                iEcallComponentArray[i2].deinit();
            }
        }
    }

    protected IEcallBapServiceAdapter getEcallBapServiceAdapter() {
        return this.getApplication().getEcallBapServiceAdapter();
    }

    protected IEcallApplication getApplication() {
        return this.application;
    }

    protected LogChannel getLogger() {
        return this.application.getEcallAppLogChannel();
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

