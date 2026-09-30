/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.statemachine.Message;
import de.audi.atip.utils.statemachine.SyncronousDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Handler {
    private final IDispatcher dispatcherBase;
    private final IHandlingStrategy handlingStrategy;
    final List messageList;
    private final IMessageCodeToStringConverter mConverter;

    public Handler(IDispatcher iDispatcher, IHandlingStrategy iHandlingStrategy, IMessageCodeToStringConverter iMessageCodeToStringConverter) {
        this.dispatcherBase = iDispatcher;
        this.handlingStrategy = iHandlingStrategy;
        this.mConverter = iMessageCodeToStringConverter;
        this.messageList = new LinkedList();
    }

    public Message obtainMessage(int n) {
        return this.obtainMessage(n, this.mConverter.messageCodeToString(n), null);
    }

    public Message obtainMessage(Runnable runnable) {
        return this.obtainMessage(-424242424, runnable.toString(), runnable);
    }

    public Message obtainMessage(int n, Runnable runnable) {
        return this.obtainMessage(n, this.mConverter.messageCodeToString(n), runnable);
    }

    public Message obtainMessage(String string, Runnable runnable) {
        return this.obtainMessage(-424242424, string, runnable);
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

    static IDispatcher.ICancelable startTimerForDelayedRunnable(final Runnable runnable, long l, final IDispatcher iDispatcher) {
        DefaultTimerListener defaultTimerListener = new DefaultTimerListener(){

            public void fireTimer(Timer timer) {
                iDispatcher.execute(runnable);
            }
        };
        final Timer timer = new Timer("delayedMsg", l, true, defaultTimerListener);
        timer.start();
        return new IDispatcher.ICancelable(){

            public void cancel() {
                timer.cancel();
            }
        };
    }

    public static class HandlerBuilder {
        private IDispatcher dispatcher = new SyncronousDispatcher();
        private IHandlingStrategy handlingStrategy = new DefaultHandlingStrategy();
        private IMessageCodeToStringConverter messageCodeToStringConverter = new DefaulftConverter();

        public HandlerBuilder setDispatcher(IDispatcher iDispatcher) {
            this.dispatcher = iDispatcher;
            return this;
        }

        public HandlerBuilder setDispatcher(DispatcherBase dispatcherBase) {
            this.dispatcher = new DispatcherBaseAdapter(dispatcherBase);
            return this;
        }

        public HandlerBuilder setHandlingStrategy(IHandlingStrategy iHandlingStrategy) {
            this.handlingStrategy = iHandlingStrategy;
            return this;
        }

        public HandlerBuilder setMessageCodeToStringConverter(IMessageCodeToStringConverter iMessageCodeToStringConverter) {
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

    private static class DefaultHandlingStrategy
    implements IHandlingStrategy {
        private DefaultHandlingStrategy() {
        }

        public void handleMessage(Message message) {
        }
    }

    public static interface IMessageCodeToStringConverter {
        public String messageCodeToString(int var1);
    }
}

