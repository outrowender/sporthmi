/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.ap.ActionProxyDispatcher$1;
import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ActionProxyDispatcher
implements IActionProxyDispatcher {
    private final LogChannel logChannel;
    private final Map listeners;
    private final TelEventQueue eventQueue;

    public ActionProxyDispatcher(LogChannel logChannel, TelEventQueue telEventQueue) {
        this.logChannel = logChannel;
        this.listeners = new HashMap();
        this.eventQueue = telEventQueue;
    }

    @Override
    public void init() {
        this.logChannel.log(-2137614336, "[ActionProxyDispatcher#init] called");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(-2137614336, "[ActionProxyDispatcher#deinit] called");
        Map map = this.listeners;
        synchronized (map) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.logChannel.log(-2137614336, "[ActionProxyDispatcher#addActionProxyListener] methodID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logChannel.log(-2137614336, "[ActionProxyDispatcher#addActionProxyListener] Listener is already added.");
                return;
            }
            linkedList.add(iActionProxyListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.logChannel.log(-2137614336, "[ActionProxyDispatcher#removeActionProxyListener] called for method '%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iActionProxyListener);
        }
    }

    @Override
    public void notifyActionProxyCall(int n, Map map) {
        this.eventQueue.enqueue(new ActionProxyDispatcher$1(this, n, n, map));
    }

    @Override
    public LogChannel getAPLogChannel() {
        return this.logChannel;
    }

    static /* synthetic */ LogChannel access$000(ActionProxyDispatcher actionProxyDispatcher) {
        return actionProxyDispatcher.logChannel;
    }

    static /* synthetic */ Map access$100(ActionProxyDispatcher actionProxyDispatcher) {
        return actionProxyDispatcher.listeners;
    }
}

