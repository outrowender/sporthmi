/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system.instances;

import de.audi.app.system.instances.InstanceDataContainer$InstanceMapping;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.List;

class InstanceDataContainer$InstanceData {
    private final int instanceType;
    private final InstanceDataContainer$InstanceMapping[] mappings;

    public InstanceDataContainer$InstanceData(int n, InstanceDataContainer$InstanceMapping[] instanceDataContainer$InstanceMappingArray) {
        this.instanceType = n;
        this.mappings = instanceDataContainer$InstanceMappingArray;
    }

    public int getInstanceType() {
        return this.instanceType;
    }

    public InstanceDataContainer$InstanceMapping[] getMappings() {
        return this.mappings;
    }

    public int getDefaultInstance() {
        return InstanceDataContainer$InstanceMapping.access$100(this.mappings[0]);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("type: ").append(this.instanceType).append(", mappings: ");
        List list = Arrays.asList(this.mappings);
        buffer.append(list);
        return buffer.toString();
    }
}

