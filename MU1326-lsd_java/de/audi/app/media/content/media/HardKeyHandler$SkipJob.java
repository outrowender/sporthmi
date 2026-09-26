/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.HardKeyHandler;
import de.esolutions.fw.util.commons.Buffer;

class HardKeyHandler$SkipJob
implements Runnable {
    private final int count;
    private final /* synthetic */ HardKeyHandler this$0;

    public HardKeyHandler$SkipJob(HardKeyHandler hardKeyHandler, int n) {
        this.this$0 = hardKeyHandler;
        this.count = n;
    }

    @Override
    public void run() {
        HardKeyHandler.access$000(this.this$0).skip(this.count > 0, Math.abs(this.count));
    }

    public String toString() {
        return new Buffer().append("HardKeyHandler.skip(").append(this.count).append(")").toString();
    }
}

