/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEventListener;

public class ATIPEvent {
    public static final int ATIP_FIRST_ID;
    private ATIPEventListener receiver;
    private ATIPEventListener[] receivers;
    private int id;
    private long posted;
    private boolean consumed;

    protected ATIPEvent(ATIPEventListener aTIPEventListener, int n) {
        this.receiver = aTIPEventListener;
        this.id = n;
    }

    protected ATIPEvent(ATIPEventListener[] aTIPEventListenerArray, int n) {
        this.receivers = aTIPEventListenerArray;
        this.id = n;
    }

    public void dispatch() {
        if (this.receiver != null) {
            this.receiver.processEvent(this);
        } else if (this.receivers != null) {
            int n = this.receivers.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this.receivers[i2] == null) continue;
                this.receivers[i2].processEvent(this);
            }
        }
    }

    public ATIPEventListener getReceiver() {
        return this.receiver;
    }

    public int getID() {
        return this.id;
    }

    public long getPosted() {
        return this.posted;
    }

    public void setPostedNow(long l) {
        this.posted = l;
    }

    public void consume() {
        this.consumed = true;
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public void setConsumed(boolean bl) {
        this.consumed = bl;
    }
}

