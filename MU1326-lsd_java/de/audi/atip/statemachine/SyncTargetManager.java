/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public interface SyncTargetManager {
    default public LogChannel getLogChannel() {
    }

    default public LogChannel getEventLogChannel() {
    }

    default public IFrameworkAccess getFramework() {
    }
}

