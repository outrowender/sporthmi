/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Message;
import de.esolutions.fw.util.commons.Buffer;
import java.util.List;

class Handler$MsgJob
implements Runnable {
    private final Message msg;
    private final /* synthetic */ Handler this$0;

    Handler$MsgJob(Handler handler, Message message) {
        this.this$0 = handler;
        this.msg = message;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        List list = Handler.access$000(this.this$0);
        synchronized (list) {
            Handler.access$000(this.this$0).remove(this.msg);
        }
        if (!this.msg.removed) {
            Handler.access$100(this.this$0, this.msg);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("MsgJob: '").append(this.msg.toString()).append("'");
        return buffer.toString();
    }
}

