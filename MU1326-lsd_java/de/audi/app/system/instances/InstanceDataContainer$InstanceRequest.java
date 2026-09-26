/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer;
import de.audi.app.system.instances.InstanceDataContainer$InstanceData;
import de.audi.app.system.instances.InstanceDataContainer$InstanceMapping;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.method.MethodException;

class InstanceDataContainer$InstanceRequest
implements Runnable {
    private final InstanceDataContainer manager;
    private final LogChannel log;
    private final String asiId;
    private final String deviceId;
    private final ASIHMISyncInstanceReply reply;

    InstanceDataContainer$InstanceRequest(InstanceDataContainer instanceDataContainer, String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.manager = instanceDataContainer;
        this.log = instanceDataContainer.getLog();
        this.asiId = string;
        this.deviceId = string2;
        this.reply = aSIHMISyncInstanceReply;
    }

    @Override
    public void run() {
        this.log.log(-2137614336, "InstanceRequest#run() - process instance request");
        if (InstanceDataContainer.access$300(this.manager).containsKey(this.asiId)) {
            InstanceDataContainer$InstanceData instanceDataContainer$InstanceData = (InstanceDataContainer$InstanceData)InstanceDataContainer.access$300(this.manager).get(this.asiId);
            if (instanceDataContainer$InstanceData.getInstanceType() == 0) {
                int n = instanceDataContainer$InstanceData.getDefaultInstance();
                this.log.log(-2137614336, "InstanceRequest#run() - requested ASI provides default instance '%1'", (long)n);
                this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                return;
            }
            if (instanceDataContainer$InstanceData.getInstanceType() == 1) {
                InstanceDataContainer$InstanceMapping[] instanceDataContainer$InstanceMappingArray = instanceDataContainer$InstanceData.getMappings();
                Integer n = InstanceDataContainer.isDeviceRegistered(instanceDataContainer$InstanceMappingArray, this.deviceId);
                if (n != null) {
                    this.log.log(-2137614336, "InstanceRequest#run() - requested ASI already maps instance id '%1' for device id '%2'", (Object)n, (Object)this.deviceId);
                    this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                } else {
                    n = InstanceDataContainer.registerDevice(instanceDataContainer$InstanceMappingArray, this.deviceId);
                    if (n != null) {
                        this.log.log(-2137614336, "InstanceRequest#run() - found new instance id '%1' for device id '%2'", (Object)n, (Object)this.deviceId);
                        this.sendResponse(this.reply, this.asiId, this.deviceId, n, 0);
                    } else {
                        this.log.log(10000, "InstanceRequest#run() - no more instance id available for device id '%1'!", (Object)this.deviceId);
                        this.sendResponse(this.reply, this.asiId, this.deviceId, -1, 2);
                    }
                }
                return;
            }
            if (instanceDataContainer$InstanceData.getInstanceType() == 2) {
                this.log.log(-2137614336, "InstanceRequest#run() - The device with id '%1' is not coded !", (Object)this.asiId);
                this.sendResponse(this.reply, this.asiId, this.deviceId, -1, 2);
                return;
            }
            this.log.log(1000, "InstanceRequest#run() - unsupported instance typ '%1', this must not happen!", (long)instanceDataContainer$InstanceData.getInstanceType());
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

