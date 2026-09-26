/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.agent.AgentActivator$1;
import de.audi.atip.agent.AgentService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class AgentActivator
extends AbstractActivator {
    private LogChannel log = null;
    private AgentService agentService = null;
    private ServiceRegistration sregAgent = null;
    private ServiceTracker agentTracker = null;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$error$DumpInfoProvider;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    private final void logStartupEvent(String string) {
        this.getFramework().getStartupMgr().logStartupEvent(string);
    }

    @Override
    public final void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("Fw.Agent.Activator");
        if (!this.getFramework().isSDISEnabled()) {
            return;
        }
        try {
            this.logStartupEvent("start Agent service");
            this.agentService = new AgentService(this.getFramework());
            this.sregAgent = bundleContext.registerService((class$de$esolutions$fw$util$commons$error$DumpInfoProvider == null ? (class$de$esolutions$fw$util$commons$error$DumpInfoProvider = AgentActivator.class$("de.esolutions.fw.util.commons.error.DumpInfoProvider")) : class$de$esolutions$fw$util$commons$error$DumpInfoProvider).getName(), (Object)this.agentService, null);
            this.agentTracker = new ServiceTracker(bundleContext, new String[]{(class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = AgentActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName()}, (ServiceTrackerCustomizer)new AgentActivator$1(this, bundleContext));
            this.agentTracker.open();
            this.logStartupEvent("started Agent service tracker");
        }
        catch (Throwable throwable) {
            this.logStartupEvent("started Agent service tracker failed!");
            this.log.log(10000, "starting AgentService failed:", throwable);
            this.getFramework().getErrorMgr().handleError(throwable, "starting AgentService failed!", 0, 0, 0);
        }
    }

    @Override
    public final void stop(BundleContext bundleContext) {
        if (this.agentTracker != null) {
            this.agentTracker.close();
            this.agentTracker = null;
        }
        if (this.sregAgent != null) {
            this.sregAgent.unregister();
            this.sregAgent = null;
        }
        if (this.agentService != null) {
            this.agentService.cleanup();
            this.agentService = null;
        }
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

    static /* synthetic */ LogChannel access$000(AgentActivator agentActivator) {
        return agentActivator.log;
    }

    static /* synthetic */ AgentService access$100(AgentActivator agentActivator) {
        return agentActivator.agentService;
    }
}

