/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.msg;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.msg.MsgListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class MessageDistributorImpl
implements MsgDistributor {
    private final IFrameworkAccess framework;
    private final LogChannel logChannel;
    private volatile List listeners = new LinkedList();

    public MessageDistributorImpl(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.logChannel = this.framework.getLogChannel("Fw.Message.Main");
    }

    @Override
    public void sendMessage(int n) {
        this.logChannel.log(1078071040, "MessageDistributorImpl.sendMessage(msgType=%1)", (long)n);
        ListIterator listIterator = this.listeners.listIterator();
        MsgListener msgListener = null;
        while (listIterator.hasNext()) {
            try {
                msgListener = (MsgListener)listIterator.next();
                this.logChannel.log(-2137614336, "MessageDistributorImpl.sendMessage: Send message to listener %1!", (Object)msgListener);
                msgListener.processMsg(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "MessageDistributorImpl.sendMessage; Message processing failed! (msgType=%1)", (long)n, (Throwable)exception);
            }
        }
    }

    synchronized void addListener(MsgListener msgListener) {
        this.logChannel.log(1078071040, "MessageDistributorImpl.addListener(listener=%1)", (Object)msgListener);
        if (msgListener == null) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.listeners);
        linkedList.add(msgListener);
        this.listeners = linkedList;
    }

    synchronized void removeListener(MsgListener msgListener) {
        this.logChannel.log(1078071040, "MessageDistributorImpl.removeListener(listener=%1)", (Object)msgListener);
        if (msgListener == null) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.listeners);
        linkedList.remove(msgListener);
        this.listeners = linkedList;
    }
}

