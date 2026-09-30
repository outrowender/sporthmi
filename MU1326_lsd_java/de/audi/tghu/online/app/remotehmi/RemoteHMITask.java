/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

public interface RemoteHMITask
extends Runnable {
    public boolean isCoalescable();

    public boolean coalesceWith(RemoteHMITask var1);

    public Long getDelayMillis();
}

