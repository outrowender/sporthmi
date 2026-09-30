/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.msg;

import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.event.AbstractTelMsgDistEvent;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.msg.IMessageDispatcher;
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
    private final PhoneServiceProvider msgListenerProvider;
    private final TelEventQueue telEventQueue;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public MessageDispatcher(LogChannel logChannel, BundleContext bundleContext, TelEventQueue telEventQueue) {
        this.logChannel = logChannel;
        this.msgListenerProvider = new PhoneServiceProvider((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = MessageDispatcher.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), this, new Hashtable(0), bundleContext, logChannel);
        this.listeners = new HashMap();
        this.telEventQueue = telEventQueue;
    }

    public void init() {
        this.logChannel.log(10000000, "[MessageDispatcher#init] called");
        this.msgListenerProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logChannel.log(10000000, "[MessageDispatcher#deinit] called");
        this.msgListenerProvider.stopService();
        Map map = this.listeners;
        synchronized (map) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addMessageListener(int n, MsgListener msgListener) {
        this.logChannel.log(10000000, "[MessageDispatcher#addMessageListener] msgID='%1', listener='%2'", (Object)Integer.toString(n), (Object)msgListener.toString());
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.listeners.put(new Integer(n), linkedList);
            }
            if (linkedList.contains(msgListener)) {
                this.logChannel.log(10000000, "[MessageDispatcher#addMessageListener] Listener is already added.");
                return;
            }
            linkedList.add(msgListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeMessageListener(int n, MsgListener msgListener) {
        this.logChannel.log(10000000, "[MessageDispatcher#removeMessageListener] msgID='%1', listener='%2'", (Object)Integer.toString(n), (Object)msgListener.toString());
        Map map = this.listeners;
        synchronized (map) {
            LinkedList linkedList = (LinkedList)this.listeners.get(new Integer(n));
            if (linkedList == null) {
                return;
            }
            linkedList.remove(msgListener);
        }
    }

    public void processMsg(final int n) {
        this.telEventQueue.enqueue(new AbstractTelMsgDistEvent(n){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                LinkedList linkedList;
                Object object = MessageDispatcher.this.listeners;
                synchronized (object) {
                    LinkedList linkedList2 = (LinkedList)MessageDispatcher.this.listeners.get(new Integer(n));
                    if (linkedList2 == null) {
                        return;
                    }
                    linkedList = (LinkedList)linkedList2.clone();
                }
                object = linkedList.iterator();
                while (object.hasNext()) {
                    try {
                        MessageDispatcher.this.logChannel.log(1000000, "[MessageDispatcher#processMsg] msgID='%1'", (long)n);
                        ((MsgListener)object.next()).processMsg(n);
                    }
                    catch (Exception exception) {
                        MessageDispatcher.this.logChannel.log(100000, "[MessageDispatcher#processMsg] exception occured: ", (Throwable)exception);
                    }
                }
            }
        });
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

