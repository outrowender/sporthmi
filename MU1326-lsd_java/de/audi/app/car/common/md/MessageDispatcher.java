/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.md;

import de.audi.app.car.common.md.IMessageDispatcher;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import org.osgi.framework.BundleContext;

public class MessageDispatcher
implements IMessageDispatcher,
MsgListener {
    private final LogChannel logChannel;
    private final Map listeners;
    private final CarServiceProvider msgListenerProvider;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public MessageDispatcher(LogChannel logChannel, BundleContext bundleContext) {
        this.logChannel = logChannel;
        this.msgListenerProvider = new CarServiceProvider((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = MessageDispatcher.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), this, new Hashtable(0), bundleContext, logChannel);
        this.listeners = new HashMap();
    }

    @Override
    public void init() {
        this.logChannel.log(1078071040, "[MessageDispatcher#init] called");
        this.msgListenerProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(1078071040, "[MessageDispatcher#deinit] called");
        this.msgListenerProvider.stopService();
        Map map = this.listeners;
        synchronized (map) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addMessageListener(int n, MsgListener msgListener) {
        this.logChannel.log(1078071040, "[MessageDispatcher#addMessageListener] msgID='%1', listener='%2'", (Object)Integer.toString(n), (Object)msgListener.toString());
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(msgListener)) {
                this.logChannel.log(1078071040, "[MessageDispatcher#addMessageListener] Listener is already added.");
                return;
            }
            linkedList.add(msgListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeMessageListener(int n, MsgListener msgListener) {
        this.logChannel.log(1078071040, "[MessageDispatcher#removeMessageListener] msgID='%1', listener='%2'", (Object)Integer.toString(n), (Object)msgListener.toString());
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(msgListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processMsg(int n) {
        LinkedList linkedList;
        this.logChannel.log(1078071040, "[MessageDispatcher#processMsg] msgID='%1'", (long)n);
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
                ((MsgListener)object.next()).processMsg(n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[MessageDispatcher#processMsg] exception occured: ", (Throwable)exception);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

