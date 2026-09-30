/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Handler;
import de.esolutions.fw.util.commons.Buffer;

public final class Message {
    private final Handler target;
    private final int code;
    final Runnable callback;
    volatile boolean removed;
    public volatile int arg1 = -424242424;
    public volatile int arg2 = -424242424;
    public volatile Object obj;
    public volatile String tag;

    Message(Handler handler, int n, String string) {
        this.target = handler;
        this.code = n;
        this.tag = string;
        this.callback = null;
    }

    Message(Handler handler, Runnable runnable) {
        this.target = handler;
        this.code = 0;
        this.tag = "r";
        this.callback = runnable;
    }

    public void sendToTarget() {
        this.target.sendMessage(this);
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
}

