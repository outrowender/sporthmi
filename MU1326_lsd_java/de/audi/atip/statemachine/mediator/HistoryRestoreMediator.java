/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.mediator;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.mediator.AbstractEventMediator;

public class HistoryRestoreMediator
extends AbstractEventMediator {
    public HistoryRestoreMediator(MediatorManager mediatorManager, int n) {
        this(-1L, mediatorManager, n);
    }

    public HistoryRestoreMediator(long l, MediatorManager mediatorManager, int n) {
        super(l, mediatorManager, n);
        this.started = true;
    }

    public void start() {
    }

    public void stop() {
    }

    public int reactivate(boolean bl) {
        super.reactivate(false);
        return this.action;
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    public int getType() {
        return 4;
    }

    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

