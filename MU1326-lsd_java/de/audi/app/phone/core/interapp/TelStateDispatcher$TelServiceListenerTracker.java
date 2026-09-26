/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelStateDispatcher;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import java.util.LinkedList;

class TelStateDispatcher$TelServiceListenerTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelStateDispatcher this$0;

    public TelStateDispatcher$TelServiceListenerTracker(TelStateDispatcher telStateDispatcher, ITelApplication iTelApplication) {
        this.this$0 = telStateDispatcher;
        super(iTelApplication, "App.Phone.Main", TelStateDispatcher.class$de$audi$atip$interapp$phone$ITelStateListener == null ? (TelStateDispatcher.class$de$audi$atip$interapp$phone$ITelStateListener = TelStateDispatcher.class$("de.audi.atip.interapp.phone.ITelStateListener")) : TelStateDispatcher.class$de$audi$atip$interapp$phone$ITelStateListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void serviceAvailable(Object object) {
        this.log.log(1078071040, "[TelStateDispatcher.TelServiceListenerTracker#serviceAvailable] %1", object);
        LinkedList linkedList = TelStateDispatcher.access$000(this.this$0);
        synchronized (linkedList) {
            TelStateDispatcher.access$000(this.this$0).add(object);
            ITelState iTelState = TelStateDispatcher.access$300(this.this$0);
            if (iTelState != null) {
                ITelStateListener iTelStateListener = (ITelStateListener)object;
                this.log.log(1078071040, "[TelStateDispatcher.TelServiceListenerTracker#serviceAvailable] listener=%1, state=%2", (Object)iTelStateListener, (Object)iTelState);
                iTelStateListener.updateTelState(0, iTelState);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void serviceRemoved(Object object) {
        this.log.log(1078071040, "[TelStateDispatcher.TelServiceListenerTracker#serviceRemoved] %1", object);
        LinkedList linkedList = TelStateDispatcher.access$000(this.this$0);
        synchronized (linkedList) {
            TelStateDispatcher.access$000(this.this$0).remove(object);
        }
    }
}

