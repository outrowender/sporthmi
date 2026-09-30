/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.SystemSDISEnv;
import de.audi.app.system.instances.InstanceDataContainer;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstance;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class InstanceASIProvider
extends ASIHMISyncInstanceAbstractBaseService
implements IASIProvider {
    private final SystemSDISEnv env;
    private final ASIHMISyncInstanceService instanceService;
    private final InstanceDataContainer instancesManager;

    public InstanceASIProvider(IFrameworkAccess iFrameworkAccess, SystemSDISEnv systemSDISEnv, int n) {
        this.env = systemSDISEnv;
        this.instanceService = new ASIHMISyncInstanceService(n, this);
        this.instancesManager = new InstanceDataContainer(iFrameworkAccess, systemSDISEnv.getLog());
        this.initAttributes();
    }

    public void start() {
        this.getLog().log(10000000, "[InstanceASIProvider.start]");
        this.instancesManager.start();
    }

    public void stop() {
        this.getLog().log(10000000, "[InstanceASIProvider.stop]");
        this.instancesManager.destroy();
    }

    public void dump() {
        this.instancesManager.dumpMappings();
    }

    private final SystemSDISEnv getEnv() {
        return this.env;
    }

    private final LogChannel getLog() {
        return this.getEnv().getLog();
    }

    public final String toString() {
        return "InstanceASIProvider";
    }

    private final void initAttributes() {
        try {
            this.updateASIVersion("1.1.00");
            this.updateReplyIDs(ASIHMISyncInstance.ReplyIDs.getIDs());
            this.updateRequestIDs(ASIHMISyncInstance.RequestIDs.getIDs());
        }
        catch (MethodException methodException) {
            this.getLog().log(1000000, "[InstanceASIProvider.iniAttributes] unexpected MethodException", (Throwable)methodException);
        }
    }

    public final IService getService() {
        return this.instanceService;
    }

    public InstanceDataContainer getInstanceDataContainer() {
        return this.instancesManager;
    }

    public final synchronized void attachStub(IStub iStub) {
        this.getLog().log(1000000, "[InstanceASIProvider.attachStub] '%1'", (Object)iStub);
    }

    public final synchronized void detachStub(IStub iStub) {
        this.getLog().log(1000000, "[InstanceASIProvider.detachStub] '%1'", (Object)iStub);
    }

    public void requestInstanceId(String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) throws MethodException {
        this.getLog().log(1000000, "[InstanceASIProvider.requestInstanceId] got request for ASI '%1' from device '%2'", (Object)string, (Object)string2);
        this.instancesManager.enqueueRequest(string, string2, aSIHMISyncInstanceReply);
    }
}

