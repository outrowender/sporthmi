/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public interface SyncTargetManager {
    public LogChannel getLogChannel();

    public LogChannel getEventLogChannel();

    public IFrameworkAccess getFramework();
}

