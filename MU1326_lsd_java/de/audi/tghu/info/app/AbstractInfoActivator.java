/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.info.AppInfoDiag
 */
package de.audi.tghu.info.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.tghu.info.app.InfoAPImpl;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.InfoHMIApplication;
import de.audi.tghu.info.app.InfoSdsService;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.InfoStorageManager;
import de.audi.tghu.info.app.tmc.TMCSimulationFacade;
import de.audi.tghu.info.app.tmc.readout.AppTMCReadOut;
import de.mib.swdiagnosis.info.AppInfoDiag;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractInfoActivator
extends AbstractActivator
implements ServiceTrackerCustomizer,
IGUIVariantProvider {
    protected LogChannel lc;
    protected AppTMC tmcApp;
    protected AppTMCReadOut appTmcReadOut;
    protected InfoAPImpl infoAp;
    protected ServiceTracker tracker;
    protected InfoHMIApplication infoHMIApplication;
    protected InfoStorageManager storageManager;
    protected InfoSdsService sdsService;
    static /* synthetic */ Class class$de$audi$tghu$info$app$InfoHMIApplication;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$navtmc$TMCService;
    static /* synthetic */ Class class$de$audi$atip$interapp$InfoService;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$maptmc$MapTmcService;
    static /* synthetic */ Class class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$icon$RenderingInfoProvider;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.tracker = this.closeTracker(this.tracker);
        this.tmcApp.stop();
        this.appTmcReadOut.stop();
        this.sdsService.stop();
        super.stop(bundleContext);
    }

    protected void registerServices() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", (class$de$audi$tghu$info$app$InfoHMIApplication == null ? (class$de$audi$tghu$info$app$InfoHMIApplication = AbstractInfoActivator.class$("de.audi.tghu.info.app.InfoHMIApplication")) : class$de$audi$tghu$info$app$InfoHMIApplication).getName());
        hashtable.put("moduleID", new Integer(this.infoHMIApplication.getId()));
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.registerService(new String[]{(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractInfoActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractInfoActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)this.infoHMIApplication, (Dictionary)hashtable);
        hashtable = new Hashtable();
        this.registerActionProxy(hashtable, this.infoAp);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractInfoActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.tmcApp.getTMCHandler(), (Dictionary)hashtable);
        if (this.framework.isFrontMU()) {
            hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractInfoActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.appTmcReadOut, (Dictionary)hashtable);
        }
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$navtmc$TMCService == null ? (class$de$audi$atip$interapp$navtmc$TMCService = AbstractInfoActivator.class$("de.audi.atip.interapp.navtmc.TMCService")) : class$de$audi$atip$interapp$navtmc$TMCService).getName());
        this.registerService((class$de$audi$atip$interapp$navtmc$TMCService == null ? (class$de$audi$atip$interapp$navtmc$TMCService = AbstractInfoActivator.class$("de.audi.atip.interapp.navtmc.TMCService")) : class$de$audi$atip$interapp$navtmc$TMCService).getName(), (Object)this.tmcApp, (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$de$audi$atip$interapp$InfoService == null ? (class$de$audi$atip$interapp$InfoService = AbstractInfoActivator.class$("de.audi.atip.interapp.InfoService")) : class$de$audi$atip$interapp$InfoService).getName());
        this.registerService((class$de$audi$atip$interapp$InfoService == null ? (class$de$audi$atip$interapp$InfoService = AbstractInfoActivator.class$("de.audi.atip.interapp.InfoService")) : class$de$audi$atip$interapp$InfoService).getName(), (Object)this.sdsService, (Dictionary)hashtable);
        if (System.getProperty("TmcSim") != null) {
            hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(0));
            this.registerService((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), (Object)new TMCSimulationFacade(this.tmcApp.getTMCHandler(), this.framework), (Dictionary)hashtable);
        }
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractInfoActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.storageManager, null);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractInfoActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.tmcApp, null);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_TMC_LIST);
        hashtable.put("ApplicationName", "TMC_LIST");
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT);
        hashtable.put("ApplicationName", "TMC_ONROAD_ONROUTE_URGENT");
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractInfoActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.tmcApp.getReadOutApp().getSync(), (Dictionary)hashtable);
        hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL);
        hashtable.put("ApplicationName", "TMC_ONROAD_ONROUTE_URGENT_NO_TEL");
        this.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = AbstractInfoActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.tmcApp.getReadOutApp().getSync(), (Dictionary)hashtable);
    }

    protected void initTracker() {
        ArrayList arrayList = new ArrayList(13);
        arrayList.add((class$de$audi$atip$interapp$maptmc$MapTmcService == null ? (class$de$audi$atip$interapp$maptmc$MapTmcService = AbstractInfoActivator.class$("de.audi.atip.interapp.maptmc.MapTmcService")) : class$de$audi$atip$interapp$maptmc$MapTmcService).getName());
        arrayList.add((class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractInfoActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName());
        arrayList.add((class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = AbstractInfoActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName());
        arrayList.add((class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = AbstractInfoActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName());
        arrayList.add((class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractInfoActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName());
        arrayList.add((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName());
        arrayList.add((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractInfoActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName());
        if (this.framework.isFrontMU()) {
            arrayList.add((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName());
        }
        this.tracker = new ServiceTracker(this.bundleContext, (String[])arrayList.toArray(new String[0]), (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (this.tmcApp == null) {
            this.lc.log(-2137614336, "[InfoActivator#addingService] tmcApp is null, abort adding ServiceReference=%1", (Object)serviceReference);
            return null;
        }
        if (this.appTmcReadOut == null) {
            this.lc.log(-2137614336, "[InfoActivator#addingService] appTmcReadOut is null, abort adding ServiceReference=%1", (Object)serviceReference);
            return null;
        }
        String string = (String)serviceReference.getProperty("DEVICE_NAME");
        String string2 = (String)serviceReference.getProperty("ApplicationName");
        Object object = this.bundleContext.getService(serviceReference);
        if (string2 != null && string2.equals("AppNavi")) {
            this.tmcApp.setNaviService((NaviService)object);
        } else if (string != null && string.equals((class$de$audi$atip$interapp$maptmc$MapTmcService == null ? (class$de$audi$atip$interapp$maptmc$MapTmcService = AbstractInfoActivator.class$("de.audi.atip.interapp.maptmc.MapTmcService")) : class$de$audi$atip$interapp$maptmc$MapTmcService).getName())) {
            this.tmcApp.setMapService((MapTmcService)object);
        } else if (string != null && string.equals((class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName())) {
            this.tmcApp.setTmcService((DSIBase)object);
        } else if (string != null && string.equals((class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = AbstractInfoActivator.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName())) {
            this.appTmcReadOut.setTmcOnRoute((DSITmcOnRoute)object);
        } else if (string != null && string.equals((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractInfoActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName())) {
            this.tmcApp.getRowBuilder().setRenderingInfoProvider((RenderingInfoProvider)object);
            this.appTmcReadOut.getUrgentPopupHandler().getRowBuilder().setRenderingInfoProvider((RenderingInfoProvider)object);
        } else if (string != null && string.equals((class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractInfoActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName())) {
            this.tmcApp.setPreviewMap((IPreviewMap)object);
        } else {
            if (object instanceof TTSService) {
                Integer n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                switch (n) {
                    case 2: 
                    case 3: 
                    case 4: 
                    case 9: {
                        this.lc.log(-2137614336, "[InfoActivator#addingService] assigning TTSService client id : %1", (Object)n);
                        this.tmcApp.setTTSService((TTSService)object, n);
                        return object;
                    }
                }
                this.lc.log(-2137614336, "[InfoActivator#addingService] unwanted TTSService client id : %1", (Object)n);
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
            if (object instanceof SwDiagnosisManager) {
                ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new AppInfoDiag(this.tmcApp, this.appTmcReadOut));
            } else {
                this.lc.log(-1601830656, "unhandled service: %1", (Object)string);
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.lc.log(-2137614336, "InfoActivator#removedService(): reference %1, object %2", (Object)serviceReference, object);
        if (this.tmcApp == null) {
            this.lc.log(-2137614336, "[InfoActivator#removedService] tmcApp is null, abort removedService ServiceReference=%1, object %2", (Object)serviceReference, object);
            return;
        }
        if (this.appTmcReadOut == null) {
            this.lc.log(-2137614336, "[InfoActivator#removedService] appTmcReadOut is null, abort removedService ServiceReference=%1, object %2", (Object)serviceReference, object);
            return;
        }
        try {
            if (object instanceof DSITmc) {
                this.tmcApp.releaseTmcService();
                this.bundleContext.ungetService(serviceReference);
            } else if (object instanceof DSITmcOnRoute) {
                this.appTmcReadOut.releaseTmcOnRoute();
                this.bundleContext.ungetService(serviceReference);
            } else {
                String string = (String)serviceReference.getProperty("DEVICE_NAME");
                String string2 = (String)serviceReference.getProperty("ApplicationName");
                Object object2 = object;
                if (string2 != null && string2.equals("AppNavi")) {
                    this.tmcApp.setNaviService(null);
                } else if (string != null && string.equals((class$de$audi$atip$interapp$maptmc$MapTmcService == null ? (class$de$audi$atip$interapp$maptmc$MapTmcService = AbstractInfoActivator.class$("de.audi.atip.interapp.maptmc.MapTmcService")) : class$de$audi$atip$interapp$maptmc$MapTmcService).getName())) {
                    this.tmcApp.setMapService(null);
                } else if (string != null && string.equals((class$de$audi$atip$interapp$icon$RenderingInfoProvider == null ? (class$de$audi$atip$interapp$icon$RenderingInfoProvider = AbstractInfoActivator.class$("de.audi.atip.interapp.icon.RenderingInfoProvider")) : class$de$audi$atip$interapp$icon$RenderingInfoProvider).getName())) {
                    this.tmcApp.getRowBuilder().setRenderingInfoProvider(null);
                    this.appTmcReadOut.getUrgentPopupHandler().getRowBuilder().setRenderingInfoProvider(null);
                } else if (string != null && string.equals((class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap == null ? (class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap = AbstractInfoActivator.class$("de.audi.atip.interapp.navigation.previewmap.IPreviewMap")) : class$de$audi$atip$interapp$navigation$previewmap$IPreviewMap).getName())) {
                    this.tmcApp.setPreviewMap(null);
                } else if (object2 instanceof TTSService) {
                    Integer n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                    switch (n) {
                        case 2: 
                        case 3: 
                        case 4: 
                        case 9: {
                            this.lc.log(-2137614336, "[InfoActivator#removedService] removing TTSService client id : %1", (Object)n);
                            this.tmcApp.setTTSService(null, n);
                            break;
                        }
                        default: {
                            this.lc.log(-2137614336, "[InfoActivator#removedService] unwanted TTSService client id : %1", (Object)n);
                            break;
                        }
                    }
                } else if (object2 instanceof SwDiagnosisManager) {
                    ((SwDiagnosisManager)object2).removeDiagGateway((AbstractSwDiagnosis)new AppInfoDiag(null, null));
                } else {
                    this.lc.log(-1601830656, "unhandled service: %1", (Object)string);
                }
            }
        }
        finally {
            this.bundleContext.ungetService(serviceReference);
        }
    }

    protected abstract InfoAPImpl createActionProxy(InfoEnv infoEnv, AppTMC appTMC, LogChannel logChannel) {
    }

    protected abstract void registerActionProxy(Hashtable hashtable, InfoAPImpl infoAPImpl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

