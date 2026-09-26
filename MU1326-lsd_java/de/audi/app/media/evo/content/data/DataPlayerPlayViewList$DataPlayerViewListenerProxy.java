/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.content.media.AbstractMediaPlayViewList$PlayerViewListenerProxy;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class DataPlayerPlayViewList$DataPlayerViewListenerProxy
extends AbstractMediaPlayViewList$PlayerViewListenerProxy
implements TimerListener {
    private static final long COVER_SYNC_DELAY_TIME;
    private final Timer coverSyncUpdateTimer;
    private volatile int currentSize;
    private volatile long entryId;
    private volatile boolean delayedUpdate;
    private final /* synthetic */ DataPlayerPlayViewList this$0;

    public DataPlayerPlayViewList$DataPlayerViewListenerProxy(DataPlayerPlayViewList dataPlayerPlayViewList, IPlayerViewListener iPlayerViewListener) {
        this.this$0 = dataPlayerPlayViewList;
        super(iPlayerViewListener);
        this.coverSyncUpdateTimer = new Timer("CoverSyncDelayTimer", 0, true, this);
        this.currentSize = -1;
        this.entryId = -1L;
    }

    private void reset() {
        DataPlayerPlayViewList.access$700(this.this$0).log(1078071040, "[%1.DataPlayerViewListenerProxy.reset]", (Object)"DataPlayerPlayViewList");
        this.coverSyncUpdateTimer.cancel();
        this.currentSize = -1;
        this.entryId = -1L;
        this.delayedUpdate = false;
    }

    @Override
    public void listInvalidated() {
        DataPlayerPlayViewList.access$800(this.this$0).log(1078071040, "[%1.DataPlayerViewListenerProxy.listInvalidated] No updates anymore. Stop timer.", (Object)"DataPlayerPlayViewList");
        this.reset();
        this.listener.listInvalidated();
    }

    @Override
    public void listChangeOnSelection(boolean bl) {
        DataPlayerPlayViewList.access$900(this.this$0).log(1078071040, "[%1.DataPlayerViewListenerProxy.listChangeOnSelection] List is changing.", (Object)"DataPlayerPlayViewList");
        this.reset();
        this.listener.listChangeOnSelection(bl);
    }

    @Override
    public void listChanged(boolean bl, long l, int n, int n2) {
        if (bl || this.currentSize != n || this.entryId != l || n2 != 4) {
            this.reset();
            this.currentSize = n;
            this.entryId = l;
            this.listener.listChanged(bl, l, n, n2);
            return;
        }
        if (this.coverSyncUpdateTimer.isRunning()) {
            DataPlayerPlayViewList.access$1000(this.this$0).log(1078071040, "[%1.PlayerViewListenerProxy.listChanged] Delay cover sync update.", (Object)"DataPlayerPlayViewList");
            this.delayedUpdate = true;
        } else {
            this.listener.listChanged(bl, l, n, n2);
            this.coverSyncUpdateTimer.start();
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.delayedUpdate) {
            DataPlayerPlayViewList.access$1100(this.this$0).log(1078071040, "[%1.PlayerViewListenerProxy.fireTimer] Delayed cover sync update.", (Object)"DataPlayerPlayViewList");
            this.delayedUpdate = false;
            this.listener.listChanged(false, this.entryId, this.currentSize, 4);
            this.coverSyncUpdateTimer.start();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

