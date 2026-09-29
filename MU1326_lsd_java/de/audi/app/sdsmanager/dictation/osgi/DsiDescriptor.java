/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

public final class DsiDescriptor {
    private final String interfaceName;
    private final int instanceId;

    public DsiDescriptor(String string, int n) {
        this.interfaceName = string;
        this.instanceId = n;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public int getInstanceId() {
        return this.instanceId;
    }
}

