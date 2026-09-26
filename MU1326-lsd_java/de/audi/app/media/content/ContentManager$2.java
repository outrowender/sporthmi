/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.ContentManager;

class ContentManager$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ContentManager this$0;

    ContentManager$2(ContentManager contentManager, String string) {
        this.this$0 = contentManager;
        super(string);
    }

    @Override
    public void run() {
        ContentManager.access$200(this.this$0).main().log(1078071040, "[%1.exceedsUpperThreshold] Vehicle moving.", (Object)"ContentManager");
        ContentManager.access$100(this.this$0, true);
    }
}

