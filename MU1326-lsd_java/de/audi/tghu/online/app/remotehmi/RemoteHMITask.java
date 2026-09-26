/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

public interface RemoteHMITask
extends Runnable {
    default public boolean isCoalescable() {
    }

    default public boolean coalesceWith(RemoteHMITask remoteHMITask) {
    }

    default public Long getDelayMillis() {
    }
}

