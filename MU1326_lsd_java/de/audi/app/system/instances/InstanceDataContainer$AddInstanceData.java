/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer;
import de.audi.app.system.instances.InstanceDataContainer$InstanceData;
import de.audi.atip.log.LogChannel;

class InstanceDataContainer$AddInstanceData
implements Runnable {
    private final InstanceDataContainer manager;
    private final LogChannel log;
    private final String asiId;
    private final InstanceDataContainer$InstanceData data;

    InstanceDataContainer$AddInstanceData(InstanceDataContainer instanceDataContainer, String string, InstanceDataContainer$InstanceData instanceDataContainer$InstanceData) {
        this.manager = instanceDataContainer;
        this.log = instanceDataContainer.getLog();
        this.asiId = string;
        this.data = instanceDataContainer$InstanceData;
    }

    @Override
    public void run() {
        this.log.log(-2137614336, "AddInstanceData#run() - add new instance data");
        if (!InstanceDataContainer.access$300(this.manager).containsKey(this.asiId)) {
            InstanceDataContainer.access$300(this.manager).put(this.asiId, this.data);
        }
    }
}

