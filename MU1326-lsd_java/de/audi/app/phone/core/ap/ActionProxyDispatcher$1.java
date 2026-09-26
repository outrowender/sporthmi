/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.ap.ActionProxyDispatcher;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.event.AbstractTelActionProxyEvent;
import java.util.LinkedList;
import java.util.Map;

class ActionProxyDispatcher$1
extends AbstractTelActionProxyEvent {
    private final /* synthetic */ int val$methodID;
    private final /* synthetic */ Map val$parameters;
    private final /* synthetic */ ActionProxyDispatcher this$0;

    ActionProxyDispatcher$1(ActionProxyDispatcher actionProxyDispatcher, int n, int n2, Map map) {
        this.this$0 = actionProxyDispatcher;
        this.val$methodID = n2;
        this.val$parameters = map;
        super(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        ActionProxyDispatcher.access$000(this.this$0).log(-2137614336, "[ActionProxyDispatcher#notifyActionProxyCall] methodID='%1', parameters='%2'", (Object)Integer.toString(this.val$methodID), (Object)this.val$parameters);
        Object object = ActionProxyDispatcher.access$100(this.this$0);
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)ActionProxyDispatcher.access$100(this.this$0).get(new Integer(this.val$methodID));
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IActionProxyListener)object.next()).actionProxyCallPerformed(this.val$methodID, this.val$parameters);
            }
            catch (Exception exception) {
                ActionProxyDispatcher.access$000(this.this$0).log(-1601830656, "[ActionProxyDispatcher#notifyActionProxyCall] exception occured: ", (Throwable)exception);
            }
        }
    }
}

