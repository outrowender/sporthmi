/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InstanceDataContainer
implements ITVStateListener {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final DispatcherBase dispatcher;
    private volatile boolean destroyed = false;
    private volatile int tvState = 0;
    public static final int INSTANCE_TYPE_DEFAULT = 0;
    public static final int INSTANCE_TYPE_DEDICATED = 1;
    public static final int INSTANCE_TYPE_NOT_CODED = 2;
    private final Map instances = new HashMap();

    public InstanceDataContainer(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("SDIS-Instance-Processing", new JobLogger(logChannel));
    }

    public final void start() {
        this.log.log(10000000, "SDISInstancesManager#start()");
        this.dispatcher.start();
        this.prepare();
    }

    public final void destroy() {
        this.log.log(10000000, "SDISInstancesManager#destroy()");
        this.destroyed = true;
        this.dispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.dispatcher.getDispatcherName());
    }

    final LogChannel getLog() {
        return this.log;
    }

    public void dumpMappings() {
        this.log.log(10000000, "SDISInstancesManager#dumpMappings()");
        if (!this.destroyed) {
            this.dispatcher.execute(new DumpInstanceData(this));
        }
    }

    public void addInstanceData(String string, int n, int[] nArray) {
        this.log.log(10000000, "SDISInstancesManager#addInstanceData( %1, %3, %2 )", (Object)string, (Object)nArray, (long)n);
        InstanceMapping[] instanceMappingArray = new InstanceMapping[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            instanceMappingArray[i2] = new InstanceMapping();
            instanceMappingArray[i2].instanceId = nArray[i2];
        }
        InstanceData instanceData = new InstanceData(n, instanceMappingArray);
        if (!this.destroyed) {
            this.dispatcher.execute(new AddInstanceData(this, string, instanceData));
        }
    }

    public final void enqueueRequest(String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.log.log(10000000, "SDISInstancesManager#enqueueRequest( %1, %2 )", (Object)string, (Object)string2);
        if (!this.destroyed) {
            this.dispatcher.execute(new InstanceRequest(this, string, string2, aSIHMISyncInstanceReply));
        }
    }

    static final Integer isDeviceRegistered(InstanceMapping[] instanceMappingArray, String string) {
        for (int i2 = 0; i2 < instanceMappingArray.length; ++i2) {
            if (!string.equals(instanceMappingArray[i2].deviceId)) continue;
            return new Integer(instanceMappingArray[i2].instanceId);
        }
        return null;
    }

    static final Integer registerDevice(InstanceMapping[] instanceMappingArray, String string) {
        for (int i2 = 0; i2 < instanceMappingArray.length; ++i2) {
            if (instanceMappingArray[i2].deviceId != null && instanceMappingArray[i2].deviceId.length() != 0) continue;
            instanceMappingArray[i2].deviceId = string;
            return new Integer(instanceMappingArray[i2].instanceId);
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

    public synchronized void updateState(int n, int[] nArray) {
        this.tvState = n;
    }

    private static class InstanceData {
        private final int instanceType;
        private final InstanceMapping[] mappings;

        public InstanceData(int n, InstanceMapping[] instanceMappingArray) {
            this.instanceType = n;
            this.mappings = instanceMappingArray;
        }

        public int getInstanceType() {
            return this.instanceType;
        }

        public InstanceMapping[] getMappings() {
            return this.mappings;
        }

        public int getDefaultInstance() {
            return this.mappings[0].instanceId;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("type: ").append(this.instanceType).append(", mappings: ");
            List list = Arrays.asList(this.mappings);
            buffer.append(list);
            return buffer.toString();
        }
    }

    private static class AddInstanceData
    implements Runnable {
        private final InstanceDataContainer manager;
        private final LogChannel log;
        private final String asiId;
        private final InstanceData data;

        AddInstanceData(InstanceDataContainer instanceDataContainer, String string, InstanceData instanceData) {
            this.manager = instanceDataContainer;
            this.log = instanceDataContainer.getLog();
            this.asiId = string;
            this.data = instanceData;
        }

        public void run() {
            this.log.log(10000000, "AddInstanceData#run() - add new instance data");
            if (!this.manager.instances.containsKey(this.asiId)) {
                this.manager.instances.put(this.asiId, this.data);
            }
        }
    }

    private static class InstanceMapping {
        private int instanceId = -1;
        private String deviceId = null;

        private InstanceMapping() {
        }

        public String toString() {
            return new Buffer().append("[id:").append(this.instanceId).append(", device:").append(this.deviceId).append(']').toString();
        }
    }

    private static class InstanceRequest
    implements Runnable {
        private final InstanceDataContainer manager;
        private final LogChannel log;
        private final String asiId;
        private final String deviceId;
        private final ASIHMISyncInstanceReply reply;

        InstanceRequest(InstanceDataContainer instanceDataContainer, String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
            this.manager = instanceDataContainer;
            this.log = instanceDataContainer.getLog();
            this.asiId = string;
            this.deviceId = string2;
            this.reply = aSIHMISyncInstanceReply;
        }

        public void run() {
            this.log.log(10000000, "InstanceRequest#run() - process instance request");
            if (this.manager.instances.containsKey(this.asiId)) {
                InstanceData instanceData = (InstanceData)this.manager.instances.get(this.asiId);
                if (instanceData.getInstanceType() == 0) {
                    int n = instanceData.getDefaultInstance();
                    this.log.log(10000000, "InstanceRequest#run() - requested ASI provides default instance '%1'", (long)n);
                    this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                    return;
                }
                if (instanceData.getInstanceType() == 1) {
                    InstanceMapping[] instanceMappingArray = instanceData.getMappings();
                    Integer n = InstanceDataContainer.isDeviceRegistered(instanceMappingArray, this.deviceId);
                    if (n != null) {
                        this.log.log(10000000, "InstanceRequest#run() - requested ASI already maps instance id '%1' for device id '%2'", (Object)n, (Object)this.deviceId);
                        this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                    } else {
                        n = InstanceDataContainer.registerDevice(instanceMappingArray, this.deviceId);
                        if (n != null) {
                            this.log.log(10000000, "InstanceRequest#run() - found new instance id '%1' for device id '%2'", (Object)n, (Object)this.deviceId);
                            this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                        } else {
                            this.log.log(10000, "InstanceRequest#run() - no more instance id available for device id '%1'!", (Object)this.deviceId);
                            this.sendResponse(this.reply, this.asiId, this.deviceId, -1, 2);
                        }
                    }
                    return;
                }
                if (instanceData.getInstanceType() == 2) {
                    this.log.log(10000000, "InstanceRequest#run() - The device with id '%1' is not coded !", (Object)this.asiId);
                    this.sendResponse(this.reply, this.asiId, this.deviceId, -1, 2);
                    return;
                }
                this.log.log(1000, "InstanceRequest#run() - unsupported instance typ '%1', this must not happen!", (long)instanceData.getInstanceType());
            } else {
                this.log.log(10000, "InstanceRequest#run() - Did not find requested ASI '%1' !", (Object)this.asiId);
                this.sendResponse(this.reply, this.asiId, this.deviceId, -1, 1);
            }
        }

        private final void sendResponse(ASIHMISyncInstanceReply aSIHMISyncInstanceReply, String string, String string2, int n, int n2) {
            try {
                aSIHMISyncInstanceReply.responseInstanceId(string, string2, n, n2);
            }
            catch (MethodException methodException) {
                this.log.log(10000, "Exception during reply", (Throwable)methodException);
            }
        }
    }

    private static class DumpInstanceData
    implements Runnable {
        private final InstanceDataContainer manager;
        private final LogChannel log;

        public DumpInstanceData(InstanceDataContainer instanceDataContainer) {
            this.manager = instanceDataContainer;
            this.log = instanceDataContainer.getLog();
        }

        public void run() {
            this.log.log(1000000, "DumpInstanceData#run() - dump instance mappings:");
            Iterator iterator = this.manager.instances.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                this.log.log(1000000, "%1 -> %2", entry.getKey(), entry.getValue());
            }
        }
    }
}

