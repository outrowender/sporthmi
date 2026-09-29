/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.timer.Timer;
import de.audi.tv.app.util.Handler$1;
import de.audi.tv.app.util.Handler$DefaulftConverter;
import de.audi.tv.app.util.Handler$DefaultHandlingStrategy;
import de.audi.tv.app.util.Handler$DelayedMessageTimerListener;
import de.audi.tv.app.util.Handler$DispatcherBaseDispatcher;
import de.audi.tv.app.util.Handler$IHandlingStrategy;
import de.audi.tv.app.util.Handler$IMessageCodeToStringConverter;
import de.audi.tv.app.util.Handler$MsgJob;
import de.audi.tv.app.util.IDispatcher;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates$Predicate;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Handler {
    private final IDispatcher dispatcherBase;
    private final Handler$IHandlingStrategy handlingStrategy;
    private final List messageList;
    private final Handler$IMessageCodeToStringConverter mConverter;

    private Handler(IDispatcher iDispatcher, Handler$IHandlingStrategy iHandlingStrategy, Handler$IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (iDispatcher == null || iHandlingStrategy == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = iDispatcher;
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, Handler$IHandlingStrategy iHandlingStrategy, Handler$IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (dispatcherBase == null || iHandlingStrategy == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = new Handler$DispatcherBaseDispatcher(dispatcherBase);
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, Handler$IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (dispatcherBase == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = new Handler$DispatcherBaseDispatcher(dispatcherBase);
        this.handlingStrategy = new Handler$DefaultHandlingStrategy(null);
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, Handler$IHandlingStrategy handler$IHandlingStrategy) {
        this(dispatcherBase, handler$IHandlingStrategy, (Handler$IMessageCodeToStringConverter)new Handler$DefaulftConverter(null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Message obtainMessage(int n) {
        Message message = new Message(this, n, this.mConverter.messageCodeToString(n));
        List list = this.messageList;
        synchronized (list) {
            this.messageList.add(message);
        }
        return message;
    }

    public void sendMessage(Message message) {
        this.dispatcherBase.execute(new Handler$MsgJob(this, message));
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
            Handler$DelayedMessageTimerListener handler$DelayedMessageTimerListener = new Handler$DelayedMessageTimerListener(this, message);
            Timer timer = new Timer("delayedMsg", l, true, handler$DelayedMessageTimerListener);
            timer.start();
        }
    }

    public void sendEmptyMessageDelayed(int n, long l) {
        Message message = this.obtainMessage(n);
        this.sendMessageDelayed(message, l);
    }

    public void post(Runnable runnable) {
        this.postDelayed(runnable, 0L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void postDelayed(Runnable runnable, long l) {
        Message message = new Message(this, runnable);
        List list = this.messageList;
        synchronized (list) {
            this.messageList.add(message);
        }
        this.sendMessageDelayed(message, l);
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

    public boolean removeMessages(int n) {
        return this.removeMessages(new Handler$1(this, n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeMessages(Predicates$Predicate predicates$Predicate) {
        boolean bl = false;
        List list = this.messageList;
        synchronized (list) {
            Iterator iterator = this.messageList.iterator();
            while (iterator.hasNext()) {
                Message message = (Message)iterator.next();
                if (!predicates$Predicate.apply(message)) continue;
                message.removed = true;
                iterator.remove();
            }
        }
        return bl;
    }

    private void handleMessage(Message message) {
        if (message.callback != null) {
            message.callback.run();
        } else {
            this.handlingStrategy.handleMessage(message);
        }
    }

    static /* synthetic */ List access$000(Handler handler) {
        return handler.messageList;
    }

    static /* synthetic */ void access$100(Handler handler, Message message) {
        handler.handleMessage(message);
    }

    /* synthetic */ Handler(IDispatcher iDispatcher, Handler$IHandlingStrategy iHandlingStrategy, Handler$IMessageCodeToStringConverter iMessageCodeToStringConverter, Handler$1 var4_4) {
        this(iDispatcher, iHandlingStrategy, iMessageCodeToStringConverter);
    }

    static /* synthetic */ IDispatcher access$500(Handler handler) {
        return handler.dispatcherBase;
    }
}

