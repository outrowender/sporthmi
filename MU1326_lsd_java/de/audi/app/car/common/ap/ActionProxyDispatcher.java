/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.ap;

import de.audi.app.car.common.ap.IActionProxyDispatcher;
import de.audi.app.car.common.ap.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ActionProxyDispatcher
implements IActionProxyDispatcher {
    private final LogChannel logChannel;
    private final Map listeners;

    public ActionProxyDispatcher(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.listeners = new HashMap();
    }

    @Override
    public void init() {
        this.logChannel.log(1078071040, "[ActionProxyDispatcher#init] called");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(1078071040, "[ActionProxyDispatcher#deinit] called");
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
        this.logChannel.log(1078071040, "[ActionProxyDispatcher#addActionProxyListener] methodID='%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logChannel.log(1078071040, "[ActionProxyDispatcher#addActionProxyListener] Listener is already added.");
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
        this.logChannel.log(1078071040, "[ActionProxyDispatcher#removeActionProxyListener] called for method '%1', listener='%2'", (Object)Integer.toString(n), (Object)iActionProxyListener);
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(iActionProxyListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyActionProxyCall(int n, Map map) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[ActionProxyDispatcher#notifyActionProxyCall] methodID='%1', parameters='%2'", (Object)Integer.toString(n), (Object)map);
        Object object = this.listeners;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.listeners.get(new Integer(n));
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
                this.logChannel.log(-1601830656, "[ActionProxyDispatcher#notifyActionProxyCall] exception occured: ", (Throwable)exception);
            }
        }
    }

    @Override
    public LogChannel getAPLogChannel() {
        return this.logChannel;
    }
}

