/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.HardKeyHandler;

class HardKeyHandler$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ HardKeyHandler this$0;

    HardKeyHandler$7(HardKeyHandler hardKeyHandler, String string) {
        this.this$0 = hardKeyHandler;
        super(string);
    }

    @Override
    public void run() {
        HardKeyHandler.access$000(this.this$0).startSeek(true);
    }
}

