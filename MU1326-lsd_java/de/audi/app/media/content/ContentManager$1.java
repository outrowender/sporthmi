/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.ContentManager;

class ContentManager$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ContentManager this$0;

    ContentManager$1(ContentManager contentManager, String string) {
        this.this$0 = contentManager;
        super(string);
    }

    @Override
    public void run() {
        ContentManager.access$000(this.this$0).main().log(1078071040, "[%1.belowLowerThreshold] Vehicle not moving.", (Object)"ContentManager");
        ContentManager.access$100(this.this$0, false);
    }
}

