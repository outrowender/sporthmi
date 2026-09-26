/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.actionproxy;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.actionproxy.ActionProxyDispatcherImpl$1;
import de.audi.app.terminalmode.actionproxy.ActionProxyMethod;
import de.audi.app.terminalmode.actionproxy.IActionProxyDispatcher;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ActionProxyDispatcherImpl
implements IActionProxyDispatcher,
ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final Map listenerMap;
    private final DispatcherBase dispatcher;

    public ActionProxyDispatcherImpl(ITerminalLogger iTerminalLogger, DispatcherBase dispatcherBase) {
        this.logger = iTerminalLogger.hmi();
        this.listenerMap = new HashMap();
        this.dispatcher = dispatcherBase;
    }

    @Override
    public void init() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
        this.logger.log(14808325, "[%1.addActionProxyListener] %2, '%3'", (Object)"ActionProxyDispatcherImpl", (Object)actionProxyMethod, (Object)iActionProxyListener);
        Map map = this.listenerMap;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listenerMap.get(actionProxyMethod);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listenerMap.put(actionProxyMethod, linkedList);
            }
            if (linkedList.contains(iActionProxyListener)) {
                this.logger.log(-1601830656, "[%1.addActionProxyListener] Already added.", (Object)"ActionProxyDispatcherImpl");
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
        this.logger.log(1078071040, "[%1.removeActionProxyListener] tId='%2', '%3'", (Object)"ActionProxyDispatcherImpl", (Object)String.valueOf(n), (Object)iActionProxyListener);
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

    @Override
    public void notifyActionProxyCall(int n, int n2, Map map) {
        if (map == null) {
            throw new IllegalArgumentException();
        }
        this.dispatcher.execute(new ActionProxyDispatcherImpl$1(this, "ActionProxyDispatcherImpl.notifyActionProxyCall", n, n2, map));
    }

    static /* synthetic */ Map access$000(ActionProxyDispatcherImpl actionProxyDispatcherImpl) {
        return actionProxyDispatcherImpl.listenerMap;
    }

    static /* synthetic */ LogChannel access$100(ActionProxyDispatcherImpl actionProxyDispatcherImpl) {
        return actionProxyDispatcherImpl.logger;
    }
}

