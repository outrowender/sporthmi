/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.util.IDispatcher;
import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.Predicates;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Handler {
    private final IDispatcher dispatcherBase;
    private final IHandlingStrategy handlingStrategy;
    private final List messageList;
    private final IMessageCodeToStringConverter mConverter;

    private Handler(IDispatcher iDispatcher, IHandlingStrategy iHandlingStrategy, IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (iDispatcher == null || iHandlingStrategy == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = iDispatcher;
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, IHandlingStrategy iHandlingStrategy, IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (dispatcherBase == null || iHandlingStrategy == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = new DispatcherBaseDispatcher(dispatcherBase);
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        if (dispatcherBase == null || iMessageCodeToStringConverter == null) {
            throw new InvalidParameterException("should not be null!");
        }
        this.dispatcherBase = new DispatcherBaseDispatcher(dispatcherBase);
        this.handlingStrategy = new DefaultHandlingStrategy();
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Handler(DispatcherBase dispatcherBase, IHandlingStrategy iHandlingStrategy) {
        this(dispatcherBase, iHandlingStrategy, (IMessageCodeToStringConverter)new DefaulftConverter());
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
        this.dispatcherBase.execute(new MsgJob(message));
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
            DelayedMessageTimerListener delayedMessageTimerListener = new DelayedMessageTimerListener(message);
            Timer timer = new Timer("delayedMsg", l, true, delayedMessageTimerListener);
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

    public boolean removeMessages(final int n) {
        return this.removeMessages(new Predicates.Predicate(){

            public boolean apply(Object object) {
                return ((Message)object).getCode() == n;
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeMessages(Predicates.Predicate predicate) {
        boolean bl = false;
        List list = this.messageList;
        synchronized (list) {
            Iterator iterator = this.messageList.iterator();
            while (iterator.hasNext()) {
                Message message = (Message)iterator.next();
                if (!predicate.apply(message)) continue;
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

    private class MsgJob
    implements Runnable {
        private final Message msg;

        MsgJob(Message message) {
            this.msg = message;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            List list = Handler.this.messageList;
            synchronized (list) {
                Handler.this.messageList.remove(this.msg);
            }
            if (!this.msg.removed) {
                Handler.this.handleMessage(this.msg);
            }
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("MsgJob: '").append(this.msg.toString()).append("'");
            return buffer.toString();
        }
    }

    public static class Builder {
        private IDispatcher dispatcher = new SyncronousDispatcher();
        private IHandlingStrategy handlingStrategy = new DefaultHandlingStrategy();
        private IMessageCodeToStringConverter messageCodeToStringConverter = new DefaulftConverter();

        public Builder setDispatcher(IDispatcher iDispatcher) {
            this.dispatcher = iDispatcher;
            return this;
        }

        public Builder setDispatcher(DispatcherBase dispatcherBase) {
            this.dispatcher = new DispatcherBaseDispatcher(dispatcherBase);
            return this;
        }

        public Builder setDispatcher(EventDispatcher eventDispatcher) {
            this.dispatcher = new EventDispatcherDispatcher(eventDispatcher);
            return this;
        }

        public Builder setHandlingStrategy(IHandlingStrategy iHandlingStrategy) {
            this.handlingStrategy = iHandlingStrategy;
            return this;
        }

        public Builder setMessageCodeToStringConverter(IMessageCodeToStringConverter iMessageCodeToStringConverter) {
            this.messageCodeToStringConverter = iMessageCodeToStringConverter;
            return this;
        }

        public Handler getHandler() {
            return new Handler(this.dispatcher, this.handlingStrategy, this.messageCodeToStringConverter);
        }
    }

    private static class DefaulftConverter
    implements IMessageCodeToStringConverter {
        private DefaulftConverter() {
        }

        public String messageCodeToString(int n) {
            return Integer.toString(n);
        }
    }

    public static interface IHandlingStrategy {
        public void handleMessage(Message var1);
    }

    public static class SyncronousDispatcher
    implements IDispatcher {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static class DefaultHandlingStrategy
    implements IHandlingStrategy {
        private DefaultHandlingStrategy() {
        }

        public void handleMessage(Message message) {
        }
    }

    public static class DispatcherBaseDispatcher
    implements IDispatcher {
        private final DispatcherBase dispatcherBase;

        public DispatcherBaseDispatcher(DispatcherBase dispatcherBase) {
            this.dispatcherBase = dispatcherBase;
        }

        public void execute(Runnable runnable) {
            this.dispatcherBase.execute(runnable);
            this.dispatcherBase.start();
        }
    }

    public static class EventDispatcherDispatcher
    implements IDispatcher {
        private final EventDispatcher dispatcher;

        public EventDispatcherDispatcher(EventDispatcher eventDispatcher) {
            this.dispatcher = eventDispatcher;
        }

        public void execute(Runnable runnable) {
            this.dispatcher.postEvent(new RunnableEvent(false, runnable));
        }
    }

    private final class DelayedMessageTimerListener
    extends DefaultTimerListener {
        private final Message msg;

        public DelayedMessageTimerListener(Message message) {
            this.msg = message;
        }

        public void fireTimer(Timer timer) {
            Handler.this.dispatcherBase.execute(new MsgJob(this.msg));
        }
    }

    public static interface IMessageCodeToStringConverter {
        public String messageCodeToString(int var1);
    }
}

