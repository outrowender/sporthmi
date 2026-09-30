/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.swdl.AbstractSwdlDiagnosisGateway
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.engineering.fsc.IFSCService;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem;
import de.audi.tghu.swdl.app.AbstractSwdlActionProxy;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractCustDownloadActionProxy;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.mib.swdiagnosis.swdl.AbstractSwdlDiagnosisGateway;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdllogging.DSISwdlLogging;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelection;
import org.dsi.ifc.uota.DSIUotA;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractSWDLActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    protected SwdlEnv swdlEnv;
    protected AbstractSwdlDiagnosisGateway swdlDiagnosisGateway;
    protected AbstractSwdlActionProxy swdlActionProxy;
    private ServiceTracker tracker;
    protected SwdlDSIManager swdlDSIManager;
    protected HMISwitcher hmiSwitcher;
    protected AbstractCustDownloadActionProxy abstractCustDownloadActionProxy;
    protected AbstractPopupManager abstractPopupManager;
    protected AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState;
    static /* synthetic */ Class class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyClient;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener;
    static /* synthetic */ Class class$org$dsi$ifc$uota$DSIUotAListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgress;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLogging;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyManager;
    static /* synthetic */ Class class$de$audi$atip$engineering$fsc$IFSCService;
    static /* synthetic */ Class class$org$dsi$ifc$uota$DSIUotA;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        if (null != this.tracker) {
            this.tracker.close();
            this.tracker = null;
        }
    }

    public final Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        if (object instanceof DSISwdlDeviceInfo) {
            this.swdlDSIManager.setSwdlDeviceInfoDSI((DSISwdlDeviceInfo)object);
        } else if (object instanceof DSISwdlSelection) {
            this.swdlDSIManager.setSwdlSelectionDSI((DSISwdlSelection)object);
        } else if (object instanceof DSISwdlProgress) {
            this.swdlDSIManager.setSwdlProgressDSI((DSISwdlProgress)object);
        } else if (object instanceof DSISwdlLogging) {
            this.swdlDSIManager.setSwdlLoggingDSI((DSISwdlLogging)object);
        } else if (object instanceof DSIUotA) {
            this.swdlDSIManager.setSwdlUotaDSI((DSIUotA)object);
        } else if (object instanceof IFSCService) {
            this.swdlEnv.setFscService((IFSCService)object);
        } else if (object instanceof CombiBAPServiceSystem) {
            this.swdlEnv.setCombiBAPServiceSystem((CombiBAPServiceSystem)object);
        } else if (object instanceof IBulkCopyManager) {
            this.swdlEnv.getBulkCopyAccess().setBulkCopyManager((IBulkCopyManager)object);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.getDiagnosisGateway());
        } else if (object instanceof DSINavigation) {
            if (null != this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler()) {
                this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler().addService(object);
            }
        } else {
            this.getBundleContext().ungetService(serviceReference);
            this.swdlEnv.getLogDSI().log(10000, "[SwdlActivator] adding unwanted service!");
            return null;
        }
        this.swdlEnv.getLogDSI().log(10000000, "[SwdlActivator] added service = %1", object);
        return object;
    }

    public final void removedService(ServiceReference serviceReference, Object object) {
        if (this.swdlDSIManager.getDeviceInfoDSIHandler().equalsDSI(object)) {
            this.swdlDSIManager.setSwdlDeviceInfoDSI(null);
        } else if (this.swdlDSIManager.getSelectionDSIHandler().equalsDSI(object)) {
            this.swdlDSIManager.setSwdlSelectionDSI(null);
        } else if (this.swdlDSIManager.getProgressDSIHandler().equalsDSI(object)) {
            this.swdlDSIManager.setSwdlProgressDSI(null);
        } else if (this.swdlDSIManager.getLoggingDSIHandler().equalsDSI(object)) {
            this.swdlDSIManager.setSwdlLoggingDSI(null);
        } else if (this.swdlDSIManager.getUotaDSIHandler().equalsDSI(object)) {
            this.abstractPopupManager.removePopupListener(this.swdlDSIManager.getUotaDSIHandler());
            this.swdlDSIManager.setSwdlUotaDSI(null);
        } else if (object.equals(this.swdlEnv.getFscService())) {
            this.swdlEnv.setFscService(null);
        } else if (object.equals(this.swdlEnv.getCombiBAPServiceSystem())) {
            this.swdlEnv.setCombiBAPServiceSystem(null);
        } else if (null != this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler() && this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler().equalsDSI(object)) {
            this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler().removeService(object);
        } else {
            return;
        }
        this.getBundleContext().ungetService(serviceReference);
    }

    protected final void registerBaseServices() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager = AbstractSWDLActivator.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager).getName());
        this.registerService(new String[]{(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractSWDLActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName()}, (Object)this.abstractPopupManager, (Dictionary)hashtable);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("ApplicationName", (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager == null ? (class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager = AbstractSWDLActivator.class$("de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager")) : class$de$audi$tghu$swdl$app$hmiswitcher$manager$AbstractPopupManager).getName());
        this.registerService(new String[]{(class$de$audi$atip$bulkcopy$IBulkCopyClient == null ? (class$de$audi$atip$bulkcopy$IBulkCopyClient = AbstractSWDLActivator.class$("de.audi.atip.bulkcopy.IBulkCopyClient")) : class$de$audi$atip$bulkcopy$IBulkCopyClient).getName()}, (Object)this.swdlEnv.getBulkCopyAccess(), (Dictionary)hashtable2);
        Hashtable hashtable3 = new Hashtable();
        hashtable3.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = AbstractSWDLActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.abstractCustDownloadActionProxy, (Dictionary)hashtable3);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getDeviceInfoDSIHandler(), (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = AbstractSWDLActivator.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getLoggingDSIHandler(), (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener = AbstractSWDLActivator.class$("org.dsi.ifc.swdllogging.DSISwdlLoggingListener")) : class$org$dsi$ifc$swdllogging$DSISwdlLoggingListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getProgressDSIHandler(), (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = AbstractSWDLActivator.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener).getName(), 0);
        this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getSelectionDSIHandler(), (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = AbstractSWDLActivator.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener).getName(), 0);
        if (this.swdlEnv.isUpdateOverTheAirFeatureEnabled() && this.swdlDSIManager.getUotaDSIHandler().getUotaDSIListener() != null) {
            this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getUotaDSIHandler().getUotaDSIListener(), (class$org$dsi$ifc$uota$DSIUotAListener == null ? (class$org$dsi$ifc$uota$DSIUotAListener = AbstractSWDLActivator.class$("org.dsi.ifc.uota.DSIUotAListener")) : class$org$dsi$ifc$uota$DSIUotAListener).getName(), 0);
            if (this.swdlEnv.isUotaNavDBMergeProcessNeeded()) {
                this.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = AbstractSWDLActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.swdlDSIManager.getUotaDSIHandler().getMapIntegrationDSIHandler(), (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractSWDLActivator.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName(), 0);
            }
            this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractSWDLActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.swdlDSIManager.getUotaDSIHandler(), null);
            this.abstractPopupManager.addPopupListener(this.swdlDSIManager.getUotaDSIHandler());
        }
    }

    protected final void initTracker() {
        String[] stringArray = new String[]{(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractSWDLActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = AbstractSWDLActivator.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo).getName(), (class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = AbstractSWDLActivator.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection).getName(), (class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = AbstractSWDLActivator.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress).getName(), (class$org$dsi$ifc$swdllogging$DSISwdlLogging == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLogging = AbstractSWDLActivator.class$("org.dsi.ifc.swdllogging.DSISwdlLogging")) : class$org$dsi$ifc$swdllogging$DSISwdlLogging).getName(), (class$de$audi$atip$bulkcopy$IBulkCopyManager == null ? (class$de$audi$atip$bulkcopy$IBulkCopyManager = AbstractSWDLActivator.class$("de.audi.atip.bulkcopy.IBulkCopyManager")) : class$de$audi$atip$bulkcopy$IBulkCopyManager).getName(), (class$de$audi$atip$engineering$fsc$IFSCService == null ? (class$de$audi$atip$engineering$fsc$IFSCService = AbstractSWDLActivator.class$("de.audi.atip.engineering.fsc.IFSCService")) : class$de$audi$atip$engineering$fsc$IFSCService).getName(), (class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = AbstractSWDLActivator.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA).getName(), (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem = AbstractSWDLActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem).getName()};
        String[] stringArray2 = new String[]{(class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = AbstractSWDLActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = AbstractSWDLActivator.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo).getName(), (class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = AbstractSWDLActivator.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection).getName(), (class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = AbstractSWDLActivator.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress).getName(), (class$org$dsi$ifc$swdllogging$DSISwdlLogging == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLogging = AbstractSWDLActivator.class$("org.dsi.ifc.swdllogging.DSISwdlLogging")) : class$org$dsi$ifc$swdllogging$DSISwdlLogging).getName(), (class$de$audi$atip$bulkcopy$IBulkCopyManager == null ? (class$de$audi$atip$bulkcopy$IBulkCopyManager = AbstractSWDLActivator.class$("de.audi.atip.bulkcopy.IBulkCopyManager")) : class$de$audi$atip$bulkcopy$IBulkCopyManager).getName(), (class$de$audi$atip$engineering$fsc$IFSCService == null ? (class$de$audi$atip$engineering$fsc$IFSCService = AbstractSWDLActivator.class$("de.audi.atip.engineering.fsc.IFSCService")) : class$de$audi$atip$engineering$fsc$IFSCService).getName(), (class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = AbstractSWDLActivator.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA).getName(), (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractSWDLActivator.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem = AbstractSWDLActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSystem).getName()};
        String[] stringArray3 = this.swdlEnv.isUotaNavDBMergeProcessNeeded() ? stringArray2 : stringArray;
        this.tracker = new ServiceTracker(this.getBundleContext(), stringArray3, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    protected abstract AbstractSwdlDiagnosisGateway getDiagnosisGateway();

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

