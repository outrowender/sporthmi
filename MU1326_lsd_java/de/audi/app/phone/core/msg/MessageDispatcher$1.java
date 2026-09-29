/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.msg;

import de.audi.app.phone.core.event.AbstractTelMsgDistEvent;
import de.audi.app.phone.core.msg.MessageDispatcher;
import de.audi.atip.msg.MsgListener;
import java.util.LinkedList;

class MessageDispatcher$1
extends AbstractTelMsgDistEvent {
    private final /* synthetic */ int val$msgID;
    private final /* synthetic */ MessageDispatcher this$0;

    MessageDispatcher$1(MessageDispatcher messageDispatcher, int n, int n2) {
        this.this$0 = messageDispatcher;
        this.val$msgID = n2;
        super(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        Object object = MessageDispatcher.access$000(this.this$0);
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)MessageDispatcher.access$000(this.this$0).get(new Integer(this.val$msgID));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                MessageDispatcher.access$100(this.this$0).log(1078071040, "[MessageDispatcher#processMsg] msgID='%1'", (long)this.val$msgID);
                ((MsgListener)object.next()).processMsg(this.val$msgID);
            }
            catch (Exception exception) {
                MessageDispatcher.access$100(this.this$0).log(-1601830656, "[MessageDispatcher#processMsg] exception occured: ", (Throwable)exception);
            }
        }
    }
}

