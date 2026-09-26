/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.SourceManager;
import de.audi.tv.app.SourceManager$SourceChangeRequest;

class SourceManager$1
implements Consumer {
    private final /* synthetic */ SourceManager this$0;

    SourceManager$1(SourceManager sourceManager) {
        this.this$0 = sourceManager;
    }

    public void accept(SourceManager$SourceChangeRequest sourceManager$SourceChangeRequest) {
        SourceManager.access$200(this.this$0).log(-2137614336, "[SourceManager. property desiredSource.accept] %2 (from user: %1)", sourceManager$SourceChangeRequest.isUserCall, (long)sourceManager$SourceChangeRequest.source);
        SourceManager.access$300(this.this$0, sourceManager$SourceChangeRequest.source, sourceManager$SourceChangeRequest.isUserCall);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((SourceManager$SourceChangeRequest)object);
    }
}

