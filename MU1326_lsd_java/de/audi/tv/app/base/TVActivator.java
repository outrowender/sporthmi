/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.EvoConfiguration;
import de.audi.tv.app.base.TVAppCommon;
import de.audi.tv.app.base.TVAppEvo;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.interapp.MediaSourceActivatorWrapper;
import de.audi.tv.app.lists.TVEvoRowFactory;
import de.audi.tv.app.truffles.NullDSISearchDataProvider;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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

    protected void init(TVEnv tVEnv) {
        tVEnv.setRowFactory(new TVEvoRowFactory());
        tVEnv.setConfiguration(new EvoConfiguration());
        this.app = new TVAppEvo(tVEnv, this.bundleContext);
    }

    protected TVAppCommon getApp() {
        return this.app;
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.registerActionProxy(18, this.app.actionProxy);
        this.registerService((class$de$audi$atip$interapp$tv$ITVService == null ? (class$de$audi$atip$interapp$tv$ITVService = TVActivator.class$("de.audi.atip.interapp.tv.ITVService")) : class$de$audi$atip$interapp$tv$ITVService).getName(), (Object)this.app.tvServiceListener, (Dictionary)new Hashtable(0));
        this.registerService((class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = TVActivator.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler).getName(), (Object)this.app.presetHandler.definitionHandler, null);
        this.registerService((class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = TVActivator.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler).getName(), (Object)this.app.presetHandler.executionHandler, null);
        this.registerSearchListener();
        this.trackerMediaTVState = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = TVActivator.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener).getName(), (ServiceTrackerCustomizer)new MediaTVStateTracker());
        this.trackerMediaTVState.open();
        this.trackerSearchDSI = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$search$DSISearchDataProvider == null ? (class$org$dsi$ifc$search$DSISearchDataProvider = TVActivator.class$("org.dsi.ifc.search.DSISearchDataProvider")) : class$org$dsi$ifc$search$DSISearchDataProvider).getName(), (ServiceTrackerCustomizer)new SearchDSITracker());
        this.trackerSearchDSI.open();
        this.trackerMediaService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$media$IMediaService == null ? (class$de$audi$atip$interapp$media$IMediaService = TVActivator.class$("de.audi.atip.interapp.media.IMediaService")) : class$de$audi$atip$interapp$media$IMediaService).getName(), (ServiceTrackerCustomizer)new MediaServiceTracker());
        this.trackerMediaService.open();
    }

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

    private class SearchDSITracker
    extends DefaultServiceTrackerCustomizer {
        private SearchDSITracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = serviceReference.getProperty("DEVICE_INSTANCE");
            Object object2 = TVActivator.this.bundleContext.getService(serviceReference);
            if (object2 instanceof DSISearchDataProvider && object != null && ((Integer)object).intValue() == ((TVActivator)TVActivator.this).app.searchHandler.getSearchId()) {
                TVActivator.this.env.lcMain.log(1000000, "[Activator.SearchDSITracker.addingService] %1", object2);
                ((TVActivator)TVActivator.this).app.searchHandler.getSearchDataProvider().setDeviceService((DSIBase)object2);
                return object2;
            }
            TVActivator.this.bundleContext.ungetService(serviceReference);
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TVActivator.this.env.lcMain.log(1000000, "[Activator.SearchDSITracker.removedService] %1", object);
            ((TVActivator)TVActivator.this).app.searchHandler.getSearchDataProvider().setDeviceService(new NullDSISearchDataProvider(TVActivator.this.env.lcTruffles));
            TVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class MediaServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private MediaServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = TVActivator.this.bundleContext.getService(serviceReference);
            if (object instanceof IMediaService) {
                TVActivator.this.env.lcMain.log(1000000, "[Activator.MediaServiceTracker.addingService] %1", object);
                ((TVActivator)TVActivator.this).app.sourceActivatorAdapter.addSerivce(new MediaSourceActivatorWrapper((IMediaService)object));
                return object;
            }
            TVActivator.this.bundleContext.ungetService(serviceReference);
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TVActivator.this.env.lcMain.log(1000000, "[Activator.MediaServiceTracker.removedService] %1", object);
            ((TVActivator)TVActivator.this).app.sourceActivatorAdapter.removeService();
            TVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class MediaTVStateTracker
    extends DefaultServiceTrackerCustomizer {
        private MediaTVStateTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            Object object = TVActivator.this.bundleContext.getService(serviceReference);
            if (object instanceof ITVStateListener) {
                TVActivator.this.env.lcMain.log(1000000, "[Activator.MediaTVStateTracker.addingService] %1", object);
                ((TVActivator)TVActivator.this).app.tvStateProvider.addListener((ITVStateListener)object);
                return object;
            }
            TVActivator.this.bundleContext.ungetService(serviceReference);
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TVActivator.this.env.lcMain.log(1000000, "[Activator.MediaTVStateTracker.removedService] %1", object);
            ((TVActivator)TVActivator.this).app.tvStateProvider.removeListener((ITVStateListener)object);
            TVActivator.this.bundleContext.ungetService(serviceReference);
        }
    }
}

