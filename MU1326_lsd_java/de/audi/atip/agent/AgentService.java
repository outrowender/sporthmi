/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.AgentException;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgentService
implements IServiceListener,
DumpInfoProvider {
    private final List handlers;
    private final LogChannel log;
    private final Agent agent;

    public AgentService(IFrameworkAccess iFrameworkAccess) {
        this.log = iFrameworkAccess.getLogChannel("Fw.Agent.Service");
        this.handlers = new ArrayList(3);
        this.log.log(1078071040, "AgentService() - get the agent instance");
        this.agent = Agent.getAgent();
    }

    private final Agent getAgent() {
        return this.agent;
    }

    private boolean registerASIProviderAtAgent(IASIProvider iASIProvider) {
        try {
            this.log.log(1078071040, "AgentService#registerASIProviderAtAgent(%1)", (Object)iASIProvider);
            IService iService = iASIProvider.getService();
            this.getAgent().registerService(iService);
            this.getAgent().registerServiceListener(iService, this);
            return true;
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
            this.log.log(10000, "AgentService#registerASIProviderAtAgent(%1) failed!", (Object)iASIProvider, (Throwable)interruptedException);
            return false;
        }
        catch (AgentException agentException) {
            this.log.log(10000, "AgentService#registerASIProviderAtAgent(%1) failed!", (Object)iASIProvider, (Throwable)agentException);
            return false;
        }
    }

    private void unregisterASIHandlerAtAgent(IASIProvider iASIProvider) {
        try {
            this.log.log(1078071040, "AgentService#unregisterASIProviderAtAgent(%1)", (Object)iASIProvider);
            IService iService = iASIProvider.getService();
            this.getAgent().unregisterServiceListener(iService, this);
            this.getAgent().unregisterService(iService);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
            this.log.log(10000, "AgentService#unregisterASIProviderAtAgent(%1) failed!", (Object)iASIProvider, (Throwable)interruptedException);
        }
        catch (AgentException agentException) {
            this.log.log(10000, "AgentService#unregisterASIProviderAtAgent(%1) failed!", (Object)iASIProvider, (Throwable)agentException);
        }
    }

    private boolean isService(IService iService, IStub iStub) {
        return iStub.getService().getInstanceID().equals(iService.getInstanceID());
    }

    private IASIProvider lookupHandler(IStub iStub) {
        Iterator iterator = this.handlers.iterator();
        while (iterator.hasNext()) {
            IASIProvider iASIProvider = (IASIProvider)iterator.next();
            if (!this.isService(iASIProvider.getService(), iStub)) continue;
            return iASIProvider;
        }
        return null;
    }

    public final void register(IASIProvider iASIProvider) {
        this.log.log(1078071040, "AgentService#registerASIHandler(%1)", (Object)iASIProvider);
        if (iASIProvider != null) {
            this.handlers.add(iASIProvider);
            this.registerASIProviderAtAgent(iASIProvider);
        }
    }

    public final void unregister(IASIProvider iASIProvider) {
        this.log.log(1078071040, "AgentService#unregisterASIHandler(%1)", (Object)iASIProvider);
        if (this.handlers.remove(iASIProvider)) {
            this.unregisterASIHandlerAtAgent(iASIProvider);
        }
    }

    void cleanup() {
        while (!this.handlers.isEmpty()) {
            this.unregisterASIHandlerAtAgent((IASIProvider)this.handlers.remove(0));
        }
    }

    @Override
    public void serviceStubAttached(IStub iStub) {
        this.log.log(1078071040, "AgentService#serviceStubAttached( %1 )", (Object)iStub);
        IASIProvider iASIProvider = this.lookupHandler(iStub);
        if (iASIProvider != null) {
            this.log.log(1078071040, "AgentService#serviceStubAttached() - found stub for '%1'", (Object)iASIProvider);
            iASIProvider.attachStub(iStub);
        } else {
            this.log.log(10000, "AgentService#serviceStubAttached() - ignore unknown service stub!");
        }
    }

    @Override
    public void serviceStubDetached(IStub iStub) {
        this.log.log(1078071040, "AgentService#serviceStubDetached( %1 )", (Object)iStub);
        IASIProvider iASIProvider = this.lookupHandler(iStub);
        if (iASIProvider != null) {
            this.log.log(1078071040, "AgentService#serviceStubDetached() - found stub for '%1'", (Object)iASIProvider);
            iASIProvider.detachStub(iStub);
        } else {
            this.log.log(10000, "AgentService#serviceStubDetached() - ignore unknown service stub!");
        }
    }

    @Override
    public void serviceStubCountChanged(IService iService, int n) {
        this.log.log(1078071040, "AgentService#serviceStubCountChanged( %1, %2 )", (Object)iService, (long)n);
    }

    @Override
    public String getName() {
        return "AgentSerivce";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println("registered Providers:");
        Iterator iterator = this.handlers.iterator();
        while (iterator.hasNext()) {
            IASIProvider iASIProvider = (IASIProvider)iterator.next();
            printStream.print("\t");
            printStream.println(iASIProvider.getService().getInstanceID());
        }
    }
}

