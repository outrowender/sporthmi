/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.event.AbstractTelEvent;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import java.util.LinkedList;

class GlobalTelephoneState$TelGlobalStateUpdateEvent
extends AbstractTelEvent {
    private final int attribute;
    private final IGlobalTelephoneStateStruct update;
    private final /* synthetic */ GlobalTelephoneState this$0;

    public GlobalTelephoneState$TelGlobalStateUpdateEvent(GlobalTelephoneState globalTelephoneState, int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.this$0 = globalTelephoneState;
        super("TelGlobalStateUpdateEvent", GlobalTelephoneState.getAttributeName(n));
        this.attribute = n;
        this.update = iGlobalTelephoneStateStruct;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        GlobalTelephoneState.access$100(this.this$0).log(-2137614336, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] start update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
        Object object = GlobalTelephoneState.access$200(this.this$0);
        synchronized (object) {
            linkedList = (LinkedList)GlobalTelephoneState.access$200(this.this$0).clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IGlobalTelephoneStateListener)object.next()).updateGlobalTelephoneStateProperty(this.attribute, this.update);
            }
            catch (Exception exception) {
                GlobalTelephoneState.access$100(this.this$0).log(-1601830656, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] exception occured during update of %1: \n%2", (Object)GlobalTelephoneState.getAttributeName(this.attribute), (Throwable)exception);
            }
        }
        Object object2 = GlobalTelephoneState.access$300(this.this$0);
        synchronized (object2) {
            LinkedList linkedList2 = (LinkedList)GlobalTelephoneState.access$300(this.this$0).get(new Integer(this.attribute));
            if (linkedList2 == null) {
                GlobalTelephoneState.access$100(this.this$0).log(-2137614336, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] finished update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
                return;
            }
            object = (LinkedList)linkedList2.clone();
        }
        object2 = object.iterator();
        while (object2.hasNext()) {
            try {
                ((IGlobalTelephoneStateListener)object2.next()).updateGlobalTelephoneStateProperty(this.attribute, this.update);
            }
            catch (Exception exception) {
                GlobalTelephoneState.access$100(this.this$0).log(-1601830656, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] exception occured: ", (Throwable)exception);
            }
        }
        GlobalTelephoneState.access$100(this.this$0).log(-2137614336, "[GlobalTelephoneState.TelGlobalStateUpdateEvent#run] finished update %1", (Object)GlobalTelephoneState.getAttributeName(this.attribute));
    }
}

