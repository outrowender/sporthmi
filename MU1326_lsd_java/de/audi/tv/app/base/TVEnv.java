/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DataModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.hmi.modelaccess.VirtualButtonModelApp;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.tv.app.base.IConfiguration;
import de.audi.tv.app.base.PropertyBank;
import de.audi.tv.app.base.TVEnv$1;
import de.audi.tv.app.base.TVEnv$TvLoggingPropertyFactory;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.varext.DefaultTvVariantExt;
import de.audi.tv.app.varext.ITvVariantExt;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TVEnv {
    public final IFrameworkAccess framework;
    public final PropertyBank properties;
    public final DispatcherBase dispatchBase;
    public final IDispatcher dispatch;
    public final PropertyFactory propertyFactory;
    public final ModelBindings modelBindings;
    public final LogChannel lcDSI;
    public final LogChannel lcMain;
    public final LogChannel lcHMI;
    public final LogChannel lcAudio;
    final LogChannel lcInterapp;
    public final LogChannel lcCombi;
    final LogChannel lcCmd;
    public final LogChannel lcTruffles;
    final LogChannel lcSDS;
    private ITVRowFactory rowFactory = null;
    private ITvVariantExt varExt = new DefaultTvVariantExt();
    private IConfiguration configuration = new TVEnv$1(this);
    private final SimpleIntObjectMap internalModels = new SimpleIntObjectMap();

    public TVEnv(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.lcAudio = iFrameworkAccess.getLogChannel("App.TV.Audio");
        this.lcCombi = iFrameworkAccess.getLogChannel("App.TV.Combi");
        this.lcDSI = iFrameworkAccess.getLogChannel("App.TV.DSI");
        this.lcHMI = iFrameworkAccess.getLogChannel("App.TV.HMI");
        this.lcInterapp = iFrameworkAccess.getLogChannel("App.TV.Interapp");
        this.lcMain = iFrameworkAccess.getLogChannel("App.TV.Main");
        this.lcCmd = iFrameworkAccess.getLogChannel("App.TV.Cmd");
        this.lcTruffles = iFrameworkAccess.getLogChannel("App.TV.Truffles");
        this.lcSDS = iFrameworkAccess.getLogChannel("App.TV.SDS");
        this.propertyFactory = new TVEnv$TvLoggingPropertyFactory(this, this.lcMain, -2137614336);
        this.properties = new PropertyBank(this.propertyFactory);
        this.modelBindings = SilentModelBindings.create();
        this.dispatchBase = iFrameworkAccess.getDispatcherManager().createDispatcher("TV", new JobLogger(this.lcCmd));
        this.dispatchBase.start();
        this.dispatch = this.wrapDispatcher(this.dispatchBase);
    }

    void registerSpeedThresholdListener(SpeedThresholdListener speedThresholdListener, int n) {
        this.framework.getSysApp().registerSpeedThresholdListener(speedThresholdListener, n);
    }

    public int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    public IHMIServiceApp getHMIService() {
        return this.framework.getHmiServiceApp();
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.getHMIService().getButtonModel(n);
    }

    public LabelModelApp getLabelModel(int n) {
        return this.getHMIService().getLabelModel(n);
    }

    public LabelModelApp getLabelModel(int n, int n2) {
        return this.getHMIService().getLabelModel(n, n2);
    }

    public BaseListModelApp getBaseListModel(int n) {
        return this.getHMIService().getBaseListModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.getHMIService().getChoiceModel(n);
    }

    public RangeModelApp getRangeModel(int n) {
        return this.getHMIService().getRangeModel(n);
    }

    public OptionModelApp getOptionModel(int n) {
        return this.getHMIService().getOptionModel(n);
    }

    public VirtualButtonModelApp getVirtualButtonModelModel(int n) {
        return this.getHMIService().getVirtualButtonModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.getHMIService().getSpellerModel(n);
    }

    public MetricsModelApp getMetricsModel(int n) {
        return this.getHMIService().getMetricsModel(n);
    }

    public PropertyModelApp getPropertyModel(int n) {
        return this.getHMIService().getPropertyModel(n);
    }

    public MenuModelApp getMenuModel(int n) {
        return this.getHMIService().getMenuModel(n);
    }

    public DataModelApp getDataModel(int n) {
        return this.getHMIService().getDataModel(n);
    }

    public ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.getHMIService().getResourceLocatorModel(n);
    }

    public DynamicListModelApp getDynamicListModel(int n) {
        return this.getHMIService().getDynamicListModel(n);
    }

    public DynamicListModelApp getDynamicListModel(int n, int n2) {
        return this.getHMIService().getDynamicListModel(n, n2);
    }

    public BaseListModelApp getInternalBaseListModel(int n) {
        BaseListModelApp baseListModelApp = (BaseListModelApp)this.internalModels.get(n);
        if (baseListModelApp == null) {
            baseListModelApp = new BaseListModel(n);
            this.internalModels.add(n, baseListModelApp);
        }
        return baseListModelApp;
    }

    public MsgDistributor getMsgDistributor() {
        return this.framework.getMsgDistrib();
    }

    public void setRowFactory(ITVRowFactory iTVRowFactory) {
        if (this.rowFactory == null) {
            this.rowFactory = iTVRowFactory;
        } else {
            this.lcMain.log(10000, "The row factory was already set!");
        }
    }

    public ITVRowFactory getRowFactory() {
        return this.rowFactory;
    }

    public void setVariantExt(ITvVariantExt iTvVariantExt) {
        if (iTvVariantExt == null) {
            iTvVariantExt = new DefaultTvVariantExt();
        }
        this.varExt = iTvVariantExt;
    }

    public ITvVariantExt getVarExt() {
        return this.varExt;
    }

    public void setConfiguration(IConfiguration iConfiguration) {
        this.configuration = iConfiguration;
    }

    public IConfiguration getConfiguration() {
        return this.configuration;
    }

    protected IDispatcher wrapDispatcher(DispatcherBase dispatcherBase) {
        return new DispatcherBaseAdapter(dispatcherBase);
    }
}

