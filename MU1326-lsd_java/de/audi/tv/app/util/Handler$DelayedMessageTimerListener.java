/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.util.Handler;
import de.audi.tv.app.util.Handler$MsgJob;
import de.audi.tv.app.util.Message;

final class Handler$DelayedMessageTimerListener
extends DefaultTimerListener {
    private final Message msg;
    private final /* synthetic */ Handler this$0;

    public Handler$DelayedMessageTimerListener(Handler handler, Message message) {
        this.this$0 = handler;
        this.msg = message;
    }

    @Override
    public void fireTimer(Timer timer) {
        Handler.access$500(this.this$0).execute(new Handler$MsgJob(this.this$0, this.msg));
    }
}

