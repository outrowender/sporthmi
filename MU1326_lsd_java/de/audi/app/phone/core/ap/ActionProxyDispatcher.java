/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.ap;

import de.audi.app.phone.core.ap.IActionProxyDispatcher;
import de.audi.app.phone.core.ap.IActionProxyListener;
import de.audi.app.phone.core.event.AbstractTelActionProxyEvent;
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

    public void init() {
        this.logChannel.log(10000000, "[ActionProxyDispatcher#init] called");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logChannel.log(10000000, "[ActionProxyDispatcher#deinit] called");
        Map map = this.listeners;
        synchronized (map) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.logChannel.log(10000000, "[ActionProxyDispatcher#addActionProxyListener] methodID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logChannel.log(10000000, "[ActionProxyDispatcher#addActionProxyListener] Listener is already added.");
                return;
            }
            linkedList.add(iActionProxyListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.logChannel.log(10000000, "[ActionProxyDispatcher#removeActionProxyListener] called for method '%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iActionProxyListener);
        }
    }

    public void notifyActionProxyCall(final int n, final Map map) {
        this.eventQueue.enqueue(new AbstractTelActionProxyEvent(n){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                LinkedList linkedList;
                ActionProxyDispatcher.this.logChannel.log(10000000, "[ActionProxyDispatcher#notifyActionProxyCall] methodID='%1', parameters='%2'", (Object)Integer.toString(n), (Object)map);
                Object object = ActionProxyDispatcher.this.listeners;
                synchronized (object) {
                    LinkedList linkedList2 = (LinkedList)ActionProxyDispatcher.this.listeners.get(new Integer(n));
                    if (linkedList2 == null) {
                        return;
                    }
                    linkedList = (LinkedList)linkedList2.clone();
                }
                object = linkedList.iterator();
                while (object.hasNext()) {
                    try {
                        ((IActionProxyListener)object.next()).actionProxyCallPerformed(n, map);
                    }
                    catch (Exception exception) {
                        ActionProxyDispatcher.this.logChannel.log(100000, "[ActionProxyDispatcher#notifyActionProxyCall] exception occured: ", (Throwable)exception);
                    }
                }
            }
        });
    }

    public LogChannel getAPLogChannel() {
        return this.logChannel;
    }
}

