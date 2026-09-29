/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.source.ISourceSlot;

public interface ISourceActivationCallbackHandler {
    default public void sourceDeviceActivated(ISourceSlot iSourceSlot, int n, boolean bl) {
    }

    default public void sourceDeviceDeactivated() {
    }

    default public void sourceDevicePending(long l) {
    }

    default public void sourceActivationFailed() {
    }
}

