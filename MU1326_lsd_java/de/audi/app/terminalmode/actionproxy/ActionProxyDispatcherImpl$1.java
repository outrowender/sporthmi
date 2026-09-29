/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.actionproxy;

import de.audi.app.terminalmode.actionproxy.ActionProxyDispatcherImpl;
import de.audi.app.terminalmode.actionproxy.ActionProxyMethod;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import java.util.LinkedList;
import java.util.Map;

class ActionProxyDispatcherImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pMethodID;
    private final /* synthetic */ int val$pTerminalID;
    private final /* synthetic */ Map val$pParameters;
    private final /* synthetic */ ActionProxyDispatcherImpl this$0;

    ActionProxyDispatcherImpl$1(ActionProxyDispatcherImpl actionProxyDispatcherImpl, String string, int n, int n2, Map map) {
        this.this$0 = actionProxyDispatcherImpl;
        this.val$pMethodID = n;
        this.val$pTerminalID = n2;
        this.val$pParameters = map;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        LinkedList linkedList;
        ActionProxyMethod actionProxyMethod = new ActionProxyMethod(this.val$pMethodID, this.val$pTerminalID);
        Object object = ActionProxyDispatcherImpl.access$000(this.this$0);
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)ActionProxyDispatcherImpl.access$000(this.this$0).get(actionProxyMethod);
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IActionProxyListener)object.next()).actionProxyCallPerformed(actionProxyMethod.getMethodID(), this.val$pParameters);
            }
            catch (Exception exception) {
                ActionProxyDispatcherImpl.access$100(this.this$0).log(-1601830656, "[%1.notifyActionProxyCall] Error: ", (Object)"ActionProxyDispatcherImpl", (Throwable)exception);
            }
        }
    }
}

