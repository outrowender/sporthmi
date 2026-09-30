/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface ISourceActivationCallbackHandler {
    public void sourceDeviceActivated(ISourceSlot var1, int var2, boolean var3);

    public void sourceDeviceDeactivated();

    public void sourceDevicePending(long var1);

    public void sourceActivationFailed();
}

