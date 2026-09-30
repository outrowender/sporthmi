/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.Handler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.List;

public final class Message
implements Runnable {
    public static final int NOT_LOGGED_CODE = -424242424;
    private final Handler target;
    private final int code;
    final Runnable callback;
    volatile boolean removed;
    public volatile int arg1 = -424242424;
    public volatile int arg2 = -424242424;
    public volatile Object obj;
    public volatile String tag;

    Message(Handler handler, int n, String string, Runnable runnable) {
        this.target = handler;
        this.code = n;
        this.tag = string;
        this.callback = runnable;
    }

    public void sendToTarget() {
        this.target.sendMessage(this);
    }

    public void post() {
        this.target.sendMessage(this);
    }

    public void postDelayed(long l) {
        this.target.sendMessageDelayed(this, l);
    }

    public int getCode() {
        return this.code;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if ("UNKNOWN".equals(this.tag)) {
            buffer.append(this.code);
        } else {
            buffer.append(this.tag);
        }
        if (this.arg1 != -424242424) {
            buffer.append("[").append(this.arg1).append("]");
        }
        if (this.arg2 != -424242424) {
            buffer.append("[").append(this.arg2).append("]");
        }
        if (this.obj != null) {
            buffer.append("[").append(this.obj.toString()).append("]");
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        List list = this.target.messageList;
        synchronized (list) {
            this.target.messageList.remove(this);
        }
        if (!this.removed) {
            this.target.handleMessage(this);
        }
    }
}

