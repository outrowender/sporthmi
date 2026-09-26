/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.SourceManager;

class SourceManager$2
implements Consumer {
    private final /* synthetic */ SourceManager this$0;

    SourceManager$2(SourceManager sourceManager) {
        this.this$0 = sourceManager;
    }

    public void accept(Integer n) {
        SourceManager.access$200(this.this$0).log(-2137614336, "[SourceManager. property currentSource.accept] %1 ", (Object)n);
        SourceManager.access$400(this.this$0, n);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

