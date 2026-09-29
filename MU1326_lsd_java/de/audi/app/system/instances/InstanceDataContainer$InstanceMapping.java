/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer$1;
import de.esolutions.fw.util.commons.Buffer;

class InstanceDataContainer$InstanceMapping {
    private int instanceId = -1;
    private String deviceId = null;

    private InstanceDataContainer$InstanceMapping() {
    }

    public String toString() {
        return new Buffer().append("[id:").append(this.instanceId).append(", device:").append(this.deviceId).append(']').toString();
    }

    /* synthetic */ InstanceDataContainer$InstanceMapping(InstanceDataContainer$1 instanceDataContainer$1) {
        this();
    }

    static /* synthetic */ int access$102(InstanceDataContainer$InstanceMapping instanceDataContainer$InstanceMapping, int n) {
        instanceDataContainer$InstanceMapping.instanceId = n;
        return instanceDataContainer$InstanceMapping.instanceId;
    }

    static /* synthetic */ String access$200(InstanceDataContainer$InstanceMapping instanceDataContainer$InstanceMapping) {
        return instanceDataContainer$InstanceMapping.deviceId;
    }

    static /* synthetic */ int access$100(InstanceDataContainer$InstanceMapping instanceDataContainer$InstanceMapping) {
        return instanceDataContainer$InstanceMapping.instanceId;
    }

    static /* synthetic */ String access$202(InstanceDataContainer$InstanceMapping instanceDataContainer$InstanceMapping, String string) {
        instanceDataContainer$InstanceMapping.deviceId = string;
        return instanceDataContainer$InstanceMapping.deviceId;
    }
}

