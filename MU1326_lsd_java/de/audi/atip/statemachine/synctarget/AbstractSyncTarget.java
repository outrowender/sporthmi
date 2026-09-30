/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.synctarget;

import de.audi.atip.statemachine.SMSyncTarget;
import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;

public abstract class AbstractSyncTarget
implements SMSyncTarget {
    protected SyncTargetManager syncTargetManager;
    private boolean active = false;
    private boolean triggered = false;
    protected final int syncEventID;
    protected final int transitionID;

    public AbstractSyncTarget(int n, int n2, SyncTargetManager syncTargetManager) {
        this.syncEventID = n;
        this.transitionID = n2;
        this.syncTargetManager = syncTargetManager;
    }

    public AbstractSyncTarget(int n, SyncTargetManager syncTargetManager) {
        this.syncEventID = n;
        this.transitionID = -1;
        this.syncTargetManager = syncTargetManager;
    }

    public void activate(SyncTargetProcessor syncTargetProcessor) {
        this.active = true;
        this.activated(syncTargetProcessor);
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean isActive() {
        return this.active;
    }

    public void resetTrigger() {
        this.triggered = false;
    }

    protected boolean isTriggered() {
        return this.triggered;
    }

    protected void trigger() {
        this.triggered = true;
    }

    public boolean triggerSync(SyncTargetProcessor syncTargetProcessor, int n) {
        if (this.syncEventID != n) {
            return false;
        }
        return this.execute(syncTargetProcessor);
    }

    public abstract boolean execute(SyncTargetProcessor var1);

    public abstract void activated(SyncTargetProcessor var1);
}

