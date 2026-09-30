/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.actionproxy;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.actionproxy.ActionProxyMethod;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ActionProxyDispatcherImpl
implements IActionProxyDispatcher,
ITerminalModeComponent {
    private static final String LOGCLASS = "ActionProxyDispatcherImpl";
    private final LogChannel logger;
    private final Map listenerMap;
    private final DispatcherBase dispatcher;

    public ActionProxyDispatcherImpl(ITerminalLogger iTerminalLogger, DispatcherBase dispatcherBase) {
        this.logger = iTerminalLogger.hmi();
        this.listenerMap = new HashMap();
        this.dispatcher = dispatcherBase;
    }

    public void init() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        Map map = this.listenerMap;
        synchronized (map) {
            this.listenerMap.clear();
        }
    }

    public LogChannel getLogChannel() {
        return this.logger;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addActionProxyListener(int n, int n2, IActionProxyListener iActionProxyListener) {
        ActionProxyMethod actionProxyMethod = new ActionProxyMethod(n, n2);
        this.logger.log(100000000, "[%1.addActionProxyListener] %2, '%3'", (Object)LOGCLASS, (Object)actionProxyMethod, (Object)iActionProxyListener);
        Map map = this.listenerMap;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listenerMap.get(actionProxyMethod);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listenerMap.put(actionProxyMethod, linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logger.log(100000, "[%1.addActionProxyListener] Already added.", (Object)LOGCLASS);
                return;
            }
            linkedList.add(iActionProxyListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeActionProxyListener(int n, IActionProxyListener iActionProxyListener) {
        this.logger.log(1000000, "[%1.removeActionProxyListener] tId='%2', '%3'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)iActionProxyListener);
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

    public void notifyActionProxyCall(final int n, final int n2, final Map map) {
        if (map == null) {
            throw new IllegalArgumentException();
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable("ActionProxyDispatcherImpl.notifyActionProxyCall"){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                LinkedList linkedList;
                ActionProxyMethod actionProxyMethod = new ActionProxyMethod(n, n2);
                Object object = ActionProxyDispatcherImpl.this.listenerMap;
                synchronized (object) {
                    LinkedList linkedList2 = (LinkedList)ActionProxyDispatcherImpl.this.listenerMap.get(actionProxyMethod);
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
                        ActionProxyDispatcherImpl.this.logger.log(100000, "[%1.notifyActionProxyCall] Error: ", (Object)ActionProxyDispatcherImpl.LOGCLASS, (Throwable)exception);
                    }
                }
            }
        });
    }
}

