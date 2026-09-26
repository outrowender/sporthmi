/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.log.LogChannel;

public final class LockingModelGroup
extends ModelGroup {
    private final LogChannel logChannel;
    private volatile boolean locked;
    private volatile boolean flushOnUnlock;
    private long lockStartTime;
    private final long MAX_LOCK_DURATION_IN_MS;
    private IFrameworkAccess frameworkAccess;

    public LockingModelGroup(LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        this.MAX_LOCK_DURATION_IN_MS = 0;
        this.logChannel = logChannel;
        this.frameworkAccess = iFrameworkAccess;
    }

    public void lock() {
        this.locked = true;
        this.flushOnUnlock = false;
        this.lockStartTime = this.frameworkAccess.getMonotonicTime();
        this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#lock: model group was locked, flushOnUnlock was reset");
    }

    public void unlock() {
        this.locked = false;
        this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#unlock: model group was unlocked");
        if (this.flushOnUnlock) {
            this.flushOnUnlock = false;
            this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#unlock: executing delayed flush");
            this.flush();
        }
    }

    private void setFlushOnUnlock() {
        this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#setFlushOnUnlock: scheduling flush on unlock");
        this.flushOnUnlock = true;
    }

    private boolean isLocked() {
        return this.locked;
    }

    @Override
    public void flush() {
        if (this.isLocked() && this.frameworkAccess.getMonotonicTime() > this.lockStartTime + 0) {
            this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#flush: locked model group is unlocked because of timeout!");
            this.unlock();
        }
        if (this.isLocked()) {
            this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#flush: model group is locked, setting flush flag");
            this.setFlushOnUnlock();
            return;
        }
        this.logChannel.log(1078071040, "RemoteHMIService#LockingModelGroup#flush: executing flush.");
        super.flush();
    }
}

