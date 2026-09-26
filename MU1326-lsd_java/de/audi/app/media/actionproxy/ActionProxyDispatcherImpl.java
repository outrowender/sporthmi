/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.actionproxy;

import de.audi.app.media.actionproxy.ActionProxyMethod;
import de.audi.app.media.actionproxy.IActionProxyDispatcher;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ActionProxyDispatcherImpl
implements IActionProxyDispatcher {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final Map listenerMap;

    public ActionProxyDispatcherImpl(IFrameworkAccess iFrameworkAccess) {
        this.logger = iFrameworkAccess.getLogChannel("App.Media.SM");
        this.listenerMap = new HashMap();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"ActionProxyDispatcherImpl");
        Map map = this.listenerMap;
        synchronized (map) {
            this.listenerMap.clear();
        }
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logger;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addActionProxyListener(int n, int n2, IActionProxyListener iActionProxyListener) {
        ActionProxyMethod actionProxyMethod = new ActionProxyMethod(n, n2);
        this.logger.log(1078071040, "[%1.addActionProxyListener] %2, '%3'", (Object)"ActionProxyDispatcherImpl", (Object)actionProxyMethod, (Object)iActionProxyListener);
        Map map = this.listenerMap;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listenerMap.get(actionProxyMethod);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listenerMap.put(actionProxyMethod, linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logger.log(1078071040, "[%1.addActionProxyListener] Already added.", (Object)"ActionProxyDispatcherImpl");
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
        this.logger.log(1078071040, "[%1.removeActionProxyListener] '%2', '%3'", (Object)"ActionProxyDispatcherImpl", (Object)MediaUtils.getTerminalIDToStr(n), (Object)iActionProxyListener);
        Map map = this.listenerMap;
        synchronized (map) {
            Iterator iterator = this.listenerMap.keySet().iterator();
            while (iterator.hasNext()) {
                LinkedList linkedList;
                ActionProxyMethod actionProxyMethod = (ActionProxyMethod)iterator.next();
                if (actionProxyMethod.getTerminalID() != n || (linkedList = (LinkedList)this.listenerMap.get(actionProxyMethod)) == null) continue;
                linkedList.remove(iActionProxyListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyActionProxyCall(int n, int n2, Map map) {
        LinkedList linkedList;
        if (map == null) {
            throw new IllegalArgumentException();
        }
        ActionProxyMethod actionProxyMethod = new ActionProxyMethod(n, n2);
        Object object = this.listenerMap;
        synchronized (object) {
            LinkedList linkedList2 = (LinkedList)this.listenerMap.get(actionProxyMethod);
            if (linkedList2 == null) {
                return;
            }
            linkedList = (LinkedList)linkedList2.clone();
        }
        object = linkedList.iterator();
        while (object.hasNext()) {
            try {
                ((IActionProxyListener)object.next()).actionProxyCallPerformed(actionProxyMethod.getMethodID(), map);
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifyActionProxyCall] Error: ", (Object)"ActionProxyDispatcherImpl", (Throwable)exception);
            }
        }
    }
}

