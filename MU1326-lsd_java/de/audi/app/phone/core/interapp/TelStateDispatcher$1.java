/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelStateDispatcher;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import java.util.LinkedList;

class TelStateDispatcher$1
implements Runnable {
    private final /* synthetic */ ITelState val$telState;
    private final /* synthetic */ int val$key;
    private final /* synthetic */ TelStateDispatcher this$0;

    TelStateDispatcher$1(TelStateDispatcher telStateDispatcher, ITelState iTelState, int n) {
        this.this$0 = telStateDispatcher;
        this.val$telState = iTelState;
        this.val$key = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        Object object = TelStateDispatcher.access$000(this.this$0);
        synchronized (object) {
            linkedList = (LinkedList)TelStateDispatcher.access$000(this.this$0).clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ITelStateListener iTelStateListener = (ITelStateListener)object.next();
                TelStateDispatcher.access$100(this.this$0).log(1078071040, "[TelStateDispatcher.updateListeners(...).new Runnable() {...}#run] listener=%1, state=%2", (Object)iTelStateListener, (Object)this.val$telState);
                iTelStateListener.updateTelState(this.val$key, this.val$telState);
            }
            catch (Exception exception) {
                TelStateDispatcher.access$200(this.this$0).log(-1601830656, "[TelStateDispatcher.updateListeners(...).new Runnable() {...}#run] exception occured: ", (Throwable)exception);
            }
        }
    }
}

