/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.timer.Timer;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.audi.atip.utils.statemachine.Handler$1;
import de.audi.atip.utils.statemachine.Handler$2;
import de.audi.atip.utils.statemachine.Handler$IHandlingStrategy;
import de.audi.atip.utils.statemachine.Handler$IMessageCodeToStringConverter;
import de.audi.atip.utils.statemachine.Message;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Handler {
    private final IDispatcher dispatcherBase;
    private final Handler$IHandlingStrategy handlingStrategy;
    final List messageList;
    private final Handler$IMessageCodeToStringConverter mConverter;

    public Handler(IDispatcher iDispatcher, Handler$IHandlingStrategy iHandlingStrategy, Handler$IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        this.dispatcherBase = iDispatcher;
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Message obtainMessage(int n) {
        return this.obtainMessage(n, this.mConverter.messageCodeToString(n), null);
    }

    public Message obtainMessage(Runnable runnable) {
        return this.obtainMessage(143898342, runnable.toString(), runnable);
    }

    public Message obtainMessage(int n, Runnable runnable) {
        return this.obtainMessage(n, this.mConverter.messageCodeToString(n), runnable);
    }

    public Message obtainMessage(String string, Runnable runnable) {
        return this.obtainMessage(143898342, string, runnable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Message obtainMessage(int n, String string, Runnable runnable) {
        Message message = new Message(this, n, string, runnable);
        List list = this.messageList;
        synchronized (list) {
            this.messageList.add(message);
        }
        return message;
    }

    public void sendMessage(Message message) {
        this.dispatcherBase.execute(message);
    }

    public void sendEmptyMessage(int n) {
        Message message = this.obtainMessage(n);
        this.sendMessage(message);
    }

    public void sendMessage(int n, int n2, int n3, Object object) {
        Message message = this.obtainMessage(n);
        message.arg1 = n2;
        message.arg2 = n3;
        message.obj = object;
        this.sendMessage(message);
    }

    public void sendMessage(int n, int n2, int n3) {
        Message message = this.obtainMessage(n);
        message.arg1 = n2;
        message.arg2 = n3;
        this.sendMessage(message);
    }

    public void sendMessage(int n, Object object) {
        Message message = this.obtainMessage(n);
        message.obj = object;
        this.sendMessage(message);
    }

    public void sendMessage(int n, int n2) {
        Message message = this.obtainMessage(n);
        message.arg1 = n2;
        this.sendMessage(message);
    }

    public void sendMessage(int n, int n2, Object object) {
        Message message = this.obtainMessage(n);
        message.arg1 = n2;
        message.obj = object;
        this.sendMessage(message);
    }

    public void sendMessageDelayed(Message message, long l) {
        if (l <= 0L) {
            this.sendMessage(message);
        } else {
            this.dispatcherBase.execute(message, l);
        }
    }

    public void sendEmptyMessageDelayed(int n, long l) {
        Message message = this.obtainMessage(n);
        this.sendMessageDelayed(message, l);
    }

    public void post(Runnable runnable) {
        this.postDelayed(runnable, 0L);
    }

    public void postDelayed(Runnable runnable, long l) {
        this.obtainMessage(runnable).postDelayed(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasMessages(int n) {
        List list = this.messageList;
        synchronized (list) {
            Iterator iterator = this.messageList.iterator();
            while (iterator.hasNext()) {
                Message message = (Message)iterator.next();
                if (message.getCode() != n) continue;
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeMessages(int n) {
        boolean bl = false;
        List list = this.messageList;
        synchronized (list) {
            Iterator iterator = this.messageList.iterator();
            while (iterator.hasNext()) {
                Message message = (Message)iterator.next();
                if (message.getCode() != n) continue;
                message.removed = true;
                bl = true;
                iterator.remove();
            }
        }
        return bl;
    }

    void handleMessage(Message message) {
        if (message.callback != null) {
            message.callback.run();
        } else {
            this.handlingStrategy.handleMessage(message);
        }
    }

    static IDispatcher$ICancelable startTimerForDelayedRunnable(Runnable runnable, long l, IDispatcher iDispatcher) {
        Handler$1 handler$1 = new Handler$1(iDispatcher, runnable);
        Timer timer = new Timer("delayedMsg", l, true, handler$1);
        timer.start();
        return new Handler$2(timer);
    }
}

