/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import java.util.List;

public abstract class AbstractDeviceListUpdateHandler {
    protected AbstractDeviceListUpdateHandler next;

    public abstract void handle(List var1);

    public final AbstractDeviceListUpdateHandler add(AbstractDeviceListUpdateHandler abstractDeviceListUpdateHandler) {
        this.next = abstractDeviceListUpdateHandler;
        return this.next;
    }
}

