/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.Map$Entry;

class InstanceDataContainer$DumpInstanceData
implements Runnable {
    private final InstanceDataContainer manager;
    private final LogChannel log;

    public InstanceDataContainer$DumpInstanceData(InstanceDataContainer instanceDataContainer) {
        this.manager = instanceDataContainer;
        this.log = instanceDataContainer.getLog();
    }

    @Override
    public void run() {
        this.log.log(1078071040, "DumpInstanceData#run() - dump instance mappings:");
        Iterator iterator = InstanceDataContainer.access$300(this.manager).entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            this.log.log(1078071040, "%1 -> %2", map$Entry.getKey(), map$Entry.getValue());
        }
    }
}

