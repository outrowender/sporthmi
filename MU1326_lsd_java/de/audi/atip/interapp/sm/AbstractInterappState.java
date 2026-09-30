/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.AbstractInterappSM;
import de.audi.atip.interapp.sm.IInterappConBluetoothEvent;
import de.audi.atip.interapp.sm.IInterappConDataEvent;
import de.audi.atip.interapp.sm.IInterappConManagerEvent;
import de.audi.atip.interapp.sm.IInterappConWlanEvent;
import de.audi.atip.interapp.sm.IInterappEvent;
import de.audi.atip.interapp.sm.IInterappPhoneEvent;
import de.audi.atip.interapp.sm.IInterappState;
import de.audi.atip.log.LogChannel;

public abstract class AbstractInterappState
implements IInterappState {
    protected final LogChannel log;
    private AbstractInterappSM sm;

    public AbstractInterappState(AbstractInterappSM abstractInterappSM, LogChannel logChannel) {
        this.log = logChannel;
        this.sm = abstractInterappSM;
    }

    protected AbstractInterappState entryAction(IInterappEvent iInterappEvent, AbstractInterappState abstractInterappState) {
        return this;
    }

    protected AbstractInterappState exitAction(IInterappEvent iInterappEvent, AbstractInterappState abstractInterappState) {
        return abstractInterappState;
    }

    protected abstract void handleEvent(IInterappConDataEvent var1);

    protected abstract void handleEvent(IInterappPhoneEvent var1);

    protected abstract void handleEvent(IInterappConBluetoothEvent var1);

    protected abstract void handleEvent(IInterappConWlanEvent var1);

    protected abstract void handleEvent(IInterappConManagerEvent var1);

    protected void transitionTo(IInterappEvent iInterappEvent, AbstractInterappState abstractInterappState) {
        this.sm.transitionTo(iInterappEvent, abstractInterappState);
    }
}

