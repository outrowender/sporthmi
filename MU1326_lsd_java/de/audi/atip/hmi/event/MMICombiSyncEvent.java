/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.mmicombi.exchange.IMMICombiExchangePacket;

public class MMICombiSyncEvent
extends ATIPEvent {
    private IMMICombiExchangePacket exchangePacket;

    public IMMICombiExchangePacket getExchangePacket() {
        return this.exchangePacket;
    }

    public MMICombiSyncEvent(ATIPEventListener aTIPEventListener, int n, IMMICombiExchangePacket iMMICombiExchangePacket) {
        super(aTIPEventListener, n);
        this.exchangePacket = iMMICombiExchangePacket;
    }
}

