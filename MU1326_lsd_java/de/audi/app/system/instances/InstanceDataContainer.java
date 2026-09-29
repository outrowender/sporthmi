/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer$AddInstanceData;
import de.audi.app.system.instances.InstanceDataContainer$DumpInstanceData;
import de.audi.app.system.instances.InstanceDataContainer$InstanceData;
import de.audi.app.system.instances.InstanceDataContainer$InstanceMapping;
import de.audi.app.system.instances.InstanceDataContainer$InstanceRequest;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Map;

public class InstanceDataContainer
implements ITVStateListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final DispatcherBase dispatcher;
    private volatile boolean destroyed = false;
    private volatile int tvState = 0;
    public static final int INSTANCE_TYPE_DEFAULT;
    public static final int INSTANCE_TYPE_DEDICATED;
    public static final int INSTANCE_TYPE_NOT_CODED;
    private final Map instances = new HashMap();

    public InstanceDataContainer(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("SDIS-Instance-Processing", new JobLogger(logChannel));
    }

    public final void start() {
        this.log.log(-2137614336, "SDISInstancesManager#start()");
        this.dispatcher.start();
        this.prepare();
    }

    public final void destroy() {
        this.log.log(-2137614336, "SDISInstancesManager#destroy()");
        this.destroyed = true;
        this.dispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.dispatcher.getDispatcherName());
    }

    final LogChannel getLog() {
        return this.log;
    }

    public void dumpMappings() {
        this.log.log(-2137614336, "SDISInstancesManager#dumpMappings()");
        if (!this.destroyed) {
            this.dispatcher.execute(new InstanceDataContainer$DumpInstanceData(this));
        }
    }

    public void addInstanceData(String string, int n, int[] nArray) {
        this.log.log(-2137614336, "SDISInstancesManager#addInstanceData( %1, %3, %2 )", (Object)string, (Object)nArray, (long)n);
        InstanceDataContainer$InstanceMapping[] instanceDataContainer$InstanceMappingArray = new InstanceDataContainer$InstanceMapping[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            instanceDataContainer$InstanceMappingArray[i2] = new InstanceDataContainer$InstanceMapping(null);
            InstanceDataContainer$InstanceMapping.access$102(instanceDataContainer$InstanceMappingArray[i2], nArray[i2]);
        }
        InstanceDataContainer$InstanceData instanceDataContainer$InstanceData = new InstanceDataContainer$InstanceData(n, instanceDataContainer$InstanceMappingArray);
        if (!this.destroyed) {
            this.dispatcher.execute(new InstanceDataContainer$AddInstanceData(this, string, instanceDataContainer$InstanceData));
        }
    }

    public final void enqueueRequest(String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.log.log(-2137614336, "SDISInstancesManager#enqueueRequest( %1, %2 )", (Object)string, (Object)string2);
        if (!this.destroyed) {
            this.dispatcher.execute(new InstanceDataContainer$InstanceRequest(this, string, string2, aSIHMISyncInstanceReply));
        }
    }

    static final Integer isDeviceRegistered(InstanceDataContainer$InstanceMapping[] instanceDataContainer$InstanceMappingArray, String string) {
        for (int i2 = 0; i2 < instanceDataContainer$InstanceMappingArray.length; ++i2) {
            if (!string.equals(InstanceDataContainer$InstanceMapping.access$200(instanceDataContainer$InstanceMappingArray[i2]))) continue;
            return new Integer(InstanceDataContainer$InstanceMapping.access$100(instanceDataContainer$InstanceMappingArray[i2]));
        }
        return null;
    }

    static final Integer registerDevice(InstanceDataContainer$InstanceMapping[] instanceDataContainer$InstanceMappingArray, String string) {
        for (int i2 = 0; i2 < instanceDataContainer$InstanceMappingArray.length; ++i2) {
            if (InstanceDataContainer$InstanceMapping.access$200(instanceDataContainer$InstanceMappingArray[i2]) != null && InstanceDataContainer$InstanceMapping.access$200(instanceDataContainer$InstanceMappingArray[i2]).length() != 0) continue;
            InstanceDataContainer$InstanceMapping.access$202(instanceDataContainer$InstanceMappingArray[i2], string);
            return new Integer(InstanceDataContainer$InstanceMapping.access$100(instanceDataContainer$InstanceMappingArray[i2]));
        }
        return null;
    }

    private final synchronized void prepare() {
        this.addInstanceData("ec3859ab-0660-4557-8339-69dc874fe86b", 0, new int[]{0});
        this.addInstanceData("0f18f39e-8ba2-4652-9298-39ffbea5b9fe", 0, new int[]{0});
        this.addInstanceData("7bf67018-bebb-46f4-bf0f-0d5345fcf213", 0, new int[]{0});
        this.addInstanceData("ff03f2f6-eceb-470b-8239-62939e77c4ac", 0, new int[]{0});
        this.addInstanceData("4100596a-a26d-4625-84dc-0b3013890cde", 0, new int[]{0});
        this.addInstanceData("8ccf0676-352e-4fe1-a86e-ed15a11ea69e", 0, new int[]{0});
        this.addInstanceData("848d4459-b390-4cdf-b374-6d4783690a1b", 0, new int[]{0});
        this.addInstanceData("3a42bf26-0f99-40c8-bc3a-452fc046e0ca", 0, new int[]{0});
        if (this.tvState == 0) {
            this.addInstanceData("3b9b7c34-a5a9-4acd-a935-dde0b43bf263", 0, new int[]{0});
        } else {
            this.addInstanceData("3b9b7c34-a5a9-4acd-a935-dde0b43bf263", 2, new int[]{0});
        }
        if (this.framework.getSysConst(459) == 1) {
            this.addInstanceData("43ddd4bf-1185-405b-ad9d-d74c07925b2a", 0, new int[]{0});
        } else {
            this.addInstanceData("43ddd4bf-1185-405b-ad9d-d74c07925b2a", 2, new int[]{0});
        }
        this.addInstanceData("036f2d17-c35a-4f85-8d0c-e89fd5461382", 0, new int[]{0});
        this.addInstanceData("bacc7eeb-475f-4a14-ad22-d3b237ca4c1b", 0, new int[]{0});
        this.addInstanceData("04780aa8-9662-4220-9900-4a1e11586d28", 1, new int[]{4, 5});
    }

    @Override
    public synchronized void updateState(int n, int[] nArray) {
        this.tvState = n;
    }

    static /* synthetic */ Map access$300(InstanceDataContainer instanceDataContainer) {
        return instanceDataContainer.instances;
    }
}

