/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.EvoConfiguration;
import de.audi.tv.app.base.TVActivator$MediaServiceTracker;
import de.audi.tv.app.base.TVActivator$MediaTVStateTracker;
import de.audi.tv.app.base.TVActivator$SearchDSITracker;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVAppEvo;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.TVEvoRowFactory;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TVActivator
extends AbstractTVActivator {
    private TVAppEvo app;
    private ServiceTracker trackerMediaTVState;
    private ServiceTracker trackerSearchDSI;
    private ServiceTracker trackerMediaService;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVService;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVStateListener;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaService;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    @Override
    protected void init(TVEnv tVEnv) {
        tVEnv.setRowFactory(new TVEvoRowFactory());
        tVEnv.setConfiguration(new EvoConfiguration());
        this.app = new TVAppEvo(tVEnv, this.bundleContext);
    }

    @Override
    protected TVAppCommon getApp() {
        return this.app;
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.registerActionProxy(18, this.app.actionProxy);
        this.registerService((class$de$audi$atip$interapp$tv$ITVService == null ? (class$de$audi$atip$interapp$tv$ITVService = TVActivator.class$("de.audi.atip.interapp.tv.ITVService")) : class$de$audi$atip$interapp$tv$ITVService).getName(), (Object)this.app.tvServiceListener, (Dictionary)new Hashtable(0));
        this.registerService((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = TVActivator.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (Object)this.app.presetHandler.definitionHandler, null);
        this.registerService((class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = TVActivator.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), (Object)this.app.presetHandler.executionHandler, null);
        this.registerSearchListener();
        this.trackerMediaTVState = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = TVActivator.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener).getName(), (ServiceTrackerCustomizer)new TVActivator$MediaTVStateTracker(this, null));
        this.trackerMediaTVState.open();
        this.trackerSearchDSI = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = TVActivator.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), (ServiceTrackerCustomizer)new TVActivator$SearchDSITracker(this, null));
        this.trackerSearchDSI.open();
        this.trackerMediaService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = TVActivator.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService).getName(), (ServiceTrackerCustomizer)new TVActivator$MediaServiceTracker(this, null));
        this.trackerMediaService.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.trackerMediaTVState = this.closeTracker(this.trackerMediaTVState);
        this.trackerSearchDSI = this.closeTracker(this.trackerSearchDSI);
        this.trackerMediaService = this.closeTracker(this.trackerMediaService);
        this.app.deinit();
        super.stop(bundleContext);
    }

    private void registerSearchListener() {
        this.registerDSIListener(class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = TVActivator.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener, this.app.searchHandler.getSearchDataProvider(), this.app.searchHandler.getSearchId());
        if (!this.app.searchHandler.getSearchDataProvider().isDsiFound()) {
            this.framework.startDSIService((class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = TVActivator.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), this.app.searchHandler.getSearchId());
            this.framework.getStartupMgr().logStartupEvent("[TV] startDSIService(DSISearchDataProvider)");
        }
    }

    protected void registerDSIListener(Class clazz, DSIListener dSIListener, int n) {
        String string = clazz.getName();
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", new Integer(n));
        this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TVActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ BundleContext access$300(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ TVAppEvo access$400(TVActivator tVActivator) {
        return tVActivator.app;
    }

    static /* synthetic */ BundleContext access$500(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$600(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$700(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$800(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$900(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1000(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1100(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$1200(TVActivator tVActivator) {
        return tVActivator.bundleContext;
    }
}

