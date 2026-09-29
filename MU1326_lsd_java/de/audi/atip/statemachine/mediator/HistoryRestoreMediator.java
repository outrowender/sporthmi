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

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public int reactivate(boolean bl) {
        super.reactivate(false);
        return this.action;
    }

    @Override
    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public void kill() {
        if (!this.started) {
            return;
        }
        this.stopListening();
        this.started = false;
    }
}

