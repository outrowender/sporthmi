/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.msg.TouchSound;
import de.audi.tone.app.msg.TouchSound$1;

class TouchSound$MsgListener
extends DefaultMsgListener {
    private final /* synthetic */ TouchSound this$0;

    private TouchSound$MsgListener(TouchSound touchSound) {
        this.this$0 = touchSound;
    }

    @Override
    protected void playTouchSound() {
        if (TouchSound.access$100(this.this$0)) {
            TouchSound.access$200(this.this$0).log(-2137614336, "[TouchSound.MsgListener.playTouchSound] play");
            TouchSound.access$300(this.this$0).play();
        } else {
            TouchSound.access$200(this.this$0).log(-2137614336, "[TouchSound.MsgListener.playTouchSound] touchSoundEnabled: %1", TouchSound.access$100(this.this$0));
        }
    }

    @Override
    protected void resetMessagingSettings() {
        this.this$0.itemSelected(-1841164544, 1, 0, 0);
    }

    /* synthetic */ TouchSound$MsgListener(TouchSound touchSound, TouchSound$1 touchSound$1) {
        this(touchSound);
    }
}

