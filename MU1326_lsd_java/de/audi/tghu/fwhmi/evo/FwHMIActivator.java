/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi.evo;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.testsupport.OSDActivator;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.fwhmi.HMIOSDProvider;
import de.audi.tghu.fwhmi.MemoryOSDProvider;
import de.audi.tghu.fwhmi.evo.FwHMIActivator$1;
import de.audi.tghu.fwhmi.evo.FwHMIActivator$2;
import de.audi.tghu.fwhmi.evo.FwHMIEvo;
import de.audi.tghu.fwhmi.evo.MetricsTextHandler;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class FwHMIActivator
extends AbstractFrameworkActivator {
    private FwHMIEvo fwHMI;
    LogChannel logHMIServiceMain;
    private ServiceRegistration sregHMIService = null;
    private ServiceTracker swDiagTracker = null;
    private ServiceTracker sdsServiceTracker = null;
    private DumpInfoProvider hmiInfoProvider = null;
    private HMIOSDProvider osdData = null;
    private OSDActivator osdActivator = null;
    private MemoryOSDProvider memOsdData = null;
    private OSDActivator memOsdActivator = null;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public FwHMIActivator() {
        super("FwHMI");
    }

    public FwHMI getService() {
        return this.fwHMI;
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.logHMIServiceMain = this.framework.getLogChannel("Fw.HMIService.Main");
        this.logHMIServiceMain.log(-2137614336, "FwHMIActivator.startLastMode()");
        this.fwHMI = new FwHMIEvo(this.framework);
        this.fwHMI.init();
        AbstractMetrics.setTextHandler(new MetricsTextHandler(this.framework, this.fwHMI));
        AbstractMetrics.setFrameworkAccess(this.framework);
        this.fwHMI.getDisplayManager().start(bundleContext);
        this.sregHMIService = bundleContext.registerService(new String[]{(class$de$audi$atip$hmi$HMIService == null ? (class$de$audi$atip$hmi$HMIService = FwHMIActivator.class$("de.audi.atip.hmi.HMIService")) : class$de$audi$atip$hmi$HMIService).getName(), (class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = FwHMIActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName()}, (Object)this.fwHMI, null);
        this.hmiInfoProvider = this.fwHMI.createHMIInfoProvider();
        this.framework.getErrorMgr().registerDumpInfoProvider(this.hmiInfoProvider);
        this.swDiagTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = FwHMIActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)new FwHMIActivator$1(this));
        this.swDiagTracker.open();
        this.sdsServiceTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = FwHMIActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)new FwHMIActivator$2(this));
        this.sdsServiceTracker.open();
        this.osdData = new HMIOSDProvider(this.fwHMI.getEventDispatcherAdmin());
        this.osdActivator = new OSDActivator(this.osdData, true);
        this.osdActivator.start(bundleContext);
        this.memOsdData = new MemoryOSDProvider();
        this.memOsdActivator = new OSDActivator(this.memOsdData, true);
        this.memOsdActivator.start(bundleContext);
        this.logHMIServiceMain.log(-2137614336, "FwHMIActivator.start()");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.logHMIServiceMain.log(-2137614336, "FwHMIActivator.stop()");
        if (this.hmiInfoProvider != null) {
            this.framework.getErrorMgr().unregisterDumpInfoProvider(this.hmiInfoProvider);
            this.hmiInfoProvider = null;
        }
        if (this.sregHMIService != null) {
            this.sregHMIService.unregister();
            this.sregHMIService = null;
        }
        if (this.swDiagTracker != null) {
            this.swDiagTracker.close();
            this.swDiagTracker = null;
        }
        if (this.memOsdActivator != null) {
            this.memOsdActivator.stop(bundleContext);
            this.memOsdActivator = null;
        }
        this.memOsdData = null;
        if (this.osdActivator != null) {
            this.osdActivator.stop(bundleContext);
            this.osdActivator = null;
        }
        this.osdData = null;
        super.stop(bundleContext);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IFrameworkAccess access$000(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }

    static /* synthetic */ FwHMIEvo access$100(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.fwHMI;
    }

    static /* synthetic */ IFrameworkAccess access$200(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$300(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$400(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$500(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$600(FwHMIActivator fwHMIActivator) {
        return fwHMIActivator.framework;
    }
}

